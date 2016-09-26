package com.doctor.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import com.doctor.persistance.Consultation;
import com.doctor.persistance.ConsultationDetail;
import com.doctor.service.ConsultaionService;
import com.doctor.service.ConsultationDetailService;



@ManagedBean(name ="consultationBean")
@SessionScoped
public class ConsultationBean {
	
	private Integer idconsultation;
	private String nomConsultation;
	private String honoraire;
	private double hon;
	private boolean active;
	
	
	
	
	public String getNomConsultation() {
		return nomConsultation;
	}

	public void setNomConsultation(String nomConsultation) {
		this.nomConsultation = nomConsultation;
	}

	public String getHonoraire() {
		return honoraire;
	}

	public void setHonoraire(String honoraire) {
		this.honoraire = honoraire;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}





	private List<Consultation> consultations = new ArrayList<Consultation>();

	public List<Consultation> getConsultations() {
		ConsultaionService ser= new ConsultaionService();
		consultations=ser.rechercheToutConsultation();
		
		return consultations;
	}

	public void setConsultations(List<Consultation> consultations) {
		this.consultations = consultations;
	}
	
	
	
	
	
	public void ajouterConsultation(){
		nomConsultation=null;
	    honoraire=null;
		active=false;
		
		
	}
	
	public void modifierCons(Consultation cons) {

		// honoraire.replaceAll(",", ".");
		// Double hon = Double.parseDouble(honoraire);

		idconsultation = cons.getIdconsultation();
		nomConsultation = cons.getNomConsultation();
		honoraire = "" + cons.getHonoraire();


	}
	
	
	
	public void validerAjout() {
		nomConsultation=nomConsultation.replaceAll("\\s+", " ");
		FacesContext faces = FacesContext.getCurrentInstance();
		RequestContext context = RequestContext.getCurrentInstance();

		boolean addValid = false;

		if (nomConsultation == null || (nomConsultation.trim().length() == 0)) {// tester
																				// si
			// cette zone de
			// text est vide
			faces.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"Veuillez donner le nom de la consultation.", null));
			addValid = false;
		}

		if (honoraire == null || (honoraire.trim().length() == 0)) {// tester si
			// cette zone de
			// text est vide
			faces.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"Veuillez donner l'honoraire de la consultation.", null));
			addValid = false;
		}
		if (honoraire != null && honoraire.trim().length() > 0)
			try {
				honoraire = honoraire.replaceAll(",", ".");
				System.out.println("honoraire aprs rempalcement  " + honoraire);
				hon = Float.parseFloat(honoraire);
			} catch (Exception e) {
				faces.addMessage(
						null,
						new FacesMessage(
								FacesMessage.SEVERITY_ERROR,
								"Veuillez vérifier le format d l'honoraire. Il ne peux pas contenir que des chiffres.",
								""));

				hon = 0;
				honoraire = "";
			}

		if (faces.getMessageList().size() == 0) {

			ConsultaionService ser = new ConsultaionService();
			Consultation cons = new Consultation();
			cons.setNomConsultation(nomConsultation);

			cons.setHonoraire(hon);
			cons.setActive(active);
			ser.ajouterConsultation(cons);
			//init();
			//addValid = true;

			FacesContext face = FacesContext.getCurrentInstance();
			face.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Consultation ajoutée avec succés", ""));
		}

		context.addCallbackParam("addValid", addValid);

		nomConsultation = null;
		honoraire = null;
		
		System.out.println("nomConsultation==**"+nomConsultation);
	}
	
	


public void validerModif() {

	FacesContext faces = FacesContext.getCurrentInstance();
	
	RequestContext context = RequestContext.getCurrentInstance();
	boolean addValid = false;
	ConsultaionService ser = new ConsultaionService();
	Consultation cons = new Consultation();
	System.out.println("honoraire==   " + honoraire);

	if (honoraire == null || (honoraire.trim().length() == 0)) {// tester si
		// cette zone de
		// text est vide
		faces.addMessage(null, new FacesMessage(
				FacesMessage.SEVERITY_ERROR,
				"Veuillez donner l'honnoraire de la consultation.", null));
		addValid = false;
	}

	if (honoraire != null && honoraire.trim().length() > 0)
		try {

			honoraire = honoraire.replaceAll(",", ".");
			hon = Float.parseFloat(honoraire);
		} catch (Exception e) {

			addValid = false;
			System.out.println("hon   " + hon);
			faces.addMessage(
					null,
					new FacesMessage(
							FacesMessage.SEVERITY_ERROR,
							"Veuillez vérifier le format d l'honoraire. Il ne peux pas contenir que des chiffres.",
							""));

			hon = 0;
			honoraire = "";
		}

	if (faces.getMessageList().size() == 0) {

		cons = ser.rechercheParIdConsultation(idconsultation);
		Double hon = Double.parseDouble(honoraire);
		cons.setHonoraire(hon);
		ser.modifierConsultation(cons);
		//init();
		
		faces.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Honoriare modifié avec succés", ""));
		
		
		context.execute("PF('dialogmodif').hide();");
		
		addValid = true;

	}

	context.addCallbackParam("addValid", addValid);
	
	nomConsultation = null;
	honoraire = null;

}


public void supprimerCons(int idCons){
	FacesContext faces = FacesContext.getCurrentInstance();
	ConsultationDetailService serDet= new ConsultationDetailService();
	ConsultaionService serCons= new ConsultaionService();
	List<ConsultationDetail> l= serDet.rechercheConsultationByIdCons(idCons);
	
	if (l.size()>0){ 
		
		faces.addMessage(null, new FacesMessage(
				FacesMessage.SEVERITY_ERROR,
				"Suppression impossible.", null));

		
		
	}else{
		
		serCons.supprimerConsultation(idCons);
		faces.addMessage(null, new FacesMessage(
				FacesMessage.SEVERITY_INFO,
				"Consultation supprimée avec succés.", null));
	}
	
	FacesContext context2 = FacesContext.getCurrentInstance();
	context2.getExternalContext().getFlash().setKeepMessages(true);
	try {
		context2.getExternalContext().redirect("Consultations");
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
}



}
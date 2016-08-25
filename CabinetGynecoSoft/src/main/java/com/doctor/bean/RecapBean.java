package com.doctor.bean;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.doctor.persistance.Consultation;
import com.doctor.persistance.ConsultationDetail;
import com.doctor.service.ConsultaionService;
import com.doctor.service.ConsultationDetailService;



@ManagedBean(name ="recapBean")
@SessionScoped
public class RecapBean implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Consultation> consultations = new ArrayList<Consultation>();
	List<ConsultationDetail> consDets= new ArrayList<ConsultationDetail>();
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	
	private int totalCons ;
	private double totalHon;
	
	private int idConsultation;
	
	
	
	
	
	
	public int getIdConsultation() {
		return idConsultation;
	}
	public void setIdConsultation(int idConsultation) {
		this.idConsultation = idConsultation;
	}
	
	
	
	

	
	public List<ConsultationDetail> consDetavecId(int id){
		ConsultationDetailService ser= new ConsultationDetailService();
		consDets=ser.rechercheConsultationByIdCons(id, new Date());
		return consDets;
	}
	
	public double getTotalHon() {
		ConsultationDetailService ser= new ConsultationDetailService();
		List<ConsultationDetail> l= new ArrayList<ConsultationDetail>();
		l =ser.rechercheConsultationByDate(new Date());
		double hon=0;
		for(int i=0;i<l.size();i++){
		    hon=hon+l.get(i).getHonoraire();	
		    
		}
		totalHon=hon;
		
		return totalHon;
	}
	public void setTotalHon(double totalHon) {
		this.totalHon = totalHon;
	}
	public int getTotalCons() {
		ConsultationDetailService ser= new ConsultationDetailService();
		/*Date actuelle = new Date();
		Date d=null;
		// * Definition du format utilise pour les dates
		Format dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String dateConsultation = dateFormat.format(new Date());
		SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
		try {
			System.out.println(f.parse(dateConsultation));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
	
		totalCons=ser.rechercheConsultationByDate(new Date()).size();
		
		
		return totalCons;
	}
	public void setTotalCons(int totalCons) {
		this.totalCons = totalCons;
	}
	
	public List<Consultation> getConsultations() {
		ConsultaionService serCons= new ConsultaionService();
		consultations=serCons.rechercheToutConsultation();
		return consultations;
	}
	public void setConsultations(List<Consultation> consultations) {
		this.consultations = consultations;
	}
	
	
	

	public int calculerTotalCons(int idCons){
		
		idConsultation=idCons;
		ConsultationDetailService ser= new ConsultationDetailService();
		
		List<ConsultationDetail> l= new ArrayList<ConsultationDetail>();
		l=ser.rechercheConsultationByIdCons(idCons,new Date());
		
		return l.size();
		
		
	}
	
	
	public void lePatient(Integer c) {
		// Module.idpatient = c;

		System.out.println("get in lepatient idPatient== "+c);
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		session.setAttribute("idu", c);
		session.setAttribute("retouraction", "Patients");
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("FichePatiente");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	
	
	
	
	
	
	
	
	
	
	
	
}

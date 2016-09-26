package com.doctor.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import com.doctor.persistance.ConsultationDetail;
import com.doctor.persistance.Modele;
import com.doctor.persistance.Uterus;
import com.doctor.service.ConsultationDetailService;
import com.doctor.service.ModeleService;
import com.doctor.service.UterusService;

@ManagedBean(name = "uterusBean")
@SessionScoped
public class UterusBean implements java.io.Serializable {

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;

	private Integer iduterus;
	private String uterus;

	private String valeurRecherche;

	public String getValeurRecherche() {
		valeurRecherche = Module.rechercheUterus;
		return valeurRecherche;
	}

	public void setValeurRecherche(String valeurRecherche) {
		Module.rechercheUterus = valeurRecherche;
		this.valeurRecherche = valeurRecherche;
	}

	public void annulerRecherche() {
		Module.rechercheUterus = "";
		valeurRecherche = null;
	}

	private List<Uterus> uteruss = new ArrayList<Uterus>();
	// action est un attribut pour différencier l'ajout de la modification
	private String action;

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public Integer getIduterus() {
		return this.iduterus;
	}

	public void setIduterus(Integer iduterus) {
		this.iduterus = iduterus;
	}

	public String getUterus() {
		return this.uterus;
	}

	public void setUterus(String uterus) {
		this.uterus = uterus;
	}

	public List<Uterus> getUteruss() {

		UterusService ser = new UterusService();
		if (valeurRecherche != null)
			uteruss = ser.rechercheFiltre(valeurRecherche);
		else
			uteruss = ser.rechercheTousUterus();
		return uteruss;

	}

	public void setUteruss(List<Uterus> uteruss) {
		this.uteruss = uteruss;
	}

	public void modifierUterus(Uterus d) {
		iduterus = d.getIduterus();
		uterus = d.getUterus();
		action = "Modification";

	}

	public void ajouterUterus() {
		initialisation();
		action = "Ajout";
	}

	public String closeDiag() {
		iduterus = null;
		uterus = null;
		return null;
	}

	public void Supprimer(Integer id) {
		FacesContext faces = FacesContext.getCurrentInstance();
		UterusService ser = new UterusService();
		ConsultationDetailService ser02 = new ConsultationDetailService();
		ModeleService ser03 = new ModeleService();
		Uterus u = ser.rechercheUterus(id);
		List<ConsultationDetail> l = ser02.RechercheParUterus(u);
		List<Modele> ll = ser03.RechercheParUterus(u);
		if (l.size() == 0 && ll.size() == 0) {
			ser.supprimerUterus(id);
			faces.addMessage(null, new FacesMessage(
					"Utérus supprimé avec succès."));
		}

		else
			faces.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"Suppression impossible!  Utérus utilisé.", null));

		FacesContext context2 = FacesContext.getCurrentInstance();
		context2.getExternalContext().getFlash().setKeepMessages(true);
		try {
			context2.getExternalContext().redirect("GestionUterus");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void validation() {
		uterus=uterus.replaceAll("\\s+", " ");
		UterusService ser = new UterusService();

		FacesContext faces = FacesContext.getCurrentInstance();
		RequestContext context = RequestContext.getCurrentInstance();
		boolean addValid = false;
		if (action.equals("Modification")) {
			if (uterus == null || (uterus.trim().length() == 0)) {
				// tester si cette zone de text est vide
				faces.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_ERROR,
						"Veuillez donner le nom de l'utérus.", null));
				addValid = false;
			} else // tester si cette uterus existe déjà
			{
				Uterus d = new Uterus();
				d.setUterus(uterus);
				Uterus d2 = ser.rechercheParUterus(uterus);
				if (d2 != null && !d2.getIduterus().equals(iduterus)) {
					faces.addMessage(null, new FacesMessage(
							FacesMessage.SEVERITY_ERROR, "L'uterus \"" + uterus
									+ "\" existe déjà.", null));
					addValid = false;
				} else {
					d.setIduterus(iduterus);
					ser.modifierUterus(d);
					faces.addMessage(null, new FacesMessage("Utérus modifié avec succès."));
					addValid = true;
					initialisation();
					RequestContext.getCurrentInstance().update("f1");
					FacesContext context2 = FacesContext.getCurrentInstance();
					context2.getExternalContext().getFlash()
							.setKeepMessages(true);
					try {
						context2.getExternalContext().redirect("GestionUterus");
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
			}
		}

		else if (action.equals("Ajout")) {

			if (uterus == null || (uterus.trim().length() == 0)) {
				// tester si cette zone de text est vide
				faces.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_ERROR,
						"Veuillez donner le nom de l'utérus.", null));
				addValid = false;
			} else // tester si cette uterus existe déjà
			{
				Uterus d3 = ser.rechercheParUterus(uterus);
				if (d3 == null) { // c-à-d n'existe pas uterus avec cette //
									// "uterus"
					Uterus d1 = new Uterus();
					d1.setUterus(uterus);
					ser.ajoutUterus(d1);
					faces.addMessage(null, new FacesMessage("L'utérus \""
							+ uterus + "\" ajouté avec succès."));
					addValid = true;
					initialisation();
					RequestContext.getCurrentInstance().update("f1");
					FacesContext context2 = FacesContext.getCurrentInstance();
					context2.getExternalContext().getFlash()
							.setKeepMessages(true);
					try {
						context2.getExternalContext().redirect("GestionUterus");
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}

				} else {
					faces.addMessage(null, new FacesMessage(
							FacesMessage.SEVERITY_ERROR, "L'utérus \"" + uterus
									+ "\" existe déjà.", null));
					addValid = false;
				}
			}
		}
		context.addCallbackParam("addValid", addValid);
	}

	public void initialisation() {

		uterus = null;
		iduterus = null;
	}

}

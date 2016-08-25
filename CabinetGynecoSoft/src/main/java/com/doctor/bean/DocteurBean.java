package com.doctor.bean;

// Generated 18 ao�t 2014 11:50:48 by Hibernate Tools 3.4.0.CR1

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import com.doctor.persistance.Cfclient;
import com.doctor.persistance.Docteur;
import com.doctor.service.CfclientService;
import com.doctor.service.DocteurService;

@ManagedBean(name = "docteurBean")
@SessionScoped
public class DocteurBean implements java.io.Serializable {

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;

	private Integer iddoctor;
	private String libdoctor;
	private Set<Cfclient> cfclients = new HashSet<Cfclient>(0);

	private String valeurRecherche;
	private int currentP;

	public int getCurrentP() {
		return currentP;
	}

	public void setCurrentP(int currentP) {
		this.currentP = currentP;
	}

	public String getValeurRecherche() {
		valeurRecherche = Module.rechercheDocteur;
		init();
		return valeurRecherche;
	}

	public void setValeurRecherche(String valeurRecherche) {
		this.valeurRecherche = valeurRecherche;
	}

	public Set<Cfclient> getCfclients() {
		return cfclients;
	}

	public void setCfclients(Set<Cfclient> cfclients) {
		this.cfclients = cfclients;
	}

	private List<Docteur> docteurs = new ArrayList<Docteur>();
	// action est un attribut pour différencier l'ajout de la modification
	private String action;

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public Integer getIddoctor() {
		return this.iddoctor;
	}

	public void setIddoctor(Integer iddoctor) {
		this.iddoctor = iddoctor;
	}

	public String getLibdoctor() {
		return this.libdoctor;
	}

	public void setLibdoctor(String libdoctor) {
		this.libdoctor = libdoctor;
	}

	@PostConstruct
	public void init() {
		DocteurService ser = new DocteurService();

		if (valeurRecherche != null){
			Module.rechercheDocteur=valeurRecherche;
			docteurs = ser.rechercheFiltre(valeurRecherche);
			}
		else
			docteurs = ser.rechercheTousDocteur();
	}

	public List<Docteur> getDocteurs() {

		return docteurs;

	}

	public void setDocteurs(List<Docteur> docteurs) {
		this.docteurs = docteurs;
	}

	public void modifierDocteur(Docteur d) {

		iddoctor = d.getIddoctor();
		libdoctor = d.getLibdoctor();
		action = "Modfication";

	}

	public void ajouterDocteur() {
		action = "Ajout";
	}

	public String closeDiag() {
		iddoctor = null;
		libdoctor = null;
		return null;
	}

	public void Supprimer(Integer id) {
		FacesContext faces = FacesContext.getCurrentInstance();
		DocteurService ser = new DocteurService();
		CfclientService ser02 = new CfclientService();
		List<Cfclient> l = ser02.RechercheParDocteur(id);
		if (l.size() == 0) {
			ser.supprimerDocteur(id);
			faces.addMessage(null, new FacesMessage(
					"Docteur supprimé avec succès."));
		} else
			faces.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"Suppression impossible! Docteur utilisé.", null));
		FacesContext context2 = FacesContext.getCurrentInstance();
		context2.getExternalContext().getFlash().setKeepMessages(true);
		try {
			context2.getExternalContext().redirect("GestionDocteur");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void validation() {
		DocteurService ser = new DocteurService();
		Docteur p = new Docteur(libdoctor);
		FacesContext faces = FacesContext.getCurrentInstance();
		RequestContext context = RequestContext.getCurrentInstance();
		boolean addValid = false;
		if (action.equals("Modfication")) {
			if (libdoctor == null || (libdoctor.trim().length() == 0)) {
				// tester si cette zone de text est vide
				faces.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_ERROR,
						"Veuillez donner le nom du docteur.", null));
				addValid = false;
			} else {
				Docteur p2 = ser.rechercheParDocteur(libdoctor);
				if ((p2 != null) && !p2.getIddoctor().equals(iddoctor)) {
					faces.addMessage(null, new FacesMessage(
							FacesMessage.SEVERITY_ERROR, "Le docteur \""
									+ libdoctor + "\" existe déjà.", null));
					addValid = false;

				} else {// faces.addMessage(null,new FacesMessage(
						// "Cette doctor existe déja."));
					p.setIddoctor(iddoctor);
					ser.modifierDocteur(p);
					faces.addMessage(null, new FacesMessage("Le docteur \""
							+ libdoctor + "\" modifié avec succès."));
					addValid = true;
					initialisation();
					RequestContext.getCurrentInstance().update("f1");
					FacesContext context2 = FacesContext.getCurrentInstance();
					context2.getExternalContext().getFlash()
							.setKeepMessages(true);
					try {
						context2.getExternalContext()
								.redirect("GestionDocteur");
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
			}
		} else if (action.equals("Ajout")) {
			if (libdoctor == null || (libdoctor.trim().length() == 0)) {
				// tester si cette zone de text est vide
				faces.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_ERROR,
						"Veuillez donner le nom du docteur.", null));
				addValid = false;
			} else {
				// tester si cette doctor existe déjà
				Docteur p2 = ser.rechercheParDocteur(libdoctor);
				if (p2 == null) { // c-à-d n'existe pas doctor avec cette
									// "libdoctor"
					ser.ajoutDocteur(p);
					faces.addMessage(null, new FacesMessage("Le docteur \""
							+ libdoctor + "\" est ajouté avec succès."));
					addValid = true;
					initialisation();
					RequestContext.getCurrentInstance().update("f1");
					FacesContext context2 = FacesContext.getCurrentInstance();
					context2.getExternalContext().getFlash()
							.setKeepMessages(true);
					try {
						context2.getExternalContext()
								.redirect("GestionDocteur");
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}

				} else {
					faces.addMessage(null, new FacesMessage(
							FacesMessage.SEVERITY_ERROR, "Le docteur \""
									+ libdoctor + "\" existe déjà.", null));
					addValid = false;
				}
			}
		}
		context.addCallbackParam("addValid", addValid);

	}

	public void initialisation() {
		libdoctor = null;
		iddoctor = null;
	}

	public void annulerRecherche() {
		valeurRecherche = null;
	}

}

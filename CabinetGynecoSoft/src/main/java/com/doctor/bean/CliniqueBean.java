package com.doctor.bean;

// Generated 18 ao�t 2014 11:50:48 by Hibernate Tools 3.4.0.CR1

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import com.doctor.persistance.Cfclient;
import com.doctor.persistance.Clinique;
import com.doctor.service.CfclientService;
import com.doctor.service.CliniqueService;

@ManagedBean(name = "cliniqueBean")
@SessionScoped
public class CliniqueBean implements java.io.Serializable {

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;

	private Integer idclinique;
	private String libclinique;
	private Set<Cfclient> cfclientsForProfesscp = new HashSet<Cfclient>(0);
	private Set<Cfclient> cfclientsForProfessp = new HashSet<Cfclient>(0);
	private List<Clinique> cliniques = new ArrayList<Clinique>();
	// action est un attribut pour différencier l'ajout de la modification
	private String action;
	private int currentP;

	public int getCurrentP() {
		return currentP;
	}

	public void setCurrentP(int currentP) {
		this.currentP = currentP;
	}

	private String valeurRecherche;

	public String getValeurRecherche() {
		valeurRecherche = Module.rechercheClinique;
		return valeurRecherche;
	}

	public void setValeurRecherche(String valeurRecherche) {
		Module.rechercheClinique = valeurRecherche;
		this.valeurRecherche = valeurRecherche;
	}

	public void annulerRecherche() {
		Module.rechercheClinique = "";
		valeurRecherche = null;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public Integer getIdclinique() {
		return this.idclinique;
	}

	public void setIdclinique(Integer idclinique) {
		this.idclinique = idclinique;
	}

	public String getLibclinique() {
		return this.libclinique;
	}

	public void setLibclinique(String libclinique) {
		this.libclinique = libclinique;
	}

	public Set<Cfclient> getCfclientsForProfesscp() {
		return this.cfclientsForProfesscp;
	}

	public void setCfclientsForProfesscp(Set<Cfclient> cfclientsForProfesscp) {
		this.cfclientsForProfesscp = cfclientsForProfesscp;
	}

	public Set<Cfclient> getCfclientsForProfessp() {
		return this.cfclientsForProfessp;
	}

	public void setCfclientsForProfessp(Set<Cfclient> cfclientsForProfessp) {
		this.cfclientsForProfessp = cfclientsForProfessp;
	}

	public List<Clinique> getCliniques() {

		CliniqueService ser = new CliniqueService();
		if (valeurRecherche != null)
			cliniques = ser.rechercheFiltre(valeurRecherche);
		else
			cliniques = ser.rechercheTousClinique();
		return cliniques;

	}

	public void setCliniques(List<Clinique> cliniques) {
		this.cliniques = cliniques;
	}

	public void modifierClinique(Clinique d) {
		idclinique = d.getIdclinique();
		libclinique = d.getLibclinique();
		action = "Modification";

	}

	public void ajouterClinique() {
		action = "Ajout";
	}

	public String closeDiag() {
		idclinique = null;
		libclinique = null;
		return null;
	}

	public void Supprimer(Integer id) {
		FacesContext faces = FacesContext.getCurrentInstance();
		CliniqueService ser = new CliniqueService();
		CfclientService ser02 = new CfclientService();
		List<Cfclient> l = ser02.RechercheParClinique(id);
		if (l != null && l.size() == 0) {
			ser.supprimerClinique(id);
			faces.addMessage(null, new FacesMessage(
					"Clinique supprimé avec succès."));
			
		} else
			faces.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"Suppression impossible! Clinique utilisé !", null));
	
		FacesContext context2 = FacesContext.getCurrentInstance();
		context2.getExternalContext().getFlash()
				.setKeepMessages(true);
		try {
			context2.getExternalContext().redirect("GestionClinique");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void validation() {
		CliniqueService ser = new CliniqueService();
		Clinique p = new Clinique(libclinique);
		FacesContext faces = FacesContext.getCurrentInstance();
		RequestContext context = RequestContext.getCurrentInstance();
		boolean addValid = false;

		if (action.equals("Modification")) {
			if (libclinique == null || (libclinique.trim().length() == 0)) {
				// tester si cette zone de text est vide
				faces.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_ERROR,
						"Veuillez donner le nom du clinique.", null));
				addValid = false;
			} else {
				Clinique p2 = ser.rechercheParClinique(libclinique);
				if (p2 != null && !p2.getIdclinique().equals(idclinique)) {
					faces.addMessage(null, new FacesMessage(
							FacesMessage.SEVERITY_ERROR, "La clinique \""
									+ libclinique + "\" existe déjà.", null));
					addValid = false;
				} else {
					p.setIdclinique(idclinique);
					ser.modifierClinique(p);
					faces.addMessage(null, new FacesMessage("La clinique \""
							+ libclinique + "\"  modifiée avec succès."));
					addValid = true;
					initialisation();
					RequestContext.getCurrentInstance().update("f1");
					FacesContext context2 = FacesContext.getCurrentInstance();
					context2.getExternalContext().getFlash()
							.setKeepMessages(true);
					try {
						context2.getExternalContext().redirect("GestionClinique");
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
			}
		} else if (action.equals("Ajout")) {
			if (libclinique == null || (libclinique.trim().length() == 0)) {
				// tester si cette zone de text est vide
				faces.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_ERROR,
						"Veuillez donner le nom du clinique.", null));
				addValid = false;
			} else {
				// tester si cette clinique existe déjà
				Clinique p2 = ser.rechercheParClinique(libclinique);
				if (p2 == null) { // c-à-d n'existe pas clinique avec cette
									// "libclinique"
					ser.ajoutClinique(p);

					faces.addMessage(null, new FacesMessage("La clinique \""
							+ libclinique + "\"  ajoutée avec succès."));
					addValid = true;
					initialisation();
					RequestContext.getCurrentInstance().update("f1");
					FacesContext context2 = FacesContext.getCurrentInstance();
					context2.getExternalContext().getFlash()
							.setKeepMessages(true);
					try {
						context2.getExternalContext().redirect("GestionClinique");
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				} else {
					// faces.addMessage(null,new FacesMessage(
					// "Cette clinique existe déja."));
					faces.addMessage(null, new FacesMessage(
							FacesMessage.SEVERITY_ERROR, "La clinique \""
									+ libclinique + "\" existe déjà.", null));
					addValid = false;
				}
			}
		}
		context.addCallbackParam("addValid", addValid);
	}

	public void initialisation() {
		libclinique = null;
		idclinique = null;
	}
}

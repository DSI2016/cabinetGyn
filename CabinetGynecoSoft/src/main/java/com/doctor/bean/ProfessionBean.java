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
import com.doctor.persistance.Profession;
import com.doctor.service.CfclientService;
import com.doctor.service.ProfessionService;

@ManagedBean(name = "professionBean")
@SessionScoped
public class ProfessionBean implements java.io.Serializable {

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;

	private Integer idprofession;
	private String libprofession;
	private Set<Cfclient> cfclientsForProfesscp = new HashSet<Cfclient>(0);
	private Set<Cfclient> cfclientsForProfessp = new HashSet<Cfclient>(0);
	private List<Profession> professions = new ArrayList<Profession>();
	// action est un attribut pour différencier l'ajout de la modification
	private String action;

	private String valeurRecherche;
	private int currentP;

	public int getCurrentP() {
		return currentP;
	}

	public void setCurrentP(int currentP) {
		this.currentP = currentP;
	}

	public String getValeurRecherche() {
		valeurRecherche = Module.rechercheProf;
		init();
		return valeurRecherche;
	}

	public void setValeurRecherche(String valeurRecherche) {
		Module.rechercheProf = valeurRecherche;
		this.valeurRecherche = valeurRecherche;
	}

	public void annulerRecherche() {
		Module.rechercheProf = "";
		valeurRecherche = null;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public Integer getIdprofession() {
		return this.idprofession;
	}

	public void setIdprofession(Integer idprofession) {
		this.idprofession = idprofession;
	}

	public String getLibprofession() {
		return this.libprofession;
	}

	public void setLibprofession(String libprofession) {
		this.libprofession = libprofession;
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

	@PostConstruct
	public void init() {
		ProfessionService ser = new ProfessionService();
		if (valeurRecherche != null) {
			Module.rechercheProf = valeurRecherche;
			professions = ser.rechercheFiltre(valeurRecherche);
		} else {
			Module.rechercheProf = "";
			professions = ser.rechercheTousProfession();
		}
		RequestContext.getCurrentInstance().update("f1");
	}

	public List<Profession> getProfessions() {

		return professions;

	}

	public void setProfessions(List<Profession> professions) {
		this.professions = professions;
	}

	public void modifierProfession(Profession d) {
		idprofession = d.getIdprofession();
		libprofession = d.getLibprofession();
		action = "Modification";

	}

	public void ajouterProfession() {
		action = "Ajout";
	}

	public String closeDiag() {
		idprofession = null;
		libprofession = null;
		return null;
	}

	public void Supprimer(Integer id) {
		FacesContext faces = FacesContext.getCurrentInstance();
		List<Cfclient> l = new CfclientService().RechercheParProfession(id);
		
		if (l != null && l.size() == 0) {
			new ProfessionService().supprimerProfession(id);
			faces.addMessage(
					null,
					new FacesMessage(
							"Profession supprimée avec succès."));
			//init();
		} else
			faces.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"Suppression impossible!  Profession utilisée.", null));

		FacesContext context2 = FacesContext.getCurrentInstance();
		context2.getExternalContext().getFlash().setKeepMessages(true);
		try {
			context2.getExternalContext().redirect("GestionProfession");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void validation() {
		ProfessionService ser = new ProfessionService();
		Profession p = new Profession(libprofession);
		FacesContext faces = FacesContext.getCurrentInstance();
		RequestContext context = RequestContext.getCurrentInstance();
		boolean addValid = false;

		if (action.equals("Modification")) {
			if (libprofession == null || (libprofession.trim().length() == 0)) {
				// tester si cette zone de text est vide

				faces.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_ERROR,
						"Veuillez donner le nom de la profession.", null));
				addValid = false;
			} else {
				Profession pp02 = ser.rechercheParProfession(libprofession);
				if (pp02 != null
						&& !pp02.getIdprofession().equals(idprofession)) {
					faces.addMessage(null, new FacesMessage(
							FacesMessage.SEVERITY_ERROR, "La profession \""
									+ libprofession + "\" existe déjà.", null));
					addValid = false;
				} else {
					p.setIdprofession(idprofession);
					ser.modifierProfession(p);
					faces.addMessage(null, new FacesMessage(
							"Profession modifiée avec succès."));
					initialisation();
					//init();
					RequestContext.getCurrentInstance().update("f1");
					addValid = true;
					FacesContext context2 = FacesContext.getCurrentInstance();
					context2.getExternalContext().getFlash()
							.setKeepMessages(true);
					try {
						context2.getExternalContext().redirect(
								"GestionProfession");
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
			}
		}

		else if (action.equals("Ajout")) {
			if (libprofession == null || (libprofession.trim().length() == 0)) {
				// tester si cette zone de text est vide

				faces.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_ERROR,
						"Veuillez donner le nom de la profession.", null));
				addValid = false;

			} else // tester si cette docteur existe déjà

			{

				Profession p2 = ser.rechercheParProfession(libprofession);
				if (p2 == null) { // c-à-d n'existe pas profession avec cette
									// "libprofession"
					ser.ajoutProfession(p);

					faces.addMessage(null, new FacesMessage(
							"Profession ajoutée avec succès."));
					initialisation();
					addValid = true;
					//init();
					RequestContext.getCurrentInstance().update("f1");
					FacesContext context2 = FacesContext.getCurrentInstance();
					context2.getExternalContext().getFlash()
							.setKeepMessages(true);
					try {
						context2.getExternalContext().redirect(
								"GestionProfession");
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				} else {// faces.addMessage(null,new FacesMessage(
						// "Cette profession existe déja."));
					faces.addMessage(null, new FacesMessage(
							FacesMessage.SEVERITY_ERROR, "La profession \""
									+ libprofession + "\" existe déjà.", null));
					addValid = false;
				}
			}
		}
		context.addCallbackParam("addValid", addValid);
	}

	public void initialisation() {
		libprofession = null;
		idprofession = null;
	}
}

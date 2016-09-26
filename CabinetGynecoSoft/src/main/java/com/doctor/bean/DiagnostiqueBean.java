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
import com.doctor.persistance.Diagnostique;
import com.doctor.service.DiagnostiqueService;

@ManagedBean(name = "diagnostiqueBean")
@SessionScoped
public class DiagnostiqueBean implements java.io.Serializable {

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;

	private Integer iddiagnostique;
	private String diagnostique;
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
		valeurRecherche=Module.recherchediagnos;
		init();
		return valeurRecherche;
	}

	public void setValeurRecherche(String valeurRecherche) {
		Module.recherchediagnos=valeurRecherche;
		this.valeurRecherche = valeurRecherche;
	}

	public void annulerRecherche() {
		Module.recherchediagnos="";
		
		valeurRecherche = null;
	}


	public Set<Cfclient> getCfclients() {
		return cfclients;
	}

	public void setCfclients(Set<Cfclient> cfclients) {
		this.cfclients = cfclients;
	}

	private List<Diagnostique> diagnostiques = new ArrayList<Diagnostique>();
	// action est un attribut pour différencier l'ajout de la modification
	private String action;

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public Integer getIddiagnostique() {
		return this.iddiagnostique;
	}

	public void setIddiagnostique(Integer iddiagnostique) {
		this.iddiagnostique = iddiagnostique;
	}

	public String getDiagnostique() {
		return this.diagnostique;
	}

	public void setDiagnostique(String diagnostique) {
		this.diagnostique = diagnostique;
	}

	@PostConstruct
	public void init(){
		DiagnostiqueService ser = new DiagnostiqueService();
		if (valeurRecherche != null)
			diagnostiques = ser.rechercheFiltre(valeurRecherche);
		else
			diagnostiques = ser.rechercheTousDiagnostique();
	}
	
	
	public List<Diagnostique> getDiagnostiques() {

		
		return diagnostiques;

	}

	public void setDiagnostiques(List<Diagnostique> diagnostiques) {
		this.diagnostiques = diagnostiques;
	}

	public void modifierDiagnostique(Diagnostique d) {
		iddiagnostique = d.getIddiagnostique();
		diagnostique = d.getDiagnostique();
		action = "Modification";

	}

	public void ajouterDiagnostique() {
		initialisation();
		action = "Ajout";
	}

	public String closeDiag() {
		iddiagnostique = null;
		diagnostique = null;
		return null;
	}

	public void Supprimer(Integer id) {

		DiagnostiqueService ser = new DiagnostiqueService();
		ser.supprimerDiagnostique(id);
		FacesContext faces = FacesContext.getCurrentInstance();
		faces.addMessage(
				null,
				new FacesMessage(
						"Suppression Diagnostique :  Diagnostique supprimé avec succès."));
		FacesContext context2 = FacesContext.getCurrentInstance();
		context2.getExternalContext().getFlash()
				.setKeepMessages(true);
		try {
			context2.getExternalContext().redirect("GestionDiagnostique");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void validation() {
		diagnostique=diagnostique.replaceAll("\\s+", " ");
		DiagnostiqueService ser = new DiagnostiqueService();

		FacesContext faces = FacesContext.getCurrentInstance();
		RequestContext context = RequestContext.getCurrentInstance();
		boolean addValid = false;
		if (action.equals("Modification")) {
			if (diagnostique == null || (diagnostique.trim().length() == 0)) {
				// tester si cette zone de text est vide text est vide
				faces.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_ERROR,
						"Veuillez donner le nom de la diagnostique.", null));
				addValid = false;
			} else // tester si cette diagnostique existe déjà
			{
				Diagnostique d = new Diagnostique(diagnostique);
				Diagnostique d2 = ser.rechercheParDiagnostique(diagnostique);
				if (d2 != null
						&& !d2.getIddiagnostique().equals(iddiagnostique)) {
					faces.addMessage(null, new FacesMessage(
							FacesMessage.SEVERITY_ERROR, "La diagnostique \""
									+ diagnostique + "\" existe déjà.", null));
					addValid = false;
				} else {
					d.setIddiagnostique(iddiagnostique);
					ser.modifierDiagnostique(d);
					faces.addMessage(null, new FacesMessage("Diagnostique modifiée avec succès."));
					addValid = true;
					initialisation();
					RequestContext.getCurrentInstance().update("f1");
					FacesContext context2 = FacesContext.getCurrentInstance();
					context2.getExternalContext().getFlash()
							.setKeepMessages(true);
					try {
						context2.getExternalContext().redirect("GestionDiagnostique");
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
			}
		}

		else if (action.equals("Ajout")) {

			if (diagnostique == null || (diagnostique.trim().length() == 0)) {
				// tester si cette zone de text est vide
				faces.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_ERROR,
						"Veuillez donner le nom de la diagnostique.", null));
				addValid = false;
			} else // tester si cette diagnostique existe déjà
			{
				Diagnostique d3 = ser.rechercheParDiagnostique(diagnostique);
				if (d3 == null) { // c-à-d n'existe pas diagnostique avec cette
									// // "diagnostique"
					Diagnostique d1 = new Diagnostique(diagnostique);
					ser.ajoutDiagnostique(d1);
					faces.addMessage(null, new FacesMessage("Diagnostique  \""
							+ diagnostique + "\" ajoutée avec succès."));
					addValid = true;
					initialisation();
					RequestContext.getCurrentInstance().update("f1");
					FacesContext context2 = FacesContext.getCurrentInstance();
					context2.getExternalContext().getFlash()
							.setKeepMessages(true);
					try {
						context2.getExternalContext().redirect("GestionDiagnostique");
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				} else {// faces.addMessage(null,new FacesMessage(
						// "Cette diagnostique existe déja."));
					faces.addMessage(null, new FacesMessage(
							FacesMessage.SEVERITY_ERROR, "La diagnostique \""
									+ diagnostique + "\" existe déjà.", null));
					addValid = false;
				}
			}
		}
		context.addCallbackParam("addValid", addValid);

	}

	public void initialisation() {
		diagnostique = null;
		iddiagnostique = null;
	}
}

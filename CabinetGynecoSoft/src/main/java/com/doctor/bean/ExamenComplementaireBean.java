package com.doctor.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import com.doctor.persistance.ExamenComplementaire;
import com.doctor.service.ExamenComplementaireService;

@ManagedBean(name = "examenComplementaireBean")
@SessionScoped
public class ExamenComplementaireBean implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idexamenComplementaire;
	private String libExamenComplementaire;
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
		valeurRecherche=Module.rechercheExamenComp;
		return valeurRecherche;
	}

	public void setValeurRecherche(String valeurRecherche) {
		Module.rechercheExamenComp=valeurRecherche;
		this.valeurRecherche = valeurRecherche;
	}

	public void annulerRecherche() {
		Module.rechercheExamenComp="";
		valeurRecherche = null;
	}

	private List<ExamenComplementaire> examenComplementaires = new ArrayList<ExamenComplementaire>();

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public Integer getIdexamenComplementaire() {
		return idexamenComplementaire;
	}

	public void setIdexamenComplementaire(Integer idexamenComplementaire) {
		this.idexamenComplementaire = idexamenComplementaire;
	}

	public String getLibExamenComplementaire() {
		return libExamenComplementaire;
	}

	public void setLibExamenComplementaire(String libExamenComplementaire) {
		this.libExamenComplementaire = libExamenComplementaire;
	}

	public List<ExamenComplementaire> getExamenComplementaires() {
		ExamenComplementaireService ser = new ExamenComplementaireService();
		if (valeurRecherche == null)
			examenComplementaires = ser.rechercheTousExamenComplementaire();
		else
			examenComplementaires = ser.rechercheFiltre(valeurRecherche);
		return examenComplementaires;
	}

	public void setExamenComplementaires(
			List<ExamenComplementaire> examenComplementaires) {
		this.examenComplementaires = examenComplementaires;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void ajouterExamenComplementaire() {
		initialisation();
		action = "Ajout";
	}

	public String closeDiag() {
		idexamenComplementaire = null;
		libExamenComplementaire = null;
		return null;
	}

	public void modifierExamenComplementaire(ExamenComplementaire d) {
		idexamenComplementaire = d.getIdexamenComplementaire();
		libExamenComplementaire = d.getLibExamenComplementaire();
		action = "Modification";

	}

	public void Supprimer(Integer id) {
		ExamenComplementaireService ser = new ExamenComplementaireService();
		ser.supprimerExamenComplementaire(id);
		FacesContext faces = FacesContext.getCurrentInstance();
		faces.addMessage(null, new FacesMessage(
				"Examen supprimé avec succès."));
		FacesContext context2 = FacesContext.getCurrentInstance();
		context2.getExternalContext().getFlash()
				.setKeepMessages(true);
		try {
			context2.getExternalContext().redirect("GestionExamenComplementaire");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void validation() {
		libExamenComplementaire=libExamenComplementaire.replaceAll("\\s+", " ");
		ExamenComplementaireService ser = new ExamenComplementaireService();

		FacesContext faces = FacesContext.getCurrentInstance();
		RequestContext context = RequestContext.getCurrentInstance();
		boolean addValid = false;
		if (action.equals("Modification")) {
			if (libExamenComplementaire == null
					|| (libExamenComplementaire.trim().length() == 0)) {
				// tester si cette zone de text est vide
				faces.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_ERROR,
						"Veuillez donner le nom de l'examen.", null));
				addValid = false;
			} else // tester si cette ville existe déjà
			{
				ExamenComplementaire d = new ExamenComplementaire(
						libExamenComplementaire);
				ExamenComplementaire d2 = ser
						.rechercheExamenComplementaireParLibelleExamenComplementaire(libExamenComplementaire);
				if (d2 != null
						&& !d2.getIdexamenComplementaire().equals(
								idexamenComplementaire)) {
					faces.addMessage(null, new FacesMessage(
							FacesMessage.SEVERITY_ERROR, "L'examen \""
									+ libExamenComplementaire
									+ "\" existe déjà.", null));
					addValid = false;
				} else {
					d.setIdexamenComplementaire(idexamenComplementaire);
					d.setLibExamenComplementaire(libExamenComplementaire);
					ser.modifierExamenComplementaire(d);
					faces.addMessage(null, new FacesMessage("Examen modifié avec succès."));
					addValid = true;
					initialisation();
					RequestContext.getCurrentInstance().update("f1");
					FacesContext context2 = FacesContext.getCurrentInstance();
					context2.getExternalContext().getFlash()
							.setKeepMessages(true);
					try {
						context2.getExternalContext().redirect("GestionExamenComplementaire");
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
			}
		}

		else

		if (action.equals("Ajout")) {

			if (libExamenComplementaire == null
					|| (libExamenComplementaire.trim().length() == 0)) {
				// tester si cette zone de text est vide
				faces.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_ERROR,
						"Veuillez donner le nom de l'examen.", null));
				addValid = false;
			} else // tester si cette etat existe déjà
			{

				ExamenComplementaire d3 = ser
						.rechercheExamenComplementaireParLibelleExamenComplementaire(libExamenComplementaire);

				if (d3 == null) { 
					ExamenComplementaire d1 = new ExamenComplementaire(
							libExamenComplementaire);

					ser.ajoutExamenComplementaire(d1);
					faces.addMessage(null, new FacesMessage("L'examen \""
							+ libExamenComplementaire
							+ "\"  ajouté avec succès."));
					addValid = true;
					initialisation();
					RequestContext.getCurrentInstance().update("f1");
					FacesContext context2 = FacesContext.getCurrentInstance();
					context2.getExternalContext().getFlash()
							.setKeepMessages(true);
					try {
						context2.getExternalContext().redirect("GestionExamenComplementaire");
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}

				} else

				{
					faces.addMessage(null, new FacesMessage(
							FacesMessage.SEVERITY_ERROR, "L'examen \""
									+ libExamenComplementaire
									+ "\" existe déjà.", null));
					addValid = false;
				}
			}
		}
		context.addCallbackParam("addValid", addValid);
		

	}
	public void initialisation (){
		libExamenComplementaire = null;
		idexamenComplementaire = null;
		
	}

}

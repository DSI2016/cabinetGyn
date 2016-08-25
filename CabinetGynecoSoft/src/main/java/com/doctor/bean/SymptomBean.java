package com.doctor.bean;


import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import com.doctor.persistance.Symptome;
import com.doctor.service.SymptomeService;

@ManagedBean(name = "symptomeBean")
@SessionScoped
public class SymptomBean implements java.io.Serializable {

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;

	private Integer idsymptome;
	private String symptome;

	private String valeurRecherche;
	private int currentP;

	public int getCurrentP() {
		return currentP;
	}

	public void setCurrentP(int currentP) {
		this.currentP = currentP;
	}

	public String getValeurRecherche() {
		valeurRecherche = Module.recherchesympt;
		init();
		return valeurRecherche;
	}

	public void setValeurRecherche(String valeurRecherche) {
		Module.recherchesympt = valeurRecherche;
		this.valeurRecherche = valeurRecherche;
	}

	public void annulerRecherche() {
		Module.recherchesympt = "";
		valeurRecherche = null;
	}

	@PostConstruct
	public void init() {
		SymptomeService ser = new SymptomeService();
		if (valeurRecherche != null)
			symptomes = ser.rechercheFiltre(valeurRecherche);
		else
			symptomes = ser.rechercheTousSymptome();
	}

	private List<Symptome> symptomes = new ArrayList<Symptome>();
	// action est un attribut pour différencier l'ajout de la modification
	private String action;

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public Integer getIdsymptome() {
		return this.idsymptome;
	}

	public void setIdsymptome(Integer idsymptome) {
		this.idsymptome = idsymptome;
	}

	public String getSymptome() {
		return this.symptome;
	}

	public void setSymptome(String symptome) {
		this.symptome = symptome;
	}

	public List<Symptome> getSymptomes() {

		return symptomes;

	}

	public void setSymptomes(List<Symptome> symptomes) {
		this.symptomes = symptomes;
	}

	public void modifierSymptome(Symptome d) {
		idsymptome = d.getIdsymptome();
		symptome = d.getSymptome();
		action = "Modification";

	}

	public void ajouterSymptome() {
		action = "Ajout";
	}

	public String closeDiag() {
		idsymptome = null;
		symptome = null;
		return null;
	}

	public void Supprimer(Integer id) {
		SymptomeService ser = new SymptomeService();
		ser.supprimerSymptome(id);
		FacesContext faces = FacesContext.getCurrentInstance();
		faces.addMessage(null, new FacesMessage(
				"Suppression Symptôme :  Symptôme supprimé avec succès."));
		FacesContext context2 = FacesContext.getCurrentInstance();
		context2.getExternalContext().getFlash().setKeepMessages(true);
		try {
			context2.getExternalContext().redirect("GestionSymptome");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void validation() {
		SymptomeService ser = new SymptomeService();

		FacesContext faces = FacesContext.getCurrentInstance();
		RequestContext context = RequestContext.getCurrentInstance();
		boolean addValid = false;
		if (action.equals("Modification")) {
			if (symptome == null || (symptome.trim().length() == 0)) {
				// tester si cette zone de text est vide text est vide
				faces.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_ERROR,
						"Veuillez donner le nom du symptôme.", null));
				addValid = false;
			} else // tester si cette symptome existe déjà
			{
				Symptome d = new Symptome(symptome);
				Symptome d2 = ser.rechercheParSymptome(symptome);
				if (d2 != null && !d2.getIdsymptome().equals(idsymptome)) {
					faces.addMessage(null, new FacesMessage(
							FacesMessage.SEVERITY_ERROR, "Le symptôme \""
									+ symptome + "\" existe déjà.", null));

					addValid = false;
				} else {
					d.setIdsymptome(idsymptome);
					ser.modifierSymptome(d);
					faces.addMessage(null, new FacesMessage("Le symptôme  \""
							+ symptome + "\" modifié avec succès."));
					addValid = true;
					initialisation();
					RequestContext.getCurrentInstance().update("f1");
					FacesContext context2 = FacesContext.getCurrentInstance();
					context2.getExternalContext().getFlash()
							.setKeepMessages(true);
					try {
						context2.getExternalContext().redirect(
								"GestionSymptome");
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}

				}
			}
		}

		else if (action.equals("Ajout")) {

			if (symptome == null || (symptome.trim().length() == 0)) {
				// tester si cette zone de text est vide text est vide
				faces.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_ERROR,
						"Veuillez donner le nom du symptôme.", null));
				addValid = false;
			} else // tester si cette symptome existe déjà
			{
				Symptome d3 = ser.rechercheParSymptome(symptome);
				if (d3 == null) { // c-à-d n'existe pas symptome avec cette //
									// "symptome"
					Symptome d1 = new Symptome(symptome);
					ser.ajoutSymptome(d1);
					faces.addMessage(null, new FacesMessage("Le symptôme \""
							+ symptome + "\"  ajouté avec succès."));
					addValid = true;
					initialisation();
					RequestContext.getCurrentInstance().update("f1");
					FacesContext context2 = FacesContext.getCurrentInstance();
					context2.getExternalContext().getFlash()
							.setKeepMessages(true);
					try {
						context2.getExternalContext().redirect(
								"GestionSymptome");
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}

				} else {
					faces.addMessage(null, new FacesMessage(
							FacesMessage.SEVERITY_ERROR, "Le symptôme \""
									+ symptome + "\" existe déjà.", null));
					addValid = false;
				}
			}
		}
		context.addCallbackParam("addValid", addValid);
	}

	public void initialisation() {
		symptome = null;
		idsymptome = null;
	}
}

package com.doctor.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import com.doctor.persistance.FormeMedicament;
import com.doctor.service.FormeMedicamentService;
import com.doctor.service.MedicamentService;

@ManagedBean(name = "formeMedicamentBean")
@SessionScoped
public class FormeMedicamentBean implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idFormeMedicament;
	private String forme;
	private String action;
	private List<FormeMedicament> formeMedicaments = new ArrayList<FormeMedicament>();
	private String valeurRecherche;
	private int currentP;

	public int getCurrentP() {
		return currentP;
	}

	public void setCurrentP(int currentP) {
		this.currentP = currentP;
	}

	public Integer getIdFormeMedicament() {
		return idFormeMedicament;
	}

	public void setIdFormeMedicament(Integer idFormeMedicament) {
		this.idFormeMedicament = idFormeMedicament;
	}

	public String getForme() {
		return forme;
	}

	public void setForme(String forme) {
		this.forme = forme;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getValeurRecherche() {
		valeurRecherche = Module.rechercheFormMed;
		init();
		return valeurRecherche;
	}

	public void setValeurRecherche(String valeurRecherche) {
		Module.rechercheFormMed = valeurRecherche;
		this.valeurRecherche = valeurRecherche;
	}

	@PostConstruct
	public void init() {
		FormeMedicamentService ser = new FormeMedicamentService();
		if (valeurRecherche != null)
			formeMedicaments = ser.rechercheFiltre(valeurRecherche);
		else
			formeMedicaments = ser.rechercheTousFormeMedicament();
	}

	public List<FormeMedicament> getFormeMedicaments() {
		return formeMedicaments;
	}

	public void setFormeMedicaments(List<FormeMedicament> formeMedicaments) {
		this.formeMedicaments = formeMedicaments;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void ajouterFormeMedicament() {
		action = "Ajout";
	}

	public String closeDiag() {
		idFormeMedicament = null;
		forme = null;
		return null;
	}

	public void modifierFormeMedicament(FormeMedicament d) {
		idFormeMedicament = d.getIdFormeMedicament();
		forme = d.getForme();
		action = "Modification";

	}

	public void supprimerFormeMed(FormeMedicament fm) {
		FacesContext faces = FacesContext.getCurrentInstance();
		FormeMedicamentService ser = null;
		// tester si ce forme existe comme clé etragère dans d'autre table
		MedicamentService s = new MedicamentService();
		if (s.rechercheParForme(fm.getIdFormeMedicament()) == null) {

			ser = new FormeMedicamentService();
			ser.supprimerFormeMedicament(fm.getIdFormeMedicament());
			faces.addMessage(
					null,
					new FacesMessage(
							"Suppression Forme Médicament :  Forme supprimée avec succès."));
		} else
			faces.addMessage(
					null,
					new FacesMessage(
							FacesMessage.SEVERITY_ERROR,
							"Vous ne pouvez pas supprimer cette forme.\n Il y a des médicaments avec cette forme "
									+ fm.getForme(), null));
		FacesContext context2 = FacesContext.getCurrentInstance();
		context2.getExternalContext().getFlash().setKeepMessages(true);
		try {
			context2.getExternalContext().redirect("GestionFormMedicament");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void validation() {
		FormeMedicamentService ser = new FormeMedicamentService();

		FacesContext faces = FacesContext.getCurrentInstance();
		RequestContext context = RequestContext.getCurrentInstance();
		boolean addValid = false;
		if (action.equals("Modification")) {
			if (forme == null || (forme.trim().length() == 0)) {// tester si
																// cette zone de
																// text est vide
				// text est vide
				faces.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_ERROR,
						"Veuillez donner le nom de la forme.", null));
				addValid = false;
			} else {
				FormeMedicament d = new FormeMedicament(forme);
				FormeMedicament d2 = ser
						.rechercheFormeMedicamentParLibelleFormeMedicament(forme);
				if (d2 != null
						&& !d2.getIdFormeMedicament().equals(idFormeMedicament)) {
					faces.addMessage(null, new FacesMessage(
							FacesMessage.SEVERITY_ERROR, "Forme médicament \""
									+ forme + "\" existe déjà.", null));
					addValid = false;
				} else {
					d.setIdFormeMedicament(idFormeMedicament);
					d.setForme(forme);
					ser.modifierFormeMedicament(d);
					faces.addMessage(null, new FacesMessage(
							"Forme médicament \"" + forme
									+ "\" modifiée avec succès."));
					addValid = true;
					initialisation();
					RequestContext.getCurrentInstance().update("f1");
					FacesContext context2 = FacesContext.getCurrentInstance();
					context2.getExternalContext().getFlash()
							.setKeepMessages(true);
					try {
						context2.getExternalContext().redirect(
								"GestionFormMedicament");
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
			}
		}

		else

		if (action.equals("Ajout")) {

			if (forme == null || (forme.trim().length() == 0)) {// tester si
																// cette zone de
																// text est vide
				faces.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_ERROR,
						"Veuillez donner le nom de la forme.", null));
				addValid = false;
			} else // tester si ce forme existe déjà
			{

				FormeMedicament d3 = ser
						.rechercheFormeMedicamentParLibelleFormeMedicament(forme);

				if (d3 == null) { // c-à-d n'existe pas forme avec ce nom

					FormeMedicament d1 = new FormeMedicament(forme);

					ser.ajoutFormeMedicament(d1);
					faces.addMessage(null, new FacesMessage(
							"Forme médicament \"" + forme
									+ "\" ajoutée avec succès."));
					addValid = true;
					initialisation();
					RequestContext.getCurrentInstance().update("f1");
					FacesContext context2 = FacesContext.getCurrentInstance();
					context2.getExternalContext().getFlash()
							.setKeepMessages(true);
					try {
						context2.getExternalContext().redirect(
								"GestionFormMedicament");
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}

				} else

					faces.addMessage(null, new FacesMessage(
							FacesMessage.SEVERITY_ERROR, "Forme médicament \""
									+ forme + "\" existe déjà.", null));
				addValid = false;

			}
		}

		context.addCallbackParam("addValid", addValid);
	}

	public void initialisation() {
		forme = null;
		idFormeMedicament = null;
	}

	public void annulerRecherche() {
		Module.rechercheFormMed = "";
		valeurRecherche = null;
	}

}

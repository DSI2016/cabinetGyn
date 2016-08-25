package com.doctor.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import com.doctor.persistance.Examen;
import com.doctor.service.ExamenService;

@ManagedBean(name = "examenBean")
@SessionScoped
public class ExamenBean implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idexamen;
	private String examen;
	private String action;
	private List<Examen> examens = new ArrayList<Examen>();
	private String valeurRecherche;
	private int currentP;

	public int getCurrentP() {
		return currentP;
	}

	public void setCurrentP(int currentP) {
		this.currentP = currentP;
	}

	public String getValeurRecherche() {
		valeurRecherche = Module.rechercheExamen;
		init();
		return valeurRecherche;
	}

	public void setValeurRecherche(String valeurRecherche) {
		Module.rechercheExamen = valeurRecherche;
		this.valeurRecherche = valeurRecherche;
	}

	public void annulerRecherche() {
		Module.rechercheExamen = "";
		valeurRecherche = null;
	}

	public Integer getIdexamen() {
		return idexamen;
	}

	public void setIdexamen(Integer idexamen) {
		this.idexamen = idexamen;
	}

	public String getExamen() {
		return examen;
	}

	public void setExamen(String examen) {
		this.examen = examen;
	}

	@PostConstruct
	public void init() {
		ExamenService ser = new ExamenService();
		if (valeurRecherche == null)
			examens = ser.rechercheToutExamen();
		else
			examens = ser.rechercheFiltre(valeurRecherche);
	}

	public List<Examen> getExamens() {

		return examens;
	}

	public void setExamens(List<Examen> examens) {
		this.examens = examens;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public void ajouterExamen() {
		action = "Ajout";
	}

	public String closeDiag() {
		idexamen = null;
		examen = null;
		return null;
	}

	public void modifierExamen(Examen e) {
		idexamen = e.getIdexamen();
		examen = e.getExamen();
		action = "Modification";
	}

	public void Supprimer(Integer id) {
		FacesContext faces = FacesContext.getCurrentInstance();

		ExamenService ser = new ExamenService();
		ser.supprimerExamen(id);
		faces.addMessage(null, new FacesMessage(
				"Examen supprimé avec succès."));
		FacesContext context2 = FacesContext.getCurrentInstance();
		context2.getExternalContext().getFlash().setKeepMessages(true);
		try {
			context2.getExternalContext().redirect("GestionExamenClinique");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void validation() {
		ExamenService ser = new ExamenService();

		FacesContext faces = FacesContext.getCurrentInstance();
		RequestContext context = RequestContext.getCurrentInstance();
		boolean addValid = false;
		if (action.equals("Modification")) {
			if (examen == null || (examen.trim().length() == 0)) {
				// tester si cette zone de text est vide

				faces.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_ERROR,
						"Veuillez donner le nom de l'examen.", null));
				addValid = false;

			} else // tester si cet examen existe déjà
			{
				Examen d = new Examen(examen.trim());
				Examen d2 = ser.rechercheExamenParLibelExamen(examen.trim());
				if (d2 != null && !d2.getIdexamen().equals(idexamen)) {
					faces.addMessage(null, new FacesMessage(
							FacesMessage.SEVERITY_ERROR, "L'examen \"" + examen
									+ "\" existe déjà.", null));
					addValid = false;

				} else {
					d.setIdexamen(idexamen);
					ser.modifierExamen(d);
					faces.addMessage(null, new FacesMessage(
							"Examen modifié avec succès."));
					addValid = true;
					initialisation();
					RequestContext.getCurrentInstance().update("f1");
					FacesContext context2 = FacesContext.getCurrentInstance();
					context2.getExternalContext().getFlash()
							.setKeepMessages(true);
					try {
						context2.getExternalContext().redirect(
								"GestionExamenClinique");
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
			}
		} else

		if (action.equals("Ajout")) {

			if (examen == null || (examen.trim().length() == 0)) {
				// tester si cette zone de text est vide
				faces.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_ERROR,
						"Veuillez donner le nom de l'examen.", null));
				addValid = false;

			} else // tester si cette etat existe déjà
			{
				Examen d3 = ser.rechercheExamenParLibelExamen(examen.trim());
				if (d3 == null) { // c-à-d n'existe pas examen avec ce nom //

					Examen d1 = new Examen(examen.trim());

					ser.ajouterExamen(d1);
					faces.addMessage(null, new FacesMessage(
							"Examen ajouté avec succès."));
					addValid = true;
					initialisation();
					RequestContext.getCurrentInstance().update("f1");
					FacesContext context2 = FacesContext.getCurrentInstance();
					context2.getExternalContext().getFlash()
							.setKeepMessages(true);
					try {
						context2.getExternalContext().redirect(
								"GestionExamenClinique");
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				} else

				{
					faces.addMessage(null, new FacesMessage(
							FacesMessage.SEVERITY_ERROR, "L'examen " + examen
									+ " existe déjà.", null));
					addValid = false;

				}

			}
		}
		context.addCallbackParam("addValid", addValid);

	}

	public void initialisation() {
		examen = null;
		idexamen = null;
	}

}
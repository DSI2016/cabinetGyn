package com.doctor.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import com.doctor.persistance.Analyse;
import com.doctor.service.AnalyseService;

@ManagedBean(name = "analyseBean")
@SessionScoped
public class AnalyseBean implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idanalyse;
	private String libAnalyse;
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
		valeurRecherche = Module.rechercheAnalyse;
		init();
		return valeurRecherche;
	}

	public void setValeurRecherche(String valeurRecherche) {
		Module.rechercheAnalyse = valeurRecherche;
		this.valeurRecherche = valeurRecherche;
	}

	public void annulerRecherche() {
		Module.rechercheAnalyse = "";
		valeurRecherche = null;
		init();
	}

	private List<Analyse> analyses = new ArrayList<Analyse>();

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public Integer getIdanalyse() {
		return idanalyse;
	}

	public void setIdanalyse(Integer idanalyse) {
		this.idanalyse = idanalyse;
	}

	public String getLibAnalyse() {
		return libAnalyse;
	}

	public void setLibAnalyse(String libAnalyse) {
		this.libAnalyse = libAnalyse;
	}

	@PostConstruct
	public void init() {
		AnalyseService ser = new AnalyseService();
		if (valeurRecherche == null) {
			analyses = ser.rechercheTousAnalyse();

		} else {
			Module.rechercheAnalyse = valeurRecherche;
			analyses = ser.rechercheFiltre(valeurRecherche);
		}

	}

	public List<Analyse> getAnalyses() {
		return analyses;
	}

	public void setAnalyses(List<Analyse> analyses) {
		this.analyses = analyses;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void ajouterAnalyse() {
		initialisation();
		action = "Ajout";
	}

	public String closeDiag() {
		idanalyse = null;
		libAnalyse = null;
		return null;
	}

	public void modifierAnalyse(Analyse d) {
		idanalyse = d.getIdanalyse();
		libAnalyse = d.getLibAnalyse();
		action = "Modfication";

	}

	public void Supprimer(Integer id) {
		AnalyseService ser = new AnalyseService();
		ser.supprimerAnalyse(id);
		FacesContext faces = FacesContext.getCurrentInstance();
		faces.addMessage(null, new FacesMessage(
				"Analyse supprimée avec succès."));
		//init();
		FacesContext context2 = FacesContext.getCurrentInstance();
		context2.getExternalContext().getFlash().setKeepMessages(true);
		try {
			context2.getExternalContext().redirect("GestionAnalyse");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void validation() {
		libAnalyse=libAnalyse.replaceAll("\\s+", " ");
		AnalyseService ser = new AnalyseService();

		FacesContext faces = FacesContext.getCurrentInstance();
		RequestContext context = RequestContext.getCurrentInstance();
		boolean addValid = false;
		if (action.equals("Modfication")) {
			if (libAnalyse == null || (libAnalyse.trim().length() == 0)) {
				// tester si cette zone de text est vide
				
				faces.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_ERROR,
						"Veuillez donner le nom de l'analyse.", null));
				addValid = false;
			} else // tester si cette ville existe déjà
			{
				Analyse d = new Analyse(libAnalyse);
				Analyse d2 = ser.rechercheAnalyseParLibelleAnalyse(libAnalyse);
				if (d2 != null && !d2.getIdanalyse().equals(idanalyse)) {
					
					faces.addMessage("f1:f2:dialog:pro", new FacesMessage(
							FacesMessage.SEVERITY_ERROR, "L'analyse \""
									+ libAnalyse + "\" existe déjà.", null));
					
					addValid = false;
				} else {
					d.setIdanalyse(idanalyse);
					d.setLibAnalyse(libAnalyse);
					ser.modifierAnalyse(d);
					faces.addMessage(null, new FacesMessage(
							"Analyse modifiée avec succès."));
					addValid = true;
					initialisation();
					//init();
					RequestContext.getCurrentInstance().update("f1");
					FacesContext context2 = FacesContext.getCurrentInstance();
					context2.getExternalContext().getFlash()
							.setKeepMessages(true);
					try {
						context2.getExternalContext()
								.redirect("GestionAnalyse");
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
			}
		}

		if (action.equals("Ajout")) {

			if (libAnalyse == null || (libAnalyse.trim().length() == 0)) {
				// tester si cette zone de text est vide
				faces.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_ERROR,
						"Veuillez donner le nom de l'analyse.", null));
				
				
				addValid = false;
			} else // tester si cette etat existe déjà
			{

				Analyse d3 = ser.rechercheAnalyseParLibelleAnalyse(libAnalyse);

				if (d3 == null) { // c-à-d n'existe pas ville avec cette //
									// "ville"

					Analyse d1 = new Analyse(libAnalyse);

					ser.ajoutAnalyse(d1);
					
					faces.addMessage(null, new FacesMessage("L'Analyse \""
							+ libAnalyse + "\" est ajoutée avec succès."));
					
					
					addValid = true;
					initialisation();
					//init();
					RequestContext.getCurrentInstance().update("f1");
					FacesContext context2 = FacesContext.getCurrentInstance();
					context2.getExternalContext().getFlash()
							.setKeepMessages(true);
					try {
						context2.getExternalContext()
								.redirect("GestionAnalyse");
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				} else {

					//faces.addMessage(null, new FacesMessage("L'Analyse "
							//+ libAnalyse + " existe déjà."));
					faces.addMessage(null, new FacesMessage(
							FacesMessage.SEVERITY_ERROR, "L'analyse \""
									+ libAnalyse + "\" existe déjà.", null));
					addValid = false;
				}

			}
		}
		context.addCallbackParam("addValid", addValid);

	}

	public void initialisation() {
		libAnalyse = null;
		idanalyse = null;
		init();
	}

}

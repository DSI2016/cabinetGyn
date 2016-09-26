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
import com.doctor.persistance.MedOrd;
import com.doctor.persistance.Medicament;
import com.doctor.service.FormeMedicamentService;
import com.doctor.service.MedOrdService;
import com.doctor.service.MedicamentService;

@ManagedBean(name = "medicamentBean")
@SessionScoped
public class MedicamentBean implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idmedicament;
	private String designation;
	private Integer idForme;
	private String forme;
	private String posologie;
	private String laboratoire;
	private float prix;
	private String observation;
	private List<FormeMedicament> formesMedicament = new ArrayList<FormeMedicament>();
	private List<Medicament> medicamentsAvecJointure = new ArrayList<Medicament>();
	private String action;
	private String valeurRecherche;
	private String attribut;
	private String valForme;
	private List<FormeMedicament> listesFormes = new ArrayList<FormeMedicament>(
			0);
	private boolean formeActive;
	private boolean permenent;
	private int currentP;
	private String prixString;
	private String tableau;

	public String getTableau() {
		return tableau;
	}

	public void setTableau(String tableau) {
		this.tableau = tableau;
	}

	public boolean isPermenent() {
		return permenent;
	}

	public void setPermenent(boolean permenent) {
		this.permenent = permenent;
	}

	public String getPrixString() {
		return prixString;
	}

	public void setPrixString(String prixString) {
		this.prixString = prixString;
	}

	public int getCurrentP() {
		return currentP;
	}

	public void setCurrentP(int currentP) {
		this.currentP = currentP;
	}

	@PostConstruct
	public void init() {
		MedicamentService ser = new MedicamentService();
		if ((valeurRecherche != null) && (valeurRecherche.trim().length() > 0)
				&& (attribut != null) && (attribut.trim().length() > 0)) {
			medicamentsAvecJointure = ser.rechercheFiltre(attribut,
					valeurRecherche);
		} else if (attribut != null && attribut.equals("Forme")
				&& valForme != null && valForme.length() > 0) {
			medicamentsAvecJointure = ser
					.rechercheAvecformeMedicament(valForme);
		} else if ((attribut == null || attribut.trim().length() == 0)
				&& valeurRecherche != null
				&& valeurRecherche.trim().length() > 0) {
			medicamentsAvecJointure = ser.rechercheFiltre("Medicament",
					valeurRecherche);
		} else {
			medicamentsAvecJointure = ser
					.rechercheAvecJointureMedicament("formeMedicament");
		}
	}

	public boolean isFormeActive() {

		if (attribut != null && attribut.equals("Forme"))
			formeActive = false;
		else {
			valForme = null;
			formeActive = true;
		}
		return formeActive;
	}

	public void setFormeActive(boolean formeActive) {
		this.formeActive = formeActive;
	}

	public String getValForme() {
		return valForme;
	}

	public void setValForme(String valForme) {
		this.valForme = valForme;
	}

	public List<FormeMedicament> getListesFormes() {
		FormeMedicamentService ser = new FormeMedicamentService();
		listesFormes = ser.rechercheTousFormeMedicament();
		return listesFormes;
	}

	public void setListesFormes(List<FormeMedicament> listesFormes) {
		this.listesFormes = listesFormes;
	}

	public String getPosologie() {
		return posologie;
	}

	public void setPosologie(String posologie) {
		this.posologie = posologie;
	}

	public String getLaboratoire() {
		return laboratoire;
	}

	public void setLaboratoire(String laboratoire) {
		this.laboratoire = laboratoire;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public String getAttribut() {
		return attribut;
	}

	public void setAttribut(String attribut) {
		this.attribut = attribut;
	}

	private List<String> listesRecherches = new ArrayList<String>();

	public List<String> getListesRecherches() {
		listesRecherches.clear();
		listesRecherches.add("Medicament");
		listesRecherches.add("Forme");
		return listesRecherches;
	}

	public void setListesRecherches(List<String> listesRecherches) {
		this.listesRecherches = listesRecherches;
	}

	public String getForme() {
		return forme;
	}

	public void setForme(String forme) {
		this.forme = forme;
	}

	public String getValeurRecherche() {
		valeurRecherche = Module.rechercheMedicament;
		init();
		return valeurRecherche;
	}

	public void setValeurRecherche(String valeurRecherche) {
		Module.rechercheMedicament = valeurRecherche;
		this.valeurRecherche = valeurRecherche;
	}

	public void annulerRecherche() {
		Module.rechercheMedicament = "";
		valeurRecherche = null;
		attribut = null;
		valForme = null;
		formeActive = true;
		initialisation();
		// init();
	}

	public Integer getIdmedicamet() {
		return idmedicament;
	}

	public List<FormeMedicament> getFormesMedicament() {
		FormeMedicamentService ser = new FormeMedicamentService();
		formesMedicament = ser.rechercheTousFormeMedicament();

		return formesMedicament;
	}

	public void setFormesMedicament(List<FormeMedicament> formesMedicament) {
		this.formesMedicament = formesMedicament;
	}

	public void setIdmedicamet(Integer idmedicamet) {
		this.idmedicament = idmedicamet;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public void modifierMedicament(Medicament medicament) {
		idmedicament = medicament.getIdMedicament();
		designation = medicament.getDesignation();
		prixString = medicament.getPrix() + "";
		posologie = medicament.getPosologie();
		laboratoire = medicament.getLaboratoire();
		observation = medicament.getObservation();
		tableau = medicament.getTableau();
		FormeMedicament m;
		if (medicament.getFormeMed() != null) {
			m = medicament.getFormeMed();
			// forme = m.getForme();
			idForme = m.getIdFormeMedicament();
		}
		action = "Modification";

	}

	public Integer getIdForme() {
		return idForme;
	}

	public void setIdForme(Integer idForme) {
		this.idForme = idForme;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public List<Medicament> getMedicamentsAvecJointure() {
		return medicamentsAvecJointure;
	}

	public void setMedicamentsAvecJointure(
			List<Medicament> medicamentsAvecJointure) {
		this.medicamentsAvecJointure = medicamentsAvecJointure;
	}

	public void ajouterMedicament() {
		initialisation();
		action = "Ajout";
	}

	public String closeDiag() {
		idmedicament = null;
		designation = null;
		idForme = null;
		prix = 0;
		prixString = "";
		posologie = null;
		laboratoire = null;
		observation = null;
		forme = null;
		return null;
	}

	public void supprimer(Integer code) {
		FacesContext faces = FacesContext.getCurrentInstance();

		// vérification de jointure avec table medOrd
		MedOrdService serM = new MedOrdService();
		List<MedOrd> m = serM.rechercheParMedicament(code);
		if (m != null && m.size() > 0) {
			faces.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"Suppression impossible!  Médicament utilisé.", null));
			permenent = false;
		} else {
			MedicamentService ser = new MedicamentService();
			ser.supprimerMedicament(code);
			faces.addMessage(null, new FacesMessage(
					"Médicament supprimé avec succès.", ""));
			permenent = false;
		}
		// init();
		// RequestContext.getCurrentInstance().update("f1");
		FacesContext context2 = FacesContext.getCurrentInstance();
		context2.getExternalContext().getFlash().setKeepMessages(true);
		try {
			context2.getExternalContext().redirect("GestionMedicament");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void validation() {
		designation=designation.replaceAll("\\s+", " ");
		posologie=posologie.replaceAll("\\s+", " ");
		prixString=prixString.replaceAll("\\s+", "");
		laboratoire=laboratoire.replaceAll("\\s+", " ");
		tableau=tableau.replaceAll("\\s+", " ");
		observation=observation.replaceAll("\\s+", " ");
		
		MedicamentService ser = new MedicamentService();
		FormeMedicamentService s = new FormeMedicamentService();
		FacesContext faces = FacesContext.getCurrentInstance();
		RequestContext context = RequestContext.getCurrentInstance();
		boolean addValid = false;

		if (designation == null || (designation.trim().length() == 0)) {
			// tester si cette zone de text est vide
			faces.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"Veuillez donner le nom du médicament.", ""));
			permenent = true;
			addValid = false;
		}
		if (prixString != null && prixString.trim().length() > 0)
			try {
				prixString.replaceAll(",", ".");
				prix = Float.parseFloat(prixString);
			} catch (Exception e) {
				faces.addMessage(
						null,
						new FacesMessage(
								FacesMessage.SEVERITY_ERROR,
								"Veuillez vérifier le format du prix. Il ne peux pas contenir que des chiffres.",
								""));
				permenent = true;
				prix = 0;
				prixString = "";
			}
		if (faces.getMessageList().size() == 0) {
			// recherche par nom et format du médicament si cette ligne exist
			// déjà
			FormeMedicament f = null;
			Medicament m = null;
			if (idForme != null) {
				f = s.rechercheFormeMedicament(idForme);
				if (f != null)
					m = ser.rechercheMedicamentParLibelleMedicament(
							designation, f.getForme());
			} else {
				m = ser.rechercheMedicamentSansForme(designation);
			}
			if ((m != null) && !(m.getIdMedicament().equals(idmedicament))) {
				// c'est le cas de modification des données differents que le
				// nom et la forme
				faces.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_ERROR, "Le médicament \""
								+ designation + "\" existe déjà.", ""));
				permenent = true;
				addValid = false;
			} else {
				Medicament m2 = new Medicament();
				m2.setDesignation(designation);
				if (f != null)
					m2.setFormeMed(f);
				m2.setPosologie(posologie);
				m2.setPrix(prix);
				m2.setLaboratoire(laboratoire);
				m2.setObservation(observation);
				m2.setTableau(tableau);
				if (action.equals("Modification")) {
					m2.setIdMedicament(idmedicament);
					ser.modifierMedicament(m2);
					faces.addMessage(null, new FacesMessage("Le médicament\""
							+ designation + "\" modifié avec succès.", ""));
					permenent = false;
					addValid = true;
					initialisation();
					RequestContext.getCurrentInstance().update("f1");
					FacesContext context2 = FacesContext.getCurrentInstance();
					context2.getExternalContext().getFlash()
							.setKeepMessages(true);
					try {
						context2.getExternalContext().redirect(
								"GestionMedicament");
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
				if (action.equals("Ajout")) {
					ser.ajouterMedicament(m2);
					faces.addMessage(null, new FacesMessage("Le médicament\""
							+ designation + "\" ajouté avec succès.", ""));
					permenent = false;
					addValid = true;
					initialisation();
					RequestContext.getCurrentInstance().update("f1");
					FacesContext context2 = FacesContext.getCurrentInstance();
					context2.getExternalContext().getFlash()
							.setKeepMessages(true);
					try {
						context2.getExternalContext().redirect(
								"GestionMedicament");
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
			}
		}

		context.addCallbackParam("addValid", addValid);
	}

	public void initialisation() {
		designation = null;
		idmedicament = null;
		idForme = null;
		prix = 0;
		prixString = "";
		posologie = null;
		laboratoire = null;
		observation = null;
		forme = null;
		formeActive = true;
		tableau = null;
		// init();
	}

	public void onFormeChange() {
		if (valForme != null)
			valeurRecherche = valForme;
	}

	public void onAttributChange() {
		valeurRecherche = null;
	}

	public void ajoutForme() {
		forme=forme.replaceAll("\\s+", " ");
		RequestContext context = RequestContext.getCurrentInstance();
		boolean addValid = false;

		FacesContext faces = FacesContext.getCurrentInstance();
		FormeMedicamentService ser = new FormeMedicamentService();
		if (forme == null || (forme.trim().length() == 0)) {// tester si cette
															// zone de text est
															// vide
			faces.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"Veuillez donner le nom de la forme.", null));
			permenent = true;
			addValid = false;
		} else // tester si ce forme existe déjà
		{
			FormeMedicament d3 = ser
					.rechercheFormeMedicamentParLibelleFormeMedicament(forme);

			if (d3 == null) { // c-à-d n'existe pas forme avec ce nom

				FormeMedicament d1 = new FormeMedicament(forme);

				ser.ajoutFormeMedicament(d1);
				faces.addMessage(null, new FacesMessage("Forme médicament \""
						+ forme + "\" ajoutée avec succès."));
				permenent = false;
				addValid = true;

				List<FormeMedicament> fm = ser.rechercheTousFormeMedicament();
				if (fm != null && fm.size() > 0) {
					idForme = fm.get(fm.size() - 1).getIdFormeMedicament();
				}

			} else {

				faces.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_ERROR, "Forme médicament \""
								+ forme + "\" existe déjà.", null));
				permenent = false;
				addValid = false;
			}
		}

		context.addCallbackParam("addValid", addValid);
	}

	public void initForme() {
		idForme = null;
		forme = null;
	}

}

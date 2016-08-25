package com.doctor.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean(name = "accueilBean")
public class AccueilBean {

	public void goToRapport() {
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("Modelle-Rapport");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void goToSession() {
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("Session");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void goToSalleAttente() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		session.setAttribute("redirectSalle", "Accueil");
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("Salle");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void goToParametrage() {
		Module.rechercheProf = "";
		Module.rechercheClinique = "";
		Module.rechercheVille = "";
		Module.rechercheDocteur = "";
		Module.rechercheEtatGross = "";
		Module.rechercheEtatBebe = "";
		Module.rechercheAnalyse = "";
		Module.rechercheExamen = "";
		Module.rechercheContracept = "";
		Module.recherchediagnos = "";
		Module.recherchesympt = "";
		Module.rechercheExamenComp = "";
		Module.rechercheFormMed = "";
		Module.rechercheUterus = "";
		Module.rechercheMedicament = "";
		Module.rechercheAntecedent = "";
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("Parametrage");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void goToPatient() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		session.setAttribute("retourPatient", "Accueil");
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("Patients");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	
	public void goToUtilisateur() {
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("Utilisateurs");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void goToAccueil() {
		Module.rechercheProf = "";
		Module.rechercheClinique = "";
		Module.rechercheVille = "";
		Module.rechercheDocteur = "";
		Module.rechercheEtatGross = "";
		Module.rechercheEtatBebe = "";
		Module.rechercheAnalyse = "";
		Module.rechercheExamen = "";
		Module.rechercheContracept = "";
		Module.recherchediagnos = "";
		Module.recherchesympt = "";
		Module.rechercheExamenComp = "";
		Module.rechercheFormMed = "";
		Module.rechercheUterus = "";
		Module.rechercheMedicament = "";
		Module.rechercheAntecedent = "";
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("Accueil");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void goToGestionJoursFériés() {
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("GestionJoursFeries");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void goToGestionEtatBebe() {
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("GestionEtatBebe");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void goToGestionDiagnostique() {
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("GestionDiagnostique");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void goToGestionMoyenContraception() {
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("GestionMoyenContraception");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void goToGestionUterus() {
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("GestionUterus");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void goToGestionExamenClinique() {
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("GestionExamenClinique");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void goToGestionDocteur() {
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("GestionDocteur");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void goToGestionAnalyse() {
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("GestionAnalyse");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void goToGestionEtatFinGrossesses() {
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("GestionEtatFinGrossesses");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void goToGestionProfession() {
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("GestionProfession");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void goToGestionClinique() {
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("GestionClinique");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void goToGestionVille() {
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("GestionVille");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void goToGestionMedicament() {
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("GestionMedicament");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void goToGestionFormMedicament() {
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("GestionFormMedicament");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void goToGestionHoraireTravail() {
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("GestionHoraireTravail");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void goToGestionCabinet() {
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("GestionCabinet");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void goToGestionSymptome() {
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("GestionSymptome");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void goToAntecedents()

	{

		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("GestionAntecedents");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void goToGestionExamenComplementaire() {

		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("GestionExamenComplementaire");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void GoToRendezVous() {
		// action1 = "Accueil";
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		session.setAttribute("source", "Accueil");
		session.setAttribute("actionRDV", "consulter");
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("Rendez-Vous");
		} catch (Exception e) {
		}
	}

	public void retourDeHoraire() {
		HttpSession session2 = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		String valRetour = (String) session2.getAttribute("valeurRetour");
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect(valRetour);
		} catch (Exception e) {
		}
	}

	public void goToConsultation() {

		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("Consultations");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void goToRecap() {

		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("Recap");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
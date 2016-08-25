package com.doctor.bean;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "headerBean")
@ApplicationScoped
public class HeaderBean implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private boolean menuSalle;
	private boolean menuGestionPat;
	private boolean menuGestParametre;
	private boolean menuGestRapport;
	private boolean menuGestUtilisateur;
	
	private boolean gestionDoct;
	private boolean gestionProf;
	private boolean gestionVille;
	private boolean gestionClinique;
	private boolean rapportCertif;
	private boolean rapportOrdnce;
	private boolean rapportLettre;
	private boolean menuConfiguration;
	private int i;

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public boolean isMenuConfiguration() {
		if (Module.menuConfig.equals("0")) {
			menuConfiguration = false;
		} else {
			menuConfiguration = true;
		}
		
		return menuConfiguration;
	}

	public void setMenuConfiguration(boolean menuConfiguration) {
		this.menuConfiguration = menuConfiguration;
	}

	public boolean isGestionDoct() {
		
		if (Module.gestDoc.equals("0")) {
			gestionDoct = false;
		} else {
			gestionDoct = true;
		}
		return gestionDoct;
	}

	public void setGestionDoct(boolean gestionDoct) {
		this.gestionDoct = gestionDoct;
	}

	public boolean isGestionProf() {
		if (Module.gestProf.equals("0")) {
			gestionProf = false;
		} else {
			gestionProf = true;
		}
		
		return gestionProf;
	}

	public void setGestionProf(boolean gestionProf) {
		this.gestionProf = gestionProf;
	}

	public boolean isGestionVille() {
		
		if (Module.gestVil.equals("0")) {
			gestionVille = false;
		} else {
			gestionVille = true;
		}
		return gestionVille;
	}

	public void setGestionVille(boolean gestionVille) {
		this.gestionVille = gestionVille;
	}

	public boolean isGestionClinique() {
		
		if (Module.gestClin.equals("0")) {
			gestionClinique = false;
		} else {
			gestionClinique = true;
		}
		return gestionClinique;
	}

	public void setGestionClinique(boolean gestionClinique) {
		this.gestionClinique = gestionClinique;
	}

	public boolean isRapportCertif() {
		
		if (Module.rappCertif.equals("0")) {
			rapportCertif = false;
		} else {
			rapportCertif = true;
		}
		return rapportCertif;
	}

	public void setRapportCertif(boolean rapportCertif) {
		this.rapportCertif = rapportCertif;
	}

	public boolean isRapportOrdnce() {
		
		if (Module.rappOrdnce.equals("0")) {
			rapportOrdnce = false;
		} else {
			rapportOrdnce = true;
		}
		return rapportOrdnce;
	}

	public void setRapportOrdnce(boolean rapportOrdnce) {
		this.rapportOrdnce = rapportOrdnce;
	}

	public boolean isRapportLettre() {
		
		if (Module.rappLettre.equals("0")) {
			rapportLettre = false;
		} else {
			rapportLettre = true;
		}
		return rapportLettre;
	}

	public void setRapportLettre(boolean rapportLettre) {
		this.rapportLettre = rapportLettre;
	}

	public boolean isMenuGestUtilisateur() {
		if (Module.menuGestUtl.equals("0"))

		{
			menuGestUtilisateur = false;
		} else {
			menuGestUtilisateur = true;
		}
		return menuGestUtilisateur;
	}

	public void setMenuGestUtilisateur(boolean menuGestUtilisateur) {
		this.menuGestUtilisateur = menuGestUtilisateur;
	}

	public boolean isMenuGestRapport() {
		if (Module.menuRapport.equals("0")) {
			menuGestRapport = false;
		} else {
			menuGestRapport = true;
		}
		
		return menuGestRapport;
	}

	public void setMenuGestRapport(boolean menuGestRapport) {
		this.menuGestRapport = menuGestRapport;
	}

	public boolean isMenuGestParametre() {
		if (Module.menuParametre.equals("0")) {
			menuGestParametre = false;
		} else {
			menuGestParametre = true;
		}
		
		return menuGestParametre;
	}

	public void setMenuGestParametre(boolean menuGestParametre) {
		this.menuGestParametre = menuGestParametre;
	}

	public boolean isMenuGestionPat() {
		if (Module.menuGestPat.equals("0")) {
			menuGestionPat = false;
		} else {
			menuGestionPat = true;
		}
		return menuGestionPat;
	}

	public void setMenuGestionPat(boolean menuGestionPat) {
		this.menuGestionPat = menuGestionPat;
	}

	public boolean isMenuSalle() {
		
		if (Module.menuSal.equals("0")) {
			menuSalle = false;
		} else {
			menuSalle = true;
		}
		return menuSalle;
	}

	public void setMenuSalle(boolean menuSalle) {
		this.menuSalle = menuSalle;
	}

}

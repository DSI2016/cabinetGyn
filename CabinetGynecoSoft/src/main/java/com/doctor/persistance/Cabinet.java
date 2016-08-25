package com.doctor.persistance;

public class Cabinet {
	private Integer idcabinet;
	private String docteur;
	private String adresse;
	private String ville;
	private String tel1;
	private String tel2;
	private String gsm1;
	private String gsm2;
	private String fax;
	private String eMail;

	private String specialite;

	public Integer getIdcabinet() {
		return idcabinet;
	}

	public void setIdcabinet(Integer idcabinet) {
		this.idcabinet = idcabinet;
	}

	public String getDocteur() {
		return docteur;
	}

	public void setDocteur(String docteur) {
		this.docteur = docteur;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTel1() {
		return tel1;
	}

	public void setTel1(String tel1) {
		this.tel1 = tel1;
	}

	public String getTel2() {
		return tel2;
	}

	public void setTel2(String tel2) {
		this.tel2 = tel2;
	}

	public String getGsm1() {
		return gsm1;
	}

	public void setGsm1(String gsm1) {
		this.gsm1 = gsm1;
	}

	public String getGsm2() {
		return gsm2;
	}

	public void setGsm2(String gsm2) {
		this.gsm2 = gsm2;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getSpecialite() {
		return specialite;
	}

	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adresse == null) ? 0 : adresse.hashCode());
		result = prime * result + ((docteur == null) ? 0 : docteur.hashCode());
		result = prime * result + ((eMail == null) ? 0 : eMail.hashCode());
		result = prime * result + ((fax == null) ? 0 : fax.hashCode());
		result = prime * result + ((gsm1 == null) ? 0 : gsm1.hashCode());
		result = prime * result + ((gsm2 == null) ? 0 : gsm2.hashCode());
		result = prime * result
				+ ((idcabinet == null) ? 0 : idcabinet.hashCode());
		result = prime * result
				+ ((specialite == null) ? 0 : specialite.hashCode());
		result = prime * result + ((tel1 == null) ? 0 : tel1.hashCode());
		result = prime * result + ((tel2 == null) ? 0 : tel2.hashCode());
		result = prime * result + ((ville == null) ? 0 : ville.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cabinet other = (Cabinet) obj;
		if (adresse == null) {
			if (other.adresse != null)
				return false;
		} else if (!adresse.equals(other.adresse))
			return false;
		if (docteur == null) {
			if (other.docteur != null)
				return false;
		} else if (!docteur.equals(other.docteur))
			return false;
		if (eMail == null) {
			if (other.eMail != null)
				return false;
		} else if (!eMail.equals(other.eMail))
			return false;
		if (fax == null) {
			if (other.fax != null)
				return false;
		} else if (!fax.equals(other.fax))
			return false;
		if (gsm1 == null) {
			if (other.gsm1 != null)
				return false;
		} else if (!gsm1.equals(other.gsm1))
			return false;
		if (gsm2 == null) {
			if (other.gsm2 != null)
				return false;
		} else if (!gsm2.equals(other.gsm2))
			return false;
		if (idcabinet == null) {
			if (other.idcabinet != null)
				return false;
		} else if (!idcabinet.equals(other.idcabinet))
			return false;
		if (specialite == null) {
			if (other.specialite != null)
				return false;
		} else if (!specialite.equals(other.specialite))
			return false;
		if (tel1 == null) {
			if (other.tel1 != null)
				return false;
		} else if (!tel1.equals(other.tel1))
			return false;
		if (tel2 == null) {
			if (other.tel2 != null)
				return false;
		} else if (!tel2.equals(other.tel2))
			return false;
		if (ville == null) {
			if (other.ville != null)
				return false;
		} else if (!ville.equals(other.ville))
			return false;
		return true;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	@Override
	public String toString() {
		return "Cabinet [idcabinet=" + idcabinet + ", docteur=" + docteur
				+ ", adresse=" + adresse + ", ville=" + ville + ", tel1="
				+ tel1 + ", tel2=" + tel2 + ", gsm1=" + gsm1 + ", gsm2=" + gsm2
				+ ", fax=" + fax + ", eMail=" + eMail + ", specialite="
				+ specialite + "]";
	}

}

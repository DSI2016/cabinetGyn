package com.doctor.persistance;

import java.util.Date;

public class Radio implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idradio;
	private String examenComplementaire;
	private String renseignementClinique;
	private ConsultationDetail consultationDetail;
	private Cfclient patient;
	private String proprietaire;
	private String possesseur;
	private Date dateRadios;
	
	public Date getDateRadios() {
		return dateRadios;
	}


	public void setDateRadios(Date dateRadios) {
		this.dateRadios = dateRadios;
	}


	public String getProprietaire() {
		return proprietaire;
	}


	public void setProprietaire(String proprietaire) {
		this.proprietaire = proprietaire;
	}


	public String getPossesseur() {
		return possesseur;
	}


	public void setPossesseur(String possesseur) {
		this.possesseur = possesseur;
	}


	public Cfclient getPatient() {
		return patient;
	}


	public void setPatient(Cfclient patient) {
		this.patient = patient;
	}
	private String resultat;
	
	public Radio() {
		
	}
	
	
	public String getResultat() {
		return resultat;
	}


	public void setResultat(String resultat) {
		this.resultat = resultat;
	}


	public ConsultationDetail getConsultationDetail() {
		return consultationDetail;
	}


	public void setConsultationDetail(ConsultationDetail consultationDetail) {
		this.consultationDetail = consultationDetail;
	}


	public Integer getIdradio() {
		return idradio;
	}
	public void setIdradio(Integer idradio) {
		this.idradio = idradio;
	}
	public String getExamenComplementaire() {
		return examenComplementaire;
	}
	public void setExamenComplementaire(String examenComplementaire) {
		this.examenComplementaire = examenComplementaire;
	}
	public String getRenseignementClinique() {
		return renseignementClinique;
	}
	public void setRenseignementClinique(String renseignementClinique) {
		this.renseignementClinique = renseignementClinique;
	}
	@Override
	public String toString() {
		return "Radio [idradio=" + idradio + ", examenComplementaire="
				+ examenComplementaire + ", renseignementClinique="
				+ renseignementClinique + ", proprietaire=" + proprietaire
				+ ", possesseur=" + possesseur + ", dateRadios=" + dateRadios
				+ ", resultat=" + resultat + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dateRadios == null) ? 0 : dateRadios.hashCode());
		result = prime
				* result
				+ ((examenComplementaire == null) ? 0 : examenComplementaire
						.hashCode());
		result = prime * result + ((idradio == null) ? 0 : idradio.hashCode());
		result = prime * result
				+ ((possesseur == null) ? 0 : possesseur.hashCode());
		result = prime * result
				+ ((proprietaire == null) ? 0 : proprietaire.hashCode());
		result = prime
				* result
				+ ((renseignementClinique == null) ? 0 : renseignementClinique
						.hashCode());
		result = prime * result
				+ ((resultat == null) ? 0 : resultat.hashCode());
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
		Radio other = (Radio) obj;
		if (dateRadios == null) {
			if (other.dateRadios != null)
				return false;
		} else if (!dateRadios.equals(other.dateRadios))
			return false;
		if (examenComplementaire == null) {
			if (other.examenComplementaire != null)
				return false;
		} else if (!examenComplementaire.equals(other.examenComplementaire))
			return false;
		if (idradio == null) {
			if (other.idradio != null)
				return false;
		} else if (!idradio.equals(other.idradio))
			return false;
		if (possesseur == null) {
			if (other.possesseur != null)
				return false;
		} else if (!possesseur.equals(other.possesseur))
			return false;
		if (proprietaire == null) {
			if (other.proprietaire != null)
				return false;
		} else if (!proprietaire.equals(other.proprietaire))
			return false;
		if (renseignementClinique == null) {
			if (other.renseignementClinique != null)
				return false;
		} else if (!renseignementClinique.equals(other.renseignementClinique))
			return false;
		if (resultat == null) {
			if (other.resultat != null)
				return false;
		} else if (!resultat.equals(other.resultat))
			return false;
		return true;
	}
	
	
	
}

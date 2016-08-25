package com.doctor.persistance;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Medicament implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idMedicament;
	private String designation;
	private String posologie;
	private String laboratoire;
	private float prix;
	private String observation;
	private String posoEnfa;
	private String posoNou;
	private String tableau;

	private FormeMedicament formeMed;
	private Set<MedOrd> medOrds = new HashSet<MedOrd>(0);

	public String getPosoEnfa() {
		return posoEnfa;
	}

	public void setPosoEnfa(String posoEnfa) {
		this.posoEnfa = posoEnfa;
	}

	public String getPosoNou() {
		return posoNou;
	}

	public void setPosoNou(String posoNou) {
		this.posoNou = posoNou;
	}

	public String getTableau() {
		return tableau;
	}

	public void setTableau(String tableau) {
		this.tableau = tableau;
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

	public Set<MedOrd> getMedOrds() {
		return medOrds;
	}

	public void setMedOrds(Set<MedOrd> medOrds) {
		this.medOrds = medOrds;
	}

	public Medicament() {

	}

	public Medicament(String designation) {

		this.designation = designation;
	}

	public Integer getIdMedicament() {

		return idMedicament;
	}

	public void setIdMedicament(Integer idMedicament) {
		this.idMedicament = idMedicament;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public FormeMedicament getFormeMed() {
		return formeMed;
	}

	public void setFormeMed(FormeMedicament formeMed) {
		this.formeMed = formeMed;
	}

	@Override
	public String toString() {
		return "Medicament [idMedicament=" + idMedicament + ", designation="
				+ designation + ", posologie=" + posologie + ", laboratoire="
				+ laboratoire + ", prix=" + prix + ", observation="
				+ observation + ", posoEnfa=" + posoEnfa + ", posoNou="
				+ posoNou + ", tableau=" + tableau + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((designation == null) ? 0 : designation.hashCode());
		result = prime * result
				+ ((idMedicament == null) ? 0 : idMedicament.hashCode());
		result = prime * result
				+ ((laboratoire == null) ? 0 : laboratoire.hashCode());
		result = prime * result
				+ ((observation == null) ? 0 : observation.hashCode());
		result = prime * result
				+ ((posoEnfa == null) ? 0 : posoEnfa.hashCode());
		result = prime * result + ((posoNou == null) ? 0 : posoNou.hashCode());
		result = prime * result
				+ ((posologie == null) ? 0 : posologie.hashCode());
		result = prime * result + Float.floatToIntBits(prix);
		result = prime * result + ((tableau == null) ? 0 : tableau.hashCode());
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
		Medicament other = (Medicament) obj;
		if (designation == null) {
			if (other.designation != null)
				return false;
		} else if (!designation.equals(other.designation))
			return false;
		if (idMedicament == null) {
			if (other.idMedicament != null)
				return false;
		} else if (!idMedicament.equals(other.idMedicament))
			return false;
		if (laboratoire == null) {
			if (other.laboratoire != null)
				return false;
		} else if (!laboratoire.equals(other.laboratoire))
			return false;
		if (observation == null) {
			if (other.observation != null)
				return false;
		} else if (!observation.equals(other.observation))
			return false;
		if (posoEnfa == null) {
			if (other.posoEnfa != null)
				return false;
		} else if (!posoEnfa.equals(other.posoEnfa))
			return false;
		if (posoNou == null) {
			if (other.posoNou != null)
				return false;
		} else if (!posoNou.equals(other.posoNou))
			return false;
		if (posologie == null) {
			if (other.posologie != null)
				return false;
		} else if (!posologie.equals(other.posologie))
			return false;
		if (Float.floatToIntBits(prix) != Float.floatToIntBits(other.prix))
			return false;
		if (tableau == null) {
			if (other.tableau != null)
				return false;
		} else if (!tableau.equals(other.tableau))
			return false;
		return true;
	}

}

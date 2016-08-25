package com.doctor.persistance;

import java.util.HashSet;
import java.util.Set;

public class ModeleOrdonnance {
	private Integer idModeleOrdonnance;
	private String nomModele;
	private Set<MedOrd> medOrds = new HashSet<MedOrd>(0);

	public Integer getIdModeleOrdonnance() {
		return idModeleOrdonnance;
	}

	public void setIdModeleOrdonnance(Integer idModeleOrdonnance) {
		this.idModeleOrdonnance = idModeleOrdonnance;
	}

	public String getNomModele() {
		return nomModele;
	}

	public void setNomModele(String nomModele) {
		this.nomModele = nomModele;
	}

	public Set<MedOrd> getMedOrds() {
		return medOrds;
	}

	public void setMedOrds(Set<MedOrd> medOrds) {
		this.medOrds = medOrds;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((idModeleOrdonnance == null) ? 0 : idModeleOrdonnance
						.hashCode());
		result = prime * result
				+ ((nomModele == null) ? 0 : nomModele.hashCode());
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
		ModeleOrdonnance other = (ModeleOrdonnance) obj;
		if (idModeleOrdonnance == null) {
			if (other.idModeleOrdonnance != null)
				return false;
		} else if (!idModeleOrdonnance.equals(other.idModeleOrdonnance))
			return false;
		if (nomModele == null) {
			if (other.nomModele != null)
				return false;
		} else if (!nomModele.equals(other.nomModele))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ModeleOrdonnance [idModeleOrdonnance=" + idModeleOrdonnance
				+ ", nomModele=" + nomModele + "]";
	}
}

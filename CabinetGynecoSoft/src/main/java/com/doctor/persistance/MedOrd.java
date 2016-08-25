package com.doctor.persistance;

public class MedOrd {
	private Integer idMedOrd;
	private String posologie;
	private String unite;
	private int qte;

	private Medicament medicament;
	private ModeleOrdonnance modeleOrdonnance;
	private Ordonnance ordonnance;

	public Integer getIdMedOrd() {
		return idMedOrd;
	}

	public void setIdMedOrd(Integer idMedOrd) {
		this.idMedOrd = idMedOrd;
	}

	public String getPosologie() {
		return posologie;
	}

	public void setPosologie(String posologie) {
		this.posologie = posologie;
	}

	public String getUnite() {
		return unite;
	}

	public void setUnite(String unite) {
		this.unite = unite;
	}

	public int getQte() {
		return qte;
	}

	public void setQte(int qte) {
		this.qte = qte;
	}

	public Medicament getMedicament() {
		return medicament;
	}

	public void setMedicament(Medicament medicament) {
		this.medicament = medicament;
	}

	public ModeleOrdonnance getModeleOrdonnance() {
		return modeleOrdonnance;
	}

	public void setModeleOrdonnance(ModeleOrdonnance modeleOrdonnance) {
		this.modeleOrdonnance = modeleOrdonnance;
	}

	public Ordonnance getOrdonnance() {
		return ordonnance;
	}

	public void setOrdonnance(Ordonnance ordonnance) {
		this.ordonnance = ordonnance;
	}

	@Override
	public String toString() {
		return "MedOrd [idMedOrd=" + idMedOrd + ", posologie=" + posologie
				+ ", unite=" + unite + ", qte=" + qte + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idMedOrd == null) ? 0 : idMedOrd.hashCode());
		result = prime * result
				+ ((posologie == null) ? 0 : posologie.hashCode());
		result = prime * result + qte;
		result = prime * result + ((unite == null) ? 0 : unite.hashCode());
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
		MedOrd other = (MedOrd) obj;
		if (idMedOrd == null) {
			if (other.idMedOrd != null)
				return false;
		} else if (!idMedOrd.equals(other.idMedOrd))
			return false;
		if (posologie == null) {
			if (other.posologie != null)
				return false;
		} else if (!posologie.equals(other.posologie))
			return false;
		if (qte != other.qte)
			return false;
		if (unite == null) {
			if (other.unite != null)
				return false;
		} else if (!unite.equals(other.unite))
			return false;
		return true;
	}

}

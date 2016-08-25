package com.doctor.persistance;

import java.io.Serializable;
import java.util.Date;

public class Saison implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idSaison;
	private String nom;
	private Jour lun;
	private Jour mar;
	private Jour mer;
	private Jour jeu;
	private Jour ven;
	private Jour sam;
	private Jour dim;
	private int select;
	private Date debut;
	private Date fin;

	public Date getDebut() {
		return debut;
	}

	public void setDebut(Date debut) {
		this.debut = debut;
	}

	public Date getFin() {
		return fin;
	}

	public void setFin(Date fin) {
		this.fin = fin;
	}

	public Saison() {
	}

	public Integer getIdSaison() {
		return idSaison;
	}

	public void setIdSaison(Integer idSaison) {
		this.idSaison = idSaison;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Jour getLun() {
		return lun;
	}

	public void setLun(Jour lun) {
		this.lun = lun;
	}

	public Jour getMar() {
		return mar;
	}

	public void setMar(Jour mar) {
		this.mar = mar;
	}

	public Jour getMer() {
		return mer;
	}

	public void setMer(Jour mer) {
		this.mer = mer;
	}

	public Jour getJeu() {
		return jeu;
	}

	public void setJeu(Jour jeu) {
		this.jeu = jeu;
	}

	public Jour getVen() {
		return ven;
	}

	public void setVen(Jour ven) {
		this.ven = ven;
	}

	public Jour getSam() {
		return sam;
	}

	public void setSam(Jour sam) {
		this.sam = sam;
	}

	public Jour getDim() {
		return dim;
	}

	public void setDim(Jour dim) {
		this.dim = dim;
	}

	public int getSelect() {
		return select;
	}

	public void setSelect(int select) {
		this.select = select;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((debut == null) ? 0 : debut.hashCode());
		result = prime * result + ((fin == null) ? 0 : fin.hashCode());
		result = prime * result
				+ ((idSaison == null) ? 0 : idSaison.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
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
		Saison other = (Saison) obj;
		if (debut == null) {
			if (other.debut != null)
				return false;
		} else if (!debut.equals(other.debut))
			return false;
		if (fin == null) {
			if (other.fin != null)
				return false;
		} else if (!fin.equals(other.fin))
			return false;
		if (idSaison == null) {
			if (other.idSaison != null)
				return false;
		} else if (!idSaison.equals(other.idSaison))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Saison [idSaison=" + idSaison + ", nom=" + nom + ", debut="
				+ debut + ", fin=" + fin + "]";
	}
}

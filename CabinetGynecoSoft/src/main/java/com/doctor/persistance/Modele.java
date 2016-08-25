package com.doctor.persistance;

import java.io.Serializable;

public class Modele implements Serializable{
	/*
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nommodele;
	private Integer idmodele;
	private String indications;
	
	private String ligne;
	private String annexes;
	private String conclusion;
	private Integer longueur;
	private Integer larg;
	private Integer diam;
	
	private String contours;
	private String echostructure;
	private Uterus  uterus;
	
	public String getNommodele() {
		return nommodele;
	}
	public void setNommodele(String nommodele) {
		this.nommodele = nommodele;
	}
	
	public String getAnnexes() {
		return annexes;
	}
	public void setAnnexes(String annexes) {
		this.annexes = annexes;
	}
	public Integer getIdmodele() {
		return idmodele;
	}
	public void setIdmodele(Integer idmodele) {
		this.idmodele = idmodele;
	}

	public String getContours() {
		return contours;
	}
	public void setContours(String contours) {
		this.contours = contours;
	}
	public String getEchostructure() {
		return echostructure;
	}
	public void setEchostructure(String echostructure) {
		this.echostructure = echostructure;
	}
	
	public String getIndications() {
		return indications;
	}
	public void setIndications(String indications) {
		this.indications = indications;
	}
	public String getLigne() {
		return ligne;
	}
	public void setLigne(String ligne) {
		this.ligne = ligne;
	}
	public String getConclusion() {
		return conclusion;
	}
	public void setConclusion(String conclusion) {
		this.conclusion = conclusion;
	}
	public Integer getLongueur() {
		return longueur;
	}
	public void setLongueur(Integer longueur) {
		this.longueur = longueur;
	}
	public Integer getLarg() {
		return larg;
	}
	public void setLarg(Integer larg) {
		this.larg = larg;
	}
	public Integer getDiam() {
		return diam;
	}
	public void setDiam(Integer diam) {
		this.diam = diam;
	}
	public Uterus getUterus() {
		return uterus;
	}
	public void setUterus(Uterus uterus) {
		this.uterus = uterus;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((annexes == null) ? 0 : annexes.hashCode());
		result = prime * result + ((conclusion == null) ? 0 : conclusion.hashCode());
		result = prime * result + ((contours == null) ? 0 : contours.hashCode());
		result = prime * result + ((diam == null) ? 0 : diam.hashCode());
		result = prime * result + ((echostructure == null) ? 0 : echostructure.hashCode());
		result = prime * result + ((idmodele == null) ? 0 : idmodele.hashCode());
		result = prime * result + ((indications == null) ? 0 : indications.hashCode());
		result = prime * result + ((larg == null) ? 0 : larg.hashCode());
		result = prime * result + ((ligne == null) ? 0 : ligne.hashCode());
		result = prime * result + ((longueur == null) ? 0 : longueur.hashCode());
		result = prime * result + ((nommodele == null) ? 0 : nommodele.hashCode());
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
		Modele other = (Modele) obj;
		if (annexes == null) {
			if (other.annexes != null)
				return false;
		} else if (!annexes.equals(other.annexes))
			return false;
		if (conclusion == null) {
			if (other.conclusion != null)
				return false;
		} else if (!conclusion.equals(other.conclusion))
			return false;
		if (contours == null) {
			if (other.contours != null)
				return false;
		} else if (!contours.equals(other.contours))
			return false;
		if (diam == null) {
			if (other.diam != null)
				return false;
		} else if (!diam.equals(other.diam))
			return false;
		if (echostructure == null) {
			if (other.echostructure != null)
				return false;
		} else if (!echostructure.equals(other.echostructure))
			return false;
		if (idmodele == null) {
			if (other.idmodele != null)
				return false;
		} else if (!idmodele.equals(other.idmodele))
			return false;
		if (indications == null) {
			if (other.indications != null)
				return false;
		} else if (!indications.equals(other.indications))
			return false;
		if (larg == null) {
			if (other.larg != null)
				return false;
		} else if (!larg.equals(other.larg))
			return false;
		if (ligne == null) {
			if (other.ligne != null)
				return false;
		} else if (!ligne.equals(other.ligne))
			return false;
		if (longueur == null) {
			if (other.longueur != null)
				return false;
		} else if (!longueur.equals(other.longueur))
			return false;
		if (nommodele == null) {
			if (other.nommodele != null)
				return false;
		} else if (!nommodele.equals(other.nommodele))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Modele [nommodele=" + nommodele + ", idmodele=" + idmodele + ", indications=" + indications
				+ ", ligne=" + ligne + ", annexes=" + annexes + ", conclusion=" + conclusion + ", longueur=" + longueur
				+ ", larg=" + larg + ", diam=" + diam + ", contours=" + contours + ", echostructure=" + echostructure
				+ "]";
	}
	
}

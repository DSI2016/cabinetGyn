package com.doctor.persistance;

import java.io.Serializable;
import java.util.Date;

public class AnalyseDemandee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idanalyseDemandee;
	private String analyses;
	private ConsultationDetail consultationDetail;
	
	//pour le resultat
	private String toxo;
	private String tpha;
	private String rubeole;
	private String agHbs;
	private String glycemie;
	private String frottis;	
	private String proprietaire;
	private String possesseur;
	private Date dateAnalyse;
	private Cfclient patiente;
	
	
	public Date getDateAnalyse() {
		return dateAnalyse;
	}
	public void setDateAnalyse(Date dateAnalyse) {
		this.dateAnalyse = dateAnalyse;
	}
	public Cfclient getPatiente() {
		return patiente;
	}
	public void setPatiente(Cfclient patiente) {
		this.patiente = patiente;
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
	public String getToxo() {
		return toxo;
	}
	public void setToxo(String toxo) {
		this.toxo = toxo;
	}
	public String getTpha() {
		return tpha;
	}
	public void setTpha(String tpha) {
		this.tpha = tpha;
	}
	public String getRubeole() {
		return rubeole;
	}
	public void setRubeole(String rubeole) {
		this.rubeole = rubeole;
	}
	public String getAgHbs() {
		return agHbs;
	}
	public void setAgHbs(String agHbs) {
		this.agHbs = agHbs;
	}
	public String getGlycemie() {
		return glycemie;
	}
	public void setGlycemie(String glycemie) {
		this.glycemie = glycemie;
	}
	public String getFrottis() {
		return frottis;
	}
	public void setFrottis(String frottis) {
		this.frottis = frottis;
	}
	public Integer getIdanalyseDemandee() {
		return idanalyseDemandee;
	}
	public void setIdanalyseDemandee(Integer idanalyseDemandee) {
		this.idanalyseDemandee = idanalyseDemandee;
	}
	public String getAnalyses() {
		return analyses;
	}
	public void setAnalyses(String analyses) {
		this.analyses = analyses;
	}
	public ConsultationDetail getConsultationDetail() {
		return consultationDetail;
	}
	public void setConsultationDetail(ConsultationDetail consultationDetail) {
		this.consultationDetail = consultationDetail;
	}
	@Override
	public String toString() {
		return "AnalyseDemandee [idanalyseDemandee=" + idanalyseDemandee
				+ ", analyses=" + analyses + ", toxo=" + toxo + ", tpha="
				+ tpha + ", rubeole=" + rubeole + ", agHbs=" + agHbs
				+ ", glycemie=" + glycemie + ", frottis=" + frottis
				+ ", proprietaire=" + proprietaire + ", possesseur="
				+ possesseur + ", dateAnalyse=" + dateAnalyse + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((agHbs == null) ? 0 : agHbs.hashCode());
		result = prime * result
				+ ((analyses == null) ? 0 : analyses.hashCode());
		result = prime * result
				+ ((dateAnalyse == null) ? 0 : dateAnalyse.hashCode());
		result = prime * result + ((frottis == null) ? 0 : frottis.hashCode());
		result = prime * result
				+ ((glycemie == null) ? 0 : glycemie.hashCode());
		result = prime
				* result
				+ ((idanalyseDemandee == null) ? 0 : idanalyseDemandee
						.hashCode());
		result = prime * result
				+ ((possesseur == null) ? 0 : possesseur.hashCode());
		result = prime * result
				+ ((proprietaire == null) ? 0 : proprietaire.hashCode());
		result = prime * result + ((rubeole == null) ? 0 : rubeole.hashCode());
		result = prime * result + ((toxo == null) ? 0 : toxo.hashCode());
		result = prime * result + ((tpha == null) ? 0 : tpha.hashCode());
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
		AnalyseDemandee other = (AnalyseDemandee) obj;
		if (agHbs == null) {
			if (other.agHbs != null)
				return false;
		} else if (!agHbs.equals(other.agHbs))
			return false;
		if (analyses == null) {
			if (other.analyses != null)
				return false;
		} else if (!analyses.equals(other.analyses))
			return false;
		if (dateAnalyse == null) {
			if (other.dateAnalyse != null)
				return false;
		} else if (!dateAnalyse.equals(other.dateAnalyse))
			return false;
		if (frottis == null) {
			if (other.frottis != null)
				return false;
		} else if (!frottis.equals(other.frottis))
			return false;
		if (glycemie == null) {
			if (other.glycemie != null)
				return false;
		} else if (!glycemie.equals(other.glycemie))
			return false;
		if (idanalyseDemandee == null) {
			if (other.idanalyseDemandee != null)
				return false;
		} else if (!idanalyseDemandee.equals(other.idanalyseDemandee))
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
		if (rubeole == null) {
			if (other.rubeole != null)
				return false;
		} else if (!rubeole.equals(other.rubeole))
			return false;
		if (toxo == null) {
			if (other.toxo != null)
				return false;
		} else if (!toxo.equals(other.toxo))
			return false;
		if (tpha == null) {
			if (other.tpha != null)
				return false;
		} else if (!tpha.equals(other.tpha))
			return false;
		return true;
	}
	
	
	
}

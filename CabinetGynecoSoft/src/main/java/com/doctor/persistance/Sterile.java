package com.doctor.persistance;

import java.io.Serializable;
import java.util.Date;

public class Sterile implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private Integer idSterile;
	private String sterilite;
	private Date depuis;
	private String cohabitation;
	private String habitude;
	private int rapport;
	private String antecedentH;
	private String hormoneH;
	private String spermH;
	private String bilanH;
	private String traitementH;
	private String antecedent;
	private String examensH;
	private String examens;
	private String hormone;
	private String echoPelvienne;
	private String hsg;
	private String hysteroscopie;
	private String coelioscopie;
	private String traitement;
	private String coital;
	
	private String cycle;
	private String cycleList;
	private Cfclient cfclient;
	private String regles;
	
	public String getRegles() {
		return regles;
	}

	public void setRegles(String regles) {
		this.regles = regles;
	}

	public Sterile() {

	}

	public String getCycle() {
		return cycle;
	}

	public void setCycle(String cycle) {
		this.cycle = cycle;
	}

	public String getCycleList() {
		return cycleList;
	}

	public void setCycleList(String cycleList) {
		this.cycleList = cycleList;
	}

	

	public Cfclient getCfclient() {
		return cfclient;
	}

	public void setCfclient(Cfclient cfclient) {
		this.cfclient = cfclient;
	}

	public Integer getIdSterile() {
		return idSterile;
	}

	public void setIdSterile(Integer idSterile) {
		this.idSterile = idSterile;
	}

	public String getSterilite() {
		return sterilite;
	}

	public void setSterilite(String sterilite) {
		this.sterilite = sterilite;
	}

	public Date getDepuis() {
		return depuis;
	}

	public void setDepuis(Date depuis) {
		this.depuis = depuis;
	}

	public String getCohabitation() {
		return cohabitation;
	}

	public void setCohabitation(String cohabitation) {
		this.cohabitation = cohabitation;
	}

	public String getHabitude() {
		return habitude;
	}

	public void setHabitude(String habitude) {
		this.habitude = habitude;
	}




	public String getAntecedentH() {
		return antecedentH;
	}

	public void setAntecedentH(String antecedentH) {
		this.antecedentH = antecedentH;
	}

	public String getHormoneH() {
		return hormoneH;
	}

	public void setHormoneH(String hormoneH) {
		this.hormoneH = hormoneH;
	}

	public String getSpermH() {
		return spermH;
	}

	public void setSpermH(String spermH) {
		this.spermH = spermH;
	}

	public String getBilanH() {
		return bilanH;
	}

	public void setBilanH(String bilanH) {
		this.bilanH = bilanH;
	}

	public String getTraitementH() {
		return traitementH;
	}

	public void setTraitementH(String traitementH) {
		this.traitementH = traitementH;
	}

	public String getAntecedent() {
		return antecedent;
	}

	public void setAntecedent(String antecedent) {
		this.antecedent = antecedent;
	}

	public String getExamensH() {
		return examensH;
	}

	public void setExamensH(String examensH) {
		this.examensH = examensH;
	}

	public String getExamens() {
		return examens;
	}

	public void setExamens(String examens) {
		this.examens = examens;
	}

	public String getHormone() {
		return hormone;
	}

	public void setHormone(String hormone) {
		this.hormone = hormone;
	}

	public String getEchoPelvienne() {
		return echoPelvienne;
	}

	public void setEchoPelvienne(String echoPelvienne) {
		this.echoPelvienne = echoPelvienne;
	}

	public String getHsg() {
		return hsg;
	}

	public void setHsg(String hsg) {
		this.hsg = hsg;
	}

	public String getHysteroscopie() {
		return hysteroscopie;
	}

	public void setHysteroscopie(String hysteroscopie) {
		this.hysteroscopie = hysteroscopie;
	}

	public String getCoelioscopie() {
		return coelioscopie;
	}

	public void setCoelioscopie(String coelioscopie) {
		this.coelioscopie = coelioscopie;
	}

	public String getTraitement() {
		return traitement;
	}

	public void setTraitement(String traitement) {
		this.traitement = traitement;
	}

	public String getCoital() {
		return coital;
	}

	public void setCoital(String coital) {
		this.coital = coital;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((antecedent == null) ? 0 : antecedent.hashCode());
		result = prime * result
				+ ((antecedentH == null) ? 0 : antecedentH.hashCode());
		result = prime * result + ((bilanH == null) ? 0 : bilanH.hashCode());
		result = prime * result
				+ ((coelioscopie == null) ? 0 : coelioscopie.hashCode());
		result = prime * result
				+ ((cohabitation == null) ? 0 : cohabitation.hashCode());
		result = prime * result + ((coital == null) ? 0 : coital.hashCode());
		result = prime * result + ((cycle == null) ? 0 : cycle.hashCode());
		result = prime * result
				+ ((cycleList == null) ? 0 : cycleList.hashCode());
		result = prime * result + ((depuis == null) ? 0 : depuis.hashCode());
		result = prime * result
				+ ((echoPelvienne == null) ? 0 : echoPelvienne.hashCode());
		result = prime * result + ((examens == null) ? 0 : examens.hashCode());
		result = prime * result
				+ ((examensH == null) ? 0 : examensH.hashCode());
		result = prime * result
				+ ((habitude == null) ? 0 : habitude.hashCode());
		result = prime * result + ((hormone == null) ? 0 : hormone.hashCode());
		result = prime * result
				+ ((hormoneH == null) ? 0 : hormoneH.hashCode());
		result = prime * result + ((hsg == null) ? 0 : hsg.hashCode());
		result = prime * result
				+ ((hysteroscopie == null) ? 0 : hysteroscopie.hashCode());
		result = prime * result
				+ ((idSterile == null) ? 0 : idSterile.hashCode());

		result = prime * result + ((spermH == null) ? 0 : spermH.hashCode());
		result = prime * result
				+ ((sterilite == null) ? 0 : sterilite.hashCode());
		result = prime * result
				+ ((traitement == null) ? 0 : traitement.hashCode());
		result = prime * result
				+ ((traitementH == null) ? 0 : traitementH.hashCode());
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
		Sterile other = (Sterile) obj;
		if (antecedent == null) {
			if (other.antecedent != null)
				return false;
		} else if (!antecedent.equals(other.antecedent))
			return false;
		if (antecedentH == null) {
			if (other.antecedentH != null)
				return false;
		} else if (!antecedentH.equals(other.antecedentH))
			return false;
		if (bilanH == null) {
			if (other.bilanH != null)
				return false;
		} else if (!bilanH.equals(other.bilanH))
			return false;
		if (coelioscopie == null) {
			if (other.coelioscopie != null)
				return false;
		} else if (!coelioscopie.equals(other.coelioscopie))
			return false;
		if (cohabitation == null) {
			if (other.cohabitation != null)
				return false;
		} else if (!cohabitation.equals(other.cohabitation))
			return false;
		if (coital == null) {
			if (other.coital != null)
				return false;
		} else if (!coital.equals(other.coital))
			return false;
		if (cycle == null) {
			if (other.cycle != null)
				return false;
		} else if (!cycle.equals(other.cycle))
			return false;
		if (cycleList == null) {
			if (other.cycleList != null)
				return false;
		} else if (!cycleList.equals(other.cycleList))
			return false;
		if (depuis == null) {
			if (other.depuis != null)
				return false;
		} else if (!depuis.equals(other.depuis))
			return false;
		if (echoPelvienne == null) {
			if (other.echoPelvienne != null)
				return false;
		} else if (!echoPelvienne.equals(other.echoPelvienne))
			return false;
		if (examens == null) {
			if (other.examens != null)
				return false;
		} else if (!examens.equals(other.examens))
			return false;
		if (examensH == null) {
			if (other.examensH != null)
				return false;
		} else if (!examensH.equals(other.examensH))
			return false;
		if (habitude == null) {
			if (other.habitude != null)
				return false;
		} else if (!habitude.equals(other.habitude))
			return false;
		if (hormone == null) {
			if (other.hormone != null)
				return false;
		} else if (!hormone.equals(other.hormone))
			return false;
		if (hormoneH == null) {
			if (other.hormoneH != null)
				return false;
		} else if (!hormoneH.equals(other.hormoneH))
			return false;
		if (hsg == null) {
			if (other.hsg != null)
				return false;
		} else if (!hsg.equals(other.hsg))
			return false;
		if (hysteroscopie == null) {
			if (other.hysteroscopie != null)
				return false;
		} else if (!hysteroscopie.equals(other.hysteroscopie))
			return false;
		if (idSterile == null) {
			if (other.idSterile != null)
				return false;
		} else if (!idSterile.equals(other.idSterile))
			return false;
		
		if (spermH == null) {
			if (other.spermH != null)
				return false;
		} else if (!spermH.equals(other.spermH))
			return false;
		if (sterilite == null) {
			if (other.sterilite != null)
				return false;
		} else if (!sterilite.equals(other.sterilite))
			return false;
		if (traitement == null) {
			if (other.traitement != null)
				return false;
		} else if (!traitement.equals(other.traitement))
			return false;
		if (traitementH == null) {
			if (other.traitementH != null)
				return false;
		} else if (!traitementH.equals(other.traitementH))
			return false;
		return true;
	}

	public int getRapport() {
		return rapport;
	}

	public void setRapport(int rapport) {
		this.rapport = rapport;
	}

	@Override
	public String toString() {
		return "Sterile [idSterile=" + idSterile + ", sterilite=" + sterilite
				+ ", depuis=" + depuis + ", cohabitation=" + cohabitation
				+ ", habitude=" + habitude + ", rapport=" + rapport
				+ ", antecedentH=" + antecedentH + ", hormoneH=" + hormoneH
				+ ", spermH=" + spermH + ", bilanH=" + bilanH
				+ ", traitementH=" + traitementH + ", antecedent=" + antecedent
				+ ", examensH=" + examensH + ", examens=" + examens
				+ ", hormone=" + hormone + ", echoPelvienne=" + echoPelvienne
				+ ", hsg=" + hsg + ", hysteroscopie=" + hysteroscopie
				+ ", coelioscopie=" + coelioscopie + ", traitement="
				+ traitement + ", coital=" + coital + ", cycle=" + cycle
				+ ", cycleList=" + cycleList + "]";
	}

	

}

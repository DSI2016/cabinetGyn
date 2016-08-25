package com.doctor.persistance;

public class Contraception {
private Integer idcontraception;
private String dateDebut;
private String moyen;
private String remarque;
private String dateFin;

private Cfclient cfclient;

public Contraception(){
}


public Contraception(String dateDebut, String moyen,
		String remarque, String dateFin, Cfclient cfclient) {
	super();
	this.dateDebut = dateDebut;
	this.moyen = moyen;
	this.remarque = remarque;
	this.dateFin = dateFin;
	this.cfclient = cfclient;
}


public Integer getIdcontraception() {
	return idcontraception;
}

public void setIdcontraception(Integer idcontraception) {
	this.idcontraception = idcontraception;
}

public String getDateDebut() {
	return dateDebut;
}

public void setDateDebut(String dateDebut) {
	this.dateDebut = dateDebut;
}

public String getMoyen() {
	return moyen;
}

public void setMoyen(String moyen) {
	this.moyen = moyen;
}

public String getRemarque() {
	return remarque;
}

public void setRemarque(String remarque) {
	this.remarque = remarque;
}

public String getDateFin() {
	return dateFin;
}

public void setDateFin(String dateFin) {
	this.dateFin = dateFin;
}

public Cfclient getCfclient() {
	return cfclient;
}

public void setCfclient(Cfclient cfclient) {
	this.cfclient = cfclient;
}

@Override
public String toString() {
	return "Contraception [idcontraception=" + idcontraception + ", dateDebut="
			+ dateDebut + ", moyen=" + moyen + ", remarque=" + remarque
			+ ", dateFin=" + dateFin + ", cfclient=" + cfclient + "]";
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((cfclient == null) ? 0 : cfclient.hashCode());
	result = prime * result + ((dateDebut == null) ? 0 : dateDebut.hashCode());
	result = prime * result + ((dateFin == null) ? 0 : dateFin.hashCode());
	result = prime * result
			+ ((idcontraception == null) ? 0 : idcontraception.hashCode());
	result = prime * result + ((moyen == null) ? 0 : moyen.hashCode());
	result = prime * result + ((remarque == null) ? 0 : remarque.hashCode());
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
	Contraception other = (Contraception) obj;
	if (cfclient == null) {
		if (other.cfclient != null)
			return false;
	} else if (!cfclient.equals(other.cfclient))
		return false;
	if (dateDebut == null) {
		if (other.dateDebut != null)
			return false;
	} else if (!dateDebut.equals(other.dateDebut))
		return false;
	if (dateFin == null) {
		if (other.dateFin != null)
			return false;
	} else if (!dateFin.equals(other.dateFin))
		return false;
	if (idcontraception == null) {
		if (other.idcontraception != null)
			return false;
	} else if (!idcontraception.equals(other.idcontraception))
		return false;
	if (moyen == null) {
		if (other.moyen != null)
			return false;
	} else if (!moyen.equals(other.moyen))
		return false;
	if (remarque == null) {
		if (other.remarque != null)
			return false;
	} else if (!remarque.equals(other.remarque))
		return false;
	return true;
}


}

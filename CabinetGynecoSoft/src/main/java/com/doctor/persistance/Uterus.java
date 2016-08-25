package com.doctor.persistance;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Uterus implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private Integer iduterus;
private String uterus;
private Set<ConsultationDetail> consultationDetails = new HashSet<ConsultationDetail>(0);

private Set<Modele> modeles = new HashSet<Modele>(0);



public Uterus()
{
	}


public Integer getIduterus() {
	return iduterus;
}
public void setIduterus(Integer iduterus) {
	this.iduterus = iduterus;
}
public String getUterus() {
	return uterus;
}
public void setUterus(String uterus) {
	this.uterus = uterus;
}



public Set<Modele> getModeles() {
	return modeles;
}


public void setModeles(Set<Modele> modeles) {
	this.modeles = modeles;
}


public Set<ConsultationDetail> getConsultationDetails() {
	return consultationDetails;
}


public void setConsultationDetails(Set<ConsultationDetail> consultationDetails) {
	this.consultationDetails = consultationDetails;
}


@Override
public String toString() {
	return "Uterus [iduterus=" + iduterus + ", uterus=" + uterus + "]";
}


@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((iduterus == null) ? 0 : iduterus.hashCode());
	result = prime * result + ((uterus == null) ? 0 : uterus.hashCode());
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
	Uterus other = (Uterus) obj;
	if (iduterus == null) {
		if (other.iduterus != null)
			return false;
	} else if (!iduterus.equals(other.iduterus))
		return false;
	if (uterus == null) {
		if (other.uterus != null)
			return false;
	} else if (!uterus.equals(other.uterus))
		return false;
	return true;
}

}

package com.doctor.persistance;

// Generated 18 ao�t 2014 11:50:48 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

/**
 * Symptome generated by hbm2java
 */
public class Symptome implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idsymptome;
	private String symptome;
	
	
	
	private Set<Cfclient> cfclients = new HashSet<Cfclient>(0);

	public Symptome() {
	}

	public Symptome(String symptome) {
		this.symptome = symptome;
	}

	public Symptome(String symptome, Set<Cfclient> cfclients) {
		this.symptome = symptome;
		this.cfclients = cfclients;
	}

	public Integer getIdsymptome() {
		return this.idsymptome;
	}

	public void setIdsymptome(Integer idsymptome) {
		this.idsymptome = idsymptome;
	}

	public String getSymptome() {
		return this.symptome;
	}

	public void setSymptome(String symptome) {
		this.symptome = symptome;
	}

	public Set<Cfclient> getCfclients() {
		return this.cfclients;
	}

	public void setCfclients(Set<Cfclient> cfclients) {
		this.cfclients = cfclients;
	}

}

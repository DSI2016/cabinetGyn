package com.doctor.persistance;

// Generated 18 ao�t 2014 11:50:48 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

/**
 * Diagnostique generated by hbm2java
 */
public class Diagnostique implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer iddiagnostique;
	private String diagnostique;
	
	
	
	private Set<Cfclient> cfclients = new HashSet<Cfclient>(0);

	public Diagnostique() {
	}

	public Diagnostique(String diagnostique) {
		this.diagnostique = diagnostique;
	}

	public Diagnostique(String diagnostique, Set<Cfclient> cfclients) {
		this.diagnostique = diagnostique;
		this.cfclients = cfclients;
	}

	public Integer getIddiagnostique() {
		return this.iddiagnostique;
	}

	public void setIddiagnostique(Integer iddiagnostique) {
		this.iddiagnostique = iddiagnostique;
	}

	public String getDiagnostique() {
		return this.diagnostique;
	}

	public void setDiagnostique(String diagnostique) {
		this.diagnostique = diagnostique;
	}

	public Set<Cfclient> getCfclients() {
		return this.cfclients;
	}

	public void setCfclients(Set<Cfclient> cfclients) {
		this.cfclients = cfclients;
	}

}

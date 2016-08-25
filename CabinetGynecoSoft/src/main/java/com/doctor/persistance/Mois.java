package com.doctor.persistance;


public class Mois  implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String numberMois;
	private String nomMois;


	

	public Mois(String numberMois, String nomMois) {
		super();
		this.numberMois = numberMois;
		this.nomMois = nomMois;
	}
	
	
	public String getNumberMois() {
		return numberMois;
	}


	public void setNumberMois(String numberMois) {
		this.numberMois = numberMois;
	}


	public String getNomMois() {
		return nomMois;
	}
	public void setNomMois(String nomMois) {
		this.nomMois = nomMois;
	}
	

	
}

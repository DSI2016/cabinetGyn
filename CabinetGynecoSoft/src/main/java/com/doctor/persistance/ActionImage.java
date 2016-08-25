package com.doctor.persistance;

public class ActionImage {
private String nom;
private String action;

public ActionImage(String n,String a){
	nom=n;
	action=a;
}

public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public String getAction() {
	return action;
}
public void setAction(String action) {
	this.action = action;
}

}

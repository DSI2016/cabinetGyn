package com.doctor.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.doctor.persistance.Uterus;
import com.doctor.service.UterusService;


@ManagedBean(name ="myBean")
@SessionScoped
public class MyBean
{
private String text;

public String getText() {
	System.out.println("test"+text);
    return text;
}

public void setText(String text) {
    this.text = text;
}
public void enregistrer() 
{
	UterusService ser = new UterusService();
	Uterus d = new Uterus();
	d.setUterus(text);
	ser.ajoutUterus(d);
	System.out.println("enregistrer");
}
}

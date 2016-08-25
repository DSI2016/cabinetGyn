package com.doctor.service;

import java.util.List;

import com.doctor.bean.SalleBean;
import com.doctor.persistance.Salle;

public class Test {

	public static void main(String[] args) {
SalleBean s=new SalleBean();

List<Salle>l=s.getSallesAvecJointure();
System.out.println(l.size());
for (int i=0;i<l.size();i++)
	System.out.println(l.get(i).getCfclient().getNom());
	
	}

}

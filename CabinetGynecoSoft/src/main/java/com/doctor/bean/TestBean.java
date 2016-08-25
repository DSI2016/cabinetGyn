package com.doctor.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "testBean")
@SessionScoped
public class TestBean {
	String value;





public String  getValue() {
	return value;
}


public void setValue(String  value) {
	this.value = value;
}


}


package com.doctor.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

@ManagedBean(name = "validatorBean")
public class Validator
{
  public void validateField(FacesContext ctx, UIComponent comp, Object inValue) throws ValidatorException
  {          
	  FacesContext face = FacesContext.getCurrentInstance();
     int value = (Integer) inValue;
          
     if (!(value >= 0 && value <= 100) && !(value == -9))
     {
    	 face.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Erreur", "il faut que entiers"));
     }
  }
}
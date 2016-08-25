package com.doctor.bean;


import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ApplicationScoped
@ManagedBean
public class ApplicationBean {

   private String textStore;

   public String findValue() {
      return textStore;
   }

   public void saveValue(String textStore) {
      this.textStore = textStore;
   }

}

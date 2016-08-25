package com.doctor.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.doctor.persistance.HistoriquePatient;
import com.doctor.service.HistoriquePatientService;

@ManagedBean (name="historiquePatientBean")
public class HistoriquePatientBean {
	private Integer idhistoriquePatient;
	private String typeConsultation;
	private String dateConsultation;
	private List<HistoriquePatient> listHistoriques=new ArrayList<HistoriquePatient>();
	private Integer idPatient;
	
	
	@PostConstruct
	public void init(){
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");
	//	idPatient=Module.idpatient;
	}
	public Integer getIdPatient() {
		return idPatient;
	}
	public void setIdPatient(Integer idPatient) {
		this.idPatient = idPatient;
	}
	public List<HistoriquePatient> getListHistoriques() {
		HistoriquePatientService ser= new HistoriquePatientService();
		listHistoriques=ser.rechercheToutHistoriquePatient(idPatient);
		return listHistoriques;
	}
	public void setListHistoriques(List<HistoriquePatient> listHistoriques) {
		this.listHistoriques = listHistoriques;
	}
	public Integer getIdhistoriquePatient() {
		return idhistoriquePatient;
	}
	public void setIdhistoriquePatient(Integer idhistoriquePatient) {
		this.idhistoriquePatient = idhistoriquePatient;
	}
	public String getTypeConsultation() {
		return typeConsultation;
	}
	public void setTypeConsultation(String typeConsultation) {
		this.typeConsultation = typeConsultation;
	}
	public String getDateConsultation() {
		return dateConsultation;
	}
	public void setDateConsultation(String dateConsultation) {
		this.dateConsultation = dateConsultation;
	}
	
	
	
}

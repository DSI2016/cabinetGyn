package com.doctor.persistance;

import java.io.Serializable;

import org.primefaces.model.ScheduleEvent;

import java.util.Date;

public class RendezVous implements Serializable, ScheduleEvent{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private Integer idrendezVous;
	private Cfclient codeclient;
	private Date date;
	private String note;
	private int etat;
	private String styleClass;
	private Object data;
	
	public int getEtat() {
		return etat;
	}

	public void setEtat(int etat) {
		this.etat = etat;
	}

	@SuppressWarnings("deprecation")
	private Date add30Min(Date D){
		Date DF = (Date) D.clone();
		DF.setMinutes(DF.getMinutes()+30);
		return DF;
	}
	
	public RendezVous(){
	}

	public RendezVous(Cfclient codeclient, Date date, String note,String classe) {
		this.codeclient = codeclient;
		this.date = date;
		this.note = note;
		this.setStyleClass(classe);
	}

	public void setStyleClass(String styleClass) {
		this.styleClass = styleClass;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Integer getIdrendezVous() {
		return idrendezVous;
	}

	public void setIdrendezVous(Integer idrendezVous) {
		this.idrendezVous = idrendezVous;
	}

	public Cfclient getCodeclient() {
		return codeclient;
	}

	public void setCodeclient(Cfclient codeclient) {
		this.codeclient = codeclient;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codeclient == null) ? 0 : codeclient.hashCode());
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + etat;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((idrendezVous == null) ? 0 : idrendezVous.hashCode());
		result = prime * result + ((note == null) ? 0 : note.hashCode());
		result = prime * result + ((styleClass == null) ? 0 : styleClass.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RendezVous other = (RendezVous) obj;
		if (codeclient == null) {
			if (other.codeclient != null)
				return false;
		} else if (!codeclient.equals(other.codeclient))
			return false;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (etat != other.etat)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (idrendezVous == null) {
			if (other.idrendezVous != null)
				return false;
		} else if (!idrendezVous.equals(other.idrendezVous))
			return false;
		if (note == null) {
			if (other.note != null)
				return false;
		} else if (!note.equals(other.note))
			return false;
		if (styleClass == null) {
			if (other.styleClass != null)
				return false;
		} else if (!styleClass.equals(other.styleClass))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RendezVous [idrendezVous=" + idrendezVous + ", codeclient=" + codeclient + ", date=" + date + ", note="
				+ note + ", etat=" + etat + "]";
	}

	@Override
	public String getId() {
		return this.id;
	}

	@Override
	public void setId(String id) {
		this.id = id;
	}

	@Override
	public Object getData() {
		return data;
	}

	@Override
	public String getTitle() {
		return codeclient.getPrenom()+" "+codeclient.getNom()+"\n"+this.note;
	}

	@Override
	public Date getStartDate() {
		return this.date;
	}

	@Override
	public Date getEndDate() {
		return this.add30Min(date);
	}

	@Override
	public boolean isAllDay() {
		return false;
	}

	@Override
	public String getStyleClass() {
		return this.styleClass;
	}

	@Override
	public boolean isEditable() {
		return true;
	}

	public String getDescription() {
		return note;
	}
	
}

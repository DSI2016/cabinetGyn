package com.doctor.persistance;

public class EnLigne {
	
	
	private int idenligne  ;
	private String idSession;
	public int getIdenligne() {
		return idenligne;
	}
	public void setIdenligne(int idenligne) {
		this.idenligne = idenligne;
	}
	public String getIdSession() {
		return idSession;
	}
	public void setIdSession(String idSession) {
		this.idSession = idSession;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idSession == null) ? 0 : idSession.hashCode());
		result = prime * result + idenligne;
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
		EnLigne other = (EnLigne) obj;
		if (idSession == null) {
			if (other.idSession != null)
				return false;
		} else if (!idSession.equals(other.idSession))
			return false;
		if (idenligne != other.idenligne)
			return false;
		return true;
	}
		
	

	

}

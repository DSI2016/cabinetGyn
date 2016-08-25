package com.doctor.persistance;

public class Connecte {
	private Integer idConnecte;
	private String login;

	@Override
	public String toString() {
		return login;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idConnecte == null) ? 0 : idConnecte.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
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
		Connecte other = (Connecte) obj;
		if (idConnecte == null) {
			if (other.idConnecte != null)
				return false;
		} else if (!idConnecte.equals(other.idConnecte))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		return true;
	}

	public Integer getIdConnecte() {
		return idConnecte;
	}

	public void setIdConnecte(Integer idConnecte) {
		this.idConnecte = idConnecte;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

}

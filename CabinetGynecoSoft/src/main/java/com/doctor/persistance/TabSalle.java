package com.doctor.persistance;

public class TabSalle {
	private Integer idTabSalle;
	private String nomTab;
	private int index;
	private boolean ordreDifferent;
	private boolean active;

	public Integer getIdTabSalle() {
		return idTabSalle;
	}

	public void setIdTabSalle(Integer idTabSalle) {
		this.idTabSalle = idTabSalle;
	}

	public String getNomTab() {
		return nomTab;
	}

	public void setNomTab(String nomTab) {
		this.nomTab = nomTab;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public boolean isOrdreDifferent() {
		return ordreDifferent;
	}

	public void setOrdreDifferent(boolean ordreDifferent) {
		this.ordreDifferent = ordreDifferent;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (active ? 1231 : 1237);
		result = prime * result
				+ ((idTabSalle == null) ? 0 : idTabSalle.hashCode());
		result = prime * result + index;
		result = prime * result + ((nomTab == null) ? 0 : nomTab.hashCode());
		result = prime * result + (ordreDifferent ? 1231 : 1237);
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
		TabSalle other = (TabSalle) obj;
		if (active != other.active)
			return false;
		if (idTabSalle == null) {
			if (other.idTabSalle != null)
				return false;
		} else if (!idTabSalle.equals(other.idTabSalle))
			return false;
		if (index != other.index)
			return false;
		if (nomTab == null) {
			if (other.nomTab != null)
				return false;
		} else if (!nomTab.equals(other.nomTab))
			return false;
		if (ordreDifferent != other.ordreDifferent)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TabSalle [idTabSalle=" + idTabSalle + ", nomTab=" + nomTab
				+ ", index=" + index + ", ordreDifferent=" + ordreDifferent
				+ ", active=" + active + "]";
	}

}

package com.doctor.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import com.doctor.persistance.EnLigne;
import com.doctor.service.EnLigneService;

@ManagedBean(name = "enLigneBean")
@SessionScoped
public class EnLigneBean {
	private int idenligne;
	private String idSession;
	private List<EnLigne> enLignes = new ArrayList<EnLigne>();

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

	// public static HttpSession find(String sessionId) {
	// System.out.println("entree cherche");
	// return sessions.get(sessionId);
	//
	// }
//s7i7a hathi
//	public void deconnectSession(String idSession,Integer idenligne) {
//
//		EnLigne enLigne = new EnLigne();
//		HttpSession temp1 = SessionCounter.find(idSession);
//		enLigne.setIdenligne(idenligne);
//		HttpSession session5 = (HttpSession) FacesContext
//				.getCurrentInstance().getExternalContext()
//				.getSession(true);
//		System.out.println("idsession courant"+session5.getId());
//		System.out.println(temp1.getId()+"Ali chenfas5ou");
//		if (temp1 != null) {
//			System.out.println("temp1 !=null");
//			temp1.invalidate();
//			System.out.println("la session "+temp1.getId()+"invalider aves succes");
//			EnLigneService ser2 = new EnLigneService();
//			
//			ser2.supprimerEnLigne(enLigne);
//		}
//		else
//			System.out.println("temp==null");
//
//	}

	public List<EnLigne> getEnLignes() {
		EnLigneService ser1 = new EnLigneService();
		enLignes = ser1.rechercheTousEnLigne();
		return enLignes;
	}

	public void setEnLignes(List<EnLigne> enLignes) {
		this.enLignes = enLignes;
	}

}
package com.doctor.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.doctor.persistance.EnLigne;
import com.doctor.persistance.HistoriqueMsg;
import com.doctor.service.EnLigneService;
import com.doctor.service.HistoriqueMsgService;

@ManagedBean(name = "chatBean")
@SessionScoped
public class ChatBean {
	private List<HistoriqueMsg> listeMessages = new ArrayList<HistoriqueMsg>();
	private String globalMessage;

	private List<EnLigne> users = new ArrayList<EnLigne>();

	public List<EnLigne> getUsers() {
		EnLigneService enligneser =new EnLigneService();
		//users = s.rechercheTousConnecte();
users=enligneser.rechercheTousEnLigne();
		return users;
	}

	

	public void setUsers(List<EnLigne> users) {
		this.users = users;
	}



	public List<HistoriqueMsg> getListeMessages() {
		listeMessages = new HistoriqueMsgService().rechercheTousHistoriqueMsg();
		return listeMessages;
	}

	public void setListeMessages(List<HistoriqueMsg> listeMessages) {
		this.listeMessages = listeMessages;
	}

	public String getGlobalMessage() {
		return globalMessage;
	}

	public void setGlobalMessage(String globalMessage) {
		this.globalMessage = globalMessage;
	}

	private String utilisateur;

	public String getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(String utilisateur) {
		this.utilisateur = utilisateur;
	}

	public void sendGlobal() {
		HistoriqueMsg hm = new HistoriqueMsg();
		hm.setTexte(globalMessage);
		hm.setLu(false);
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		utilisateur = (String) session.getAttribute("name");
		hm.setSource(utilisateur);
		new HistoriqueMsgService().ajoutHistoriqueMsg(hm);
		globalMessage = null;
	}

}

package com.doctor.chat;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@ApplicationScoped
public class HistoriqueMessage {
	private static String message;
	private List<String> listeMessages;

	public List<String> getListeMessages() {
		return listeMessages;
	}

	@PostConstruct
	public void init() {
		listeMessages = new ArrayList<String>();
	}

	public void remove(String msg) {
		this.listeMessages.remove(msg);
	}

	public void add(String msg) {
		this.listeMessages.add(0, msg);
	}

	public boolean contains(String msg) {
		return this.listeMessages.contains(msg);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		HistoriqueMessage.message = message;
	}

}

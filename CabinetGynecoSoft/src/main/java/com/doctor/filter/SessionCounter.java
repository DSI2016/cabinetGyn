package com.doctor.filter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.doctor.persistance.EnLigne;

public  class SessionCounter implements HttpSessionListener {

	public static int activeSessions = 0;
	public static final Map<String, HttpSession> sessions = new HashMap<String, HttpSession>();
public static List<EnLigne> sesionEnLigne = new ArrayList<EnLigne>();

	@Override
	public void sessionCreated(HttpSessionEvent event) {
	//	HttpSession session = event.getSession();
		activeSessions++;
//		sessions.put(session.getId(), session);
//		System.out.println("creation de session  " + activeSessions+" "+session.getId());
//		// HttpSession session77 = (HttpSession)
		// FacesContext.getCurrentInstance()
		// .getExternalContext().getSession(false);
		// //idPatient = (Integer) session.getAttribute("idsession");
		// session77.setAttribute("idsession",session.getId());
		//
		//
		// System.out.println("message set "+session77.getAttribute("idsession"));
		//

//		HttpSession session2 = find(session.getId());
//		if (session2 != null) {
//			System.out.println("l9aha");
//
//		} else {
//			System.out.println("mal9ahache");
//		}
//		System.out.println("termine methode created session");

//		EnLigne enLigne = new EnLigne();
		//EnLigneService ser1 = new EnLigneService();
//		enLigne.setIdSession(session.getId());
//		ser1.ajoutEnLigne(enLigne);

		//HttpSession temp;

		
//		************
//		
//		sesionEnLigne.clear();
//		sesionEnLigne = ser1.rechercheTousEnLigne();
//		for (int i = 0; i < sesionEnLigne.size(); i++) {
//			temp = find(sesionEnLigne.get(i).getIdSession());
//			if (temp == null) {
//				ser1.supprimerEnLigne(sesionEnLigne.get(i));
//				System.out.println("supprimer"
//						+ sesionEnLigne.get(i).getIdenligne());
//			}
//		}
//System.out.println("size="+sesionEnLigne.size());
//
//
//****
//		if(sesionEnLigne.size()>3)
//			
//		{
//			HttpSession temp1=find(sesionEnLigne.get(2).getIdSession());
//System.out.println(temp1.getId());
//		if(temp1!=null)
//		{
//			temp1.invalidate();
//			System.out.println("nbr"+activeSessions);
//			EnLigneService ser2 = new EnLigneService();
//			enLigne.setIdSession(temp1.getId());
//	ser2.supprimerEnLigne(enLigne);
//		}
//		
//		}
//		else
//		{
//		System.out.println("PAS ENCORE");	
//		}
//		
	}

	// public void sessionDestroyed(HttpSessionEvent event) {
	// sessions.remove(event.getSession().getId());
	// }

//	public static HttpSession find(String sessionId) {
//		System.out.println("entree cherche");
//		return sessions.get(sessionId);
//
//	}

	// public void sessionCreated(HttpSessionEvent se) {
	// // HttpSession session = event.getSession();
	// // sessions.put(session.getId(), session);
	// activeSessions++;
	// System.out.println("creat  " + activeSessions);
	// }
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		//EnLigneService ser1 = new EnLigneService();
//		String id = se.getSession().getId();
//		EnLigne enLigne = new EnLigne();
//		enLigne.setIdSession(id);
//		HttpSession session = se.getSession();
//		if (activeSessions > 0) {
//
//			activeSessions--;
//			// final ServletContext context = session.getServletContext();
//			// idPatient =
////			String idb = (String) session.getAttribute("idsession");
////			if ((idb == null) || (idb.equals("")))
////				System.out.println("null el id");
////
////			else
////				System.out.println("id" + idb);
//
//			System.out.println("effacee  " + activeSessions);
//			// final ServletContext context = session.getServletContext();
//
//			// final ServletContext context = session.getServletContext();
//			// context.removeAttribute(session.getId());
//			ser1.supprimerEnLigne(enLigne);
//
//		}
//
	}

//	public void supprimerSession(HttpSessionEvent se) {
//
//		HttpSession session = se.getSession();
//		final ServletContext context = session.getServletContext();
//		String id = (String) context.getAttribute("session");
//	//	System.out.println("id" + id);
//
//	}

	public static int getActiveSessions() {
//		System.out.println("nbr" + activeSessions);
		return activeSessions;
	}

	public static void listeSaision()

	{
		//System.out.println("entreee liste session" + sessions.size());

		// System.out.println("session1" + sessions.get(0).getId());

	}

}

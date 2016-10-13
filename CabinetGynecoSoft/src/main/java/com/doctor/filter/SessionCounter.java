package com.doctor.filter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.doctor.persistance.EnLigne;
import com.doctor.service.EnLigneService;

public  class SessionCounter implements HttpSessionListener {
	
	public static int activeSessions = 0;
	public static final Map<String, HttpSession> sessions = new HashMap<String, HttpSession>();
public static List<EnLigne> sesionEnLigne = new ArrayList<EnLigne>();

	@Override
	public void sessionCreated(HttpSessionEvent event) {
		System.out.println("entree methode creation ");
		HttpSession session = event.getSession();
		activeSessions++;
		sessions.put(session.getId(), session);
		EnLigne enLigne = new EnLigne();
		EnLigneService ser1 = new EnLigneService();
		
		

		List<EnLigne> Listesession=ser1.rechercheTousEnLigne();
		System.out.println("liste size"+Listesession.size());
		int k=0;
		while(k<Listesession.size()&&(Listesession.size()>0))
		{
			boolean sessionTemp =findSession(Listesession.get(k).getIdSession());
			if(sessionTemp==false)
			{
				EnLigne enligneASupp=ser1.rechercheEnLigne(Listesession.get(k).getIdenligne());
				if(enligneASupp!=null)
					{ser1.supprimerEnLigne(enligneASupp);}
						
			}
			k++;
			
		}


	}
	 public void sessionDestroyed(HttpSessionEvent event) {
	 sessions.remove(event.getSession().getId());
	 }

	public static HttpSession find(String sessionId) {
		return sessions.get(sessionId);

	}
public static boolean findSession(String sessionId)
{
	boolean temp=false;
	Set cles = sessions.keySet();
	Iterator it = cles.iterator();
	while (it.hasNext()&&(temp==false)){
	   Object cle = it.next(); // tu peux typer plus finement ici
	   HttpSession valeur = sessions.get(cle); // tu peux typer plus finement ici
	   if(valeur.getId().equals(sessionId)==true)
temp=true;
		   else
temp=false;	
	}
	if(temp==true)
	return true;
	else
		return(false);

}


	public static int getActiveSessions() {
		return activeSessions;
	}

}

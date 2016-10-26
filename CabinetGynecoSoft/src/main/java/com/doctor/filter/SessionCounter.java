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
	public static final Map<String, HttpSession> sessions = new HashMap<String, HttpSession>();//contient les session courant active
public static List<EnLigne> sesionEnLigne = new ArrayList<EnLigne>();

	@Override
	public void sessionCreated(HttpSessionEvent event) {// cette methode déclanche lors l'application instancier
		System.out.println("entree methode creation ");
		HttpSession session = event.getSession();
		activeSessions++;
		sessions.put(session.getId(), session);//ajouter la session courant dans la map
		EnLigneService ser1 = new EnLigneService();
		
		

		List<EnLigne> Listesession=new ArrayList<EnLigne>();
		Listesession.clear();
		Listesession=ser1.rechercheTousEnLigne();//retourne liste des utilisateurs connecter dans la base
		int k=0;
		while(k<Listesession.size()&&(Listesession.size()>0))
		{
			boolean sessionTemp =findSession(Listesession.get(k).getIdSession());//si une session enregistrer dans la base mais ne sont pas dans notre map on la supprimer
			if(sessionTemp==false)
			{
				EnLigne enligneASupp;
				enligneASupp=ser1.rechercheEnLigne(Listesession.get(k).getIdenligne());
				System.out.println("en ligne a supprimer session counter"+enligneASupp);
				if(enligneASupp!=null)
					{ser1.supprimerEnLigne(enligneASupp);}
						
			}
			k++;
			
		}


	}
	 public void sessionDestroyed(HttpSessionEvent event) {//cette methode supprimer tous session inactif dans la :map
	 sessions.remove(event.getSession().getId());
	 }

	public static HttpSession find(String sessionId) {//cette methode retourner le session recherche dans la map par id session 
		return sessions.get(sessionId);

	}
public static boolean findSession(String sessionId)// cette methode retourner true si la session entrer est trouver dans la map et false sinon

{
	boolean temp=false;
	Set<String> cles = sessions.keySet();
	Iterator<String> it = cles.iterator();
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

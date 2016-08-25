package com.doctor.bean;

// Generated 18 ao�t 2014 11:50:48 by Hibernate Tools 3.4.0.CR1

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.doctor.persistance.Horaire;
import com.doctor.persistance.Jour;
import com.doctor.persistance.Saison;
import com.doctor.service.HoraireService;
import com.doctor.service.JourService;
import com.doctor.service.SaisonService;

@ManagedBean(name = "horaireBean")
@SessionScoped
public class HoraireBean implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idHoraire;
	private Date debut;
	private Date fin;
	private List<Horaire> horaires = new ArrayList<Horaire>();
	private String action;
	private Horaire selectedHoraire = new Horaire();
	private int minHeurs;
	private int maxHeurs;

	public Integer getIdHoraire() {
		return idHoraire;
	}

	public void setIdHoraire(Integer idHoraire) {
		this.idHoraire = idHoraire;
	}

	public Date getDebut() {
		return debut;
	}

	public void setDebut(Date debut) {
		this.debut = debut;
	}

	public Date getFin() {
		return fin;
	}

	public void setFin(Date fin) {
		this.fin = fin;
	}

	public List<Horaire> getHoraires() {
		HoraireService ser = new HoraireService();
		horaires = ser.rechercheTousHoraire();
		return horaires;
	}

	public void setHoraires(List<Horaire> horaires) {
		this.horaires = horaires;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public Horaire getSelectedHoraire() {
		return selectedHoraire;
	}

	public void setSelectedHoraire(Horaire selectedHoraire) {
		this.selectedHoraire = selectedHoraire;
	}

	@SuppressWarnings("deprecation")
	public static String Time(Date d) {
		String time = "";
		if (d.getHours() < 10)
			time = time + "0" + d.getHours();
		else
			time = time + d.getHours();
		if (d.getMinutes() < 10)
			time = time + ":0" + d.getMinutes();
		else
			time = time + ":" + d.getMinutes();
		return time;
	}

	public void init() {
		idHoraire = null;
		debut = null;
		fin = null;
		selectedHoraire = null;
	}

	public void modifierHoraire(Horaire horaire) {
		init();
		selectedHoraire = horaire;
		debut = horaire.getDebut();
		fin = horaire.getFin();
		action = "Modifier";
	}

	public void ajouterHoraire() {
		init();
		action = "Ajouter";
	}

	public void ajout() {
		FacesContext faces = FacesContext.getCurrentInstance();
		HoraireService ser = new HoraireService();
		List<Horaire> l = ser.rechercheParDates(debut, fin);
		if (debut == null || fin == null)
			faces.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Erreur !",
					"Il faut remplir tout les champs !"));
		else if (l.size() != 0)
			faces.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Erreur !",
					"Cette horaire existe déjà !"));
		else if (debut.after(fin))
			faces.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_FATAL, "Impossible !",
					"Intervalle horaire invalide !(" + Time(debut) + " - "
							+ Time(fin) + ")"));
		else {
			Horaire obj = new Horaire(debut, fin);
			ser.ajoutHoraire(obj);
			faces.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Succès !", "Nouvelle horaire est ajouté avec succès."));
		}
	}

	public void modif() {
		FacesContext faces = FacesContext.getCurrentInstance();
		HoraireService ser = new HoraireService();
		List<Horaire> l = ser.rechercheParDates(debut, fin);
		if (debut == null || fin == null)
			faces.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Erreur !",
					"Il faut remplir tout les champs !"));
		else if (l.size() != 0)
			faces.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Erreur !",
					"Cette horaire existe déjà !"));
		else if (debut.after(fin))
			faces.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_FATAL, "Impossible !",
					"Intervalle horaire invalide !(" + Time(debut) + " - "
							+ Time(fin) + ")"));
		else {
			selectedHoraire.setDebut(debut);
			selectedHoraire.setFin(fin);
			ser.modifierHoraire(selectedHoraire);
			faces.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Succès !", "Horaire est modifiée avec succès."));
		}
	}

	public void Supprimer(Integer id) {
		FacesContext faces = FacesContext.getCurrentInstance();
		HoraireService ser = new HoraireService();
		JourService ser02 = new JourService();
		List<Jour> liste = ser02.rechercheParIdHoraire(id);
		List<Jour> liste2 = ser02.rechercheParIdHoraire2(id);
		if (liste.size() == 0 && liste2.size() == 0) {
			ser.supprimerHoraire(id);
			faces.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Succès !", "Horaire est supprimée avec succès."));
		} else
			faces.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_FATAL, "Impossible !",
					"Horaire est utilisé."));
	}

	public void validation() {
		if (action.equals("Ajouter"))
			ajout();
		if (action.equals("Modifier"))
			modif();
		init();
	}

	@SuppressWarnings("deprecation")
	public int getMinHeurs() {
		HoraireService ser = new HoraireService();
		horaires = ser.rechercheTousHoraireAvecOrdre("croissante");
		minHeurs = horaires.get(0).getDebut().getHours();
		return minHeurs;
	}

	public void setMinHeurs(int minHeurs) {
		this.minHeurs = minHeurs;
	}

	@SuppressWarnings("deprecation")
	public int getMaxHeurs() {
		HoraireService ser = new HoraireService();
		horaires = ser.rechercheTousHoraireAvecOrdre("décroissante");
		maxHeurs = horaires.get(0).getFin().getHours();
		return maxHeurs;
	}

	public void setMaxHeurs(int maxHeurs) {
		this.maxHeurs = maxHeurs;
	}

	// nv code

	private String hiver;
	private String ramadhan;
	private String eteDuree;
	private List<Saison> Saisons = new ArrayList<Saison>();
	private Integer idSaison;
	private String debutSaison;
	private String finSaison;
	private Saison DEF ;
	private Saison ETE;
	private Saison RAM;

	public Saison getDEF() {
		getSaisons();
		DEF = Saisons.get(0);
		return DEF;
	}

	public void setDEF(Saison dEF) {
		DEF = dEF;
	}

	public Saison getETE() {
		ETE = Saisons.get(1);
		return ETE;
	}

	public void setETE(Saison eTE) {
		ETE = eTE;
	}

	public Saison getRAM() {
		RAM = Saisons.get(2);
		return RAM;
	}

	public void setRAM(Saison rAM) {
		RAM = rAM;
	}

	public Integer getIdSaison() {
		return idSaison;
	}

	public void setIdSaison(Integer idSaison) {
		this.idSaison = idSaison;
	}

	public String getDebutSaison() {
		return debutSaison;
	}

	public void setDebutSaison(String debutSaison) {
		this.debutSaison = debutSaison;
	}

	public String getFinSaison() {
		return finSaison;
	}

	public void setFinSaison(String finSaison) {
		this.finSaison = finSaison;
	}

	public void setEteDuree(String eteDuree) {
		this.eteDuree = eteDuree;
	}

	public List<Saison> getSaisons() {
		SaisonService ser = new SaisonService();
		Saisons = ser.rechercheTousSaisonAvecJointure();
		return Saisons;
	}

	public void setSaisons(List<Saison> saisons) {
		Saisons = saisons;
	}

	public String getHiver() {

		SaisonService ser = new SaisonService();
		Saisons = ser.rechercheTousSaisonAvecJointure();
		Format format = new SimpleDateFormat("dd/MM/yyyy");

		String deb = format.format(Saisons.get(0).getDebut());
		String f = format.format(Saisons.get(0).getFin());
		hiver = "  du " + deb + " au " + f + " ";
		return hiver;
	}

	public void setHiver(String hiver) {
		this.hiver = hiver;
	}

	public String getRamadhan() {
		SaisonService ser = new SaisonService();
		Saisons = ser.rechercheTousSaisonAvecJointure();
		Format format = new SimpleDateFormat("dd/MM/yyyy");

		String deb = format.format(Saisons.get(2).getDebut());
		String f = format.format(Saisons.get(2).getFin());
		ramadhan = "  du " + deb + " au " + f + " ";
		return ramadhan;
	}

	public void setRamadhan(String ramadhan) {
		this.ramadhan = ramadhan;
	}

	public String getEteDuree() {
		SaisonService ser = new SaisonService();
		Saisons = ser.rechercheTousSaisonAvecJointure();
		Format format = new SimpleDateFormat("dd/MM/yyyy");

		String deb = format.format(Saisons.get(1).getDebut());
		String f = format.format(Saisons.get(1).getFin());
		eteDuree = "  du " + deb + " au " + f + " ";
		return eteDuree;
	}

	public void enArriere() {
		// rechercher nous sommes dans quels saison par rapport date du jour

		// redirection

		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("GestionHoraireTravail");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void modiferSaison(Integer id) {
		idSaison = id;
		SaisonService ser = new SaisonService();
		Saison saison = ser.rechercheSaisonParId(id);
		Format format = new SimpleDateFormat("dd/MM/yyyy");
		debutSaison = format.format(saison.getDebut());
		finSaison = format.format(saison.getFin());
	}

	public void validerSaison() {
		SaisonService ser = new SaisonService();
		Saison s = ser.rechercheSaisonParId(idSaison);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			s.setDebut(sdf.parse(debutSaison));
			s.setFin(sdf.parse(finSaison));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		ser.modifierSaison(s);
		
		// modification selection
		Date aujourdhui = new Date();
		// SaisonService ser = new SaisonService();
		Saisons = ser.rechercheTousSaisonAvecJointure();

		if (Saisons.get(2).getDebut() != null
				&& Saisons.get(2).getFin() != null
				&& aujourdhui.after(Saisons.get(2).getDebut())
				&& aujourdhui.before(Saisons.get(2).getFin())) {
			// saisonEnCour = "de Ramadhan";
			Saisons.get(0).setSelect(0);
			Saisons.get(1).setSelect(0);
			Saisons.get(2).setSelect(1);
			ser.modifierSaison(Saisons.get(0));
			ser.modifierSaison(Saisons.get(1));
			ser.modifierSaison(Saisons.get(2));
		}

		else if (Saisons.get(1).getDebut() != null
				&& Saisons.get(1).getFin() != null
				&& aujourdhui.after(Saisons.get(1).getDebut())
				&& aujourdhui.before(Saisons.get(1).getFin())) {
			// saisonEnCour = "d'été";
			Saisons.get(0).setSelect(0);
			Saisons.get(1).setSelect(1);
			Saisons.get(2).setSelect(0);
			ser.modifierSaison(Saisons.get(0));
			ser.modifierSaison(Saisons.get(1));
			ser.modifierSaison(Saisons.get(2));

		} else {
			// saisonEnCour = "d'hiver";
			Saisons.get(0).setSelect(1);
			Saisons.get(1).setSelect(0);
			Saisons.get(2).setSelect(0);
			ser.modifierSaison(Saisons.get(0));
			ser.modifierSaison(Saisons.get(1));
			ser.modifierSaison(Saisons.get(2));
		}
	}
}

package com.doctor.bean;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import com.doctor.persistance.Cfclient;
import com.doctor.persistance.ConsultationDetail;
import com.doctor.persistance.FormeMedicament;
import com.doctor.persistance.MedOrd;
import com.doctor.persistance.Medicament;
import com.doctor.persistance.ModeleOrdonnance;
import com.doctor.persistance.Ordonnance;
import com.doctor.service.CfclientService;
import com.doctor.service.ConsultationDetailService;
import com.doctor.service.FormeMedicamentService;
import com.doctor.service.MedOrdService;
import com.doctor.service.MedicamentService;
import com.doctor.service.ModeleOrdonnanceService;
import com.doctor.service.OrdonnanceService;

@ManagedBean(name = "ordonnanceBean")
@SessionScoped
public class OrdonnanceBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idOrdonnance;
	private String posologie;
	private String notes;
	private String unite;

	private int qte;
	private boolean desibledImp = true;
	private boolean desibledimpOrdHistorique = true;
	private Integer idMedicament;
	private Integer idConsult;
	private Medicament medicament;
	private ConsultationDetail consult;
	private Cfclient cfclient;
	private Integer idPatient;
	private Ordonnance selectedOrd;
	private Integer idModeleOrd;
	private String nomModeleOrd;
	private boolean app;
	private boolean nvMod;
	private String action;
	public boolean blocage = false;
	private int tempsface = 1500;
	private Date dateDebut;
	private Date dateFin;
	private String typee;
	private boolean desibledOk;
	private Date dateOrd;
	private Integer idOrdSelectionne;
	private String nomProprietaire;
	private String designation;
	private Integer idForme;
	private String prixString;
	private String laboratoire;
	private String tableau;
	private String observation;
	private String forme;
	private String posologieMed;
	private String proprietaire;
	private List<Medicament> medicaments = new ArrayList<Medicament>(0);
	private List<FormeMedicament> formesMedicament = new ArrayList<FormeMedicament>();
	private List<ModeleOrdonnance> modeleOrdonnances = new ArrayList<ModeleOrdonnance>();
	private List<Ordonnance> histoOrdCons = new ArrayList<Ordonnance>();
	private List<Ordonnance> ordonnances = new ArrayList<Ordonnance>();
	private List<MedOrd> medOrds = new ArrayList<MedOrd>(0);
	private boolean consultation;

	public boolean isConsultation() {

		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		action = (String) session.getAttribute("act");
		if (action == null)
			consultation = true;
		else {
			if (action != null && action.equals("consulter"))
				consultation = true;
			else
				consultation = false;
		}

		return consultation;
	}

	public void setConsultation(boolean consultation) {
		this.consultation = consultation;
	}

	public Date getDateOrd() {
		System.out.println("get   " + dateOrd);
		return dateOrd;
	}

	public void setDateOrd(Date dateOrd) {
		System.out.println("set   " + dateOrd);
		this.dateOrd = dateOrd;
	}

	public String getNomProprietaire() {

		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");
		CfclientService ser = new CfclientService();
		cfclient = ser.RechercheCfclient(idPatient);
		if (proprietaire != null && cfclient != null) {

			if (proprietaire.equals("Patiente")) {
				nomProprietaire = cfclient.getPrefix() + " "
						+ cfclient.getNom() + " " + cfclient.getPrenom();

				if (cfclient.getNomC() != null
						&& cfclient.getNomC().trim().length() > 0)
					nomProprietaire += " Ep. " + cfclient.getNomC().trim();

			}

			if (proprietaire.equals("Conjoint")) {
				nomProprietaire = "M.";
				if (cfclient.getPrenomC() != null
						&& cfclient.getPrenomC().trim().length() > 0)
					nomProprietaire += cfclient.getPrenomC().trim();

				if (cfclient.getNomC() != null
						&& cfclient.getNomC().trim().length() > 0)
					nomProprietaire = nomProprietaire + " "
							+ cfclient.getNomC().trim();
			}
		}

		return nomProprietaire;
	}

	public void setNomProprietaire(String nomProprietaire) {
		this.nomProprietaire = nomProprietaire;
	}

	public List<Ordonnance> getHistoOrdCons() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);

		idConsult = (Integer) session.getAttribute("idConsultD");
		idPatient = (Integer) session.getAttribute("idu");
		if (idModeleOrd == null)
			medOrds.clear();
		if (histoOrdCons != null)
			histoOrdCons.clear();
		if (idConsult != null)
			histoOrdCons = new OrdonnanceService()
					.rechercheOrdonnanceParConsultation(idConsult);
		else
			histoOrdCons = new OrdonnanceService()
					.rechercheOrdonnanceLibreParPtient(idPatient, "Libre");
		// afficher liste des ordonnances libres

		return histoOrdCons;
	}

	public void setHistoOrdCons(List<Ordonnance> histoOrdCons) {
		this.histoOrdCons = histoOrdCons;
	}

	@PostConstruct
	public void initial() {
		desibledImp = true;
		desibledimpOrdHistorique = true;
		selectedOrd = null;
		medicaments = new MedicamentService().rechercheToutMedicament();
		desibledOk = true;
		idMedicament = null;
		idOrdSelectionne = null;
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idConsult = (Integer) session.getAttribute("idConsultD");
		medOrds.clear();
		OrdonnanceService serOrd = new OrdonnanceService();
		histoOrdCons.clear();
		if (idConsult != null)
			histoOrdCons = serOrd.rechercheOrdonnanceParConsultation(idConsult);

		idPatient = (Integer) session.getAttribute("idu");
		CfclientService ser = new CfclientService();
		cfclient = ser.RechercheCfclient(idPatient);
		if (proprietaire != null && cfclient != null) {
			if (proprietaire.equals("Patiente")) {
				nomProprietaire = cfclient.getPrefix() + " "
						+ cfclient.getNom() + " " + cfclient.getPrenom();

				if (cfclient.getNomC() != null
						&& cfclient.getNomC().trim().length() > 0)
					nomProprietaire += " Ep. " + cfclient.getNomC().trim();
			}

			if (proprietaire.equals("Conjoint")) {
				nomProprietaire = "M.";
				if (cfclient.getPrenomC() != null
						&& cfclient.getPrenomC().trim().length() > 0)
					nomProprietaire += cfclient.getPrenomC().trim();

				if (cfclient.getNomC() != null
						&& cfclient.getNomC().trim().length() > 0)
					nomProprietaire = nomProprietaire + " "
							+ cfclient.getNomC().trim();
			}
		} else
			proprietaire = "Patiente";
		impress = true;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public boolean isBlocage() {
		return blocage;
	}

	public void setBlocage(boolean blocage) {
		this.blocage = blocage;
	}

	public int getTempsface() {
		return tempsface;
	}

	public void setTempsface(int tempsface) {
		this.tempsface = tempsface;
	}

	public String getAction() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		action = (String) session.getAttribute("act");
		if (action == null)
			consultation = true;
		else {
			if (action != null && action.equals("consulter"))
				consultation = true;
			else
				consultation = false;
		}
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public boolean isNvMod() {

		if (medOrds != null && medOrds.size() == 0)
			nvMod = true;
		else
			nvMod = false;

		return nvMod;
	}

	public void setNvMod(boolean nvMod) {
		this.nvMod = nvMod;
	}

	public boolean isApp() {
		if (idModeleOrd != null)
			app = false;
		else
			app = true;
		return app;
	}

	public void setApp(boolean app) {

		this.app = app;
	}

	public String getNomModeleOrd() {
		return nomModeleOrd;
	}

	public void setNomModeleOrd(String nomModeleOrd) {
		this.nomModeleOrd = nomModeleOrd;
	}

	public Integer getIdModeleOrd() {

		return idModeleOrd;
	}

	public void setIdModeleOrd(Integer idModeleOrd) {

		this.idModeleOrd = idModeleOrd;
	}

	public List<ModeleOrdonnance> getModeleOrdonnances() {
		ModeleOrdonnanceService ser = new ModeleOrdonnanceService();
		modeleOrdonnances = ser.rechercheTousModeleOrdonnance();
		return modeleOrdonnances;
	}

	public void setModeleOrdonnances(List<ModeleOrdonnance> modeleOrdonnances) {
		this.modeleOrdonnances = modeleOrdonnances;
	}

	public Ordonnance getSelectedOrd() {
		return selectedOrd;
	}

	public void setSelectedOrd(Ordonnance selectedOrd) {
		this.selectedOrd = selectedOrd;
	}

	public List<MedOrd> getMedOrds() {

		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");
		action = (String) session.getAttribute("act");
		idOrdonnance = (Integer) session.getAttribute("ido");
		if (action != null)
			if (idOrdonnance != null) {
				medOrds.clear();
				MedOrdService ser = new MedOrdService();
				List<MedOrd> m = ser.rechercheParIdOrd(idOrdonnance);
				for (int i = 0; i < m.size(); i++)
					medOrds.add(m.get(i));
			}
		if (medOrds != null && medOrds.size() == 0)
			nvMod = true;
		else
			nvMod = false;
		return medOrds;
	}

	public void setMedOrds(List<MedOrd> medOrds) {
		if (medOrds != null && medOrds.size() == 0)
			nvMod = true;
		else
			nvMod = false;

		this.medOrds = medOrds;
	}

	public List<Medicament> getMedicaments() {
		return medicaments;
	}

	public void setMedicaments(List<Medicament> medicaments) {
		this.medicaments = medicaments;
	}

	public Cfclient getCfclient() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");
		CfclientService ser = new CfclientService();
		cfclient = ser.RechercheCfclient(idPatient);
		if (proprietaire != null && cfclient != null) {

			if (proprietaire.equals("Patiente")) {
				nomProprietaire = cfclient.getPrefix() + " "
						+ cfclient.getNom() + " " + cfclient.getPrenom();

				if (cfclient.getNomC() != null
						&& cfclient.getNomC().trim().length() > 0)
					nomProprietaire += " Ep. " + cfclient.getNomC().trim();

			}

			if (proprietaire.equals("Conjoint")) {
				nomProprietaire = "M.";
				if (cfclient.getPrenomC() != null
						&& cfclient.getPrenomC().trim().length() > 0)
					nomProprietaire += cfclient.getPrenomC().trim();

				if (cfclient.getNomC() != null
						&& cfclient.getNomC().trim().length() > 0)
					nomProprietaire = nomProprietaire + " "
							+ cfclient.getNomC().trim();
			}
		}

		return cfclient;
	}

	public void setCfclient(Cfclient cfclient) {
		this.cfclient = cfclient;
	}

	public Integer getIdPatient() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");
		return idPatient;
	}

	public void setIdPatient(Integer idPatient) {
		this.idPatient = idPatient;
	}

	public List<Ordonnance> getOrdonnances() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");
		Date df = null;
		if (dateFin != null) {
			GregorianCalendar calendar = new GregorianCalendar();
			calendar.setTime(dateFin);
			calendar.add(Calendar.DATE, 1);
			df = calendar.getTime();
		}
		OrdonnanceService ser = new OrdonnanceService();

		ordonnances = ser.rechercheOrdonnanceParPatient(idPatient, dateDebut,
				df, idMedicament);

		return ordonnances;
	}

	public void setOrdonnances(List<Ordonnance> ordonnances) {
		this.ordonnances = ordonnances;
	}

	public Medicament getMedicament() {
		return medicament;
	}

	public void setMedicament(Medicament medicament) {
		this.medicament = medicament;
	}

	public ConsultationDetail getConsult() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idConsult = (Integer) session.getAttribute("idConsultD");
		ConsultationDetailService ser = new ConsultationDetailService();
		consult = ser.rechercheConsultationDetail(idConsult);
		return consult;
	}

	public void setConsult(ConsultationDetail consult) {
		this.consult = consult;
	}

	public Integer getIdOrdonnance() {
		return idOrdonnance;
	}

	public void setIdOrdonnance(Integer idOrdonnance) {
		this.idOrdonnance = idOrdonnance;
	}

	public String getPosologie() {
		return posologie;
	}

	public void setPosologie(String posologie) {
		this.posologie = posologie;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getUnite() {
		return unite;
	}

	public void setUnite(String unite) {
		this.unite = unite;
	}

	public int getQte() {
		return qte;
	}

	public void setQte(int qte) {
		this.qte = qte;
	}

	public Integer getIdMedicament() {
		if (idMedicament != null) {
			posologie = new MedicamentService().rechercheMedicament(
					idMedicament).getPosologie();
		} else if (idMedicament == null || idMedicament.equals(""))
			desibledOk = false;
		return idMedicament;
	}

	public void setIdMedicament(Integer idMedicament) {
		this.idMedicament = idMedicament;
	}

	public Integer getIdConsult() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idConsult = (Integer) session.getAttribute("idConsultD");
		return idConsult;
	}

	public void setIdConsult(Integer idConsult) {
		this.idConsult = idConsult;
	}

	public void ajouterMed() {
		FacesContext face = FacesContext.getCurrentInstance();

		if (idMedicament != null) {
			if (posologie == null || posologie.trim().length() == 0) {
				face.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_ERROR, "",
						"Veuillez saisir la posologie!!"));
				blocage = true;
			}
			if (qte <= 0) {
				face.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_ERROR, "",
						"Veuillez saisir une quantité !!"));
				blocage = true;
			}
			if (unite == null || unite.equals("")) {
				face.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_ERROR, "",
						"Veuillez saisir l'unité !!"));
				blocage = true;
			}
			HttpSession session = (HttpSession) FacesContext
					.getCurrentInstance().getExternalContext()
					.getSession(false);

			idOrdonnance = (Integer) session.getAttribute("ido");
			if (face.getMessageList().size() == 0) {
				Medicament med = new MedicamentService()
						.rechercheMedicament(idMedicament);
				MedOrd mo = new MedOrd();
				mo.setMedicament(med);
				mo.setPosologie(posologie);
				mo.setQte(qte);
				mo.setUnite(unite);

				mo.setOrdonnance(new OrdonnanceService()
						.rechercheOrdonnance(idOrdonnance));

				new MedOrdService().ajouterMedOrd(mo);
				medOrds.add(mo);
				setMedOrds(medOrds);
				idMedicament = null;
				posologie = null;
				qte = 1;
				unite = null;
				desibledOk = false;
			}
		}
	}

	public void nouvelOrd() {

		action = "Ajout";
		medOrds.clear();
		idMedicament = null;
		posologie = null;
		qte = 1;
		unite = null;
		idOrdonnance = null;
		selectedOrd = null;
		// si consult diff null c'est la date du cons
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idConsult = (Integer) session.getAttribute("idConsultD");
		session.setAttribute("act", "Ajout");
		if (idConsult != null) {
			consult = new ConsultationDetailService()
					.rechercheConsultationDetail(idConsult);
			if (consult != null)
				dateOrdon = consult.getDateConsultation();
		} else
			dateOrdon = new Date();
		cfclient = new CfclientService().RechercheCfclient(idPatient);
		if (cfclient != null)
			nomProprietaire = cfclient.getNom() + cfclient.getPrenom();
		proprietaire = "Patiente";
		notes = null;
		Ordonnance o = new Ordonnance();
		o.setDateOrd(dateOrdon);
		// validation = false;
		new OrdonnanceService().ajoutOrdonnance(o);
		idOrdonnance = o.getIdOrdonnance();
		session.setAttribute("ido", idOrdonnance);
	}

	public void modifOrd(Ordonnance o) {

		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		selectedOrd=o;
		// validation = false;
		if (o.getType() != null && o.getType().equals("Libre")) {
			session.setAttribute("act", "ModifLibre");
			action = "ModifLibre";
		} else {
			session.setAttribute("act", "Modif");
			action = "Modif";
		}
		idOrdonnance = o.getIdOrdonnance();
		setDateOrd(o.getDateOrd());
		medOrds.clear();
		Ordonnance ord = new OrdonnanceService()
				.rechercheParIdOrd(idOrdonnance);
		if (ord != null) {
			Iterator<MedOrd> itr = ord.getMedOrds().iterator();
			while (itr.hasNext()) {
				medOrds.add(itr.next());
			}
			setMedOrds(medOrds);
		}

		setNotes(o.getNotes());
		nomProprietaire = o.getProprietaire();
		proprietaire = o.getPossesseur();
		idMedicament = null;
		posologie = null;
		qte = 1;
		unite = null;
	}

	public void gotoAcceuil() {
		idModeleOrd = null;
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			context.getExternalContext().redirect("Accueil");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void annulation() {

		List<MedOrd> l;
		if (action != null && action.equals("Ajout")) {
			// suppression l'ordonnance ajoutée et les medord liés
			l = new MedOrdService().rechercheParIdOrd(idOrdonnance);
			for (int i = 0; i < l.size(); i++)
				new MedOrdService().supprimerMedOrd(l.get(i).getIdMedOrd());
			new OrdonnanceService().supprimerOrdonnance(idOrdonnance);
		}
		if (action != null && action.equals("ajoutOrdLibre")) {
			l = new MedOrdService().rechercheParIdOrd(idOrdonnance);
			for (int i = 0; i < l.size(); i++)
				new MedOrdService().supprimerMedOrd(l.get(i).getIdMedOrd());
			new OrdonnanceService().supprimerOrdonnance(idOrdonnance);
		}
		medOrds.clear();
		dateOrd = null;
		action = null;
		idOrdonnance = null;
		// validation = true;
	}

	public void retour() {
		idConsult = null;
		idModeleOrd = null;
		medOrds.clear();
		idOrdonnance = null;
		dateOrdon = null;
		selectedOrd = null;
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		session.setAttribute("idConsultD", null);

		String destination = (String) session.getAttribute("source");
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect(destination);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		action = null;
		session.setAttribute("act", null);
		medOrds.clear();
		notes = null;
	}

	public void ajouterModeleOrdonnance() {
		FacesContext face = FacesContext.getCurrentInstance();
		// tester si existe un modèle avec le meme nom
		ModeleOrdonnanceService ser = new ModeleOrdonnanceService();
		ModeleOrdonnance mo = ser.rechercheParModeleOrdonnance(nomModeleOrd);
		if (mo != null)// model existe déjà
		{
			tempsface = 3000;
			blocage = true;
			face.addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur",
							"Existe déjà un Modèle sous le nom "
									+ mo.getNomModele()));
		}
		if (face.getMessageList().size() == 0) {
			ModeleOrdonnance mOrd = new ModeleOrdonnance();
			mOrd.setNomModele(nomModeleOrd);
			ser.ajoutModeleOrdonnance(mOrd);

			List<ModeleOrdonnance> ords = ser.rechercheTousModeleOrdonnance();
			ModeleOrdonnance o = ords.get(ords.size() - 1);

			MedOrdService se = new MedOrdService();

			Iterator<MedOrd> itr = medOrds.iterator();
			while (itr.hasNext()) {
				MedOrd m = itr.next();
				MedOrd mod = new MedOrd();
				mod.setModeleOrdonnance(o);
				mod.setMedicament(m.getMedicament());
				mod.setPosologie(m.getPosologie());
				mod.setQte(m.getQte());
				mod.setUnite(m.getUnite());
				se.ajouterMedOrd(mod);
			}
			blocage = false;
			tempsface = 3000;

			face.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"", "Modèle ajouté avec succés "));

		}
	}

	public void onMedicamentChange() {
		if (idMedicament != null) {
			posologie = new MedicamentService().rechercheMedicament(
					idMedicament).getPosologie();
			desibledOk = false;
		} else
			posologie = null;
	}

	public void supprimer(MedOrd m) {
		FacesContext face = FacesContext.getCurrentInstance();
		medOrds.remove(m);
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);

		action = (String) session.getAttribute("act");

		// supprimer cette ligne de table MedOrd
		new MedOrdService().supprimerMedOrd(m.getIdMedOrd());
		blocage = false;
		face.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "",
				"Médicament supprimée avec succès"));

		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getFlash().setKeepMessages(true);
		try {
			context.getExternalContext().redirect("NouvelleOrdonnance");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void onRowSelect(SelectEvent event) {
		Ordonnance o = (Ordonnance) event.getObject();
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		session.setAttribute("act", "consulter");
		selectedOrd = o;
		impress = false;
		medOrds.clear();
		// recherche liste des medicament par idord
		if (o != null) {
			idOrdSelectionne = o.getIdOrdonnance();
			idOrdonnance = o.getIdOrdonnance();
			session.setAttribute("ido", o.getIdOrdonnance());
			desibledImp = false;
			desibledimpOrdHistorique = false;
			OrdonnanceService ser = new OrdonnanceService();
			Ordonnance ord = ser.rechercheParIdOrd(o.getIdOrdonnance());
			medOrds.addAll(ord.getMedOrds());
			typee = ord.getType();
			dateOrd = ord.getDateOrd();
			proprietaire = ord.getPossesseur();
			nomProprietaire = ord.getProprietaire();
			notes = ord.getNotes();
			if (idOrdSelectionne == null) {
				desibledImp = true;
			} else
				desibledImp = false;
			if (idOrdSelectionne == null) {
				desibledimpOrdHistorique = true;
			} else
				desibledimpOrdHistorique = false;
		}
	}

	public void ajoutModel() {
		RequestContext.getCurrentInstance().update(":f1:f2:p1");

		RequestContext context = RequestContext.getCurrentInstance();
		context.execute("PF('ajoutModel').show();");
	}

	public void appliquerModeleOrd() {

		if (idModeleOrd != null) {

			MedOrdService ser = new MedOrdService();
			List<MedOrd> m = ser.rechercheModeleOrdonnanceAvecJoin(idModeleOrd);
			for (int i = 0; i < m.size(); i++) {
				MedOrd me = new MedOrd();
				me.setMedicament(m.get(i).getMedicament());
				me.setPosologie(m.get(i).getPosologie());
				me.setQte(m.get(i).getQte());
				me.setUnite(m.get(i).getUnite());
				medOrds.add(me);
			}
			FacesContext context = FacesContext.getCurrentInstance();
			try {
				context.getExternalContext().redirect("NouvelleOrdonnance");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}
	}

	public void modeleSelectionChanged(final AjaxBehaviorEvent event) {
		if (idModeleOrd != null)
			app = false;
		else
			app = true;
	}

	public void suppressionOrdonnance(Integer idOrd) {
		// supression des medOrd avec cet idOrd

		MedOrdService s = new MedOrdService();
		List<MedOrd> listMed = s.rechercheParIdOrd(idOrd);
		for (int i = 0; i < listMed.size(); i++)
			s.supprimerMedOrd(listMed.get(i));
		medOrds.clear();
		OrdonnanceService ser = new OrdonnanceService();

		ser.supprimerOrdonnance(idOrd);
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idConsult = (Integer) session.getAttribute("idConsultD");
		if (idConsult != null) {
			consult = new ConsultationDetailService()
					.rechercheConsultationDetail(idConsult);
			consult.setNbOrd(consult.getNbOrd() - 1);
			new ConsultationDetailService().modifierConsultationDetail(consult);
		}
		FacesContext context = FacesContext.getCurrentInstance();
		FacesContext faces = FacesContext.getCurrentInstance();
		blocage = false;
		faces.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "",
				"Ordonnance supprimée avec succès"));
		context.getExternalContext().getFlash().setKeepMessages(true);
		try {
			context.getExternalContext().redirect("NouvelleOrdonnance");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void supprimerOrdonnance(Integer idOrd) {
		// supression des medOrd avec cet idOrd

		MedOrdService s = new MedOrdService();
		List<MedOrd> listMed = s.rechercheParIdOrd(idOrd);
		for (int i = 0; i < listMed.size(); i++)
			s.supprimerMedOrd(listMed.get(i));
		medOrds.clear();
		OrdonnanceService ser = new OrdonnanceService();

		ser.supprimerOrdonnance(idOrd);

		FacesContext context = FacesContext.getCurrentInstance();
		FacesContext faces = FacesContext.getCurrentInstance();
		blocage = false;
		faces.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "",
				"Ordonnance supprimée avec succès"));
		context.getExternalContext().getFlash().setKeepMessages(true);
		try {
			context.getExternalContext().redirect("HistoriqueOrdonnances");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void supprimerModeleOrdonnance(Integer idModeleOrd) {

		// supression des lignes medOrd lié avant
		MedOrdService serMO = new MedOrdService();
		List<MedOrd> l = serMO.rechercheParIdModele(idModeleOrd);
		for (int j = 0; j < l.size(); j++)
			serMO.supprimerMedOrd(l.get(j).getIdMedOrd());

		ModeleOrdonnanceService ser = new ModeleOrdonnanceService();
		ser.supprimerModeleOrdonnance(idModeleOrd);

	}

	// impression ordonnance de la liste(historique ord ou selectionné du
	// demande)
	public void viewOrd(ActionEvent actionEvent) throws SQLException, Exception {

		if (selectedOrd != null) {
			typee = selectedOrd.getType();
			idOrdSelectionne = selectedOrd.getIdOrdonnance();
		}
		String nomReport = "";
		if (typee.equals("Libre")) {
			nomReport = "ordonnaceLibre";
		} else {
			nomReport = "ord";
		}
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("idOrd", idOrdSelectionne);

		Module.imprimer(nomReport, param);
	}

	public void validationOrd() {
		FacesContext faces = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		Ordonnance ord = new Ordonnance();

		idPatient = (Integer) session.getAttribute("idu");
		idConsult = (Integer) session.getAttribute("idConsultD");
		idOrdonnance = (Integer) session.getAttribute("ido");
		ord = new OrdonnanceService().rechercheOrdonnance(idOrdonnance);
		ord.setNotes(notes);
		ord.setProprietaire(nomProprietaire);
		ord.setPossesseur(proprietaire);
		if (idPatient != null) {
			CfclientService serc = new CfclientService();
			Cfclient c = serc.RechercheCfclient(idPatient);
			ord.setPatient(c);
		}
		ord.setDateOrd(dateOrdon);
		consult = new ConsultationDetailService()
				.rechercheConsultationDetailAvecJoint(idConsult);
		if (consult != null) {
			ord.setType(consult.getConsultation().getNomConsultation());
			ord.setConsult(consult);
			tempsface = 3000;
		} else
			ord.setType("Libre");

		if (action.equals("Ajout")) {
			consult.setNbOrd(consult.getNbOrd() + 1);
			new ConsultationDetailService().modifierConsultationDetail(consult);
		}

		new OrdonnanceService().modifierOrdonnance(ord);
		if (action.equals("ajoutOrdLibre"))
			faces.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"", "Ordonnance ajoutée avec succès"));

		if (action.equals("Modif") || action.equals("ModifLibre"))
			faces.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"", "Ordonnance modifiée avec succès"));

		idMedicament = null;
		posologie = null;
		qte = 1;
		unite = null;
		selectedOrd = ord;
		action = "consulter";
		session.setAttribute("act", "consulter");
	}

	// methode non utilisée
	public void validerOrd(ActionEvent actionEvent) throws SQLException,
			Exception {
		// String nomReport = "ord"

		FacesContext face = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		Ordonnance ord = null;

		idPatient = (Integer) session.getAttribute("idu");
		idConsult = (Integer) session.getAttribute("idConsultD");
		if (idConsult != null) {
			if (action != null
					&& (action.equals("Ajout") || action.equals("Modif") || action
							.equals("ajoutCons"))) {

				ord = new OrdonnanceService().rechercheOrdonnance(idOrdonnance);

				ord.setNotes(notes);
				ord.setProprietaire(nomProprietaire);
				ord.setPossesseur(proprietaire);
				if (idPatient != null) {
					CfclientService serc = new CfclientService();
					Cfclient c = serc.RechercheCfclient(idPatient);
					ord.setPatient(c);
				}
				System.out.println("la date valide  " + dateOrd);
				ord.setDateOrd(dateOrd);
				consult = new ConsultationDetailService()
						.rechercheConsultationDetailAvecJoint(idConsult);
				if (consult != null) {
					ord.setType(consult.getConsultation().getNomConsultation());
					ord.setConsult(consult);
					tempsface = 3000;
				}
				new OrdonnanceService().modifierOrdonnance(ord);

				if (action.equals("Ajout") || action.equals("ajoutCons")) {
					consult.setNbOrd(consult.getNbOrd() + 1);
					new ConsultationDetailService()
							.modifierConsultationDetail(consult);

					face.addMessage(null, new FacesMessage(
							FacesMessage.SEVERITY_INFO, "",
							"Ordonnance ajoutée avec succès"));

					idMedicament = null;
					posologie = null;
					qte = 1;
					unite = null;
					notes = null;
				} else
					face.addMessage(null, new FacesMessage(
							FacesMessage.SEVERITY_INFO, "",
							"Ordonnance modifiée avec succès"));
			}
		} else {

			if (action != null
					&& (action.equals("ajoutOrdLibre")
							|| action.equals("ajoutOrdLibreHistorique")
							|| action.equals("Ajout") || action.equals("Modif") || action
								.equals("ModifLibre"))) {
				ord = new OrdonnanceService().rechercheOrdonnance(idOrdonnance);

				ord.setNotes(notes);
				ord.setProprietaire(nomProprietaire);
				ord.setPossesseur(proprietaire);
				if (idPatient != null) {
					CfclientService serc = new CfclientService();
					Cfclient c = serc.RechercheCfclient(idPatient);
					ord.setPatient(c);
				}
				ord.setDateOrd(dateOrd);
				ord.setType("Libre");
				new OrdonnanceService().modifierOrdonnance(ord);

			}
		}

		if (action != null && action.equals("modifierHistorique")) {
			ord = new OrdonnanceService().rechercheOrdonnance(idOrdonnance);

			ord.setNotes(notes);
			ord.setProprietaire(nomProprietaire);
			ord.setPossesseur(proprietaire);
			if (idPatient != null) {
				CfclientService serc = new CfclientService();
				Cfclient c = serc.RechercheCfclient(idPatient);
				ord.setPatient(c);
			}
			ord.setDateOrd(dateOrd);
			new OrdonnanceService().modifierOrdonnance(ord);

		}
		action = null;
		selectedOrd = ord;
		session.setAttribute("act", null);

	}

	public void dateChange() {
		setDateOrdon(dateOrdon);
	}

	public void recuperationOrdonnance(Ordonnance o) {

		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		
		selectedOrd=o;
		if (o.getType() != null && o.getType().equals("Libre")) {
			// c'est une modification d'une ord libre
			session.setAttribute("act", "ModifLibre");
			action = "ModifLibre";
		} else {
			// c'est une modification d'une ord d'une cons
			session.setAttribute("act", "Modif");
			action = "Modif";
		}
		idOrdonnance = o.getIdOrdonnance();
		dateOrdon = o.getDateOrd();
		// setDateOrd(o.getDateOrd());
		medOrds.clear();
		Ordonnance ord = new OrdonnanceService()
				.rechercheParIdOrd(idOrdonnance);
		if (ord != null) {
			Iterator<MedOrd> itr = ord.getMedOrds().iterator();
			while (itr.hasNext()) {
				medOrds.add(itr.next());
			}
			setMedOrds(medOrds);
		}

		setNotes(o.getNotes());
		nomProprietaire = o.getProprietaire();
		proprietaire = o.getPossesseur();
		idMedicament = null;
		posologie = null;
		qte = 1;
		unite = null;
		session.setAttribute("source", "HistoriqueOrdonnances");
		session.setAttribute("ido", idOrdonnance);
		if (o.getConsult() != null) {
			session.setAttribute("idConsultD", o.getConsult()
					.getIdConsultationDetail());
		}

		FacesContext context = FacesContext.getCurrentInstance();
		try {
			context.getExternalContext().redirect("NouvelleOrdonnance");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void annulerRecherche() {
		dateDebut = null;
		dateFin = null;
		idMedicament = null;
		selectedOrd = null;
	}

	public void goToRead() {
		idOrdSelectionne = null;
		selectedOrd = null;
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			context.getExternalContext().redirect("FichePatiente");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void goTonouvelleOrd() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			context.getExternalContext().redirect("NouvelleOrdonnance");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void ajouterOrdLibre() {

		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		session.setAttribute("idu", idPatient);
		session.setAttribute("act", "ajoutOrdLibre");
		Ordonnance o = new Ordonnance();
		o.setDateOrd(new Date());
		dateOrdon = new Date();
		o.setType("Libre");
		new OrdonnanceService().ajoutOrdonnance(o);
		idOrdonnance = o.getIdOrdonnance();
		CfclientService ser = new CfclientService();
		System.out.println(idPatient);
		cfclient = ser.RechercheCfclient(idPatient);
		if (cfclient != null)
			nomProprietaire = cfclient.getNom() + cfclient.getPrenom();
		proprietaire = "Patiente";
		session.setAttribute("ido", idOrdonnance);

	}

	public void goToOrdonnanceLibreHistorique() {
		ajouterOrdLibre();
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		session.setAttribute("source", "HistoriqueOrdonnances");
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("NouvelleOrdonnance");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void goToOrdonnanceLibre() {
		ajouterOrdLibre();
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		session.setAttribute("source", "FichePatiente");
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("NouvelleOrdonnance");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public String getTypee() {
		return typee;
	}

	public void setTypee(String typee) {
		this.typee = typee;
	}

	public boolean isDesibledOk() {
		return desibledOk;
	}

	public void setDesibledOk(boolean desibledOk) {
		this.desibledOk = desibledOk;
	}

	public Integer getIdOrdSelectionne() {
		return idOrdSelectionne;
	}

	public void setIdOrdSelectionne(Integer idOrdSelectionne) {
		this.idOrdSelectionne = idOrdSelectionne;
	}

	public boolean isDesibledImp() {
		return desibledImp;
	}

	public void setDesibledImp(boolean desibledImp) {
		this.desibledImp = desibledImp;
	}

	public void goToOrdonnances() {
		idOrdSelectionne = null;
		selectedOrd = null;
	}

	public String getPosologieMed() {
		return posologieMed;
	}

	public void setPosologieMed(String posologieMed) {
		this.posologieMed = posologieMed;
	}

	public void validationMed() {
		MedicamentService ser = new MedicamentService();
		FormeMedicamentService s = new FormeMedicamentService();
		FacesContext faces = FacesContext.getCurrentInstance();
		RequestContext context = RequestContext.getCurrentInstance();
		boolean addValid = false;
		float prix = 0;

		if (designation == null || (designation.trim().length() == 0)) {
			// tester si cette zone de text est vide
			faces.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"Veuillez donner le nom du médicament.", ""));
			addValid = false;
		}
		if (prixString != null && prixString.trim().length() > 0)
			try {
				prixString.replaceAll(",", ".");
				prix = Float.parseFloat(prixString);
			} catch (Exception e) {
				faces.addMessage(
						null,
						new FacesMessage(
								FacesMessage.SEVERITY_ERROR,
								"Veuillez vérifier le format du prix. Il ne peux pas contenir que des chiffres.",
								""));
				prix = 0;
				prixString = "";
			}
		if (faces.getMessageList().size() == 0) {
			// recherche par nom et format du médicament si cette ligne exist
			// déjà
			FormeMedicament f = null;
			Medicament m = null;
			if (idForme != null) {
				f = s.rechercheFormeMedicament(idForme);
				if (f != null)
					m = ser.rechercheMedicamentParLibelleMedicament(
							designation, f.getForme());
			} else {
				m = ser.rechercheMedicamentSansForme(designation);
			}
			if (m != null) {
				// c'est le cas de modification des données differents que le
				// nom et la forme
				faces.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_ERROR, "Le médicament \""
								+ designation + "\" existe déjà.", ""));
				addValid = false;
			} else {
				Medicament m2 = new Medicament();
				m2.setDesignation(designation);
				if (f != null)
					m2.setFormeMed(f);
				m2.setPosologie(posologieMed);
				m2.setPrix(prix);
				m2.setLaboratoire(laboratoire);
				m2.setObservation(observation);
				m2.setTableau(tableau);

				ser.ajouterMedicament(m2);
				medicaments = new MedicamentService().rechercheToutMedicament();
				idMedicament = m2.getIdMedicament();
				faces.addMessage(null, new FacesMessage("Le médicament\""
						+ designation + "\" ajouté avec succès.", ""));
				addValid = true;
				closeDiagMed();
				RequestContext.getCurrentInstance().update("f1");
				FacesContext.getCurrentInstance().getExternalContext()
						.getFlash().setKeepMessages(true);
				try {
					FacesContext.getCurrentInstance().getExternalContext()
							.redirect("NouvelleOrdonnance");
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}

		context.addCallbackParam("addValid", addValid);
	}

	public void closeDiagMed() {
		designation = null;
		idForme = null;
		posologieMed = null;
		prixString = null;
		laboratoire = null;
		tableau = null;
		observation = null;
		forme = null;
	}

	public void initForme() {
		idForme = null;
		forme = null;
	}

	public void ajoutForme() {
		RequestContext context = RequestContext.getCurrentInstance();
		boolean addValid = false;

		FacesContext faces = FacesContext.getCurrentInstance();
		FormeMedicamentService ser = new FormeMedicamentService();
		if (forme == null || (forme.trim().length() == 0)) {// tester si cette
															// zone de text est
															// vide
			faces.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"Veuillez donner le nom de la forme.", null));
			addValid = false;
		} else // tester si ce forme existe déjà
		{
			FormeMedicament d3 = ser
					.rechercheFormeMedicamentParLibelleFormeMedicament(forme);

			if (d3 == null) { // c-à-d n'existe pas forme avec ce nom

				FormeMedicament d1 = new FormeMedicament(forme);

				ser.ajoutFormeMedicament(d1);
				faces.addMessage(null, new FacesMessage("Forme médicament \""
						+ forme + "\" ajoutée avec succès."));
				addValid = true;

				List<FormeMedicament> fm = ser.rechercheTousFormeMedicament();
				if (fm != null && fm.size() > 0) {
					idForme = fm.get(fm.size() - 1).getIdFormeMedicament();
				}

			} else {

				faces.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_ERROR, "Forme médicament \""
								+ forme + "\" existe déjà.", null));
				addValid = false;
			}
		}

		context.addCallbackParam("addValid", addValid);
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Integer getIdForme() {
		return idForme;
	}

	public void setIdForme(Integer idForme) {
		this.idForme = idForme;
	}

	public List<FormeMedicament> getFormesMedicament() {
		formesMedicament = new FormeMedicamentService()
				.rechercheTousFormeMedicament();
		return formesMedicament;
	}

	public void setFormesMedicament(List<FormeMedicament> formesMedicament) {
		this.formesMedicament = formesMedicament;
	}

	public String getPrixString() {
		return prixString;
	}

	public void setPrixString(String prixString) {
		this.prixString = prixString;
	}

	public String getLaboratoire() {
		return laboratoire;
	}

	public void setLaboratoire(String laboratoire) {
		this.laboratoire = laboratoire;
	}

	public String getTableau() {
		return tableau;
	}

	public void setTableau(String tableau) {
		this.tableau = tableau;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public String getForme() {
		return forme;
	}

	public void setForme(String forme) {
		this.forme = forme;
	}

	public String getProprietaire() {
		return proprietaire;
	}

	public void setProprietaire(String proprietaire) {
		this.proprietaire = proprietaire;
	}

	public void changeProp() {
		setProprietaire(proprietaire);
		setNomProprietaire(nomProprietaire);
	}

	public void notesChange() {

		setNotes(notes);
	}

	public boolean isDesibledimpOrdHistorique() {
		return desibledimpOrdHistorique;
	}

	public void setDesibledimpOrdHistorique(boolean desibledimpOrdHistorique) {
		this.desibledimpOrdHistorique = desibledimpOrdHistorique;
	}

	public void initMed() {
		designation = null;
		idForme = null;
		posologieMed = null;
		prixString = null;
		laboratoire = null;
		tableau = null;
		observation = null;

		forme = null;
		// ouvrir le dialogue
		RequestContext.getCurrentInstance().update(":f1;fmed:dialog");
		RequestContext context = RequestContext.getCurrentInstance();
		context.execute("PF('dialogmedicament').show();");

	}

	private boolean impress;

	public boolean isImpress() {
		return impress;
	}

	public void setImpress(boolean impress) {
		this.impress = impress;
	}

	private Date dateOrdon;

	public Date getDateOrdon() {
		return dateOrdon;
	}

	public void setDateOrdon(Date dateOrdon) {
		this.dateOrdon = dateOrdon;
	}

}

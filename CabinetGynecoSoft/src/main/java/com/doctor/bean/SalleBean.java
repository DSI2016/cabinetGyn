package com.doctor.bean;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.primefaces.context.RequestContext;

import com.doctor.persistance.AnnuleSalle;
import com.doctor.persistance.Cfclient;
import com.doctor.persistance.Salle;
import com.doctor.persistance.TabSalle;
import com.doctor.service.AnnuleSalleService;
import com.doctor.service.CfclientService;
import com.doctor.service.SalleService;
import com.doctor.service.TabSalleService;

@ManagedBean(name = "salleBean")
@SessionScoped
public class SalleBean implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer code;
	private int sizeTous;
	private int sizeConsultation;
	private int sizeControl;
	private String motif;
	private String notes;
	private int ordre;
	private List<Salle> salles = new ArrayList<Salle>();
	private List<Salle> sallesAvecJointure = new ArrayList<Salle>();

	private List<Salle> sallesAvecJointureControl = new ArrayList<Salle>();
	private List<Salle> sallesAvecJointureConsultation = new ArrayList<Salle>();
	private List<Salle> sallesAvecJointureBilan = new ArrayList<Salle>();
	private List<Salle> sallesAvecJointureTel = new ArrayList<Salle>();
	private List<Salle> sallesAvecJointureMotif = new ArrayList<Salle>();
	private int sizeTel;
	private int sizeMotif;
	private int nouveauOrdre;
	private Integer codePatient;
	private String page;
	private Cfclient cfclient;
	private String heure;
	private String reponse;
	private int exactOrdre;
	private boolean nouvellePatientSal;
	private boolean monterPatientSal;
	private boolean descendrePatientSal;
	private boolean permuterPatientSal;
	private boolean premierPatientSal;
	private boolean dernierPatientSal;
	private boolean suppressionPatientSal;
	private boolean chargerPatientSal;
	private boolean verConsultation;
	private String cause;
	private List<AnnuleSalle> sallesAnnule = new ArrayList<AnnuleSalle>(0);
	private int sizeAnnul;

	private Integer idTabSalle;
	private String nomTab;
	private int index;
	private boolean ordreDifferent;
	private boolean active;
	private List<TabSalle> tabSalles = new ArrayList<TabSalle>();

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

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

	public List<TabSalle> getTabSalles() {

		TabSalleService ser = new TabSalleService();
		tabSalles = ser.rechercheToutTabSalle();

		return tabSalles;
	}

	public void setTabSalles(List<TabSalle> tabSalles) {
		this.tabSalles = tabSalles;
	}

	public int getSizeAnnul() {
		sallesAnnule = new AnnuleSalleService().rechercheToutAnnuleSalle();
		sizeAnnul = sallesAnnule.size();
		return sizeAnnul;
	}

	public void setSizeAnnul(int sizeAnnul) {
		this.sizeAnnul = sizeAnnul;
	}

	public List<AnnuleSalle> getSallesAnnule() {
		sallesAnnule = new AnnuleSalleService()
				.rechercheToutAnnuleSalleAvecJoin();

		return sallesAnnule;
	}

	public void setSallesAnnule(List<AnnuleSalle> sallesAnnule) {
		this.sallesAnnule = sallesAnnule;
	}

	public String getCause() {
		return cause;
	}

	public void setCause(String cause) {
		this.cause = cause;
	}

	public boolean isVerConsultation() {
		if (Module.verConsult.equals("0")) {
			verConsultation = false;
		} else {
			verConsultation = true;
		}
		return verConsultation;
	}

	public void setVerConsultation(boolean verConsultation) {
		this.verConsultation = verConsultation;
	}

	public boolean isNouvellePatientSal() {

		if (Module.nouvPatSal.equals("0")) {
			nouvellePatientSal = false;
		} else {
			nouvellePatientSal = true;
		}
		return nouvellePatientSal;
	}

	public void setNouvellePatientSal(boolean nouvellePatientSal) {
		this.nouvellePatientSal = nouvellePatientSal;
	}

	public boolean isMonterPatientSal() {
		if (Module.monterPatSal.equals("0"))
			monterPatientSal = false;
		else
			monterPatientSal = true;
		return monterPatientSal;
	}

	public void setMonterPatientSal(boolean monterPatientSal) {
		this.monterPatientSal = monterPatientSal;
	}

	public boolean isDescendrePatientSal() {

		if (Module.desdrePatSal.equals("0"))
			descendrePatientSal = false;
		else
			descendrePatientSal = true;
		return descendrePatientSal;
	}

	public void setDescendrePatientSal(boolean descendrePatientSal) {
		this.descendrePatientSal = descendrePatientSal;
	}

	public boolean isPermuterPatientSal() {

		if (Module.permutPatSal.equals("0"))
			permuterPatientSal = false;
		else
			permuterPatientSal = true;
		return permuterPatientSal;
	}

	public void setPermuterPatientSal(boolean permuterPatientSal) {
		this.permuterPatientSal = permuterPatientSal;
	}

	public boolean isPremierPatientSal() {
		if (Module.premierPatSal.equals("0"))
			premierPatientSal = false;
		else
			premierPatientSal = true;
		return premierPatientSal;
	}

	public void setPremierPatientSal(boolean premierPatientSal) {
		this.premierPatientSal = premierPatientSal;
	}

	public boolean isDernierPatientSal() {
		if (Module.dernierPatSal.equals("0"))
			dernierPatientSal = false;
		else
			dernierPatientSal = true;
		return dernierPatientSal;
	}

	public void setDernierPatientSal(boolean dernierPatientSal) {
		this.dernierPatientSal = dernierPatientSal;
	}

	public boolean isSuppressionPatientSal() {

		if (Module.supPatSal.equals("0"))
			suppressionPatientSal = false;
		else
			suppressionPatientSal = true;

		return suppressionPatientSal;
	}

	public void setSuppressionPatientSal(boolean suppressionPatientSal) {
		this.suppressionPatientSal = suppressionPatientSal;
	}

	public boolean isChargerPatientSal() {

		if (Module.chargPatSal.equals("0"))
			chargerPatientSal = false;
		else
			chargerPatientSal = true;

		return chargerPatientSal;
	}

	public void setChargerPatientSal(boolean chargerPatientSal) {
		this.chargerPatientSal = chargerPatientSal;
	}

	public int getNouveauOrdre() {
		return nouveauOrdre;
	}

	public void setNouveauOrdre(int exactOrdre) {
		this.nouveauOrdre = exactOrdre;
	}

	public List<Salle> getSallesAvecJointureMotif() {
		SalleService sl = new SalleService();
		sallesAvecJointureMotif = sl.rechercheSalleAvecMotif(motif);
		sizeMotif = sallesAvecJointureMotif.size();
		return sallesAvecJointureMotif;
	}

	public void setSallesAvecJointureMotif(List<Salle> sallesAvecJointureMotif) {
		this.sallesAvecJointureMotif = sallesAvecJointureMotif;
	}

	public int getSizeMotif() {
		SalleService ser = new SalleService();
		sallesAvecJointureMotif = ser.rechercheSalleAvecMotif(motif);
		sizeMotif = sallesAvecJointureMotif.size();

		return sizeMotif;
	}

	public void setSizeMotif(int sizeMotif) {
		this.sizeMotif = sizeMotif;
	}

	public int getSizeTel() {
		SalleService ser = new SalleService();
		sallesAvecJointureTel = ser.rechercheSalleAvecMotif("Telephone");
		sizeTel = sallesAvecJointureTel.size();
		return sizeTel;
	}

	public void setSizeTel(int sizeTel) {
		this.sizeTel = sizeTel;
	}

	public List<Salle> getSallesAvecJointureTel() {

		SalleService sl = new SalleService();
		sallesAvecJointureTel = sl.rechercheSalleAvecMotif("Telephone");
		sizeTel = sallesAvecJointureTel.size();
		return sallesAvecJointureTel;
	}

	public void setSallesAvecJointureTel(List<Salle> sallesAvecJointureTel) {
		this.sallesAvecJointureTel = sallesAvecJointureTel;
	}

	public int getSizeTous() {
		SalleService sl = new SalleService();
		List<Salle> toutSalles = new ArrayList<Salle>();// tous les salles
		List<TabSalle> tsList = new ArrayList<TabSalle>();
		List<String> motifsList = new ArrayList<String>();
		TabSalleService ser = new TabSalleService();

		tsList = ser.rechercheParOrdDiff(false);// list tabsalle while
												// orddiff==false cad mem ordre
		for (int i = 0; i < tsList.size(); i++) {

			motifsList.add(tsList.get(i).getNomTab());
		}
		sallesAvecJointure.clear();
		toutSalles = sl.rechercheTouSalleAvecJoin("cfclient");
		for (int i = 0; i < toutSalles.size(); i++) {
			for (int j = 0; j < motifsList.size(); j++) {

				if (toutSalles.get(i).getMotif().equals(motifsList.get(j))) {
					sallesAvecJointure.add(toutSalles.get(i));
				}
			}
		}

		sizeTous = sallesAvecJointure.size();

		return sizeTous;
	}

	public void setSizeTous(int sizeTous) {
		this.sizeTous = sizeTous;
	}

	public int getSizeConsultation() {
		SalleService ser = new SalleService();
		sallesAvecJointureConsultation = ser
				.rechercheSalleAvecMotif("Consultation");
		sizeConsultation = sallesAvecJointureConsultation.size();
		return sizeConsultation;
	}

	public void setSizeConsultation(int sizeConsultation) {
		this.sizeConsultation = sizeConsultation;
	}

	public int getSizeControl() {
		SalleService ser = new SalleService();
		sallesAvecJointureControl = ser.rechercheSalleAvecMotif("Control");
		sizeControl = sallesAvecJointureControl.size();
		return sizeControl;
	}

	public void setSizeControl(int sizeControl) {
		this.sizeControl = sizeControl;
	}

	public String getHeure() {
		return heure;
	}

	public void setHeure(String heure) {
		this.heure = heure;
	}

	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public int getOrdre() {
		ordre = sizeTous;
		return ordre;
	}

	public void setOrdre(int ordre) {
		ordre = sizeTous;
		this.ordre = ordre;
	}

	public List<Salle> getSalles() {
		SalleService sl = new SalleService();
		salles = sl.rechercheToutSalle();
		return salles;
	}

	public void setSalles(List<Salle> salles) {
		this.salles = salles;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public Cfclient getCfclient() {
		return cfclient;
	}

	public void setCfclient(Cfclient cfclient) {
		this.cfclient = cfclient;
	}

	public int getExactOrdre() {
		return exactOrdre;
	}

	public void setExactOrdre(int exactOrdre) {
		this.exactOrdre = exactOrdre;
	}

	public Integer getCodePatient() {
		return codePatient;
	}

	public void setCodePatient(Integer codePatient) {
		this.codePatient = codePatient;
	}

	public void initialiser() {
		code = null;
		heure = null;
		notes = null;

		cfclient = null;
		motif = null;
		codePatient = null;

	}

	public void ajout(Integer codeClient) {
		codePatient = codeClient;
	}

	// public void ajoutSalle() {
	// String minu = "";
	// Calendar c = Calendar.getInstance();
	// Integer minute = c.get(Calendar.MINUTE);
	// if (minute < 10)
	// minu = "0" + minute;
	// else
	// minu = minute.toString();
	//
	// SalleService ser = new SalleService();
	// Salle sal = new Salle();
	// Cfclient cl = new Cfclient();
	// CfclientService ser1 = new CfclientService();
	// cl = ser1.RechercheCfclient(codePatient);
	// sal.setCfclient(cl);
	// sal.setHeure(c.get(Calendar.HOUR_OF_DAY) + ":" + minu);
	// sal.setMotif(motif);
	// sal.setNotes(notes);
	// ser.ajouterSalle(sal, motif);
	// initialiser();
	//
	// }

	public List<Salle> getSallesAvecJointure() {

		SalleService sl = new SalleService();
		List<Salle> toutSalles = new ArrayList<Salle>();// tous les salles
		List<TabSalle> tsList = new ArrayList<TabSalle>();
		List<String> motifsList = new ArrayList<String>();
		TabSalleService ser = new TabSalleService();

		tsList = ser.rechercheParOrdDiff(false);// list tabsalle while
												// orddiff==false cad mem ordre
		for (int i = 0; i < tsList.size(); i++) {

			motifsList.add(tsList.get(i).getNomTab());
		}

		toutSalles = sl.rechercheTouSalleAvecJoin("cfclient");
		sallesAvecJointure.clear();
		for (int i = 0; i < toutSalles.size(); i++) {
			for (int j = 0; j < motifsList.size(); j++) {

				if (toutSalles.get(i).getMotif().equals(motifsList.get(j))) {
					sallesAvecJointure.add(toutSalles.get(i));
					break;

				}
			}
		}

		sizeTous = sallesAvecJointure.size();
		return sallesAvecJointure;
	}

	public void setSallesAvecJointure(List<Salle> sallesAvecJointure) {
		this.sallesAvecJointure = sallesAvecJointure;
	}

	private int sizeBilan;

	public int getSizeBilan() {
		SalleService ser = new SalleService();
		sallesAvecJointureBilan = ser.rechercheSalleAvecMotif("Bilan");
		sizeBilan = sallesAvecJointureBilan.size();
		return sizeBilan;
	}

	public void setSizeBilan(int sizeBilan) {
		this.sizeBilan = sizeBilan;
	}

	public List<Salle> getSallesAvecJointureBilan() {
		SalleService ser = new SalleService();
		sallesAvecJointureBilan = ser.rechercheSalleAvecMotif("Bilan");
		sizeBilan = sallesAvecJointureBilan.size();
		return sallesAvecJointureBilan;
	}

	public void setSallesAvecJointureBilan(List<Salle> sallesAvecJointureBilan) {
		this.sallesAvecJointureBilan = sallesAvecJointureBilan;
	}

	public List<Salle> getSallesAvecJointureControl() {

		SalleService ser = new SalleService();
		sallesAvecJointureControl = ser.rechercheSalleAvecMotif("Control");
		sizeControl = sallesAvecJointureControl.size();
		return sallesAvecJointureControl;
	}

	public void setSallesAvecJointureControl(
			List<Salle> sallesAvecJointureControl) {
		this.sallesAvecJointureControl = sallesAvecJointureControl;
	}

	public List<Salle> getSallesAvecJointureConsultation() {
		SalleService ser = new SalleService();
		sallesAvecJointureConsultation = ser
				.rechercheSalleAvecMotif("Consultation");
		sizeConsultation = sallesAvecJointureConsultation.size();
		return sallesAvecJointureConsultation;
	}

	public void setSallesAvecJointureConsultation(
			List<Salle> sallesAvecJointureConsultation) {
		this.sallesAvecJointureConsultation = sallesAvecJointureConsultation;
	}

	@SuppressWarnings("deprecation")
	public void recupererDon(Integer codeC) {
		codePatient = codeC;
		CfclientService se = new CfclientService();
		cfclient = se.RechercheCfclient(codeC);

		Calendar c = Calendar.getInstance();
		Date v = c.getTime();
		int h = v.getHours();
		int min = v.getMinutes();
		heure = avoirHeure(h, min);
	}

	private String avoirHeure(int h, int min) {
		String heure = "";
		if (h < 9)
			heure += "0" + h;
		else
			heure += h;

		if (min < 9)
			heure += ":0" + min;
		else
			heure += ":" + min;

		return heure;
	}

	public String up(Salle s) {
		
		SalleService ser = new SalleService();
		
		List<TabSalle> tsList= new ArrayList<TabSalle>();
		List<String> motifsList= new ArrayList<String>();
		TabSalleService serts= new TabSalleService();
		
		tsList=serts.rechercheParOrdDiff(true);//list tabsalle avec ord diff
		for(int i=0; i<tsList.size();i++){
			
			motifsList.add(tsList.get(i).getNomTab());
		}
		
		
		Salle av = ser.rechercheParOrdre(s.getOrdre() - 1,motifsList);
		if (s.getOrdre() > 1) {
			s.setOrdre(s.getOrdre() - 1);
			av.setOrdre(av.getOrdre() + 1);
			ser.modifierSalle(av);
			ser.modifierSalle(s);
		}
		return null;
	}

	public String down(Salle s) {
		SalleService ser = new SalleService();
		List<TabSalle> tsList= new ArrayList<TabSalle>();
		List<String> motifsList= new ArrayList<String>();
		TabSalleService serts= new TabSalleService();
		
		tsList=serts.rechercheParOrdDiff(true);//list tabsalle avec ord diff
		for(int i=0; i<tsList.size();i++){
			
			motifsList.add(tsList.get(i).getNomTab());
		}
		
		if (s.getOrdre() < getSizeTous()) {
			Salle ap = ser.rechercheParOrdre(s.getOrdre() + 1,motifsList);
			s.setOrdre(s.getOrdre() + 1);
			ap.setOrdre(ap.getOrdre() - 1);
			ser.modifierSalle(ap);
			ser.modifierSalle(s);
		}
		return null;
	}

	public void getParameterTel(Salle s) {
		code = s.getCode();
		motif = s.getMotif();
		notes = s.getNotes();
		nouveauOrdre = s.getOrdre();
		ordre = s.getOrdre();
		cfclient = s.getCfclient();
		heure = s.getHeure();
		cause = null;

	}

	public void getParameter(Salle s, TabSalle ts) {
		code = s.getCode();
		motif = s.getMotif();
		notes = s.getNotes();
		nouveauOrdre = s.getOrdre();
		ordre = s.getOrdre();
		cfclient = s.getCfclient();
		heure = s.getHeure();
		cause = null;
		ordreDifferent = ts.isOrdreDifferent();

	
	}
	public void getParameter(Salle s) {
		code = s.getCode();
		motif = s.getMotif();
		notes = s.getNotes();
		nouveauOrdre = s.getOrdre();
		ordre = s.getOrdre();
		cfclient = s.getCfclient();
		heure = s.getHeure();
		cause = null;
		//ordreDifferent = t/s.isOrdreDifferent();

	
	}

	public void getParameter(Salle s,Boolean permut) {
		if(permut){
		code = s.getCode();
		motif = s.getMotif();
		notes = s.getNotes();
		nouveauOrdre = s.getOrdre();
		ordre = s.getOrdre();
		cfclient = s.getCfclient();
		heure = s.getHeure();
		cause = null;
		RequestContext context = RequestContext.getCurrentInstance();
		context.execute("PF('modord').show();");
		}else{
			
			
		}

	}

	public void devenirPremier(Salle salle) {

		if (salle.getOrdre() > 1)
			for (int i = salle.getOrdre(); i > 1; i--)
				up(salle);
	}

	public void devenirDernier(Salle salle) {
		if (salle.getOrdre() < sizeTous)
			for (int i = salle.getOrdre(); i < sizeTous; i++)
				down(salle);
	}

	public void changerOrdre() {
		SalleService ser = new SalleService();
		List<TabSalle> tsList= new ArrayList<TabSalle>();
		List<String> motifsList= new ArrayList<String>();
		TabSalleService serts= new TabSalleService();
		
		tsList=serts.rechercheParOrdDiff(true);//list tabsalle avec ord diff
		for(int i=0; i<tsList.size();i++){
			
			motifsList.add(tsList.get(i).getNomTab());
		}
		
		Salle s = ser.rechercheParOrdre(ordre,motifsList);
		if (ordre != nouveauOrdre) {

			Salle s2 = ser.rechercheParOrdre(nouveauOrdre,motifsList);

			s.setOrdre(nouveauOrdre);
			ser.modifierSalle(s);

			s2.setOrdre(ordre);
			ser.modifierSalle(s2);

		}

	}

	public void supprimerTel() {
		SalleService ser = new SalleService();
		Salle sas = new SalleService().rechercheParId(code);
		if (sas != null) {

			int ord = sas.getOrdre();
			ser.supprimerSalle(sas);

			for (int i = 0; i < sallesAvecJointureTel.size(); i++) {
				if (sallesAvecJointureTel.get(i).getOrdre() > ord) {
					sallesAvecJointureTel.get(i).setOrdre(
							sallesAvecJointureTel.get(i).getOrdre() - 1);
					ser.modifierSalle(sallesAvecJointureTel.get(i));
				}
			}

		}

	}

	public void supprimer() {
		SalleService ser = new SalleService();
		Salle sas = new SalleService().rechercheParId(code);
		if (sas != null) {
		//	String motif = sas.getMotif();
			int ord = sas.getOrdre();
			ser.supprimerSalle(sas);
			if (!ordreDifferent)// cad mm ordre
				for (int i = 0; i < sallesAvecJointure.size(); i++) {
					if (sallesAvecJointure.get(i).getOrdre() > ord) {
						sallesAvecJointure.get(i).setOrdre(
								sallesAvecJointure.get(i).getOrdre() - 1);
						ser.modifierSalle(sallesAvecJointure.get(i));
					}
				}

			else
				// ordre diff
				for (int i = 0; i < sallesAvecJointureMotif.size(); i++) {
					if (sallesAvecJointureMotif.get(i).getOrdre() > ord) {
						sallesAvecJointureMotif.get(i).setOrdre(
								sallesAvecJointureMotif.get(i).getOrdre() - 1);
						ser.modifierSalle(sallesAvecJointureMotif.get(i));
					}
				}
		}

	}

	public void lePatient(Integer code) {

		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		session.setAttribute("idu", code);
		session.setAttribute("retouraction", "Salle");

		CfclientService s = new CfclientService();
		if(code!=null)
		{
		Cfclient c = s.RechercheCfclient(code);
		if(c!=null)
		{Module.patientEnConsultation = c.getPrenom() + " " + c.getNom();
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("FichePatiente");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		}
		}

	}

	public void lePatientVersConsult(Salle s) {

		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		session.setAttribute("idu", s.getCfclient().getCode());

		// Module.idpatient = s.getCfclient().getCode();
		Integer codep = s.getCfclient().getCode();
		CfclientService ser = new CfclientService();
		Cfclient c = ser.RechercheCfclient(codep);
		Module.patientEnConsultation = c.getPrenom() + " " + c.getNom();

		SalleService se = new SalleService();

		for (int i = 0; i < sallesAvecJointure.size(); i++) {
			if (sallesAvecJointure.get(i).getOrdre() > s.getOrdre()) {
				sallesAvecJointure.get(i).setOrdre(
						sallesAvecJointure.get(i).getOrdre() - 1);
				se.modifierSalle(sallesAvecJointure.get(i));
			}
		}
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("FichePatiente");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		se.supprimerSalle(s);

	}

	public String getReponse() {
		return reponse;
	}

	public void setReponse(String reponse) {
		this.reponse = reponse;
	}

	public void modifReponse(Salle salle) {
		code = salle.getCode();
		reponse = salle.getReponse();
		salle.getReponse();
	}

	public void modificationSalle() {
		SalleService ser = new SalleService();
		Salle s = ser.rechercheParId(code);
		s.setReponse(reponse);
		ser.modifierSalle(s);
	}

	public void goToListePatient() {
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("Patients");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void Retour() {

		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		page = (String) session.getAttribute("redirectSalle");

		if (page != null) {
			try {
				FacesContext.getCurrentInstance().getExternalContext()
						.redirect(page);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public void modifSalle(Salle s) {
		cfclient = s.getCfclient();
		heure = s.getHeure();
		motif = s.getMotif();
		code = s.getCode();
		notes = s.getNotes();
	}

	public void annuleModif() {
		cfclient = null;
		heure = null;
		motif = null;
		code = null;
		notes = null;
	}

	public void modifierLigneSalle() {
		SalleService ser = new SalleService();
		Salle s = ser.rechercheParId(code);
		s.setMotif(motif);
		s.setNotes(notes);
		ser.modifierSalle(s);
		FacesContext faces = FacesContext.getCurrentInstance();
		faces.addMessage(null, new FacesMessage(
				"Salle d'attente modifiée avec succès", ""));
	}

	public void annulerLigneSalle() {
		SalleService ser = new SalleService();
		Salle s = ser.rechercheParId(code);
		AnnuleSalle salle = new AnnuleSalle();
		salle.setCause(cause);
		salle.setHeure(s.getHeure());
		salle.setMotif(s.getMotif());
		salle.setNotes(s.getNotes());
		salle.setPatient(cfclient.getPrenom() + " " + cfclient.getNom());
		salle.setVillage(cfclient.getVillage());
		salle.setCfclient(cfclient);
		new AnnuleSalleService().ajouterAnnuleSalle(salle);
		ordre = s.getOrdre();
		motif = s.getMotif();
		ser.supprimerSalle(s);

		// mettre à jour l'order
		
		
		if (!ordreDifferent)// cad mm ordre
			for (int i = 0; i < sallesAvecJointure.size(); i++) {
				if (sallesAvecJointure.get(i).getOrdre() > ordre) {
					sallesAvecJointure.get(i).setOrdre(
							sallesAvecJointure.get(i).getOrdre() - 1);
					ser.modifierSalle(sallesAvecJointure.get(i));
				}
			}

		else
			sallesAvecJointureMotif=getSallesAvecJointureMotif();
			// ordre diff
			for (int i = 0; i < sallesAvecJointureMotif.size(); i++) {
				

				if (sallesAvecJointureMotif.get(i).getOrdre() > ordre) {
					sallesAvecJointureMotif.get(i).setOrdre(
							sallesAvecJointureMotif.get(i).getOrdre() - 1);
					ser.modifierSalle(sallesAvecJointureMotif.get(i));
				}
			}

		FacesContext faces = FacesContext.getCurrentInstance();
		faces.addMessage(null, new FacesMessage(
				"Une patiente est éliminée de la salle d'attente", ""));
		RequestContext.getCurrentInstance().update("f1");

	}

	public void annuleAnnulation() {
		cfclient = null;
		heure = null;
		motif = null;
		code = null;
		notes = null;
		cause = null;
	}

	private Integer idS;

	public Integer getIdS() {
		return idS;
	}

	public void setIdS(Integer idS) {
		this.idS = idS;
	}

	public void supprimeAnn(Integer idannuleSalle) {
		idS = idannuleSalle;
	}

	public void supprimeAnnul() {
		if (idS != null) {
			AnnuleSalle s = new AnnuleSalle();
			s.setIdannuleSalle(idS);

			new AnnuleSalleService().supprimerAnnuleSalle(s);

			FacesContext faces = FacesContext.getCurrentInstance();
			faces.addMessage(null, new FacesMessage(
					"Patiente supprimée avec succès", ""));
		}
		FacesContext context2 = FacesContext.getCurrentInstance();
		context2.getExternalContext().getFlash().setKeepMessages(true);

		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("Salle");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public int taille(String motif) {

		List<Salle> s = new SalleService().rechercheSalleAvecMotif(motif);
		if (s != null)
			return s.size();
		return 0;
	}

	public List<Salle> sallesAvecJointure(String motif) {
		List<Salle> s = new SalleService().rechercheSalleAvecMotif(motif);
		return s;
	}
	
	public void redirectVersSalle(){
		
		
		try {

			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("Salle");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}

package com.doctor.bean;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import com.doctor.persistance.Cfclient;
import com.doctor.persistance.Sterile;
import com.doctor.service.CfclientService;
import com.doctor.service.SterileService;

@ManagedBean(name = "sterileBean")
public class SterileBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idSterile;
	private String sterilite;
	private Date depuis;
	private String cohabitation;
	private String habitude;
	private int rapport;
	private String antecedentH;
	private String hormoneH;
	private String spermH;
	private String bilanH;
	private String traitementH;
	private String antecedent;
	private String examensH;
	private String examens;
	private String hormone;
	private String echoPelvienne;
	private String hsg;
	private String hysteroscopie;
	private String coelioscopie;
	private String traitement;
	private String coital;
	private Integer idPatient;
	private Cfclient cfclient;
	private int ageF;
	private int ageH;
	private Date mariage;
	private String dysmenor;
	private String cycle;
	private String cycleList;
	private String regles;
	private String reglesList;
	private String dysmenorhe;
	private boolean blocage;
	private String consultationmotif;
	private boolean spanio;
private boolean addValid=false;
	public boolean isSpanio() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");

		cfclient = new CfclientService().RechercheCfclient(idPatient);
		if (cfclient != null)
			spanio = cfclient.isSpanio();

		return spanio;
	}

	public void setSpanio(boolean spanio) {
		this.spanio = spanio;
	}

	public void spanioChange() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");
		CfclientService se = new CfclientService();
		cfclient = se.RechercheCfclient(idPatient);
		if (cfclient != null) {
			cfclient.setSpanio(spanio);
			se.modifierPatient(cfclient);
		}

	}

	public boolean isBlocage() {

		return blocage;
	}

	public void setBlocage(boolean blocage) {
		this.blocage = blocage;
	}

	public String getDysmenorhe() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");// idPatient =
															// Module.idpatient;
		CfclientService se = new CfclientService();
		cfclient = se.RechercheCfclient(idPatient);
		dysmenorhe = cfclient.getDysmenorhe();

		return dysmenorhe;
	}

	public void setDysmenorhe(String dysmenorhe) {
		this.dysmenorhe = dysmenorhe;
	}

	public String getReglesList() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");// idPatient =
															// Module.idpatient;
		CfclientService se = new CfclientService();
		cfclient = se.RechercheCfclient(idPatient);
		reglesList = cfclient.getRegleType();
		return reglesList;
	}

	public void setReglesList(String reglesList) {
		this.reglesList = reglesList;
	}

	public String getRegles() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");// idPatient =
															// Module.idpatient;
		CfclientService se = new CfclientService();
		cfclient = se.RechercheCfclient(idPatient);
		regles = cfclient.getRegles();

		return regles;
	}

	public void setRegles(String regles) {
		this.regles = regles;
	}

	public String getCycle() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");// idPatient =
															// Module.idpatient;

		CfclientService se = new CfclientService();
		cfclient = se.RechercheCfclient(idPatient);
		cycle = cfclient.getCycle();
		return cycle;
	}

	public void setCycle(String cycle) {
		this.cycle = cycle;
	}

	public String getCycleList() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");// idPatient =
															// Module.idpatient;

		CfclientService se = new CfclientService();
		cfclient = se.RechercheCfclient(idPatient);
		cycleList = cfclient.getCycleType();
		return cycleList;
	}

	public void setCycleList(String cycleList) {
		this.cycleList = cycleList;
	}

	public Date getMariage() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");// idPatient =
															// Module.idpatient;
		CfclientService se = new CfclientService();
		cfclient = se.RechercheCfclient(idPatient);
		mariage = cfclient.getMariage();
		return mariage;
	}

	public void setMariage(Date mariage) {
		this.mariage = mariage;
	}

	public String getDysmenor() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");// idPatient =
															// Module.idpatient;
		CfclientService se = new CfclientService();
		cfclient = se.RechercheCfclient(idPatient);
		dysmenor = cfclient.getDysmenorhe();
		return dysmenor;
	}

	public void setDysmenor(String dysmenor) {
		this.dysmenor = dysmenor;
	}

	private String ageFem;

	public String getAgeFem() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");
		CfclientService se = new CfclientService();
		cfclient = se.RechercheCfclient(idPatient);
		if (cfclient.getDateNaiss() != null) {

			ageFem = calculAgeS(cfclient.getDateNaiss());
			// calculAge(cfclient.getDateNaiss());
		} else
			ageFem = "0";

		return ageFem;
	}

	public void setAgeFem(String ageFem) {
		this.ageFem = ageFem;
	}

	public int getAgeF() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");// idPatient =
															// Module.idpatient;
		CfclientService se = new CfclientService();
		cfclient = se.RechercheCfclient(idPatient);
		if (cfclient.getDateNaiss() != null) {

			ageFem = calculAgeS(cfclient.getDateNaiss());
			// calculAge(cfclient.getDateNaiss());
		} else
			ageFem = "0";

		return ageF;
	}

	public void setAgeF(int ageF) {
		this.ageF = ageF;
	}

	private String ageHom;

	public String getAgeHom() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");// idPatient =
															// Module.idpatient;
		CfclientService se = new CfclientService();
		cfclient = se.RechercheCfclient(idPatient);
		if (cfclient.getDateNaissC() != null) {
			ageHom = calculAgeS(cfclient.getDateNaissC());
		} else
			ageHom = "0";

		return ageHom;
	}

	public void setAgeHom(String ageHom) {
		this.ageHom = ageHom;
	}

	public int getAgeH() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");// idPatient =
															// Module.idpatient;
		CfclientService se = new CfclientService();
		cfclient = se.RechercheCfclient(idPatient);
		if (cfclient.getDateNaissC() != null) {
			ageH = calculAge(cfclient.getDateNaissC());
		} else
			ageH = 0;

		return ageH;
	}

	public void setAgeH(int ageH) {
		this.ageH = ageH;
	}

	public Cfclient getCfclient() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");// idPatient =
															// Module.idpatient;
		CfclientService se = new CfclientService();
		cfclient = se.RechercheCfclient(idPatient);
		return cfclient;
	}

	public void setCfclient(Cfclient cfclient) {
		this.cfclient = cfclient;
	}

	public Integer getIdPatient() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");// idPatient =
															// Module.idpatient;
		return idPatient;
	}

	public void setIdPatient(Integer idPatient) {
		this.idPatient = idPatient;
	}

	public Integer getIdSterile() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");// idPatient =
															// Module.idpatient;
		SterileService ser = new SterileService();
		Sterile s = ser.rechercheSterilePatient(idPatient);

		if (s != null) {
			idSterile = s.getIdSterile();
		}
		return idSterile;
	}

	public void setIdSterile(Integer idSterile) {
		this.idSterile = idSterile;
	}

	public String getSterilite() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");// idPatient =
															// Module.idpatient;
		SterileService ser = new SterileService();
		Sterile s = ser.rechercheSterilePatient(idPatient);

		if (s != null) {

			sterilite = s.getSterilite();

		}
		return sterilite;
	}

	public void setSterilite(String sterilite) {
		this.sterilite = sterilite;
	}

	public Date getDepuis() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");// idPatient =
															// Module.idpatient;
		SterileService ser = new SterileService();
		Sterile s = ser.rechercheSterilePatient(idPatient);

		if (s != null) {
			depuis = s.getDepuis();
		}
		return depuis;
	}

	public void setDepuis(Date depuis) {
		this.depuis = depuis;
	}

	public String getCohabitation() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");// idPatient =
															// Module.idpatient;
		SterileService ser = new SterileService();
		Sterile s = ser.rechercheSterilePatient(idPatient);

		if (s != null) {

			cohabitation = s.getCohabitation();

		}
		return cohabitation;
	}

	public void setCohabitation(String cohabitation) {
		this.cohabitation = cohabitation;
	}

	public String getHabitude() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");// idPatient =
															// Module.idpatient;
		SterileService ser = new SterileService();
		Sterile s = ser.rechercheSterilePatient(idPatient);

		if (s != null) {

			habitude = s.getHabitude();
		}
		return habitude;
	}

	public void setHabitude(String habitude) {
		this.habitude = habitude;
	}

	public int getRapport() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");// idPatient =
															// Module.idpatient;
		SterileService ser = new SterileService();
		Sterile s = ser.rechercheSterilePatient(idPatient);

		if (s != null) {
			rapport = s.getRapport();
		}
		return rapport;
	}

	public void setRapport(int rapport) {
		this.rapport = rapport;
	}

	public String getAntecedentH() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");// idPatient =
															// Module.idpatient;
		SterileService ser = new SterileService();
		Sterile s = ser.rechercheSterilePatient(idPatient);

		if (s != null) {

			antecedentH = s.getAntecedentH();
		}
		return antecedentH;
	}

	public void setAntecedentH(String antecedentH) {
		this.antecedentH = antecedentH;
	}

	public String getHormoneH() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");// idPatient =
															// Module.idpatient;
		SterileService ser = new SterileService();
		Sterile s = ser.rechercheSterilePatient(idPatient);

		if (s != null) {

			hormoneH = s.getHormoneH();
		}
		return hormoneH;
	}

	public void setHormoneH(String hormoneH) {
		this.hormoneH = hormoneH;
	}

	public String getSpermH() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");// idPatient =
															// Module.idpatient;
		SterileService ser = new SterileService();
		Sterile s = ser.rechercheSterilePatient(idPatient);

		if (s != null) {

			spermH = s.getSpermH();

		}
		return spermH;
	}

	public void setSpermH(String spermH) {
		this.spermH = spermH;
	}

	public String getBilanH() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");// idPatient =
															// Module.idpatient;
		SterileService ser = new SterileService();
		Sterile s = ser.rechercheSterilePatient(idPatient);

		if (s != null) {

			bilanH = s.getBilanH();

		}
		return bilanH;
	}

	public void setBilanH(String bilanH) {
		this.bilanH = bilanH;
	}

	public String getTraitementH() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");// idPatient =
															// Module.idpatient;
		SterileService ser = new SterileService();
		Sterile s = ser.rechercheSterilePatient(idPatient);

		if (s != null) {

			traitementH = s.getTraitementH();

		}
		return traitementH;
	}

	public void setTraitementH(String traitementH) {
		this.traitementH = traitementH;
	}

	public String getAntecedent() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");// idPatient =
															// Module.idpatient;
		SterileService ser = new SterileService();
		Sterile s = ser.rechercheSterilePatient(idPatient);

		if (s != null) {

			antecedent = s.getAntecedent();

		}
		return antecedent;
	}

	public void setAntecedent(String antecedent) {
		this.antecedent = antecedent;
	}

	public String getExamensH() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");// idPatient =
															// Module.idpatient;
		SterileService ser = new SterileService();
		Sterile s = ser.rechercheSterilePatient(idPatient);

		if (s != null) {

			examensH = s.getExamensH();

		}
		return examensH;
	}

	public void setExamensH(String examensH) {
		this.examensH = examensH;
	}

	public String getExamens() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");// idPatient =
															// Module.idpatient;
		SterileService ser = new SterileService();
		Sterile s = ser.rechercheSterilePatient(idPatient);

		if (s != null) {

			examens = s.getExamens();

		}
		return examens;
	}

	public void setExamens(String examens) {
		this.examens = examens;
	}

	public String getHormone() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");// idPatient =
															// Module.idpatient;
		SterileService ser = new SterileService();
		Sterile s = ser.rechercheSterilePatient(idPatient);

		if (s != null) {

			hormone = s.getHormone();

		}
		return hormone;
	}

	public void setHormone(String hormone) {
		this.hormone = hormone;
	}

	public String getEchoPelvienne() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");// idPatient =
															// Module.idpatient;
		SterileService ser = new SterileService();
		Sterile s = ser.rechercheSterilePatient(idPatient);

		if (s != null) {

			echoPelvienne = s.getEchoPelvienne();

		}
		return echoPelvienne;
	}

	public void setEchoPelvienne(String echoPelvienne) {
		this.echoPelvienne = echoPelvienne;
	}

	public String getHsg() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");// idPatient =
															// Module.idpatient;
		SterileService ser = new SterileService();
		Sterile s = ser.rechercheSterilePatient(idPatient);

		if (s != null) {

			hsg = s.getHsg();

		}
		return hsg;
	}

	public void setHsg(String hsg) {
		this.hsg = hsg;
	}

	public String getHysteroscopie() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");
		SterileService ser = new SterileService();
		Sterile s = ser.rechercheSterilePatient(idPatient);

		if (s != null) {

			hysteroscopie = s.getHysteroscopie();

		}
		return hysteroscopie;
	}

	public void setHysteroscopie(String hysteroscopie) {
		this.hysteroscopie = hysteroscopie;
	}

	public String getCoelioscopie() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");// idPatient =
															// Module.idpatient;
		SterileService ser = new SterileService();
		Sterile s = ser.rechercheSterilePatient(idPatient);

		if (s != null) {

			coelioscopie = s.getCoelioscopie();

		}
		return coelioscopie;
	}

	public void setCoelioscopie(String coelioscopie) {
		this.coelioscopie = coelioscopie;
	}

	public String getTraitement() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");// idPatient =
															// Module.idpatient;
		SterileService ser = new SterileService();
		Sterile s = ser.rechercheSterilePatient(idPatient);

		if (s != null) {

			traitement = s.getTraitement();
		}
		return traitement;
	}

	public void setTraitement(String traitement) {
		this.traitement = traitement;
	}

	public String getCoital() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");// idPatient =
															// Module.idpatient;
		SterileService ser = new SterileService();
		Sterile s = ser.rechercheSterilePatient(idPatient);

		if (s != null) {

			coital = s.getCoital();

		}
		return coital;
	}

	public void setCoital(String coital) {
		this.coital = coital;
	}

	@PostConstruct
	public void init() {

		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");// idPatient =
															// Module.idpatient;
		SterileService ser = new SterileService();
		Sterile s = ser.rechercheSterilePatient(idPatient);

		CfclientService se = new CfclientService();
		cfclient = se.RechercheCfclient(idPatient);

		if (s != null) {
			idSterile = s.getIdSterile();
		}

	}

	public void initialiser() {
		mariage = null;
		habitude = null;
		cohabitation = null;
		sterilite = null;
		depuis = null;

		antecedent = null;
		antecedentH = null;

		examens = null;
		examensH = null;

		hormone = null;
		hormoneH = null;

		echoPelvienne = null;
		spermH = null;

		hsg = null;
		bilanH = null;

		hysteroscopie = null;
		traitementH = null;

		coelioscopie = null;
		coital = null;
		traitement = null;
	}

	private String dateMariage;
	private String dateDepuis;

	public String getDateDepuis() {

		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");
		SterileService ser = new SterileService();
		Sterile s = ser.rechercheSterilePatient(idPatient);

		if (s != null) {
			depuis = s.getDepuis();
			if (depuis != null) {
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				try {
					dateDepuis = sdf.format(depuis);
				} catch (Exception e) {
					dateDepuis = null;
				}
				ancienvaleurDateDepuis = dateDepuis;
			}
		}
		return dateDepuis;
	}

	public void setDateDepuis(String dateDepuis) {
		this.dateDepuis = dateDepuis;
	}

	public String getDateMariage() {

		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");
		CfclientService se = new CfclientService();
		cfclient = se.RechercheCfclient(idPatient);
		if((cfclient.getMariage()!=null))
		mariage = cfclient.getMariage();
		if(mariage!=null)
			{if((mariage.equals("")==false)&&(mariage.equals("__/__/____")==false))
		{SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			dateMariage = sdf.format(mariage);
		} catch (Exception e) {
			dateMariage = null;
		}}}
		//ancienvaleurDateMar = dateMariage;
		
		return dateMariage;
	}

	public void setDateMariage(String dateMariage) {
		this.dateMariage = dateMariage;
	}

	private String ancienvaleurDateMar;

	public String getAncienvaleurDateMar() {
		return ancienvaleurDateMar;
	}

	public void setAncienvaleurDateMar(String ancienvaleurDateMar) {
		this.ancienvaleurDateMar = ancienvaleurDateMar;
	}

	public void dateMariageChange() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");

		CfclientService se = new CfclientService();
		cfclient = se.RechercheCfclient(idPatient);

		FacesContext face = FacesContext.getCurrentInstance();
		

		dateMariage = Module.corigerDate(dateMariage);
			
			String verifDate = Module.verifierDate(dateMariage);
			if ((verifDate.equals(""))==false) {
				addValid=false;
				this.blocage = true;
				face.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_ERROR,
						"","Le date du mariage "+ verifDate));

			}

			else if (face.getMessageList().size() == 0)
			{
				addValid =true;

			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			try {

				if ((dateMariage != null)&&(dateMariage.equals("")==false))
				{
					if(dateMariage.equals("__/__/____")==false)
					{
					mariage = sdf.parse(dateMariage);}}
			} catch (ParseException e) {
				e.printStackTrace();
			}
			cfclient.setMariage(mariage);

			se.modifierPatient(cfclient);
			}
	
		

	}

	public void cycleChange() {

		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");// idPatient =
															// Module.idpatient;
		CfclientService se = new CfclientService();
		cfclient = se.RechercheCfclient(idPatient);

		cfclient.setCycle(cycle);

		se.modifierPatient(cfclient);

	}

	public void cycleListChange() {

		// s.setCycleList(cycleList);
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");// idPatient =
															// Module.idpatient;
		CfclientService se = new CfclientService();
		cfclient = se.RechercheCfclient(idPatient);

		cfclient.setCycleType(cycleList);

		se.modifierPatient(cfclient);
	}

	public void reglesChange() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");// idPatient =
															// Module.idpatient;
		CfclientService se = new CfclientService();
		cfclient = se.RechercheCfclient(idPatient);

		cfclient.setRegles(regles);

		se.modifierPatient(cfclient);
	}

	public void regleListChange() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");// idPatient =
															// Module.idpatient;
		CfclientService se = new CfclientService();
		cfclient = se.RechercheCfclient(idPatient);

		cfclient.setRegleType(reglesList);

		se.modifierPatient(cfclient);
	}

	public void dysmenoChange() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");// idPatient =
															// Module.idpatient;
		CfclientService se = new CfclientService();
		cfclient = se.RechercheCfclient(idPatient);

		cfclient.setDysmenorhe(dysmenorhe);

		se.modifierPatient(cfclient);

	}

	public void anteChange() {
		SterileService ser = new SterileService();
		Sterile s;
		if (idSterile != null) {
			s = ser.rechercheParId(idSterile);
			s.setAntecedent(antecedent);
			ser.modifierSterile(s);
		} else {
			s = new Sterile();
			s.setAntecedent(antecedent);
			s.setCfclient(cfclient);
			ser.ajouterSterile(s);

		
		}

	}

	public void examChange() {
		SterileService ser = new SterileService();
		Sterile s;
		if (idSterile != null) {
			s = ser.rechercheParId(idSterile);
			s.setExamens(examens);
			ser.modifierSterile(s);
		} else {
			s = new Sterile();
			s.setExamens(examens);
			HttpSession session = (HttpSession) FacesContext
					.getCurrentInstance().getExternalContext()
					.getSession(false);
			idPatient = (Integer) session.getAttribute("idu");// idPatient =
																// Module.idpatient;
			CfclientService se = new CfclientService();
			cfclient = se.RechercheCfclient(idPatient);

			s.setCfclient(cfclient);
			ser.ajouterSterile(s);
		}
	}

	public void hormoneChange() {
		SterileService ser = new SterileService();
		Sterile s;
		if (idSterile != null) {
			s = ser.rechercheParId(idSterile);
			s.setHormone(hormone);
			ser.modifierSterile(s);
		} else {
			s = new Sterile();
			s.setHormone(hormone);
			HttpSession session = (HttpSession) FacesContext
					.getCurrentInstance().getExternalContext()
					.getSession(false);
			idPatient = (Integer) session.getAttribute("idu");// idPatient =
																// Module.idpatient;
			CfclientService se = new CfclientService();
			cfclient = se.RechercheCfclient(idPatient);

			s.setCfclient(cfclient);
			ser.ajouterSterile(s);
		}
	}

	public void echoChange() {
		SterileService ser = new SterileService();
		Sterile s;
		if (idSterile != null) {
			s = ser.rechercheParId(idSterile);
			s.setEchoPelvienne(echoPelvienne);
			ser.modifierSterile(s);
		} else {
			s = new Sterile();
			s.setEchoPelvienne(echoPelvienne);
			s.setCfclient(cfclient);
			ser.ajouterSterile(s);
		}
	}

	public void hsgChange() {
		SterileService ser = new SterileService();
		Sterile s;
		if (idSterile != null) {
			s = ser.rechercheParId(idSterile);
			s.setHsg(hsg);
			ser.modifierSterile(s);
		} else {
			s = new Sterile();
			s.setHsg(hsg);
			s.setCfclient(cfclient);
			ser.ajouterSterile(s);
		}
	}

	public void hysteroChange() {
		SterileService ser = new SterileService();
		Sterile s;
		if (idSterile != null) {
			s = ser.rechercheParId(idSterile);
			s.setHysteroscopie(hysteroscopie);
			ser.modifierSterile(s);
		} else {
			s = new Sterile();
			s.setHysteroscopie(hysteroscopie);
			s.setCfclient(cfclient);
			ser.ajouterSterile(s);
		}
	}

	public void coelioChange() {
		SterileService ser = new SterileService();
		Sterile s;
		if (idSterile != null) {
			s = ser.rechercheParId(idSterile);
			s.setCoelioscopie(coelioscopie);
			ser.modifierSterile(s);
		} else {
			s = new Sterile();
			s.setCoelioscopie(coelioscopie);
			s.setCfclient(cfclient);
			ser.ajouterSterile(s);
		}
	}

	public void testChange() {
		SterileService ser = new SterileService();
		Sterile s;
		if (idSterile != null) {
			s = ser.rechercheParId(idSterile);
			s.setCoital(coital);
			ser.modifierSterile(s);
		} else {
			s = new Sterile();
			s.setCoital(coital);
			s.setCfclient(cfclient);
			ser.ajouterSterile(s);
		}
	}

	public void traitChange() {
		SterileService ser = new SterileService();
		Sterile s;
		if (idSterile != null) {
			s = ser.rechercheParId(idSterile);
			s.setTraitement(traitement);
			ser.modifierSterile(s);
		} else {
			s = new Sterile();
			s.setTraitement(traitement);
			s.setCfclient(cfclient);
			ser.ajouterSterile(s);
		}
	}

	public void rapChange() {
		SterileService ser = new SterileService();
		Sterile s;
		if (idSterile != null) {
			s = ser.rechercheParId(idSterile);
			s.setRapport(rapport);
			ser.modifierSterile(s);
		} else {
			s = new Sterile();
			s.setRapport(rapport);
			s.setCfclient(cfclient);
			ser.ajouterSterile(s);
		}
	}

	public void antHChange() {
		SterileService ser = new SterileService();
		Sterile s;
		if (idSterile != null) {
			s = ser.rechercheParId(idSterile);
			s.setAntecedentH(antecedentH);
			ser.modifierSterile(s);
		} else {
			s = new Sterile();
			s.setAntecedentH(antecedentH);
			s.setCfclient(cfclient);
			ser.ajouterSterile(s);
		}
	}

	public void examHChange() {
		SterileService ser = new SterileService();
		Sterile s;
		if (idSterile != null) {
			s = ser.rechercheParId(idSterile);
			s.setExamensH(examensH);
			ser.modifierSterile(s);
		} else {
			s = new Sterile();
			s.setExamensH(examensH);
			s.setCfclient(cfclient);
			ser.ajouterSterile(s);
		}
	}

	public void hormoneHChange() {
		SterileService ser = new SterileService();
		Sterile s;
		if (idSterile != null) {
			s = ser.rechercheParId(idSterile);
			s.setHormoneH(hormoneH);
			ser.modifierSterile(s);
		} else {
			s = new Sterile();
			s.setHormoneH(hormoneH);
			s.setCfclient(cfclient);
			ser.ajouterSterile(s);
		}
	}

	public void spermHChange() {
		SterileService ser = new SterileService();
		Sterile s;
		if (idSterile != null) {
			s = ser.rechercheParId(idSterile);
			s.setSpermH(spermH);
			ser.modifierSterile(s);
		} else {
			s = new Sterile();
			s.setSpermH(spermH);
			s.setCfclient(cfclient);
			ser.ajouterSterile(s);
		}
	}

	public void bilanChange() {
		SterileService ser = new SterileService();
		Sterile s;
		if (idSterile != null) {
			s = ser.rechercheParId(idSterile);
			s.setBilanH(bilanH);
			ser.modifierSterile(s);
		} else {
			s = new Sterile();
			s.setBilanH(bilanH);
			s.setCfclient(cfclient);
			ser.ajouterSterile(s);
		}
	}

	public void traitementHChange() {
		SterileService ser = new SterileService();
		Sterile s;
		if (idSterile != null) {
			s = ser.rechercheParId(idSterile);
			s.setTraitementH(traitementH);
			ser.modifierSterile(s);
		} else {
			s = new Sterile();
			s.setTraitementH(traitementH);
			HttpSession session = (HttpSession) FacesContext
					.getCurrentInstance().getExternalContext()
					.getSession(false);
			idPatient = (Integer) session.getAttribute("idu");
			CfclientService se = new CfclientService();
			cfclient = se.RechercheCfclient(idPatient);

			s.setCfclient(cfclient);
			ser.ajouterSterile(s);
		}
	}

	public void habitudeChange() {
		SterileService ser = new SterileService();
		Sterile s;
		if (idSterile != null) {
			s = ser.rechercheParId(idSterile);
			s.setHabitude(habitude);
			ser.modifierSterile(s);
		} else {
			s = new Sterile();
			s.setHabitude(habitude);
			s.setCfclient(cfclient);
			ser.ajouterSterile(s);
		}
	}

	private int calculAge(String dateNaiss) {

		int i = dateNaiss.lastIndexOf("/");
		int j = Integer.parseInt(dateNaiss.substring(i + 1));
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);

		return (year - j);
	}

	public void sterilChange() {
		SterileService ser = new SterileService();
		Sterile s;
		if (idSterile != null) {
			s = ser.rechercheParId(idSterile);
			s.setSterilite(sterilite);
			ser.modifierSterile(s);
		} else {
			s = new Sterile();
			s.setSterilite(sterilite);
			s.setCfclient(cfclient);
			ser.ajouterSterile(s);
		}
	}

	private String ancienvaleurDateDepuis;

	public String getAncienvaleurDateDepuis() {
		return ancienvaleurDateDepuis;
	}

	public void setAncienvaleurDateDepuis(String ancienvaleurDateDepuis) {
		this.ancienvaleurDateDepuis = ancienvaleurDateDepuis;
	}

	public void depuisChange() {
		//setDateDepuis(dateDepuis);
		SterileService ser = new SterileService();
		Sterile s;
		FacesContext face = FacesContext.getCurrentInstance();
			
			String verifDate = Module.verifierDate(dateDepuis);
			
			
			if ((verifDate.equals(""))==false) {
				this.blocage = true;
				face.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_ERROR,
						"", "Le date du dépuis "+ verifDate));
				addValid=false;

				
			} else if (face.getMessageList().size() == 0) {
				
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
					if (dateDepuis != null && dateDepuis.length() > 0 && dateDepuis.equals("__/__/____")==false)
						try {
							depuis = sdf.parse(dateDepuis);
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						
					
					addValid=true;
					if (idSterile != null) {
						s = ser.rechercheParId(idSterile);
						s.setDepuis(depuis);
						ser.modifierSterile(s);
					} else {
						s = new Sterile();
						s.setDepuis(depuis);
						s.setCfclient(cfclient);
						ser.ajouterSterile(s);
					}		
						}
			}
		

		

	}

	public void cohabitationChange() {
		SterileService ser = new SterileService();
		Sterile s;
		if (idSterile != null) {
			s = ser.rechercheParId(idSterile);
			s.setCohabitation(cohabitation);
			ser.modifierSterile(s);
		} else {
			s = new Sterile();
			s.setCohabitation(cohabitation);
			s.setCfclient(cfclient);
			ser.ajouterSterile(s);
		}
	}

	public void goToRetour() {
//		
//		if(addValid==false)
//		{
//			dateMariageChange();
//			depuisChange();
//			
//
//			RequestContext.getCurrentInstance().update(
//					":f1:growl");
//		}
//		else{
		FacesContext context = FacesContext.getCurrentInstance();
		try {

			context.getExternalContext().redirect("FichePatiente");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		}
	//}

	public void goToAcceuil() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {

			context.getExternalContext().redirect("Accueil");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public String getConsultationmotif() {
		return consultationmotif;
	}

	public void setConsultationmotif(String consultationmotif) {
		this.consultationmotif = consultationmotif;
	}

	public void goToStreril() {
		// Module.idpatient = idPatient;
		// this.consultationmotif = "Stérilité";
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("Infertilité");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public String calculAgeS(String date) {
		if (date != null) {
			return Module.age(date);

		} else {
			Date toDay = new Date();
			SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
			String DateDuJour = sf.format(toDay);

			return Module.age(DateDuJour);
		}
	}

	public boolean isAddValid() {
		return addValid;
	}

	public void setAddValid(boolean addValid) {
		this.addValid = addValid;
	}

}

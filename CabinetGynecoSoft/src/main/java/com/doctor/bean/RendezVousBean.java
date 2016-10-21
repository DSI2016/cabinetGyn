package com.doctor.bean;

import java.io.Serializable;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

import com.doctor.persistance.Cfclient;
import com.doctor.persistance.Horaire;
import com.doctor.persistance.Jour;
import com.doctor.persistance.JourFr;
import com.doctor.persistance.JourFrSp;
import com.doctor.persistance.Mois;
import com.doctor.persistance.RendezVous;
import com.doctor.persistance.Saison;
import com.doctor.persistance.Salle;
import com.doctor.persistance.TabSalle;
import com.doctor.service.CfclientService;
import com.doctor.service.JourFrService;
import com.doctor.service.JourFrSpService;
import com.doctor.service.RendezVousService;
import com.doctor.service.SaisonService;
import com.doctor.service.SalleService;
import com.doctor.service.TabSalleService;

@ManagedBean(name = "rendezVousBean")
@SessionScoped
public class RendezVousBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date dateSys = new Date();
	private Integer idrendezVous;
	private Cfclient codeclient = null;
	private Date date;
	private String note;
	private int heure;
	private int minute;
	private Integer codeclientCode;
	private ScheduleEvent selectedRendezVous = new RendezVous();
	private String script = "";
	private static String style = "{border: 1px solid #666666;background: #5C98BD;background:#aaaaff -moz-linear-gradient(top, rgba(0,0,0,0.25), rgba(0,0,0,0));color:#ffffff;text-shadow: 1px 1px 1px #333333;}\n";
	private int dureeRDV;
	private List<JourFr> jourFrs = new ArrayList<JourFr>();
	private List<JourFrSp> jourFrSps = new ArrayList<JourFrSp>();
	private boolean jourfr;
	private boolean notjourfr;
	private List<Mois> moiss = new ArrayList<Mois>();
	private List<String> jours = new ArrayList<String>();
	private List<Integer> annee = new ArrayList<Integer>();
	private int jj;
	private int mm;
	private Integer aaaa;
	private int JJ;
	private int MM;
	private Integer AAAA;
	private String view = "agendaWeek";
	private String disc = " ";
	private int widthDialog;
	private String Dialog;
	private int horaire = 0;
	private boolean disponible;
	private String motif;
	private String noteSalle;
	private int etat;
	private int NBR;
	// private String action1;
	private ScheduleModel rendezVouss = new DefaultScheduleModel();
	private List<RendezVous> rendezVoussParDate = new ArrayList<RendezVous>();
	private Date selectedDate = new Date();
	private boolean permenent;
	private String dateChoisi;
//^pjkjkghgfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfg
//	@PostConstruct
//	public void mettreAJourSaison() {
//		// récuperer la liste de saison;
//		List<Saison> l = new SaisonService().rechercheTousSaison();
//
//		// tester pour chaque saison si date fin < date aujourd'hui
//		for (int i = 0; i < l.size(); i++) {
//			if (l.get(i).getFin().before(new Date())) {
//				
//				Date df = l.get(i).getFin();//date debut desaison
//				
//				
//				Calendar calf = Calendar.getInstance();
//				calf.setTime(df);
//				calf.add(Calendar.YEAR, 1);
//				
//				
//				Date dd = l.get(i).getDebut();
//				
//				Calendar cald = Calendar.getInstance();
//				cald.setTime(df);
//				cald.add(Calendar.YEAR, 1);
//				
//				if (l.get(i).getNom().equals("Ramadhan")) {
//					// si c'est ramadhane on ajout 1 ans -12jours
//					
//					calf.add(Calendar.DATE, -12);
//					cald.add(Calendar.DATE, -12);
//				} 
//				
//				df=calf.getTime();
//				l.get(i).setFin(df);
//				
//				dd = cald.getTime();
//				l.get(i).setDebut(dd);
//				
//				//modifier la date de debu et fin du siason
//				
//				new SaisonService().modifierSaison(l.get(i));
//				
//			}
//
//		}
//
//	}

	public String getDateChoisi() {
		return dateChoisi;
	}

	public void setDateChoisi(String dateChoisi) {
		this.dateChoisi = dateChoisi;
	}

	public int getDureeRDV() {
		return dureeRDV;
	}

	public void setDureeRDV(int dureeRDV) {
		this.dureeRDV = dureeRDV;
	}

	public boolean isPermenent() {
		return permenent;
	}

	public void setPermenent(boolean permenent) {
		this.permenent = permenent;
	}

	public int getNBR() {
		return NBR;
	}

	public void setNBR(int nBR) {
		NBR = nBR;
	}

	public Date getDateSys() {
		dateSys = new Date();
		return dateSys;
	}

	public void setDateSys(Date dateSys) {
		this.dateSys = dateSys;
	}

	public int getEtat() {
		return etat;
	}

	public void setEtat(int etat) {
		this.etat = etat;
	}

	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}

	public String getNoteSalle() {
		return noteSalle;
	}

	public void setNoteSalle(String noteSalle) {
		this.noteSalle = noteSalle;
	}

	public String getClasse(Date date, RendezVous obj) {
		if (date != null && obj != null) {
			if (obj.getEtat() == 1)
				return "passer2";
			if (date.before(new Date()))
				return "retard2";
			else
				return "default2";
		} else
			return "default2";
	}

	public boolean isDisponible() {
		disponible = dispo(getHoraire(), selectedDate);
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	public int getHoraire() {
		SaisonService ser = new SaisonService();
		List<Saison> l = ser.rechercheTousSaison();
		if (l.get(0).getSelect() == 1)
			horaire = 0;
		else if (l.get(1).getSelect() == 1)
			horaire = 1;
		else if (l.get(2).getSelect() == 1)
			horaire = 2;
		return horaire;
	}

	public void setHoraire(int horaire) {
		this.horaire = horaire;
	}

	public String getDialog() {
		return Dialog;
	}

	public void setDialog(String dialog) {
		Dialog = dialog;
	}

	public int getJJ() {
		return JJ;
	}

	public void setJJ(int jJ) {
		JJ = jJ;
	}

	public int getMM() {
		return MM;
	}

	public void setMM(int mM) {
		MM = mM;
	}

	public Integer getAAAA() {
		return AAAA;
	}

	public void setAAAA(Integer aAAA) {
		AAAA = aAAA;
	}

	public int getWidthDialog() {
		return widthDialog;
	}

	public void setWidthDialog(int widthDialog) {
		this.widthDialog = widthDialog;
	}

	public boolean isNotjourfr() {
		return notjourfr;
	}

	public void setNotjourfr(boolean notjourfr) {
		this.notjourfr = notjourfr;
		this.jourfr = !notjourfr;
	}

	public String getDisc() {
		return disc;
	}

	public void setDisc(String disc) {
		this.disc = disc;
	}

	public String getView() {
		return view;
	}

	public void setView(String view) {
		this.view = view;
	}

	@SuppressWarnings("deprecation")
	public int getJj() {
		jj = selectedDate.getDate();
		return jj;
	}

	public void setJj(int jj) {
		this.jj = jj;
	}

	@SuppressWarnings("deprecation")
	public int getMm() {
		mm = selectedDate.getMonth() + 1;
		return mm;
	}

	public void setMm(int mm) {
		this.mm = mm;
	}

	@SuppressWarnings("deprecation")
	public Integer getAaaa() {
		aaaa = selectedDate.getYear() + 1900;
		return aaaa;
	}

	public void setAaaa(Integer aaaa) {
		this.aaaa = aaaa;
	}

	public List<String> getJours() {
		jours.clear();
		for (int i = 1; i <= 31; i++)
			if (i < 10)
				jours.add(new String("0" + i));
			else
				jours.add(new String("" + i));

		return jours;
	}

	public void setJours(List<String> jours) {
		this.jours = jours;
	}

	public List<Integer> getAnnee() {
		annee.clear();
		int i;
		for (i = 1900; i <= 2200; i++) {
			annee.add(new Integer(i));
		}
		return annee;
	}

	public void setAnnee(List<Integer> annee) {
		this.annee = annee;
	}

	public List<Mois> getMoiss() {
		moiss.clear();
		Mois arg0 = new Mois("01", "01");
		moiss.add(arg0);
		Mois arg1 = new Mois("02", "02");
		moiss.add(arg1);
		Mois arg2 = new Mois("03", "03");
		moiss.add(arg2);
		Mois arg3 = new Mois("04", "04");
		moiss.add(arg3);
		Mois arg4 = new Mois("05", "05");
		moiss.add(arg4);
		Mois arg5 = new Mois("06", "06");
		moiss.add(arg5);
		Mois arg6 = new Mois("07", "07");

		moiss.add(arg6);
		Mois arg7 = new Mois("08", "08");
		moiss.add(arg7);
		Mois arg8 = new Mois("09", "09");
		moiss.add(arg8);
		Mois arg9 = new Mois("10", "10");
		moiss.add(arg9);
		Mois arg10 = new Mois("11", "11");
		moiss.add(arg10);
		Mois arg11 = new Mois("12", "12");
		moiss.add(arg11);
		return moiss;
	}

	public boolean isJourfr() throws ParseException {
		return jourfr;
	}

	public void setJourfr(boolean jourfr) {
		this.jourfr = jourfr;
		this.notjourfr = !jourfr;
	}

	public List<JourFr> getJourFrs() {

		JourFrService ser = new JourFrService();

		jourFrs = ser.rechercheTousJourFr();
		// Calendar cal = Calendar.getInstance();
		// for (int i = 0; i < jourFrs.size(); i++) {
		// cal.setTime(jourFrs.get(i).getDate());
		// cal.add(Calendar.DATE, 1);
		// DefaultScheduleEvent jfr = new DefaultScheduleEvent("  ",
		// cal.getTime(), cal.getTime(), true);
		// jfr.setStyleClass("myclass");
		// rendezVouss.addEvent(jfr);
		// }

		return jourFrs;
	}

	public void setJourFrs(List<JourFr> jourFrs) {
		this.jourFrs = jourFrs;
	}

	public List<JourFrSp> getJourFrSps() {
		JourFrSpService ser02 = new JourFrSpService();
		jourFrSps = ser02.rechercheTousJourFrSp();
		return jourFrSps;
	}

	public void setJourFrSps(List<JourFrSp> jourFrSps) {
		this.jourFrSps = jourFrSps;
	}

	@SuppressWarnings("deprecation")
	public String getScript() {
		script = "";
		jourFrs = new JourFrService().rechercheTousJourFr();
		jourFrSps = new JourFrSpService().rechercheTousJourFrSp();

		String aaaa;
		String mm;
		String jj;
		String jf;

		for (int i = 0; i < jourFrs.size(); i++) {
			mm = "" + (jourFrs.get(i).getDate().getMonth() + 1);
			if (mm.length() == 1)
				mm = "0" + mm;
			jj = "" + jourFrs.get(i).getDate().getDate();
			if (jj.length() == 1)
				jj = "0" + jj;
			for (int j = 1900; j <= 2200; j++) {
				jf = "td[data-date='" + j + "-" + mm + "-" + jj + "']";
				script += jf + style;
			}
		}
		for (int i = 0; i < jourFrSps.size(); i++) {
			Date deb = jourFrSps.get(i).getDebut();
			Date fin = jourFrSps.get(i).getFin();
			fin.setHours(23);
			fin.setMinutes(59);
			fin.setSeconds(59);
			while (fin.after(deb)) {
				mm = "" + (deb.getMonth() + 1);
				if (mm.length() == 1)
					mm = "0" + mm;
				jj = "" + deb.getDate();
				if (jj.length() == 1)
					jj = "0" + jj;
				aaaa = "" + (deb.getYear() + 1900);
				jf = "td[data-date='" + aaaa + "-" + mm + "-" + jj + "']";
				script += jf + style;
				Calendar cal = Calendar.getInstance();
				cal.setTime(deb);
				cal.add(Calendar.DATE, 1);
				deb = cal.getTime();
			}
		}

		SaisonService ser = new SaisonService();
		List<Saison> l = ser.rechercheTousSaisonAvecJointure();
		Saison S = l.get(getHoraire());
		// int i = 8 - selectedDate.getDay();
		if (S.getLun().getActive() == 0)
			script += ".fc-day.fc-mon, .fc-mon.fc-col0.ui-widget-content, .fc-col0.ui-widget-content"
					+ style;
		if (S.getMar().getActive() == 0)
			script += ".fc-day.fc-tue, .fc-tue.fc-col0.ui-widget-content, .fc-col1.ui-widget-content"
					+ style;
		if (S.getMer().getActive() == 0)
			script += ".fc-day.fc-wed, .fc-wed.fc-col0.ui-widget-content, .fc-col2.ui-widget-content"
					+ style;
		if (S.getJeu().getActive() == 0)
			script += ".fc-day.fc-thu, .fc-thu.fc-col0.ui-widget-content, .fc-col3.ui-widget-content"
					+ style;
		if (S.getVen().getActive() == 0)
			script += ".fc-day.fc-fri, .fc-fri.fc-col0.ui-widget-content, .fc-col4.ui-widget-content"
					+ style;
		if (S.getSam().getActive() == 0)
			script += ".fc-day.fc-sat, .fc-sat.fc-col0.ui-widget-content, .fc-col5.ui-widget-content"
					+ style;
		if (S.getDim().getActive() == 0) {
			script += ".fc-day.fc-sun, .fc-sun.fc-col0.ui-widget-content, .fc-col6.ui-widget-content"
					+ style;

		}
		return script;
	}

	public void setScript(String script) {
		this.script = script;
	}

	public ScheduleEvent getSelectedRendezVous() {
		return selectedRendezVous;
	}

	public void setSelectedRendezVous(ScheduleEvent selectedRendezVous) {
		this.selectedRendezVous = selectedRendezVous;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public Integer getCodeclientCode() {
		return codeclientCode;
	}

	public void setCodeclientCode(Integer codeclientCode) {
		this.codeclientCode = codeclientCode;
	}

	public List<RendezVous> getRendezVoussParDate() throws ParseException {
		RendezVousService ser = new RendezVousService();
		rendezVoussParDate = ser.rechercheTousParDate(selectedDate);
		return rendezVoussParDate;
	}

	public int getHeure() {
		return heure;
	}

	public void setHeure(int heure) {
		this.heure = heure;
	}

	public void setRendezVoussParDate(List<RendezVous> rendezVoussParDate) {
		this.rendezVoussParDate = rendezVoussParDate;
	}

	public Date getSelectedDate() {

		return selectedDate;
	}

	public void setSelectedDate(Date selectedDate) throws ParseException {
		disc = "";
		JourFrService ser = new JourFrService();
		List<JourFr> l = ser.rechercheTousParDate(selectedDate);
		if (l.size() != 0)
			if (l.get(0).getDisc().trim().equals("")
					|| l.get(0).getDisc() == null)
				;
			else
				disc = "(" + l.get(0).getDisc() + ")";
		if (l.size() != 0) {
			jourfr = true;
		} else {
			jourfr = false;
		}
		this.selectedDate = selectedDate;
	}

	public Integer getIdrendezVous() {
		return idrendezVous;
	}

	public void setIdrendezVous(Integer idrendezVous) {
		this.idrendezVous = idrendezVous;
	}

	public Cfclient getCodeclient() {
		return codeclient;
	}

	public void setCodeclient(Cfclient codeclient) {
		this.codeclient = codeclient;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@SuppressWarnings("deprecation")
	public ScheduleModel getRendezVouss() throws ParseException {
		rendezVouss = new DefaultScheduleModel();
		List<RendezVous> liste = new ArrayList<RendezVous>();
		RendezVousService ser = new RendezVousService();
		liste = ser.rechercheTousRendezVousAvecJointure("codeclient");
		try {
			for (int i = 0; i < liste.size(); i++) {
				Cfclient cl = liste.get(i).getCodeclient();
				Date date = liste.get(i).getDate();
				String note = liste.get(i).getNote();

				RendezVous R;
				if (liste.get(i).getEtat() == 1)// c'est un rendez vous passé
					R = new RendezVous(cl, date, note, "passer");
				else if (date.before(new Date()))// la patiente est en retard
					R = new RendezVous(cl, date, note, "retard");
				else
					// le rendez vous pas encore arrivé
					R = new RendezVous(cl, date, note, "default");
				rendezVouss.addEvent(R);
			}
		} catch (Exception e) {

			System.out.println(e.getMessage());
			return rendezVouss;
		}
		if (view.equals("agendaDay")) {
			Calendar cal = Calendar.getInstance();
			Date d = selectedDate;
			d.setHours(0);
			d.setMinutes(0);
			d.setSeconds(0);
			cal.setTime(d);
			// cal.add(Calendar.DATE, i);
			// tester si c'est un jour férier
			List<JourFr> jf = new JourFrService().rechercheTousContientDate(cal
					.getTime());
			List<JourFrSp> jfs = new JourFrSpService()
					.rechercheTousContientDate(cal.getTime());
			if ((jf != null && jf.size() > 0)
					|| (jfs != null && jfs.size() > 0)) {
				if (jf != null && jf.size() > 0) {
					DefaultScheduleEvent jourf = new DefaultScheduleEvent(jf
							.get(0).getDisc(), cal.getTime(), cal.getTime(),
							true);
					jourf.setStyleClass("nbr");
					rendezVouss.addEvent(jourf);
				}
				if (jfs != null && jfs.size() > 0) {
					DefaultScheduleEvent jourfs = new DefaultScheduleEvent(jfs
							.get(0).getDisc(), cal.getTime(), cal.getTime(),
							true);
					jourfs.setStyleClass("nbr");
					rendezVouss.addEvent(jourfs);
				}
			} else {
				RendezVousService ser2 = new RendezVousService();
				int x = ser2.rechercheTousParDate(cal.getTime()).size();
				DefaultScheduleEvent nbrRend = new DefaultScheduleEvent(x
						+ " rendez-vous\n ", cal.getTime(), cal.getTime(), true);
				nbrRend.setStyleClass("nbrrdv");

				if (x != 0) {
					rendezVouss.addEvent(nbrRend);
				}
			}
		}
		if (view.equals("agendaWeek")) {

			for (int i = -7; i <= 7; i++) {
				Calendar cal = Calendar.getInstance();
				Date d = selectedDate;
				d.setHours(0);
				d.setMinutes(0);
				d.setSeconds(0);
				cal.setTime(d);
				cal.add(Calendar.DATE, i);
				// tester si c'est un jour férier
				List<JourFr> jf = new JourFrService()
						.rechercheTousContientDate(cal.getTime());
				List<JourFrSp> jfs = new JourFrSpService()
						.rechercheTousContientDate(cal.getTime());
				if ((jf != null && jf.size() > 0)
						|| (jfs != null && jfs.size() > 0)) {
					if (jf != null && jf.size() > 0) {
						DefaultScheduleEvent jourf = new DefaultScheduleEvent(
								jf.get(0).getDisc(), cal.getTime(),
								cal.getTime(), true);
						jourf.setStyleClass("nbr");
						rendezVouss.addEvent(jourf);
					}
					if (jfs != null && jfs.size() > 0) {
						DefaultScheduleEvent jourfs = new DefaultScheduleEvent(
								jfs.get(0).getDisc(), cal.getTime(),
								cal.getTime(), true);
						jourfs.setStyleClass("nbr");
						rendezVouss.addEvent(jourfs);
					}
				} else {
					RendezVousService ser2 = new RendezVousService();
					int x = ser2.rechercheTousParDate(cal.getTime()).size();
					DefaultScheduleEvent nbrRend = new DefaultScheduleEvent(x
							+ " rendez-vous\n ", cal.getTime(), cal.getTime(),
							true);
					nbrRend.setStyleClass("nbrrdv");

					if (x != 0) {
						rendezVouss.addEvent(nbrRend);
					}
				}
			}
		}
		if (view.equals("month")) {
			for (int i = -30; i <= 30; i++) {
				Calendar cal = Calendar.getInstance();
				Date d = selectedDate;
				d.setHours(0);
				d.setMinutes(0);
				d.setSeconds(0);
				cal.setTime(d);
				cal.add(Calendar.DATE, i);
				// tester si c'est un jour férier
				List<JourFr> jf = new JourFrService()
						.rechercheTousContientDate(cal.getTime());
				List<JourFrSp> jfs = new JourFrSpService()
						.rechercheTousContientDate(cal.getTime());
				if ((jf != null && jf.size() > 0)
						|| (jfs != null && jfs.size() > 0)) {
					if (jf != null && jf.size() > 0) {
						DefaultScheduleEvent jourf = new DefaultScheduleEvent(
								jf.get(0).getDisc(), cal.getTime(),
								cal.getTime(), true);
						jourf.setStyleClass("nbr");
						rendezVouss.addEvent(jourf);
					}
					if (jfs != null && jfs.size() > 0) {
						DefaultScheduleEvent jourfs = new DefaultScheduleEvent(
								jfs.get(0).getDisc(), cal.getTime(),
								cal.getTime(), true);
						jourfs.setStyleClass("nbr");
						rendezVouss.addEvent(jourfs);
					}
				} else {
					RendezVousService ser2 = new RendezVousService();
					int x = ser2.rechercheTousParDate(cal.getTime()).size();
					DefaultScheduleEvent nbrRend = new DefaultScheduleEvent(x
							+ " rendez-vous\n ", cal.getTime(), cal.getTime(),
							true);
					nbrRend.setStyleClass("nbrrdv");

					if (x != 0) {
						rendezVouss.addEvent(nbrRend);
					}
				}
			}
		}

		return rendezVouss;

	}

	public void setRendezVouss(ScheduleModel rendezVouss) {
		this.rendezVouss = rendezVouss;
	}

	public void modifierRendezVous(RendezVous r) throws ParseException {
		selectedRendezVous = r;
		idrendezVous = r.getIdrendezVous();
		codeclient = r.getCodeclient();
		date = r.getDate();
		note = r.getNote();
		codeclientCode = codeclient.getCode();
	}

	public void init() {
		selectedRendezVous = null;
		idrendezVous = null;
		codeclient = null;
		date = null;
		note = "";
		codeclientCode = null;
		JJ = -1;
		MM = -1;
		AAAA = -1;
		heure = 0;
		minute = 0;

	}

	public void modif() {
		FacesContext faces = FacesContext.getCurrentInstance();
		RendezVousService ser = new RendezVousService();
		CfclientService ser2 = new CfclientService();
		codeclient = ser2.RechercheCfclient(codeclientCode);
		((RendezVous) selectedRendezVous).setCodeclient(codeclient);
		((RendezVous) selectedRendezVous).setDate(date);
		((RendezVous) selectedRendezVous).setNote(note);
		ser.modifierRendezVous((RendezVous) selectedRendezVous);
		faces.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Succès", "Rendez-vous pour " + codeclient.getNom() + " "
						+ codeclient.getPrenom() + ", modifié avec succès !"));
		permenent = false;
		init();
	}

	public void supprimerRendezVous(Integer id) {
		RendezVousService ser = new RendezVousService();
		ser.supprimerRendezVous(id);
		FacesContext faces = FacesContext.getCurrentInstance();
		faces.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "",
				"Rendez-vous est supprimé avec succès"));
	}

	public void onDateSelect(SelectEvent selectEvent) throws ParseException {

		FacesContext faces = FacesContext.getCurrentInstance();
		RequestContext context = RequestContext.getCurrentInstance();
		Date selected = (Date) selectEvent.getObject();
		setSelectedDate(selected);

		SimpleDateFormat sdfH2 = new java.text.SimpleDateFormat("HH:mm");
		String heureee = sdfH2.format(selected);

		HttpSession session2 = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		session2.setAttribute("dateSelect", selected);
		session2.setAttribute("h", heureee);

		Format format = new SimpleDateFormat("dd/MM/yyyy");
		String dateString = format.format(selected);
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		String action = (String) session.getAttribute("actionRDV");
		if(action == null)
		{
			action="consulter";
		}
		if (action.equals("affecter")) {
			if (view.equals("month")) {
				view = "agendaDay";
			} else {
				if (codeclientCode != null) {
					RendezVousService serSai = new RendezVousService();
					List<RendezVous> sais = serSai.rechercheRDVParPatient(
							codeclientCode, new Date());
					if (sais != null && sais.size() > 0) {
						faces.addMessage(null, new FacesMessage(
								FacesMessage.SEVERITY_FATAL, "Attention !",
								"Cette patiente a déjà un rendez-vous le \" "
										+ sais.get(0).getDate() + " \""));
						permenent = true;
					}
				}
				if (faces.getMessageList().size() == 0) {
					// vérifier si la date valide==> dans le future
					if (selected.before(new Date())) {
						faces.addMessage(null, new FacesMessage(
								FacesMessage.SEVERITY_FATAL, "Interdit !",
								"La date sélectionnée est passée ! "));
						permenent = true;
					} else {
						jourFrs = new JourFrService()
								.rechercheTousParDate(selected);

						// variable dit si c'est un jour ferier ou nn

						boolean jf = false;
						if (jourFrs != null && jourFrs.size() > 0) {
							jf = true;// la date sélectionnée est un jour férier

						}

						SimpleDateFormat sdf = new SimpleDateFormat(
								"dd/MM/yyyy");
						// jourFrSps = new JourFrSpService()
						// .rechercheTousJourFrSp();
						Date acc = sdf.parse(format.format(selected));
						jourFrSps = new JourFrSpService()
								.rechercheTousContientDate(acc);
						if (jourFrSps != null && jourFrSps.size() > 0) {
							jf = true;// la date sélectionnée est un jour férier
						}
						if (!jf) {// tester si c'est dans les heures de travail
							// récupérer le jour la semaine
							SimpleDateFormat sdf2 = new SimpleDateFormat("EEEE");
							String s = sdf2.format(selected);

							// dans la BD le jour représenté par les 3 1er
							// lettres
							s = s.substring(0, 3);
							SaisonService serSai = new SaisonService();
							List<Saison> sais = serSai.rechercheSaisonParDate(
									sdf.parse(format.format(selected)), s);
							Saison sa = null;
							if (sais != null && sais.size() > 0)
								sa = sais.get(sais.size() - 1);

							Horaire h1 = null;
							Horaire h2 = null;
							SimpleDateFormat sdfH = new java.text.SimpleDateFormat(
									"HH:mm");
							String heure = sdfH.format(selected);
							Horaire hh = new Horaire(sdfH.parse(heure),
									sdfH.parse(heure));

							for (int i = 0; i < 1 && sa != null; i++) {
								if (s.equals("lun")) {
									if (sa.getLun().getActive() == 1) {
										h1 = sa.getLun().getHoraire();
										h2 = sa.getLun().getHoraire2();
										break;
									}
								}

								if (s.equals("mar")) {
									if (sa.getMar().getActive() == 1) {
										h1 = sa.getMar().getHoraire();
										h2 = sa.getMar().getHoraire2();
										break;
									}
								}

								if (s.equals("mer")) {
									if (sa.getMer().getActive() == 1) {
										h1 = sa.getMer().getHoraire();
										h2 = sa.getMer().getHoraire2();
										break;
									}
								}

								if (s.equals("jeu")) {
									if (sa.getJeu().getActive() == 1) {
										h1 = sa.getJeu().getHoraire();
										h2 = sa.getJeu().getHoraire2();
										break;
									}
								}

								if (s.equals("ven")) {
									if (sa.getVen().getActive() == 1) {
										h1 = sa.getVen().getHoraire();
										h2 = sa.getVen().getHoraire2();
										break;
									}
								}

								if (s.equals("sam")) {
									if (sa.getSam().getActive() == 1) {
										h1 = sa.getSam().getHoraire();
										h2 = sa.getSam().getHoraire2();
										break;
									}
								}
								if (s.equals("dim")) {
									if (sa.getDim().getActive() == 1) {
										h1 = sa.getDim().getHoraire();
										h2 = sa.getDim().getHoraire2();
										break;
									}
								}
							}

							boolean horsHoraire = true;
							if (h1 != null)
								if (hh.getDebut().equals(h1.getDebut())
										|| (hh.getDebut().after(h1.getDebut()) && hh
												.getDebut().before(h1.getFin())))
									horsHoraire = false;
							if (h2 != null)
								if (hh.getDebut().equals(h2.getDebut())
										|| (hh.getDebut().after(h2.getDebut()) && hh
												.getDebut().before(h2.getFin())))
									horsHoraire = false;
							dateChoisi = dateString + ":" + heure;
							if (!horsHoraire) {
								dureeRDV = 1;

								dateChoisi = dateString + ":" + heure;

								RequestContext.getCurrentInstance().update(
										":formeGenerale:idAffect");
								context.execute("PF('menu').show();");
							} else {
								// afficher un dialogue qui demande s'il veux
								// affecter un rdv hors horaire de travail

								RequestContext.getCurrentInstance().update(
										":formeGenerale:idHorshoraire");
								context.execute("PF('horshoraire').show();");

								// faces.addMessage(
								// null,
								// new FacesMessage(
								// FacesMessage.SEVERITY_FATAL,
								// "Interdit !",
								// "\" "
								// + heure
								// + " est hors horaire de travail ! "));
								// permenent = true;
							}
						} else {
							faces.addMessage(null, new FacesMessage(
									FacesMessage.SEVERITY_FATAL, "Interdit !",
									"Le " + dateString
											+ " est un jour férier ! "));
							permenent = true;
						}
					}
				}
			}

		} else if (action.equals("consulter")) {

			rendezVoussParDate = new RendezVousService()
					.rechercheTousParDate(selected);
			if (rendezVoussParDate.size() > 0) {

				context.execute("PF('eventDialog').show();");
			} else {
				faces.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_INFO, "",
						"Vous n'avez pas des rendez-vous le " + dateString));
				permenent = false;
			}
		}
		
	}

	public void horsHoraire() {
		dureeRDV = 1;

		RequestContext context = RequestContext.getCurrentInstance();
		RequestContext.getCurrentInstance().update(":formeGenerale:idAffect");
		context.execute("PF('menu').show();");
	}

	@SuppressWarnings("deprecation")
	public void affect() throws ParseException {
		HttpSession session2 = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		Date d = (Date) session2.getAttribute("dateSelect");
		String hr = (String) session2.getAttribute("h");
		FacesContext faces = FacesContext.getCurrentInstance();
		if (codeclientCode != null) {

			RendezVousService ser = new RendezVousService();
			CfclientService ser2 = new CfclientService();
			codeclient = ser2.RechercheCfclient(codeclientCode);
			date = (Date) d.clone();
			String h = hr.substring(0, 2);
			String min = hr.substring(3);
			date.setHours(Integer.parseInt(h));
			date.setMinutes(Integer.parseInt(min));

			ser.ajoutRendezVous(new RendezVous(codeclient, date, note,
					"default"));

			if (dureeRDV > 1) {

				Format format = new SimpleDateFormat("dd/MM/yyyy");
				String dateString = format.format(date);

				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				Date dateDuplique = sdf.parse(dateString);

				for (int i = 2; i <= dureeRDV; i++) {
					// ajouter i-1 jour pour la date

					Calendar cal = Calendar.getInstance();
					cal.setTime(dateDuplique);
					cal.add(Calendar.DATE, 1);
					dateDuplique = cal.getTime();

					jourFrs = new JourFrService()
							.rechercheTousParDate(dateDuplique);
					boolean jf = false;
					if (jourFrs != null && jourFrs.size() > 0) {
						jf = true;// la date sélectionnée est un jour férier
					}

					jourFrSps = new JourFrSpService()
							.rechercheTousContientDate(dateDuplique);
					if (jourFrSps != null && jourFrSps.size() > 0) {
						jf = true;// la date sélectionnée est un jour férier
					}
					if (jf)
						continue;
					else {
						// chercher si c'est hors horaire de travail
						SimpleDateFormat sdf2 = new SimpleDateFormat("EEEE");
						String s = sdf2.format(dateDuplique);

						// dans la BD le jour représenté par les 3 1er
						// lettres
						s = s.substring(0, 3);
						SaisonService serSai = new SaisonService();
						List<Saison> sais = serSai.rechercheSaisonParDate(
								sdf.parse(format.format(dateDuplique)), s);
						Saison sa = null;
						if (sais != null && sais.size() > 0)
							sa = sais.get(sais.size() - 1);
						// sa.get
						Horaire h1 = null;
						if (s.equals("lun")) {
							if (sa.getLun().getActive() == 1) {
								h1 = sa.getLun().getHoraire();
							}
						}

						if (s.equals("mar")) {
							if (sa.getMar() != null
									&& sa.getMar().getActive() == 1) {
								h1 = sa.getMar().getHoraire();
							}
						}

						if (s.equals("mer")) {
							if (sa.getMer() != null
									&& sa.getMer().getActive() == 1) {
								h1 = sa.getMer().getHoraire();
							}
						}

						if (s.equals("jeu")) {
							if (sa.getJeu() != null
									&& sa.getJeu().getActive() == 1) {
								h1 = sa.getJeu().getHoraire();
							}
						}

						if (s.equals("ven")) {
							if (sa.getVen() != null
									&& sa.getVen().getActive() == 1) {
								h1 = sa.getVen().getHoraire();
							}
						}

						if (s.equals("sam")) {
							if (sa.getSam() != null
									&& sa.getSam().getActive() == 1) {
								h1 = sa.getSam().getHoraire();
							}
						}
						if (s.equals("dim")) {
							if (sa.getDim() != null
									&& sa.getDim().getActive() == 1) {
								h1 = sa.getDim().getHoraire();
							}
						}

						if (h1 != null) {
							int he = h1.getDebut().getHours();
							int m = h1.getDebut().getMinutes();
							dateDuplique.setHours(he);
							dateDuplique.setMinutes(m);
							ser.ajoutRendezVous(new RendezVous(codeclient,
									dateDuplique, note, "default"));
						}

					}

				}
			}

			faces.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Succès",
							"Rendez-vous pour " + codeclient.getNom() + " "
									+ codeclient.getPrenom()
									+ ", ajouté avec succès !"));
			permenent = false;
			HttpSession session = (HttpSession) FacesContext
					.getCurrentInstance().getExternalContext()
					.getSession(false);
			session.setAttribute("actionRDV", "consulter");
			init();
		} else {
			faces.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Erreur !",
					"Séléctionnez un patient svp"));
			permenent = true;
		}
	}

	public void modifier() throws ParseException {
		boolean addValid = false;
		RequestContext context = RequestContext.getCurrentInstance();
		FacesContext faces = FacesContext.getCurrentInstance();
		if (getCodeclientCode() != null) {
			if (testJourFr(date)) {
				faces.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_FATAL, "Impossible !",
						"C'est un jour férier ! " + disc));
				addValid = false;
				RequestContext.getCurrentInstance().update(
						":formeGenerale:growl");
				permenent = true;
			} else if (dispo(getHoraire(), date) == false) {
				faces.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_FATAL, "Impossible !",
						"Hors horaire de travail !"));
				permenent = true;
				RequestContext.getCurrentInstance().update(
						":formeGenerale:growl");
				addValid = false;
			} else {
				modif();
				addValid = true;
				RequestContext ctxt = RequestContext.getCurrentInstance();
				ctxt.update(":formeGenerale:gestionRendezVous");
				ctxt.execute("PF('eventDialog').show();");
			}
		} else {
			faces.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Erreur !",
					"Séléctionnez un patient svp"));

			permenent = true;
		}

		context.addCallbackParam("addValid", addValid);
	}

	@SuppressWarnings("deprecation")
	public String selectionnezDate() throws ParseException {
		FacesContext faces = FacesContext.getCurrentInstance();
		// 0 0 0
		if (aaaa == -1 && mm == -1 && jj == -1) {
			faces.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Erreur !",
					"Vous devez séléctionnez une date !"));
			permenent = true;
			setSelectedDate(new Date());
			return "000";
		}
		// 0 0 1
		if (aaaa == -1 && mm == -1 && jj != -1) {
			aaaa = selectedDate.getYear() + 1900;
			mm = selectedDate.getMonth() + 1;
			selectedDate.setDate(jj);
			view = "agendaDay";
			return "001";
		}
		// 0 1 0
		if (aaaa == -1 && mm != -1 && jj == -1) {
			aaaa = selectedDate.getYear() + 1900;
			selectedDate.setMonth(mm - 1);
			selectedDate.setDate(1);
			jj = 1;
			view = "month";
			return "010";
		}
		// 0 1 1
		if (aaaa == -1 && mm != -1 && jj != -1) {
			aaaa = selectedDate.getYear() + 1900;
			selectedDate.setMonth(mm - 1);
			selectedDate.setDate(jj);
			view = "agendaDay";
			return "011";
		}
		// 1 0 0
		if (aaaa != -1 && mm == -1 && jj == -1) {
			selectedDate.setYear(aaaa - 1900);
			selectedDate.setMonth(0);
			mm = 1;
			selectedDate.setDate(1);
			jj = 1;
			view = "month";
			return "100";
		}
		// 1 0 1
		if (aaaa != -1 && mm == -1 && jj != -1) {
			selectedDate.setYear(aaaa - 1900);
			mm = selectedDate.getMonth();
			selectedDate.setDate(jj);
			view = "agendaDay";
			return "101";
		}
		// 1 1 0
		if (aaaa != -1 && mm != -1 && jj == -1) {
			selectedDate.setYear(aaaa - 1900);
			selectedDate.setMonth(mm - 1);
			selectedDate.setDate(1);
			jj = 1;
			view = "month";
			return "110";
		}
		// 1 1 1
		if (aaaa != -1 && mm != -1 && jj != -1) {
			selectedDate.setYear(aaaa - 1900);
			selectedDate.setMonth(mm - 1);
			selectedDate.setDate(jj);
			view = "agendaDay";
			return "111";
		}
		return "IMPOSSIBLE";
	}

	@SuppressWarnings("deprecation")
	public String selectedDateToString() {
		String yyyy = "" + (selectedDate.getYear() + 1900);
		String mm = "" + (selectedDate.getMonth() + 1);
		if (mm.length() == 1)
			mm = "0" + mm;
		String jj = "" + selectedDate.getDate();
		if (jj.length() == 1)
			jj = "0" + jj;
		return "Le " + jj + " "
				+ moiss.get(Integer.parseInt(mm) - 1).getNomMois() + " " + yyyy;
	}

	@SuppressWarnings("deprecation")
	public boolean dispo(int index, Date date) {
		Jour jr = null;
		SaisonService ser = new SaisonService();
		List<Saison> l = ser.rechercheTousSaisonAvecJointure();
		if (date.getDay() == 0)
			jr = l.get(index).getDim();
		if (date.getDay() == 1)
			jr = l.get(index).getLun();
		if (date.getDay() == 2)
			jr = l.get(index).getMar();
		if (date.getDay() == 3)
			jr = l.get(index).getMer();
		if (date.getDay() == 4)
			jr = l.get(index).getJeu();
		if (date.getDay() == 5)
			jr = l.get(index).getVen();
		if (date.getDay() == 6)
			jr = l.get(index).getSam();
		if (jr.getActive() == 0)
			return false;
		if (jr.getHoraire() == null)
			if (jr.getHoraire2() == null)
				return false;
			else
				return (jr.getHoraire2().contien(date));
		else if (jr.getHoraire2() == null)
			return (jr.getHoraire().contien(date));
		else
			return (jr.getHoraire().contien(date) || jr.getHoraire2().contien(
					date));
	}

	public boolean testJourFr(Date date) throws ParseException {
		disc = "";
		JourFrService ser = new JourFrService();
		List<JourFr> l = ser.rechercheTousParDate(date);
		if (l.size() != 0)
			if (l.get(0).getDisc().trim().equals("")
					|| l.get(0).getDisc() == null)
				;
			else
				disc = "(" + l.get(0).getDisc() + ")";
		return (l.size() != 0);
	}

	public void selectClientFiche() {
		Integer idpatient = null;
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idpatient = (Integer) session.getAttribute("idu");
		// idpatient = Module.idpatient;
		CfclientService se = new CfclientService();
		Cfclient obj = se.RechercheCfclient(idpatient);
		init();
		codeclient = obj;
		codeclientCode = obj.getCode();
		// action1 = "FichePatiente";
		// HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
		// .getExternalContext().getSession(false);
		session.setAttribute("source", "FichePatiente");
		session.setAttribute("actionRDV", "affecter");
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("Rendez-Vous");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void selectClient(Integer id) {
		init();
		CfclientService cfSer= new CfclientService();
		codeclient= cfSer.RechercheCfclient(id);
		codeclientCode = id;
		// action1 = "Patients";
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		session.setAttribute("source", "Patients");
		session.setAttribute("actionRDV", "affecter");
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("Rendez-Vous");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void versSalle(RendezVous obj) {
		System.out.println("entree methode");
		try {
			setSelectedDate(new Date());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		codeclient = obj.getCodeclient();
		selectedRendezVous = obj;
		
	}

	@SuppressWarnings("deprecation")
	public String avoirHeure(Date d) {
		String heure = "";
		if (d.getHours() < 9)
			heure += "0" + d.getHours();
		else
			heure += d.getHours();

		if (d.getMinutes() < 9)
			heure += ":0" + d.getMinutes();
		else
			heure += ":" + d.getMinutes();

		return heure;
	}

	public void versSalle() {
		System.out.println("entree methode 2");
		boolean addValid=false;
	
		// recherche si patient existe dans la salle
		SalleService serv = new SalleService();
		Salle sal = serv.rechercheSalleParPatient(codeclient.getCode());

		List<TabSalle> tsList = new ArrayList<TabSalle>();
		List<String> motifsList = new ArrayList<String>();
		TabSalleService serts = new TabSalleService();
		boolean ordrDiff;
		tsList = serts.rechercheParOrdDiff(false);// list tabsalle while
													// orddiff==false
		for (int i = 0; i < tsList.size(); i++) {

			motifsList.add(tsList.get(i).getNomTab());
		}

		CfclientService se = new CfclientService();
		Cfclient cl = se.RechercheCfclient(codeclient.getCode());
		if (motif != null && motif.length() > 0) {
		if (sal == null) {

			if (motifsList.contains(motif)) {
				ordrDiff = false;
			} else {
				ordrDiff = true;
			}
			// si patient n'exsite pas déjà dans la salle
			Salle s = new Salle();
			s.setMotif(motif);
			s.setHeure(avoirHeure(new Date()));
			s.setNotes(noteSalle);
			s.setCfclient(cl);
			SalleService ser = new SalleService();

			// ///souuuuuu
			ser.ajouterSalle(s, motif, tsList, ordrDiff);
			
			((RendezVous) selectedRendezVous).setEtat(1);
			RendezVousService ser02 = new RendezVousService();
			ser02.modifierRendezVous((RendezVous) selectedRendezVous);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"", "Patiente ajoutée à la salle d'attente avec succès."));
			addValid = true;
		}

		else {
			addValid = true;
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Attention!",
							"\"" + cl.getPrenom() + " " + cl.getNom()
									+ "\" déjà dans la salle d'attente"));
			permenent = true;
		}
		
		}
		else
		{addValid = false;
		permenent = true;
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
				"", "Veuillez choisir un type du salle d'attente"));
		}
		RequestContext context2 = RequestContext.getCurrentInstance();
		context2.addCallbackParam("addValid", addValid);
		codeclient = null;
		codeclientCode = null;
		motif = null;
		noteSalle = null;
	}
	

	public void toDay() {
		selectedDate = new Date();
	}

	@SuppressWarnings("deprecation")
	public boolean isToDay() {
		Date d = new Date();
		if ((selectedDate.getDate() == d.getDate())
				&& (selectedDate.getMonth() == d.getMonth())
				&& (selectedDate.getYear() == d.getYear()))
			return true;
		else
			return false;
	}

	public void addDays(int n) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(selectedDate);
		cal.add(Calendar.DATE, n);
		selectedDate = cal.getTime();
		NBR = 0;
	}

	public void addMonths(int n) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(selectedDate);
		cal.add(Calendar.MONTH, n);
		selectedDate = cal.getTime();
	}

	public void addYears(int n) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(selectedDate);
		cal.add(Calendar.YEAR, n);
		selectedDate = cal.getTime();
	}

	// action de flech > suivant
	public void next() {
		if (view.equals("agendaDay")) {
			addDays(1);

		}
		if (view.equals("agendaWeek")) {
			addDays(7);

		}
		if (view.equals("month")) {
			addMonths(1);
		}
	}

	// action de flech < précédent
	public void prev() {
		if (view.equals("agendaDay"))
			addDays(-1);
		if (view.equals("agendaWeek"))
			addDays(-7);
		if (view.equals("month"))
			addMonths(-1);
	}

	public void goToRendezVous() {
		// action1 = "Patients";
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		session.setAttribute("source", "Patients");
		session.setAttribute("actionRDV", "consulter");
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("Rendez-Vous");
		} catch (Exception e) {
		}
	}

	// public String getAction1() {
	// return action1;
	// }
	//
	// public void setAction1(String action1) {
	// this.action1 = action1;
	// }

	public void goToAccueil() {

		try {
			setSelectedDate(new Date());
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("Accueil");
		} catch (Exception e) {
		}
	}

	public void goToSalleattente() {
		try {
			setSelectedDate(new Date());
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		session.setAttribute("redirectSalle", "Rendez-Vous");

		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("Salle");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void retour() {
		try {
			setSelectedDate(new Date());
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		String destination = (String) session.getAttribute("source");

		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect(destination);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void goToListePatientsParRendezVous() {
		try {
			setSelectedDate(new Date());
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		session.setAttribute("retourPatient", "Rendez-Vous");
		Module.recherchePatient = null;

		try {

			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("Patients");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void goToGestionJourFr() {
		try {
			setSelectedDate(new Date());
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("GestionJoursFeries");
		} catch (Exception e) {
		}
	}

	public void goToHoraire() {
		try {
			setSelectedDate(new Date());
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		HttpSession session2 = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		session2.setAttribute("valeurRetour", "Rendez-Vous");
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("GestionHoraireTravail");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	// Méthodes à supprimer
	// public void remplireJourFrs() {
	// JourFrService ser = new JourFrService();
	// JourFrSpService ser02 = new JourFrSpService();
	// jourFrs = ser.rechercheTousJourFr();
	// jourFrSps = ser02.rechercheTousJourFrSp();
	// }
}

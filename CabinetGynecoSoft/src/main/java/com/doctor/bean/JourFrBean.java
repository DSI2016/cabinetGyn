package com.doctor.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import com.doctor.persistance.JourFr;
import com.doctor.persistance.JourFrSp;
import com.doctor.service.JourFrService;
import com.doctor.service.JourFrSpService;

@ManagedBean(name = "jourFrBean")
@SessionScoped
public class JourFrBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idjourFr;
	private Date date;
	private String disc;
	private String discSp;
	private List<JourFr> jourFrs = new ArrayList<JourFr>();
	private int jj;
	private int mm;
	private Integer idjourFrSp;
	private Date debut;
	private Date fin;
	private List<JourFrSp> jourFrSps = new ArrayList<JourFrSp>();
	private String actionSp;
	private int index;
	private String destination;
	private int currentP;
	private int currentPex;
	private int nbj;
	private Date dateFin;
	private int nbjs;

	public int getNbjs() {
		return nbjs;
	}

	public void setNbjs(int nbjs) {
		this.nbjs = nbjs;
	}

	public int getNbj() {
		return nbj;
	}

	public void setNbj(int nbj) {
		this.nbj = nbj;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public int getCurrentPex() {
		return currentPex;
	}

	public void setCurrentPex(int currentPex) {
		this.currentPex = currentPex;
	}

	public int getCurrentP() {
		return currentP;
	}

	public void setCurrentP(int currentP) {
		this.currentP = currentP;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int nbJours(Date dateDebut, Date dateFin) {
		long nbr = 0;
		// Date dateDebut = f.getDebut();
		// Date dateFin = f.getFin();
		if (dateDebut != null && dateFin != null) {
			long CONST_DURATION_OF_DAY = 1000l * 60 * 60 * 24;
			long diff = Math.abs(dateFin.getTime() - dateDebut.getTime() + 1);
			nbr = (long) diff / CONST_DURATION_OF_DAY;
			int i = (int) nbr;
			return i + 1;
		}
		return 0;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getDiscSp() {
		return discSp;
	}

	public void setDiscSp(String discSp) {
		this.discSp = discSp;
	}

	public String getActionSp() {
		return actionSp;
	}

	public void setActionSp(String actionSp) {
		this.actionSp = actionSp;
	}

	public Integer getIdjourFrSp() {
		return idjourFrSp;
	}

	public void setIdjourFrSp(Integer idjourFrSp) {
		this.idjourFrSp = idjourFrSp;
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

	public List<JourFrSp> getJourFrSps() {
		JourFrSpService ser = new JourFrSpService();
		jourFrSps = ser.rechercheTousJourFrSp();
		return jourFrSps;
	}

	public void setJourFrSps(List<JourFrSp> jourFrSps) {
		this.jourFrSps = jourFrSps;
	}

	public int getJj() {
		return jj;
	}

	public void setJj(int jj) {
		this.jj = jj;
	}

	public int getMm() {
		return mm;
	}

	public void setMm(int mm) {
		this.mm = mm;
	}

	public List<JourFr> getJourFrs() {
		JourFrService ser = new JourFrService();
		jourFrs = ser.rechercheTousJourFr();
		return jourFrs;
	}

	public void setJourFrs(List<JourFr> jourFrs) {
		this.jourFrs = jourFrs;
	}

	public Integer getIdjourFr() {
		return idjourFr;
	}

	public void setIdjourFr(Integer idjourFr) {
		this.idjourFr = idjourFr;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDisc() {
		return disc;
	}

	public void setDisc(String disc) {
		this.disc = disc;
	}

	// action est un attribut pour différencier l'ajout de la modification
	private String action;

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public void ajout() {
		nbj = 1;
		action = "Ajout";
	}

	public void supprimerJourFr(Integer id) {
		JourFrService ser = new JourFrService();
		ser.supprimerJourFr(id);
		FacesContext faces = FacesContext.getCurrentInstance();
		faces.addMessage(null, new FacesMessage(
				"Jour férier supprimé avec succès", ""));
		FacesContext context2 = FacesContext.getCurrentInstance();
		context2.getExternalContext().getFlash().setKeepMessages(true);
		try {
			context2.getExternalContext().redirect("GestionJoursFeries");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@SuppressWarnings("deprecation")
	public void modif(JourFr obj) {
		idjourFr = obj.getIdjourFr();
		date = obj.getDate();
		disc = obj.getDisc();
		nbj = obj.getNbj();
		dateFin = obj.getDateFin();
		jj = date.getDate();
		mm = date.getMonth() + 1;
		action = "Modification";
	}

	@SuppressWarnings("deprecation")
	private JourFr existe(List<JourFr> list, Date D) {
		Date D1 = null;
		for (int i = 0; i < list.size(); i++) {
			D1 = list.get(i).getDate();
			if (D1.getMonth() == D.getMonth() && D1.getDate() == D.getDate())
				return list.get(i);
		}
		return null;
	}

	@SuppressWarnings("deprecation")
	public void Validation() {
		FacesContext faces = FacesContext.getCurrentInstance();
		RequestContext context = RequestContext.getCurrentInstance();
		boolean addValid = false;

		if (jj == -1) {
			faces.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"Veuillez sélectionner le jour.", ""));
			addValid = false;
		}
		if (mm == -1) {
			faces.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"Veuillez sélectionner le mois.", ""));
			addValid = false;
		}
		if (faces.getMessageList().size() == 0) {

			if (action.equals("Ajout")) {

				date = new Date();
				date.setDate(jj);
				date.setMonth(mm - 1);

				if (existe(jourFrs, date) != null) {
					faces.addMessage(null, new FacesMessage(
							FacesMessage.SEVERITY_ERROR,
							"Jour férier existe déjà!", ""));
					addValid = false;
				} else {

					JourFrService ser = new JourFrService();
					JourFr j = new JourFr();
					j.setDate(date);
					j.setDisc(disc);
					j.setNbj(nbj);

					// calcule date fin
					Calendar cal = Calendar.getInstance();
					cal.setTime(date);
					cal.add(Calendar.DATE, nbj - 1);
					dateFin = cal.getTime();
					j.setDateFin(dateFin);
					ser.ajoutJourFr(j);

					faces.addMessage(null, new FacesMessage(
							"Jour férier ajouté avec succès", ""));
					addValid = true;
					initialisation();
					RequestContext.getCurrentInstance().update("f1");
					FacesContext context2 = FacesContext.getCurrentInstance();
					context2.getExternalContext().getFlash()
							.setKeepMessages(true);
					try {
						context2.getExternalContext().redirect(
								"GestionJoursFeries");
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}

			}

			if (action.equals("Modification")) {
				date = new Date();
				date.setDate(jj);
				date.setMonth(mm - 1);
				JourFr d1 = existe(jourFrs, date);

				if (d1 == null) {
					JourFrService ser = new JourFrService();

					JourFr obj = new JourFr();
					obj.setIdjourFr(idjourFr);
					obj.setDate(date);
					obj.setDisc(disc);
					obj.setNbj(nbj);
					// calcule date fin
					Calendar cal = Calendar.getInstance();
					cal.setTime(date);
					cal.add(Calendar.DATE, nbj - 1);
					dateFin = cal.getTime();
					obj.setDateFin(dateFin);
					ser.modifierJourFr(obj);
					faces.addMessage(null, new FacesMessage(
							"Jour férier modifié avec succès.", ""));
					addValid = true;
					initialisation();
					RequestContext.getCurrentInstance().update("f1");
					FacesContext context2 = FacesContext.getCurrentInstance();
					context2.getExternalContext().getFlash()
							.setKeepMessages(true);
					try {
						context2.getExternalContext().redirect(
								"GestionJoursFeries");
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}

				else {
					if (d1.getIdjourFr() != idjourFr) {
						faces.addMessage(null, new FacesMessage(
								FacesMessage.SEVERITY_ERROR,
								"Jour férier existe déjà!", ""));
						addValid = false;
					} else {
						JourFrService ser = new JourFrService();

						JourFr obj = new JourFr();
						obj.setIdjourFr(idjourFr);
						obj.setDate(date);
						obj.setDisc(disc);
						obj.setNbj(nbj);
						// calcule date fin
						Calendar cal = Calendar.getInstance();
						cal.setTime(date);
						cal.add(Calendar.DATE, nbj - 1);
						dateFin = cal.getTime();
						obj.setDateFin(dateFin);
						ser.modifierJourFr(obj);
						faces.addMessage(null, new FacesMessage(
								"Jour férier modifié avec succès.", ""));
						addValid = true;
						initialisation();
						RequestContext.getCurrentInstance().update("f1");
						FacesContext context2 = FacesContext
								.getCurrentInstance();
						context2.getExternalContext().getFlash()
								.setKeepMessages(true);
						try {
							context2.getExternalContext().redirect(
									"GestionJoursFeries");
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}
					}
				}
			}// fin modification
		}
		index = 0;
		context.addCallbackParam("addValid", addValid);
	}

	public void initSp() {
		idjourFrSp = 0;
		debut = null;
		fin = null;
		nbjs = 0;
		discSp = null;
	}

	public void ajoutSp() {
		initSp();
		actionSp = "Ajout";
	}

	// public void ajouterJourFrSp() {
	// JourFrSpService ser = new JourFrSpService();
	// ser.ajoutJourFrSp(new JourFrSp(debut, fin, disc));
	//
	// }

	public void supprimerJourFrSp(Integer id) {
		JourFrSpService ser = new JourFrSpService();
		ser.supprimerJourFrSp(id);
		FacesContext faces = FacesContext.getCurrentInstance();
		faces.addMessage(null, new FacesMessage(
				"Jour férier supprimé avec succès", ""));
		FacesContext context2 = FacesContext.getCurrentInstance();
		context2.getExternalContext().getFlash().setKeepMessages(true);
		try {
			context2.getExternalContext().redirect("GestionJoursFeries");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void modifSp(JourFrSp obj) {
		idjourFrSp = obj.getIdjourFrSp();
		debut = obj.getDebut();
		fin = obj.getFin();
		discSp = obj.getDisc();
		nbjs = obj.getNbjs();
		actionSp = "Modification";
	}

	public void ValidationSp() {
		FacesContext faces = FacesContext.getCurrentInstance();
		RequestContext context = RequestContext.getCurrentInstance();
		boolean addValid = false;

		if (debut == null && fin == null) {
			faces.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"Veuillez donner la date du jour Férier.", ""));
			addValid = false;

		}

		if (discSp == null) {
			faces.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"Veuillez donner la description du jour férier.", ""));
			addValid = false;
		}

		if (faces.getMessageList().size() == 0) {
			JourFrSpService ser = new JourFrSpService();
			JourFrSp jfs = new JourFrSp();
			if (debut != null)
				jfs.setDebut(debut);
			else {
				if (fin != null) {
					jfs.setFin(fin);
					jfs.setDebut(fin);
					jfs.setNbjs(1);
				}
			}
			if (fin != null)
				jfs.setFin(fin);
			else {
				if (debut != null) {
					jfs.setFin(debut);
					jfs.setDebut(debut);
					jfs.setNbjs(1);
				}
			}
			if (debut != null && fin != null)
				jfs.setNbjs(nbJours(debut, fin));
			jfs.setDisc(discSp);

			if (actionSp.equals("Ajout")) {
				if (existeJFrSp(jourFrSps, debut, fin) != null) {
					faces.addMessage(null, new FacesMessage(
							FacesMessage.SEVERITY_ERROR,
							"Jour férier existe déjà!", ""));
					addValid = false;
				} else {
					ser.ajoutJourFrSp(jfs);

					faces.addMessage(null, new FacesMessage(
							FacesMessage.SEVERITY_INFO,
							"Jour férier ajouté avec succès.", ""));
					addValid = true;
					RequestContext.getCurrentInstance().update("f1");
					FacesContext context2 = FacesContext.getCurrentInstance();
					context2.getExternalContext().getFlash()
							.setKeepMessages(true);
					try {
						context2.getExternalContext().redirect(
								"GestionJoursFeries");
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
			} else if (actionSp.equals("Modification")) {

				JourFrSp j = existeJFrSp(jourFrSps, debut, fin);
				if (j == null) {
					jfs.setIdjourFrSp(idjourFrSp);
					ser.modifierJourFrSp(jfs);
					faces.addMessage(null, new FacesMessage(
							FacesMessage.SEVERITY_INFO,
							"Jour férier modifié avec succès.", ""));
					addValid = true;
					RequestContext.getCurrentInstance().update("f1");
					FacesContext context2 = FacesContext.getCurrentInstance();
					context2.getExternalContext().getFlash()
							.setKeepMessages(true);
					try {
						context2.getExternalContext().redirect(
								"GestionJoursFeries");
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				} else {
					if (j.getIdjourFrSp() != idjourFrSp) {
						faces.addMessage(null, new FacesMessage(
								FacesMessage.SEVERITY_ERROR,
								"Jour férier existe déjà!", ""));
						addValid = false;
					} else {
						jfs.setIdjourFrSp(idjourFrSp);
						ser.modifierJourFrSp(jfs);
						faces.addMessage(null, new FacesMessage(
								FacesMessage.SEVERITY_INFO,
								"Jour férier modifié avec succès.", ""));
						addValid = true;
						RequestContext.getCurrentInstance().update("f1");
						FacesContext context2 = FacesContext
								.getCurrentInstance();
						context2.getExternalContext().getFlash()
								.setKeepMessages(true);
						try {
							context2.getExternalContext().redirect(
									"GestionJoursFeries");
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}
					}
				}

				RequestContext.getCurrentInstance().update("f1");
			}
			initialisation();
		}

		index = 1;
		context.addCallbackParam("addValid", addValid);
	}

	@SuppressWarnings("deprecation")
	public JourFrSp existeJFrSp(List<JourFrSp> list, Date deb, Date f) {
		if (deb == null)
			deb = f;
		if (f == null)
			f = deb;
		for (int i = 0; i < list.size(); i++) {
			Date D1 = list.get(i).getDebut();
			Date D2 = list.get(i).getFin();
			if ((D1.getMonth() == deb.getMonth() && D1.getDate() == deb
					.getDate())
					&& (D2.getMonth() == f.getMonth() && D2.getDate() == f
							.getDate()))
				return list.get(i);

		}
		return null;
	}

	public void initialisation() {
		idjourFr = null;
		date = null;
		dateFin = null;
		disc = null;
		discSp = null;
		jj = 0;
		mm = 0;
		nbj = 1;
		nbjs = 1;
		idjourFrSp = null;
		debut = null;
		fin = null;
		actionSp = null;
	}

	public String closeDiag() {
		initialisation();
		return null;
	}

	public void retour() {
		if (destination.equals("RendezVous"))
			try {
				FacesContext.getCurrentInstance().getExternalContext()
						.redirect("Rendez-Vous");
			} catch (Exception e) {
			}

		if (destination.equals("parametrage"))
			try {
				FacesContext.getCurrentInstance().getExternalContext()
						.redirect("Parametrage");
			} catch (Exception e) {
			}
	}

	public void goToAccueil() {

		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("Accueil");
		} catch (Exception e) {
		}
	}

	public void goToGestionJourFr() {
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("GestionJoursFeries");
		} catch (Exception e) {
		}
	}

}

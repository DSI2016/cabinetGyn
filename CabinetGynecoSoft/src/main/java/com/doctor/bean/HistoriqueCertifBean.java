package com.doctor.bean;

import java.io.Serializable;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;

import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

import com.doctor.persistance.Cabinet;
import com.doctor.persistance.Certificat;
import com.doctor.persistance.Cfclient;
import com.doctor.persistance.HistoriqueCertif;
import com.doctor.service.CabinetService;
import com.doctor.service.CertificatService;
import com.doctor.service.CfclientService;
import com.doctor.service.HistoriqueCertifService;

@ManagedBean(name = "historiqueCertifBean")
@SessionScoped
public class HistoriqueCertifBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idHistoriqueCertif;
private String titreDiag;
	private String type1;
	private Integer idPatient;
	private Cfclient cfclient;
	HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
			.getExternalContext().getSession(false);
	
	private String remarques;
	private Integer idCertificat;
	private String motifCertificat;
	private String remarque;
	private String dateCertifPrese;
	private String dateCertifPreseAccomp;
	private String proprietaire="Patiente";
	
	private String nomProprietaire;

	private boolean afficheImp = true;
	private String datereprise;
	private int dureederepos;
	private String adaterdu;
	private String datedelagression;
	private String type;
	private String accompagnant;
	private String lesions;
	private int heurelagr;
	private String dateCertif;
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private int minutelagr;
	private int heuresys;
	private int minutesys;
	private String inapte;
	private String cin;
	private String livreele;
	private String a;
	private String v1;
	private String v3;
	private String v2;
	private String v4;
	private String v5;
	private String v6;
	private String v7;
	private String v8;
	private String v9;
	private String v10;
	private String v11;
	private String v12;
	private String v13;
	private String v14;
	private String v15;
	private String v16;
	private String v17;
	private String v18;
	private String v19;
	private String v20;
	private String v21;
	private String v22;
	private String v23;
	private String v24;
	private String v25;
	private String v26;
	private String v27;
	private String v28;
	private String v29;
	private String v30;
	private String v31;
	private String ancienValeurlivreele;
	private boolean blocage = false;
	private String valueOnclik;
	// private String action;
	private String ancientext;
	private HistoriqueCertif selectedCertif;
	public String ancienValeurDateCertif;

	private String AncienValeurAdater;
	private String ancienValeurdatereprise;

	private List<HistoriqueCertif> historiqueCertifs = new ArrayList<HistoriqueCertif>();
	private List<String> types = new ArrayList<String>();

	public List<HistoriqueCertif> getHistoriqueCertifs() {
		HistoriqueCertifService ser = new HistoriqueCertifService();
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		Integer idpatient = (Integer) session.getAttribute("idu");

		historiqueCertifs = ser
				.rechercheTousHistoriqueCertifByPatient(idpatient);
		return historiqueCertifs;
	}
@PostConstruct
	public void init ()
	{
		HttpSession session = (HttpSession) FacesContext
				.getCurrentInstance().getExternalContext()
				.getSession(false);
		idPatient=(Integer) session.getAttribute("idu");
		cfclient=new CfclientService().RechercheCfclientSansjointure(idPatient);
	nomProprietaire="Mme"+cfclient.getPrenom()+" "+cfclient.getNom();
	}
	
	public void setHistoriqueCertifs(List<HistoriqueCertif> historiqueCertifs) {
		this.historiqueCertifs = historiqueCertifs;
	}

	public List<String> getTypes() {
		types.clear();
		types.add(new String("Repos"));
		types.add(new String("Prolongation de repos"));
		types.add(new String("Repos CNSS"));
		return types;
	}

	public String getDateCertif() {
		return dateCertif;
	}

	public void setDateCertif(String dateCertif) {
		this.dateCertif = dateCertif;
	}

	public void setTypes(List<String> types) {
		this.types = types;
	}

	public String getRemarques() {
		return remarques;
	}

	public void setRemarques(String remarques) {

		this.remarques = remarques;
	}

	public String getInapte() {
		return inapte;
	}

	public void setInapte(String inapte) {
		this.inapte = inapte;
	}

	public String getDatereprise() {
		return datereprise;
	}

	public void setDatereprise(String datereprise) {

		this.datereprise = datereprise;
	}

	public void verifierDate() {
		setDateCertif(dateCertif);
	}

	public String getAdaterdu() {
		return adaterdu;
	}

	public void setAdaterdu(String adaterdu) {
		this.adaterdu = adaterdu;
	}

	public String getDatedelagression() {
		return datedelagression;
	}

	public void setDatedelagression(String datedelagression) {
		this.datedelagression = datedelagression;
	}

	public Integer getIdHistoriqueCertif() {
		return idHistoriqueCertif;
	}

	public HistoriqueCertif getSelectedCertif() {
		return selectedCertif;
	}

	public void setSelectedCertif(HistoriqueCertif selectedCertif) {
		this.selectedCertif = selectedCertif;
	}

	public void setIdHistoriqueCertif(Integer idHistoriqueCertif) {
		this.idHistoriqueCertif = idHistoriqueCertif;
	}

	public Integer getIdPatient() {
		return idPatient;
	}

	public void setIdPatient(Integer idPatient) {
		this.idPatient = idPatient;
	}

	public Cfclient getCfclient() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");
		CfclientService se = new CfclientService();
		cfclient = se.RechercheCfclient(idPatient);

		return cfclient;
	}

	public void setCfclient(Cfclient cfclient) {
		this.cfclient = cfclient;
	}

	public Integer getIdCertificat() {
		return idCertificat;
	}

	public void setIdCertificat(Integer idCertificat) {
		this.idCertificat = idCertificat;
	}

	public String getMotifCertificat() {
		return motifCertificat;
	}

	public void setMotifCertificat(String motifCertificat) {
		this.motifCertificat = motifCertificat;
	}

	public String getRemarque() {
		return remarque;
	}

	public void setRemarque(String remarque) {

		this.remarque = remarque;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAccompagnant() {
		return accompagnant;
	}

	public void setAccompagnant(String accompagnant) {
		this.accompagnant = accompagnant;
	}

	public String getLesions() {
		return lesions;
	}

	public void setLesions(String lesions) {
		this.lesions = lesions;
	}

	public int getHeurelagr() {
		return heurelagr;
	}

	public void setHeurelagr(int heurelagr) {
		this.heurelagr = heurelagr;
	}

	public int getHeuresys() {
		return heuresys;
	}

	public void setHeuresys(int heuresys) {
		this.heuresys = heuresys;
	}

	public int getDureederepos() {
		return dureederepos;
	}

	public void setDureederepos(int dureederepos) {
		this.dureederepos = dureederepos;
	}

	public int getMinutelagr() {
		return minutelagr;
	}

	public void setMinutelagr(int minutelagr) {
		this.minutelagr = minutelagr;
	}

	public int getMinutesys() {
		return minutesys;
	}

	public void setMinutesys(int minutesys) {
		this.minutesys = minutesys;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getLivreele() {
		return livreele;
	}

	public void setLivreele(String livreele) {
		this.livreele = livreele;
	}

	public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a;
	}

	public String getV1() {
		return v1;
	}

	public void setV1(String v1) {
		this.v1 = v1;
	}

	public String getV3() {
		return v3;
	}

	public void setV3(String v3) {
		this.v3 = v3;
	}

	public String getV2() {
		return v2;
	}

	public void setV2(String v2) {
		this.v2 = v2;
	}

	public String getV4() {
		return v4;
	}

	public void setV4(String v4) {
		this.v4 = v4;
	}

	public String getV5() {
		return v5;
	}

	public void setV5(String v5) {
		this.v5 = v5;
	}

	public String getV6() {
		return v6;
	}

	public void setV6(String v6) {
		this.v6 = v6;
	}

	public String getV7() {
		return v7;
	}

	public void setV7(String v7) {
		this.v7 = v7;
	}

	public String getV8() {
		return v8;
	}

	public void setV8(String v8) {
		this.v8 = v8;
	}

	public String getV9() {
		return v9;
	}

	public void setV9(String v9) {
		this.v9 = v9;
	}

	public String getV10() {
		return v10;
	}

	public void setV10(String v10) {
		this.v10 = v10;
	}

	public String getV11() {
		return v11;
	}

	public void setV11(String v11) {
		this.v11 = v11;
	}

	public String getV12() {
		return v12;
	}

	public void setV12(String v12) {
		this.v12 = v12;
	}

	public String getV13() {
		return v13;
	}

	public void setV13(String v13) {
		this.v13 = v13;
	}

	public String getV14() {
		return v14;
	}

	public void setV14(String v14) {
		this.v14 = v14;
	}

	public String getV15() {
		return v15;
	}

	public void setV15(String v15) {
		this.v15 = v15;
	}

	public String getV16() {
		return v16;
	}

	public void setV16(String v16) {
		this.v16 = v16;
	}

	public String getV17() {
		return v17;
	}

	public void setV17(String v17) {
		this.v17 = v17;
	}

	public String getV18() {
		return v18;
	}

	public void setV18(String v18) {
		this.v18 = v18;
	}

	public String getV19() {
		return v19;
	}

	public void setV19(String v19) {
		this.v19 = v19;
	}

	public String getV20() {
		return v20;
	}

	public void setV20(String v20) {
		this.v20 = v20;
	}

	public String getV21() {
		return v21;
	}

	public void setV21(String v21) {
		this.v21 = v21;
	}

	public String getV22() {
		return v22;
	}

	public void setV22(String v22) {
		this.v22 = v22;
	}

	public String getV23() {
		return v23;
	}

	public void setV23(String v23) {
		this.v23 = v23;
	}

	public String getV24() {
		return v24;
	}

	public void setV24(String v24) {
		this.v24 = v24;
	}

	public String getV25() {
		return v25;
	}

	public void setV25(String v25) {
		this.v25 = v25;
	}

	public String getV26() {
		return v26;
	}

	public void setV26(String v26) {
		this.v26 = v26;
	}

	public String getV27() {
		return v27;
	}

	public void setV27(String v27) {
		this.v27 = v27;
	}

	public String getV28() {
		return v28;
	}

	public void setV28(String v28) {
		this.v28 = v28;
	}

	public String getV29() {
		return v29;
	}

	public void setV29(String v29) {
		this.v29 = v29;
	}

	public String getV30() {
		return v30;
	}

	public void setV30(String v30) {
		this.v30 = v30;
	}

	public String getV31() {
		return v31;
	}

	public void setV31(String v31) {
		this.v31 = v31;
	}

	private String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public void supressionCertif(HistoriqueCertif hist) {
		idHistoriqueCertif = hist.getIdHistoriqueCertif();
		selectedCertif = hist;

		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String dateH = "";
		if (hist.getDateCertif() != null)
			dateH = "du " + formatter.format(hist.getDateCertif());
		msg = "Voulez-vous vraiment supprimer la certificat " + dateH + " ?";

		RequestContext.getCurrentInstance().update("f1:sup");
		RequestContext context = RequestContext.getCurrentInstance();
		context.execute("PF('suppCert').show();");
	}

	public void supprimerCertif() {
		HistoriqueCertifService ser = new HistoriqueCertifService();
		ser.supprimerHistoriqueCertif(idHistoriqueCertif);
		FacesContext face = FacesContext.getCurrentInstance();
		blocage = false;
		face.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "",
				"Certificat Supprimé Avec succées"));
		intialecertif();
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getFlash().setKeepMessages(true);
		try {
			context.getExternalContext().redirect("Certificats");

		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
	}

	public void onRowSelectcertif(SelectEvent event) {
		/*
		 * try { FacesContext.getCurrentInstance().getExternalContext()
		 * .redirect("ListeCertiff.xhtml"); } catch (Exception e) { }
		 */
		HistoriqueCertif c = (HistoriqueCertif) event.getObject();

		remarque = c.getRemarque();
		idHistoriqueCertif = c.getIdHistoriqueCertif();
		cfclient = c.getCfclient();
		motifCertificat = c.getCertificat().getNomCertificat();
		ancientext = remarque;
		afficheImp = false;
	}

	public void ModifierCertif() {
		HistoriqueCertifService ser = new HistoriqueCertifService();
		HistoriqueCertif cert = ser
				.rechercheHistoriqueCertif(idHistoriqueCertif);

		cert.setCfclient(cfclient);

		try {
			cert.setDateCertif(sdf.parse(dateCertif));

			cert.setA(a);
			cert.setAccompagnant(accompagnant);
			cert.setLivreele(livreele);
			cert.setCin(cin);
			cert.setDureederepos(dureederepos);
			cert.setDatereprise(sdf.parse(datereprise));
			cert.setAdaterdu(sdf.parse(adaterdu));
			cert.setType(type1);
			cert.setLesions(lesions);
			cert.setDatedelagression(sdf.parse(datedelagression));
			cert.setHeurelagr(heurelagr);
			cert.setMinutelagr(minutelagr);
			cert.setHeuresys(heuresys);
			cert.setMinutesys(minutesys);
			cert.setInapte(inapte);
			cert.setRemarques(remarques);
			ser.modifierHistoriqueCertif(cert);
			FacesContext face = FacesContext.getCurrentInstance();
			blocage = false;
			face.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"", "Certificat Modifiée Avec succées"));
		} catch (ParseException e) {

			e.printStackTrace();
		}
	}

	public String remplaceMot(String sonTexte, String txtFind, String txtReplace) {
		String tmp;

		int lgFind = txtFind.length();
		if ((sonTexte != null) && (txtFind != null) && (txtReplace != null)) {
			int lgReplace = txtReplace.length();
			if (txtReplace != null) {
				for (int k = 0; k < (sonTexte.length() - lgFind); k++) {
					try {
						tmp = sonTexte.substring(k, k + lgFind);
					} catch (Exception e) {
						break;
					}
					if (tmp.equalsIgnoreCase(txtFind)) {
						sonTexte = sonTexte.substring(0, k)
								+ txtReplace
								+ sonTexte.substring(k + lgFind,
										sonTexte.length());
						k = k + lgReplace;
					}
				}
			}

			return (sonTexte);

		} else
			return (" ");

	}

	public String intialeTextCertificats() {

		Certificat certif = new Certificat();
		CertificatService ser = new CertificatService();
		certif = ser.rechercheCertificatParLibelleCertificat(motifCertificat);
		String rem = certif.getRemarque();

		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");
		CfclientService se = new CfclientService();
		cfclient = se.RechercheCfclient(idPatient);
		Cabinet cab = new Cabinet();
		CabinetService serCabinet = new CabinetService();
		cab = serCabinet.rechercheTousCabinet().get(0);
		if (livreele != null) {
			rem = remplaceMot(rem, "$livreele", livreele);// remplaser $livree

		} else
			rem = remplaceMot(rem, "$livreele", "");
		if (cfclient != null) {
			if (nomProprietaire!=null)
				rem = remplaceMot(rem, "$NP", nomProprietaire);
			else
				rem = remplaceMot(rem, "$NP", "");
		}
		if (cab.getDocteur() != null)
			rem = remplaceMot(rem, "$Docteur", cab.getDocteur());
		else
			rem = remplaceMot(rem, "$Docteur", "");
		if (cin != null)
			rem = remplaceMot(rem, "$Cin", cin);
		else
			rem = remplaceMot(rem, "$Cin", "");
		if (a != null)
			rem = remplaceMot(rem, "$Lieu", a);
		else
			rem = remplaceMot(rem, "$Lieu", "");
		if (dureederepos != 0)
			rem = remplaceMot(rem, "$DRP", dureederepos + "");
		else
			rem = remplaceMot(rem, "$DRP", "");
		if (adaterdu != null) {
			// Format formatter2 = new SimpleDateFormat("dd/MM/yyyy");
			// String l2 = formatter2.format(adaterdu);
			rem = remplaceMot(rem, "$ADate", adaterdu);
		} else
			rem = remplaceMot(rem, "$ADate", "");
		if (type1 != null)
			rem = remplaceMot(rem, "$Type", type1);
		else
			rem = remplaceMot(rem, "$Type", "");
		if (dateCertif != null) {
			// Format formatter3 = new SimpleDateFormat("dd/MM/yyyy");
			// String l3 = formatter3.format(dateCertif);
			rem = remplaceMot(rem, "$Datec", dateCertif);

		} else
			rem = remplaceMot(rem, "$Datec", "");
		if (accompagnant != null) {
			rem = remplaceMot(rem, "$accompagnant", accompagnant);
		} else
			rem = remplaceMot(rem, "$accompagnant", "");
		if (datereprise != null) {
			// Format formatter = new SimpleDateFormat("dd/MM/yyyy");
			// String reprise = formatter.format(datereprise);
			rem = remplaceMot(rem, "$Dreprise", datereprise);
		} else
			rem = remplaceMot(rem, "$Dreprise", "");

		if (lesions != null) {
			rem = remplaceMot(rem, "$Lesions", lesions);
		} else
			rem = remplaceMot(rem, "$Lesions", "");
		if (inapte != null) {
			rem = remplaceMot(rem, "$Inapte", inapte);
		}
		rem = remplaceMot(rem, "$Inapte", "");
		if (remarques != null) {
			rem = remplaceMot(rem, "$remarque", remarques);
		} else
			rem = remplaceMot(rem, "$remarque", "");
		if (datedelagression != null) {
			// Format formatter1 = new SimpleDateFormat("dd/MM/yyyy");
			// String ddg = formatter1.format(datedelagression);
			rem = remplaceMot(rem, "$DAgr", datedelagression);
		} else
			rem = remplaceMot(rem, "$DAgr", "");
		if (heurelagr != 0) {
			rem = remplaceMot(rem, "$HAgr", heurelagr + "");
		} else
			rem = remplaceMot(rem, "$HAgr", "");
		if (minutelagr != 0) {
			rem = remplaceMot(rem, "$MAgr", minutelagr + "");
		} else
			rem = remplaceMot(rem, "$MAgr", "");
		if (heuresys != 0) {
			rem = remplaceMot(rem, "$HSys", heuresys + "");
		} else
			rem = remplaceMot(rem, "$HSys", "");
		if (minutesys != 0) {
			rem = remplaceMot(rem, "$MSys", minutesys + "");
		} else
			rem = remplaceMot(rem, "$MSys", "");
		return (rem);
	}

	public void ajoutCertifMariage() throws SQLException, Exception {
		boolean addValid = false;
		FacesContext face = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");
		HistoriqueCertif cert = new HistoriqueCertif();

		CfclientService se = new CfclientService();
		cfclient = se.RechercheCfclient(idPatient);
		cert.setCfclient(cfclient);

		if ((dateCertif == null) || (dateCertif.length() == 0)) {
			blocage = true;
			face.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Veuillez saisi le date du certificat", ""));
			addValid = false;

		}
		if ((dateCertif != null) && (dateCertif.length() != 0)) {
			if (Module.corigerDate(dateCertif) != null) {
				this.setDateCertif(Module.corigerDate(dateCertif));
			}

			if ((Module.verifierDate(dateCertif).equals("")) == false)

			{
				blocage = true;
				face.addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "",
								"Le date de certificat "
										+ Module.verifierDate(dateCertif)));
				addValid = false;

			} else {
				try {
					addValid = true;
					cert.setDateCertif(sdf.parse(dateCertif));
				} catch (ParseException e) {

					e.printStackTrace();
				}
			}

		}

		// verification de livree le
		if (Module.corigerDate(livreele) != null) {
			this.setLivreele(Module.corigerDate(livreele));
		}
		// verification de livrele
		if ((livreele == null) || (livreele.length() == 0)) {
			blocage = true;
			face.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Veuillez saisi le date du livraison", ""));
			addValid = false;

		}
		if ((Module.verifierDate(livreele).equals("") == false))

		{
			blocage = true;
			face.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"", "Le date du livraison" + Module.verifierDate(livreele)));
			addValid = false;

			// livreele = ancienValeurlivreele;
		} else {
			// ancienValeurlivreele = livreele;
			cert.setLivreele(livreele);
			addValid = true;
		}

		// verification de cin
		if ((cin == null) || (cin.length() == 0)) {
			blocage = true;
			face.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Veuillez saisi la cin", ""));
			addValid = false;

		}
		if ((cin != null) && (cin.length() != 0)) {
			if ((cin.length() != 8) || (Module.isNumeric(cin) == false)) {
				blocage = true;
				addValid = false;
				face.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_ERROR, "",
						"Numero de cin invalide"));

			}
		}

		if (face.getMessageList().size() == 0) {
			cert.setNomProprietaire(nomProprietaire);
			addValid = true;
			cert.setDateCertif(sdf.parse(dateCertif));
			cert.setA(a);
			cert.setRemarques(remarques);

			cert.setRemarque(remarque);
			cert.setCin(cin);
			Certificat c = new CertificatService()
					.rechercheCertifParMotif(motifCertificat);
			cert.setCertificat(c);
			if (c != null) {
				if (c.getRemarque() != null) {
					String textelettre = c.getRemarque();
					textelettre = intialeTextCertificats();
					cert.setRemarque(textelettre);
				}
			}
			if (action.equals("Ajout")) {

				HistoriqueCertifService serc = new HistoriqueCertifService();
				serc.ajoutHistoriqueCertif(cert);
				selectedCertif = cert;
				afficheImp = false;
				addValid = true;
				blocage = false;
				face.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_INFO, "",
						"Certificat ajoutée Avec succès"));

				selectedCertif = cert;
				remarque = cert.getRemarque();
				// }
			}

			if (action.equals("Modification")) {

				HistoriqueCertifService serc = new HistoriqueCertifService();
				cert.setIdHistoriqueCertif(idHistoriqueCertif);
				serc.modifierHistoriqueCertif(cert);
				selectedCertif = cert;
				afficheImp = false;
				addValid = true;
				blocage = false;
				face.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_INFO, "",
						"Certificat modifiée avec succès"));
				remarque = cert.getRemarque();

			}
		}
		intialecertif();
		RequestContext context = RequestContext.getCurrentInstance();
		context.addCallbackParam("addValid", addValid);

	}

	public void verifierDatePresence() {
		setDateCertifPrese(dateCertifPrese);
	}

	public void ajoutCertifRepos() throws SQLException, Exception {

		boolean addValid = false;
		FacesContext face = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");
		HistoriqueCertif cert = new HistoriqueCertif();

		CfclientService se = new CfclientService();
		cfclient = se.RechercheCfclient(idPatient);
		if ((dateCertif == null) || (dateCertif.equals(""))) {
			blocage = true;
			face.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"", "Veuillez saisi le date de cetificat"));
			addValid = false;

		}
		if ((adaterdu == null) || (adaterdu.equals(""))) {
			blocage = true;
			face.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"", "Veuillez saisi le date adater du"));
			addValid = false;

		}
		if ((type == null) || (type.equals(""))) {
			blocage = true;
			face.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"", "Veuillez selectioner le type"));
			addValid = false;

		}

		// verification de date certif
		if ((dateCertif != null) && (dateCertif.length() != 0)) {
			if (Module.corigerDate(dateCertif) != null) {
				this.setDateCertif(Module.corigerDate(dateCertif));
			}
			if ((Module.verifierDate(dateCertif).equals("")) == false)

			{
				blocage = true;
				face.addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "",
								"Le date de certificat "
										+ Module.verifierDate(dateCertif)));
				addValid = false;

			} else {
				try {
					cert.setDateCertif(sdf.parse(dateCertif));
				} catch (ParseException e) {

					e.printStackTrace();
				}
			}

		}

		if ((adaterdu != null) && (adaterdu.length() != 0)) {
			if (Module.corigerDate(adaterdu) != null) {
				this.setAdaterdu(Module.corigerDate(adaterdu));
			}
			if ((Module.verifierDate(adaterdu).equals("")) == false)

			{
				blocage = true;
				face.addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "",
								"a dater du " + Module.verifierDate(adaterdu)));
				addValid = false;

			} else {
				try {
					cert.setAdaterdu(sdf.parse(adaterdu));
				} catch (ParseException e) {

					e.printStackTrace();
				}
			}
		}

		if (face.getMessageList().size() == 0) {
			cert.setNomProprietaire(nomProprietaire);
			cert.setDureederepos(dureederepos);
			cert.setType(type1);

			Certificat c = new CertificatService()
					.rechercheCertifParMotif(motifCertificat);
			cert.setCertificat(c);
			cert.setRemarque(remarque);
			if (c != null)
				if (c.getRemarque() != null) {
					String textelettre = c.getRemarque();
					textelettre = intialeTextCertificats();
					cert.setRemarque(textelettre);
				}
			cert.setCfclient(cfclient);
			if (action.equals("Ajout")) {
				HistoriqueCertifService serc = new HistoriqueCertifService();
				serc.ajoutHistoriqueCertif(cert);
				face.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_INFO, "",
						"Certificat ajoutée avec succès"));

				afficheImp = false;
				addValid = true;
				blocage = false;

				selectedCertif = cert;
				remarque = cert.getRemarque();

			}

			if (action.equals("Modification")) {

				HistoriqueCertifService serc = new HistoriqueCertifService();
				cert.setIdHistoriqueCertif(idHistoriqueCertif);
				serc.modifierHistoriqueCertif(cert);
				selectedCertif = cert;

				blocage = false;
				face.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_INFO, "",
						"Certificat modifiée avec succès"));
				afficheImp = false;
				addValid = true;
				blocage = false;

				selectedCertif = cert;
				remarque = cert.getRemarque();
			}
		}

		RequestContext context = RequestContext.getCurrentInstance();
		context.addCallbackParam("addValid", addValid);
		intialecertif();
	}

	public void ajoutCertifPresence() throws SQLException, Exception {
		FacesContext faces = FacesContext.getCurrentInstance();
		RequestContext context = RequestContext.getCurrentInstance();

		boolean addValid = false;
		HistoriqueCertif cert = new HistoriqueCertif();
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");
		CfclientService se = new CfclientService();
		cfclient = se.RechercheCfclient(idPatient);
		cert.setCfclient(cfclient);
		FacesContext face = FacesContext.getCurrentInstance();
		if ((dateCertifPrese == null) || (dateCertifPrese.length() == 0)) {
			blocage = true;
			face.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Veuillez saisi le date du certificat", ""));
			addValid = false;

		}
		if ((dateCertifPrese != null) && (dateCertifPrese.length() != 0)) {
			if (Module.corigerDate(dateCertifPrese) != null) {
				this.setDateCertifPrese(Module.corigerDate(dateCertifPrese));
			}

			if ((Module.verifierDate(dateCertifPrese).equals("")) == false)

			{
				blocage = true;
				face.addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "",
								"Le date de certificat "
										+ Module.verifierDate(dateCertifPrese)));
				addValid = false;

			} else {
				try {
					addValid = true;
					cert.setDateCertif(sdf.parse(dateCertifPrese));
				} catch (ParseException e) {

					e.printStackTrace();
				}
			}

		}

		if (face.getMessageList().size() == 0) {
			cert.setNomProprietaire(nomProprietaire);
			addValid = true;

			Certificat c = new CertificatService()
					.rechercheCertifParMotif(motifCertificat);
			cert.setCertificat(c);
			//
			// cert.setDateCertif(sdf.parse(dateCertif));
			cert.setRemarque(remarque);
			if (c != null)
				if (c.getRemarque() != null) {
					String textelettre = c.getRemarque();
					textelettre = intialeTextCertificats();
					cert.setRemarque(textelettre);
				}

			if (action.equals("Ajout")) {
				HistoriqueCertifService serc = new HistoriqueCertifService();
				serc.ajoutHistoriqueCertif(cert);
				faces.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_ERROR,
						"Certificat ajouté avec succès.", ""));

				selectedCertif = cert;
				afficheImp = false;
				remarque = cert.getRemarque();

			}
			if (action.equals("Modification")) {

				HistoriqueCertifService serc = new HistoriqueCertifService();
				cert.setIdHistoriqueCertif(idHistoriqueCertif);
				serc.modifierHistoriqueCertif(cert);
				faces.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_ERROR,
						"Certificat modifié avec succès.", ""));
				addValid = true;
				selectedCertif = cert;
				afficheImp = false;
				remarque = cert.getRemarque();
				RequestContext.getCurrentInstance().update("f1");
			}
		}

		context.addCallbackParam("addValid", addValid);
		intialecertif();
	}

	public void ajoutCertifPresenceAcompgnement() throws SQLException,
			Exception {

		FacesContext face = FacesContext.getCurrentInstance();
		RequestContext context = RequestContext.getCurrentInstance();

		boolean addValid = false;
		HistoriqueCertif cert = new HistoriqueCertif();
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");
		CfclientService se = new CfclientService();
		cfclient = se.RechercheCfclient(idPatient);
		if ((dateCertifPreseAccomp == null)
				|| (dateCertifPreseAccomp.equals(""))) {
			blocage = true;
			face.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"", "Veuillez saisi le date de cetificat"));
			addValid = false;

		}

		if ((dateCertifPreseAccomp != null)
				&& (dateCertifPreseAccomp.length() != 0)) {
			if (Module.corigerDate(dateCertifPreseAccomp) != null) {
				this.setDateCertifPreseAccomp(Module
						.corigerDate(dateCertifPreseAccomp));
			}
			if ((Module.verifierDate(dateCertifPreseAccomp).equals("")) == false)

			{
				blocage = true;
				face.addMessage(
						null,
						new FacesMessage(
								FacesMessage.SEVERITY_ERROR,
								"",
								"Le date du certificat "
										+ Module.verifierDate(dateCertifPreseAccomp)));
				addValid = false;

			} else {

				try {
					addValid = true;
					cert.setDateCertif(sdf.parse(dateCertifPreseAccomp));
				} catch (ParseException e) {

					e.printStackTrace();
				}
			}
		}

		if (face.getMessageList().size() == 0) {
			cert.setNomProprietaire(nomProprietaire);
			cert.setCfclient(cfclient);

			Certificat c = new CertificatService()

			.rechercheCertifParMotif(motifCertificat);
			cert.setAccompagnant(accompagnant);
			cert.setCertificat(c);
			if (c != null) {
				if (c.getRemarque() != null) {
					String textelettre = c.getRemarque();
					textelettre = intialeTextCertificats();
					cert.setRemarque(textelettre);
				}
			}
			if (action != null || (action.length() == 0)) {
				if (action.equals("Ajout")) {

					HistoriqueCertifService serc = new HistoriqueCertifService();
					serc.ajoutHistoriqueCertif(cert);
					face.addMessage(null, new FacesMessage(
							FacesMessage.SEVERITY_ERROR,
							"Certificat ajouté avec succès.", ""));

					addValid = true;
					selectedCertif = cert;
					afficheImp = false;
					remarque = cert.getRemarque();

				}
				if (action.equals("Modification")) {

					HistoriqueCertifService serc = new HistoriqueCertifService();
					cert.setIdHistoriqueCertif(idHistoriqueCertif);
					serc.modifierHistoriqueCertif(cert);
					face.addMessage(null, new FacesMessage(
							FacesMessage.SEVERITY_ERROR,
							"Certificat modifié avec succès.", ""));

					addValid = true;
					selectedCertif = cert;
					afficheImp = false;
					remarque = cert.getRemarque();

				}
			}

		}
		context.addCallbackParam("addValid", addValid);
		intialecertif();
	}

	public void gotoAcceuil() {
		afficheImp = true;
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("Accueil");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void ajoutCertifReposAccomp() throws SQLException, Exception {
		boolean addValid = false;
		FacesContext face = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");
		HistoriqueCertif cert = new HistoriqueCertif();

		CfclientService se = new CfclientService();
		cfclient = se.RechercheCfclient(idPatient);
		if ((dateCertif == null) || (dateCertif.equals(""))) {
			blocage = true;
			face.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"", "Veuillez saisi le date de cetificat"));
			addValid = false;

		}
		if ((adaterdu == null) || (adaterdu.equals(""))) {
			blocage = true;
			face.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"", "Veuillez saisi le date adater du"));
			addValid = false;

		}
		if ((type == null) || (type.equals(""))) {
			blocage = true;
			face.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"", "Veuillez selectioner le type"));
			addValid = false;

		}
		if ((accompagnant == null) || (accompagnant.equals(""))) {
			blocage = true;
			face.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"", "Veuillez saisi le nom d'accompagnement"));
			addValid = false;

		}

		// verification de date certif
		if ((dateCertif != null) && (dateCertif.equals("") == false)) {

			if (Module.corigerDate(dateCertif) != null) {
				this.setDateCertif(Module.corigerDate(dateCertif));
			}
			if ((Module.verifierDate(dateCertif).equals("")) == false)

			{
				blocage = true;
				face.addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "",
								"Le date du certificat "
										+ Module.verifierDate(dateCertif)));
				addValid = false;

			} else {
				try {
					cert.setDateCertif(sdf.parse(dateCertif));
				} catch (ParseException e) {

					e.printStackTrace();
				}

			}
		}
		if ((adaterdu != null) && (adaterdu.equals("") == false)) {
			if (Module.corigerDate(adaterdu) != null) {
				this.setAdaterdu(Module.corigerDate(adaterdu));
			}
			if ((Module.verifierDate(adaterdu).equals("")) == false)

			{
				blocage = true;
				face.addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "",
								"a dater du " + Module.verifierDate(dateCertif)));
				addValid = false;

			} else {
				try {
					cert.setAdaterdu(sdf.parse(adaterdu));
				} catch (ParseException e) {

					e.printStackTrace();
				}
			}
		}
		if (face.getMessageList().size() == 0) {
			cert.setNomProprietaire(nomProprietaire);
			cert.setDureederepos(dureederepos);
			cert.setType(type1);
			cert.setAccompagnant(accompagnant);

			Certificat c = new CertificatService()
					.rechercheCertifParMotif(motifCertificat);
			cert.setCertificat(c);
			cert.setAccompagnant(accompagnant);
			cert.setRemarque(remarque);
		
			if (c != null)
				if (c.getRemarque() != null) {
					String textelettre = c.getRemarque();
					textelettre = intialeTextCertificats();
					cert.setRemarque(textelettre);
				}
			cert.setCfclient(cfclient);
			if (action.equals("Ajout")) {
				HistoriqueCertifService serc = new HistoriqueCertifService();
				serc.ajoutHistoriqueCertif(cert);
				face.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_INFO, "",
						"Certificat ajoutée avec succès"));

				afficheImp = false;
				addValid = true;
				blocage = false;

				selectedCertif = cert;
				remarque = cert.getRemarque();

			}

			if (action.equals("Modification")) {

				HistoriqueCertifService serc = new HistoriqueCertifService();
				cert.setIdHistoriqueCertif(idHistoriqueCertif);
				serc.modifierHistoriqueCertif(cert);
				selectedCertif = cert;

				blocage = false;
				face.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_INFO, "",
						"Certificat modifiée avec succès"));
				afficheImp = false;
				addValid = true;
				blocage = false;

				selectedCertif = cert;
				remarque = cert.getRemarque();
			}
		}

		RequestContext context = RequestContext.getCurrentInstance();
		context.addCallbackParam("addValid", addValid);
		intialecertif();
	}

	public void ajoutCertifGuerision() throws SQLException, Exception {

		FacesContext face = FacesContext.getCurrentInstance();
		RequestContext context = RequestContext.getCurrentInstance();
		boolean addValid = false;
		HistoriqueCertif cert = new HistoriqueCertif();
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");
		CfclientService se = new CfclientService();
		cfclient = se.RechercheCfclient(idPatient);
		cert.setCfclient(cfclient);
		if ((dateCertif == null) || (dateCertif.equals(""))) {
			blocage = true;
			face.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"", "Veuillez saisi le date de cetificat"));
			addValid = false;

		}

		// verification de date certif
		if ((dateCertif != null) && (dateCertif.length() != 0)) {

			if (Module.corigerDate(dateCertif) != null) {
				this.setDateCertif(Module.corigerDate(dateCertif));
			}
			if ((Module.verifierDate(dateCertif).equals("")) == false)

			{
				blocage = true;
				face.addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "",
								"Le date du certificat "
										+ Module.verifierDate(dateCertif)));
				addValid = false;

			} else {
				try {
					cert.setDateCertif(sdf.parse(dateCertif));
				} catch (ParseException e) {

					e.printStackTrace();
				}

			}
		}

		// verification de date certif
		if ((datereprise != null) && (datereprise.equals("") == false)) {

			if (Module.corigerDate(datereprise) != null) {
				this.setDatereprise(Module.corigerDate(datereprise));
			}
			if ((Module.verifierDate(datereprise).equals("")) == false)

			{
				blocage = true;
				face.addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "",
								"Le date du certificat "
										+ Module.verifierDate(datereprise)));
				addValid = false;

			} else {
				try {
					cert.setDatereprise(sdf.parse(datereprise));
				} catch (ParseException e) {

					e.printStackTrace();
				}

			}
		} else {
			blocage = true;
			face.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"", "Veuillez saisi le date de reprise"));
			addValid = false;

		}

		if (face.getMessageList().size() == 0) {
			cert.setNomProprietaire(nomProprietaire);
			Certificat c = new CertificatService()
					.rechercheCertifParMotif(motifCertificat);
			cert.setCertificat(c);
			if (c != null)
				if (c.getRemarque() != null) {
					String textelettre = c.getRemarque();
					textelettre = intialeTextCertificats();
					cert.setRemarque(textelettre);
				}
			if (action.equals("Ajout")) {
				HistoriqueCertifService serc = new HistoriqueCertifService();
				serc.ajoutHistoriqueCertif(cert);

				// impression
				blocage = false;
				face.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_INFO, "",
						"Certificat ajoutée avec succès"));
				afficheImp = false;
				addValid = true;
				blocage = false;

				selectedCertif = cert;
				remarque = cert.getRemarque();

			}
			if (action.equals("Modification")) {

				HistoriqueCertifService serc = new HistoriqueCertifService();
				cert = serc.rechercheHistoriqueCertif(idHistoriqueCertif);

				serc.modifierHistoriqueCertif(cert);
				blocage = false;
				face.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_INFO, "",
						"Certificat modifiée avec succès"));
				afficheImp = false;
				addValid = true;
				blocage = false;

				selectedCertif = cert;
				remarque = cert.getRemarque();

			}
		}
		context.addCallbackParam("addValid", addValid);
		intialecertif();

	}

	public void ajoutCertifCoups() throws SQLException, Exception {
		FacesContext face = FacesContext.getCurrentInstance();
		RequestContext context = RequestContext.getCurrentInstance();
		boolean addValid = false;
		HistoriqueCertif cert = new HistoriqueCertif();
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");
		CfclientService se = new CfclientService();
		cfclient = se.RechercheCfclient(idPatient);
		cert.setCfclient(cfclient);

		if (Module.corigerDate(dateCertif) != null) {
			this.setDateCertif(Module.corigerDate(dateCertif));
		}
		if ((Module.verifierDate(dateCertif).equals("")) == false)

		{
			blocage = true;
			face.addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "",
							"Le date du certificat "
									+ Module.verifierDate(dateCertif)));
			addValid = false;

		} else {
			try {
				cert.setDateCertif(sdf.parse(dateCertif));
			} catch (ParseException e) {

				e.printStackTrace();
			}

		}

		if (Module.corigerDate(adaterdu) != null) {
			this.setAdaterdu(Module.corigerDate(adaterdu));
		}
		if ((Module.verifierDate(adaterdu).equals("")) == false)

		{
			blocage = true;
			face.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"", "a dater " + Module.verifierDate(dateCertif)));
			addValid = false;

		} else {
			try {
				cert.setAdaterdu(sdf.parse(adaterdu));
			} catch (ParseException e) {

				e.printStackTrace();
			}
		}

		if (Module.corigerDate(datedelagression) != null) {
			this.setDatedelagression(Module.corigerDate(datedelagression));
		}
		if ((Module.verifierDate(datedelagression).equals("")) == false)

		{
			blocage = true;
			face.addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "",
							"Le date de l'agression "
									+ Module.verifierDate(datedelagression)));
			addValid = false;

		} else {
			try {
				cert.setDatedelagression(sdf.parse(datedelagression));
			} catch (ParseException e) {

				e.printStackTrace();
			}

		}

		if (face.getMessageList().size() == 0) {
			cert.setNomProprietaire(nomProprietaire);

			addValid = true;
			cert.setHeuresys(heuresys);
			cert.setMinutesys(minutesys);

			cert.setHeurelagr(heurelagr);
			cert.setMinutelagr(minutelagr);

			cert.setDureederepos(dureederepos);
			cert.setLesions(lesions);

			Certificat c = new CertificatService()
					.rechercheCertifParMotif(motifCertificat);
			cert.setCertificat(c);
			if (c != null)
				if (c.getRemarque() != null) {
					String textelettre = c.getRemarque();
					textelettre = intialeTextCertificats();
					cert.setRemarque(textelettre);
				}
			if (action.equals("Ajout")) {
				addValid = true;
				HistoriqueCertifService serc = new HistoriqueCertifService();
				serc.ajoutHistoriqueCertif(cert);

				face.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_ERROR,
						"Certificat ajouté avec succès.", ""));

				addValid = true;
				selectedCertif = cert;
				afficheImp = false;
				remarque = cert.getRemarque();

			}
			if (action.equals("Modification")) {
				addValid = true;
				HistoriqueCertifService serc = new HistoriqueCertifService();
				cert.setIdHistoriqueCertif(idHistoriqueCertif);
				serc.modifierHistoriqueCertif(cert);
				blocage = false;
				face.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_INFO, "",
						"Certificat modifiée avec succès"));

				addValid = true;
				selectedCertif = cert;
				afficheImp = false;
				remarque = cert.getRemarque();

			}
		}
		context.addCallbackParam("addValid", addValid);
		intialecertif();
	}

	public void ajoutCertifAptitude() throws SQLException, Exception {
		FacesContext face = FacesContext.getCurrentInstance();
		boolean addValid = false;

		HistoriqueCertif cert = new HistoriqueCertif();
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");
		CfclientService se = new CfclientService();
		cfclient = se.RechercheCfclient(idPatient);
		cert.setCfclient(cfclient);

		if ((dateCertif == null) || (dateCertif.equals(""))) {
			blocage = true;
			face.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"", "Veuillez saisi le date de cetificat"));
			addValid = false;

		}

		// verification de date certif
		if ((dateCertif != null) && (dateCertif.length() != 0)) {

			if (Module.corigerDate(dateCertif) != null) {
				this.setDateCertif(Module.corigerDate(dateCertif));
			}
			if ((Module.verifierDate(dateCertif).equals("")) == false)

			{
				blocage = true;
				face.addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "",
								"Le date du certificat "
										+ Module.verifierDate(dateCertif)));
				addValid = false;

			} else {
				try {
					cert.setDateCertif(sdf.parse(dateCertif));
				} catch (ParseException e) {

					e.printStackTrace();
				}

			}
		}
		if (face.getMessageList().size() == 0) {
			cert.setNomProprietaire(nomProprietaire);
			cert.setRemarques(remarques);
			Certificat c = new CertificatService()
					.rechercheCertifParMotif(motifCertificat);
			cert.setCertificat(c);
			if (c != null)
				if (c.getRemarque() != null) {
					String textelettre = c.getRemarque();
					textelettre = intialeTextCertificats();
					cert.setRemarque(textelettre);
				}
			if (action.equals("Ajout")) {
				HistoriqueCertifService serc = new HistoriqueCertifService();
				serc.ajoutHistoriqueCertif(cert);

				blocage = false;
				face.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_INFO, "",
						"Certificat ajoutée avec succès"));

				addValid = true;
				selectedCertif = cert;
				afficheImp = false;
				remarque = cert.getRemarque();

			}

			if (action.equals("Modification")) {

				HistoriqueCertifService serc = new HistoriqueCertifService();
				cert.setIdHistoriqueCertif(idHistoriqueCertif);
				serc.modifierHistoriqueCertif(cert);
				selectedCertif = cert;
				blocage = false;
				face.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_INFO, "",
						"Certificat modifiée avec succès"));
				blocage = false;

				addValid = true;
				selectedCertif = cert;
				afficheImp = false;
				remarque = cert.getRemarque();

			}
		}
		RequestContext context = RequestContext.getCurrentInstance();
		context.addCallbackParam("addValid", addValid);
		intialecertif();
	}

	public void ajoutCertifInaptitude() throws SQLException, Exception {
		FacesContext face = FacesContext.getCurrentInstance();
		boolean addValid = false;

		HistoriqueCertif cert = new HistoriqueCertif();
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");
		CfclientService se = new CfclientService();
		cfclient = se.RechercheCfclient(idPatient);
		cert.setCfclient(cfclient);
		if ((dateCertif == null) || (dateCertif.equals(""))) {
			blocage = true;
			face.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"", "Veuillez saisi le date de cetificat"));
			addValid = false;

		}

		// verification de date certif
		if ((dateCertif != null) && (dateCertif.length() != 0)) {

			if (Module.corigerDate(dateCertif) != null) {
				this.setDateCertif(Module.corigerDate(dateCertif));
			}
			if ((Module.verifierDate(dateCertif).equals("")) == false)

			{
				blocage = true;
				face.addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "",
								"Le date du certificat "
										+ Module.verifierDate(dateCertif)));
				addValid = false;

			} else {
				try {
					cert.setDateCertif(sdf.parse(dateCertif));
				} catch (ParseException e) {

					e.printStackTrace();
				}

			}
		}

		if (face.getMessageList().size() == 0) {
			cert.setNomProprietaire(nomProprietaire);
			cert.setInapte(inapte);
			Certificat c = new CertificatService()
					.rechercheCertifParMotif(motifCertificat);
			cert.setCertificat(c);
			if (c != null)
				if (c.getRemarque() != null) {
					String textelettre = c.getRemarque();
					textelettre = intialeTextCertificats();
					cert.setRemarque(textelettre);
				}
			if (action.equals("Ajout")) {
				HistoriqueCertifService serc = new HistoriqueCertifService();
				serc.ajoutHistoriqueCertif(cert);

				blocage = false;
				face.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_INFO, "",
						"Certificat ajoutée avec succès"));

				addValid = true;
				selectedCertif = cert;
				afficheImp = false;
				remarque = cert.getRemarque();

			}
			if (action.equals("Modification")) {

				HistoriqueCertifService serc = new HistoriqueCertifService();
				cert.setIdHistoriqueCertif(idHistoriqueCertif);
				serc.modifierHistoriqueCertif(cert);
				selectedCertif = cert;
				blocage = false;
				face.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_INFO, "",
						"Certificat modifiée avec succès"));
				blocage = false;
				addValid = true;
				selectedCertif = cert;
				afficheImp = false;
				remarque = cert.getRemarque();

			}
		}
		RequestContext context = RequestContext.getCurrentInstance();
		context.addCallbackParam("addValid", addValid);

		intialecertif();
	}

	public void intialiserDateCertif()// pour initialiler les dates en date
	{
		action = "Ajout";
		Date actuelle = new Date();
		titreDiag="Ajout du";
		// * Definition du format utilise pour les dates DateFormat
		Format format = new SimpleDateFormat("dd/MM/yyyy");
		String dateJour = format.format(actuelle);
		dateCertif = dateJour;
		dateCertifPrese = dateJour;
		dateCertifPreseAccomp = dateJour;
		livreele = dateJour;
		ancienValeurDateCertif = dateJour;
		ancienValeurDateCertif = dateJour;
		AncienValeurAdater = dateJour;
		datedelagression = dateJour;
		datereprise = dateJour;
		ancienValeurdatereprise = dateJour;
		adaterdu = dateJour;
		ancienValeurdatedelagression = dateJour;
		dureederepos = 0;
		dureedereposString = "0";
		// livreele = actuelle;
		GregorianCalendar calendar = new GregorianCalendar();
		heuresys = calendar.get(java.util.Calendar.HOUR_OF_DAY);
		minutesys = calendar.get(java.util.Calendar.MINUTE);
		heurelagr = calendar.get(java.util.Calendar.HOUR_OF_DAY);
		minutelagr = calendar.get(java.util.Calendar.MINUTE);
		CabinetService ser = new CabinetService();
		Cabinet c = new Cabinet();
		List<Cabinet> cab = ser.rechercheTousCabinet();
		if (cab != null && cab.size() != 0) {
			c = ser.rechercheTousCabinet().get(0);
			a = c.getVille();
		}

	}

	public String getAncientext() {
		return ancientext;
	}

	public void setAncientext(String ancientext) {
		this.ancientext = ancientext;
	}

	public void initialeRetour() {
		motifCertificat = null;
		remarque = null;
		goToFichePatient();
	}

	public void intialecertif() {// pour initialiser les donnes des certificats
		dateCertifPrese = "";
		dateCertifPreseAccomp = "";
		idCertificat = null;
		dateCertif = null;
		a = null;

		// remarque = null;
		remarques = null;
		datereprise = null;
		dureederepos = 0;
		adaterdu = null;
		datedelagression = null;
		type = null;
		accompagnant = null;
		lesions = null;
		heurelagr = 0;
		minutelagr = 0;
		heuresys = 0;
		minutesys = 0;
		inapte = null;
		type1 = null;
		cin = null;
		livreele = null;
		datereprise = null;

	}

	public void annulerModification() {
		remarque = ancientext;
	}

	public void refresh() {
		intialecertif();
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("Certificats");
		} catch (Exception e) {
		}
	}

	public void dureedereposChange() {
		setDureederepos(dureederepos);
	}

	public void adaterduChange() {
		setAdaterdu(adaterdu);
	}

	public void daterepriseChange() {
		setDatereprise(datereprise);
	}

	public void datedelagressionChange() {
		setDatedelagression(datedelagression);
	}

	public void lesionsChange() {
		setLesions(lesions);
	}

	public void heurelagrChange() {
		setHeurelagr(heurelagr);
	}

	public void minutelagrChange() {
		setMinutelagr(minutelagr);
	}

	public void remarquesChange() {
		setRemarques(remarques);
	}

	public void inapteChange() {
		setInapte(inapte);
	}

	private String action;

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public void modifierCertif(HistoriqueCertif h) {

		intialecertif();

		intialecertif() ;
		selectedCertif=h;

		action = "Modification";
		titreDiag="Modification du";
		Format formater = new SimpleDateFormat("dd/MM/yyyy");
		RequestContext context = RequestContext.getCurrentInstance();
		motifCertificat = h.getCertificat().getNomCertificat();
		idCertificat = h.getIdHistoriqueCertif();
		dateCertif = formater.format(h.getDateCertif());
		dateCertifPrese = formater.format(h.getDateCertif());
		dateCertifPreseAccomp = formater.format(h.getDateCertif());
		a = h.getA();
		remarque = h.getRemarque();
		remarques = h.getRemarques();
		if (h.getDatereprise() != null)
			datereprise = formater.format(h.getDatereprise());
		dureederepos = h.getDureederepos();
		dureedereposString = h.getDureederepos() + "";
		dateCertif = formater.format(h.getDateCertif());


		if (h.getAdaterdu() != null)
			adaterdu = formater.format(h.getAdaterdu());
		if (h.getDatedelagression() != null)
			datedelagression = formater.format(h.getDatedelagression());

		accompagnant = h.getAccompagnant();
		lesions = h.getLesions();
		heurelagr = h.getHeurelagr();
		minutelagr = h.getMinutelagr();
		heuresys = h.getHeuresys();
		minutesys = h.getMinutesys();
		inapte = h.getInapte();
		cin = h.getCin();
		livreele = h.getLivreele();

		type1 = h.getType();
		type = h.getType();
		if (h.getDatereprise() != null)
			datereprise = formater.format(h.getDatereprise());

		if (motifCertificat.equals("Certificat de mariage")) {
			RequestContext.getCurrentInstance().update("idDialogMariage");
			context.execute("PF('certMar').show();");
		}
		if (motifCertificat.equals("Certificat de présence")) {
			RequestContext.getCurrentInstance().update(
					"idDialogCertificatPresence");
			context.execute("PF('CertificatPresence').show();");
		}
		if (motifCertificat.equals("Certificat de présence d'accompagnement")) {
			RequestContext.getCurrentInstance().update("idDialogPreacommp");
			context.execute("PF('certPresAcomm').show();");
		}
		if (motifCertificat.equals("Certificat de Repos")) {
			RequestContext.getCurrentInstance().update("idDialogRepos");
			context.execute("PF('certRepos').show();");
		}
		if (motifCertificat.equals("Certificat de repos de l'accompagnant")) {
			RequestContext.getCurrentInstance().update("idDialogReposAcc");
			context.execute("PF('certReposAccompagnant').show();");
		}
		if (motifCertificat.equals("Certificat de guérison")) {
			RequestContext.getCurrentInstance().update("idDialogGuerison");
			context.execute("PF('certguerison').show();");
		}
		if (motifCertificat.equals("Certificat de coups et blessures")) {
			RequestContext.getCurrentInstance().update("idDialogCoups");
			context.execute("PF('certcoups').show();");
		}
		if (motifCertificat.equals("Certificat d'aptitude")) {
			RequestContext.getCurrentInstance().update("idDialogAptitude");
			context.execute("PF('certaptitude').show();");
		}
		if (motifCertificat.equals("Certificat d'inaptitude")) {
			RequestContext.getCurrentInstance().update("idDialogInaptitude");
			context.execute("PF('certinaptitude').show();");
		}

	}

	public void verifierDateLivrele() {
		setLivreele(livreele);

	}

	public void aChange() {
		setA(a);
	}

	public void cinChange() {
		setCin(cin);
	}

	public void livreeChange() {
		setLivreele(livreele);
	}

	public void remarqueChange() {
		setRemarques(remarques);
	}

	public void dureedereposVerif() {
		FacesContext face = FacesContext.getCurrentInstance();
		Boolean testValid = true;
		String msg = "";
		try {

			dureederepos = Integer.parseInt(dureedereposString);
			setDureederepos(dureederepos);

		} catch (Exception e) {

			dureederepos = 0;
			testValid = false;
			msg = msg + "Le duree de repos ne contient que des chiffres";
			dureedereposString = "0";

		}
		if (testValid == false) {
			blocage = true;
			face.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					" ", msg));

		}
	}

	public void verifierDateAdatee() {
		setAdaterdu(adaterdu);
	}

	public void typeChange() {
		setType(type);
		setType1(type);
	}

	public void accompagnantChange() {
		setAccompagnant(accompagnant);
	}

	public void verifierDatedatereprise() {
		setDatereprise(datereprise);
	}

	public void heuresysChange() {
		setHeuresys(heuresys);
	}

	public void minutesyschange() {
		setMinutesys(minutesys);
	}

	public void verifierdatedelagression() {
		setDatedelagression(datedelagression);

	}

	private String dureedereposString;
	private String ancienValeurdatedelagression;

	public String getDureedereposString() {
		return dureedereposString;
	}

	public void setDureedereposString(String dureedereposString) {

		this.dureedereposString = dureedereposString;
	}

	public String getancienValeurDateCertif() {
		return ancienValeurDateCertif;
	}

	public String getAncienValeurlivreele() {
		return ancienValeurlivreele;
	}

	public void setAncienValeurlivreele(String ancienValeurlivreele) {
		this.ancienValeurlivreele = ancienValeurlivreele;
	}

	public void setancienValeurDateCertif(String ancienValeurDateCertif) {
		this.ancienValeurDateCertif = ancienValeurDateCertif;
	}

	public String getAncienValeurDateCertif() {
		return ancienValeurDateCertif;
	}

	public void setAncienValeurDateCertif(String ancienValeurDateCertif) {
		this.ancienValeurDateCertif = ancienValeurDateCertif;
	}

	public String getAncienValeurAdater() {
		return AncienValeurAdater;
	}

	public void setAncienValeurAdater(String ancienValeurAdater) {
		AncienValeurAdater = ancienValeurAdater;
	}

	public String getAncienValeurdatereprise() {
		return ancienValeurdatereprise;
	}

	public void setAncienValeurdatereprise(String ancienValeurdatereprise) {
		this.ancienValeurdatereprise = ancienValeurdatereprise;
	}

	public String getAncienValeurdatedelagression() {
		return ancienValeurdatedelagression;
	}

	public void setAncienValeurdatedelagression(
			String ancienValeurdatedelagression) {
		this.ancienValeurdatedelagression = ancienValeurdatedelagression;
	}

	public String getValueOnclik() {
		return valueOnclik;
	}

	public void setValueOnclik(String valueOnclik) {
		this.valueOnclik = valueOnclik;
	}

	public void goToAccueil() {
		afficheImp = true;
		FacesContext context = FacesContext.getCurrentInstance();
		try {

			context.getExternalContext().redirect("Accueil");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void goToFichePatient() {
		afficheImp = true;
		selectedCertif = null;
		FacesContext context = FacesContext.getCurrentInstance();
		try {

			context.getExternalContext().redirect("FichePatiente");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void viewHistoriqueselect(ActionEvent actionEvent)
			throws SQLException, Exception {

		String nomReport = "Certificat";
		if (selectedCertif.getCertificat().getNomCertificat() != null) {
			if (selectedCertif.getCertificat().getNomCertificat()
					.equals("Certificat de présence"))
				nomReport = "CertificatPresence";
			if (selectedCertif.getCertificat().getNomCertificat() != null) {
				if (selectedCertif.getCertificat().getNomCertificat()
						.equals("Certificat de présence d'accompagnement"))
					nomReport = "CertificatPresence";
			}
			if (selectedCertif.getCertificat().getNomCertificat()
					.equals("Certificat de mariage"))
				nomReport = "Certificatmariage";
			if (selectedCertif.getCertificat().getNomCertificat()
					.equals("Certificat de Repos"))
				nomReport = "CertificatRepos";
			if (selectedCertif.getCertificat().getNomCertificat()
					.equals("Certificat de repos de l'accompagnant"))
				nomReport = "CertificatReposAcommpa";
			if (selectedCertif.getCertificat().getNomCertificat()
					.equals("Certificat de guérison"))
				nomReport = "Certificatguerision";
			if (selectedCertif.getCertificat().getNomCertificat()
					.equals("Certificat de coups et blessures"))
				nomReport = "Certificatcoupsetbleusseur";
			if (selectedCertif.getCertificat().getNomCertificat()
					.equals("Certificat d'inaptitude"))
				nomReport = "Certificatinapptitude";
			if (selectedCertif.getCertificat().getNomCertificat()
					.equals("Certificat d'aptitude"))
				nomReport = "Certificatapptitude";

		}

		Map<String, Object> param = new HashMap<String, Object>();
		param.put("idc", selectedCertif.getIdHistoriqueCertif());
		Module.imprimer(nomReport, param);
	}

	public boolean isBlocage() {
		return blocage;
	}

	public void setBlocage(boolean blocage) {
		this.blocage = blocage;
	}

	public String getType1() {
		return type1;
	}

	public void setType1(String type1) {
		this.type1 = type1;
	}

	public boolean isafficheImp() {
		return afficheImp;
	}

	public void setafficheImp(boolean afficheImp) {
		this.afficheImp = afficheImp;
	}

	public String getDateCertifPrese() {
		return dateCertifPrese;
	}

	public void setDateCertifPrese(String dateCertifPrese) {
		this.dateCertifPrese = dateCertifPrese;
	}

	public String getDateCertifPreseAccomp() {
		return dateCertifPreseAccomp;
	}

	public void setDateCertifPreseAccomp(String dateCertifPreseAccomp) {
		this.dateCertifPreseAccomp = dateCertifPreseAccomp;
	}

	public String getTitreDiag() {
		return titreDiag;
	}

	public void setTitreDiag(String titreDiag) {
		this.titreDiag = titreDiag;
	}

	public boolean isAfficheImp() {
		return afficheImp;
	}

	public void setAfficheImp(boolean afficheImp) {
		this.afficheImp = afficheImp;
	}

	public String getProprietaire() {
		return proprietaire;
	}

	public void setProprietaire(String proprietaire) {
		this.proprietaire = proprietaire;
	}

	public String getNomProprietaire() {
		return nomProprietaire;
	}

	public void setNomProprietaire(String nomProprietaire) {
		this.nomProprietaire = nomProprietaire;
	}
	

	public void changeProp()
	{
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");

		CfclientService se = new CfclientService();
		cfclient = se.RechercheCfclient(idPatient);
		if(proprietaire!=null)
		{if(proprietaire.equals("Patiente"))
		{if((cfclient.getPrenom()!=null)&&((cfclient.getNom()!=null))&&(cfclient.getNom().trim().length()>0)&&(cfclient.getPrenom().trim().length()>0))
		{nomProprietaire="M "+cfclient.getPrenom()+" "+cfclient.getNom();}
		else
			if(cfclient.getPrenom()!=null &&(cfclient.getPrenom().trim().length()>0))
			nomProprietaire="M "+cfclient.getPrenom();
			else
				if(cfclient.getNom()!=null &&(cfclient.getNom().trim().length()>0))
					nomProprietaire="M "+cfclient.getNom();
				else
					if((cfclient.getPrenom()==null)&&((cfclient.getNom()==null))&&(cfclient.getNom().trim().length()==0)&&(cfclient.getPrenom().trim().length()==0))
					nomProprietaire="";	
	
		}
	


		else
		{if((cfclient.getPrenomC()!=null)&&((cfclient.getNomC()!=null))&&(cfclient.getNomC().trim().length()>0)&&(cfclient.getPrenomC().trim().length()>0))
		{nomProprietaire="M "+cfclient.getPrenomC()+" "+cfclient.getNomC();}
		else
			if(cfclient.getPrenomC()!=null &&(cfclient.getPrenomC().trim().length()>0))
			nomProprietaire="M "+cfclient.getPrenomC();
			else
				if(cfclient.getNomC()!=null &&(cfclient.getNomC().trim().length()>0))
					nomProprietaire="M "+cfclient.getNomC();
				else
					if((cfclient.getPrenomC()==null)&&((cfclient.getNomC()==null))&&(cfclient.getNomC().trim().length()==0)&&(cfclient.getPrenomC().trim().length()==0))
					nomProprietaire="";	
	
		}}
	

}

}

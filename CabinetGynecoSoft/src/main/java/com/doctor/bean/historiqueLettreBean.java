package com.doctor.bean;

import java.io.File;
import java.io.Serializable;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.jasperreports.engine.JasperRunManager;

import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

import com.doctor.dao.HibernateUtil;
import com.doctor.persistance.Cabinet;
import com.doctor.persistance.Cfclient;
import com.doctor.persistance.Lettre;
import com.doctor.persistance.historiqueLettre;
import com.doctor.service.CabinetService;
import com.doctor.service.CfclientService;
import com.doctor.service.LettreService;
import com.doctor.service.historiqueLettreService;
import com.mysql.jdbc.Connection;

@ManagedBean(name = "historiqueLettreBean")
@SessionScoped
public class historiqueLettreBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String textLettre;
	private Lettre lettre;

	private String dateLet;
	private String code;
	private String toxo;
	private String tpha;
	// private Date dateActe;
	private Cfclient cfclient;
	private String nomletrr;
	private Integer idHistoriquelettre;
	private String clinique;
	private String description;
	private String ddr;
	private String debutGross;
	private String termeprevue;
	private String termeactuel;
	private String rubeoole;
	private String frotti;
	private String textselect;
	private String gs;
	private String rh;
	private String resultatfrotti;
	private String diagnostic;
	private String action;
	private String v1Nature;
	private String v3;
	private String v2SigneClinique;
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
	private Integer idPatient;
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
	private String nomLettre;
	private historiqueLettre selectedhistolettre;
	private String autre;
	private String ancientext;
	private String acte;
	private String ancienValeurDateCertif;
private boolean blocage;
	public String getAncienValeurDateCertif() {
		return ancienValeurDateCertif;
	}

	public void setAncienValeurDateCertif(String ancienValeurDateCertif) {
		this.ancienValeurDateCertif = ancienValeurDateCertif;
	}

	public String getDateLet() {
		return dateLet;
	}

	public void setDateLet(String dateLet) {
		this.dateLet = dateLet;
	}

	public String getActe() {
		return acte;
	}

	public void setActe(String acte) {
		this.acte = acte;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	private List<historiqueLettre> historiqueLettres = new ArrayList<historiqueLettre>();

	public Lettre getLettre() {
		return lettre;
	}

	public void setLettre(Lettre Lettre) {
		this.lettre = Lettre;
	}

	public String getNomLettre() {
		return nomLettre;
	}

	public void setNomLettre(String nomLettre) {
		this.nomLettre = nomLettre;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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

	public Integer getIdHistoriquelettre() {
		return idHistoriquelettre;
	}

	public void setIdHistoriquelettre(Integer idHistoriquelettre) {
		this.idHistoriquelettre = idHistoriquelettre;
	}

	public String getClinique() {
		return clinique;
	}

	public void setClinique(String clinique) {
		this.clinique = clinique;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDdr() {
		return ddr;
	}

	public void setDdr(String ddr) {
		this.ddr = ddr;
	}

	public String getDebutGross() {
		return debutGross;
	}

	public void setDebutGross(String debutGross) {
		this.debutGross = debutGross;
	}

	public String getTermeprevue() {
		return termeprevue;
	}

	public void setTermeprevue(String termeprevue) {
		this.termeprevue = termeprevue;
	}

	public String getTermeactuel() {
		return termeactuel;
	}

	public void setTermeactuel(String termeactuel) {
		this.termeactuel = termeactuel;
	}

	public String getRubeoole() {
		return rubeoole;
	}

	public void setRubeoole(String rubeoole) {
		this.rubeoole = rubeoole;
	}

	public String getFrotti() {
		return frotti;
	}

	public void setFrotti(String frotti) {
		this.frotti = frotti;
	}

	public String getGs() {
		return gs;
	}

	public void setGs(String gs) {
		this.gs = gs;
	}

	public String getRh() {
		return rh;
	}

	public void setRh(String rh) {
		this.rh = rh;
	}

	public String getResultatfrotti() {
		return resultatfrotti;
	}

	public void setResultatfrotti(String resultatfrotti) {
		this.resultatfrotti = resultatfrotti;
	}

	public String getDiagnostic() {
		return diagnostic;
	}

	public void setDiagnostic(String diagnostic) {
		this.diagnostic = diagnostic;
	}

	

	public String getV3() {
		return v3;
	}

	public void setV3(String v3) {
		this.v3 = v3;
	}

	

	public String getV1Nature() {
		return v1Nature;
	}

	public void setV1Nature(String v1Nature) {
		this.v1Nature = v1Nature;
	}

	public String getV2SigneClinique() {
		return v2SigneClinique;
	}

	public void setV2SigneClinique(String v2SigneClinique) {
		this.v2SigneClinique = v2SigneClinique;
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

	public String getToxo() {
		return toxo;
	}

	public void setToxo(String toxo) {
		this.toxo = toxo;
	}

	public String getTpha() {
		return tpha;
	}

	public void setTpha(String tpha) {
		this.tpha = tpha;
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

	public String getTextLettre() {

		return textLettre;
	}

	public void setTextLettre(String textLettre) {
		this.textLettre = textLettre;
	}

	public Integer getIdPatient() {
		return idPatient;
	}

	public void setIdPatient(Integer idPatient) {
		this.idPatient = idPatient;
	}

	public List<historiqueLettre> getHistoriqueLettres() {
		historiqueLettreService serh = new historiqueLettreService();
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");
		historiqueLettres = serh.rechercheTousHistoriqueLettre(idPatient);
		return historiqueLettres;
	}

	public void setHistoriqueLettres(List<historiqueLettre> historiqueLettres) {
		this.historiqueLettres = historiqueLettres;
	}

	public void supprimerLettre(Integer id) {
		historiqueLettreService ser = new historiqueLettreService();
		ser.supprimerHistoriqueLettre(id);
		FacesContext face = FacesContext.getCurrentInstance();
		blocage=false;
		face.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "",
				"Certificat Supprimé Avec succées"));
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getFlash().setKeepMessages(true);		
		try {
			context.getExternalContext().redirect("Lettres");

		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
//		try {
//			FacesContext.getCurrentInstance().getExternalContext()
//					.redirect("Lettres");
//		} catch (Exception e) {
//		}
	}

	public void onRowSelectlettre(SelectEvent event) {
		historiqueLettre c = (historiqueLettre) event.getObject();
//		try {
//			FacesContext.getCurrentInstance().getExternalContext()
//					.redirect("ListeLettre.xhtml");
//		} catch (Exception e) {
//		}

		textLettre = c.getTextLettre();
		idHistoriquelettre = c.getIdHistoriquelettre();
		cfclient = c.getCfclient();
		lettre = c.getLettre();
		nomLettre = c.getLettre().getNomLettre();
		ancientext = textLettre;
	}
	
	
	public void ModifierLettrePanel()
	{
		FacesContext face = FacesContext.getCurrentInstance();
		historiqueLettre lettree=new historiqueLettre();
		historiqueLettreService ser = new historiqueLettreService();
		 lettree = ser
				.rechercheHistoriqueLettre(selectedhistolettre.getIdHistoriquelettre());
	lettree.setTextLettre(textLettre);
	ser.modifierHistoriqueLettre(lettree);
	blocage=false;
	face.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "",
			"Lettre Modifiée Avec succées"));
	
	}

	public void ModifierLettre() {
		historiqueLettreService ser = new historiqueLettreService();
		historiqueLettre cert = ser
				.rechercheHistoriqueLettre(idHistoriquelettre);
		cert.setDdr(ddr);
		cert.setCfclient(cfclient);
		cert.setDebutGross(debutGross);
		cert.setDescription(description);
		cert.setDiagnostic(diagnostic);
		cert.setFrotti(frotti);
		cert.setGs(gs);
		cert.setLettre(lettre);
		cert.setResultatfrotti(resultatfrotti);
		cert.setRh(rh);
		cert.setRubeoole(rubeoole);
		cert.setTermeactuel(termeactuel);
		cert.setTermeprevue(termeprevue);
		cert.setTextLettre(textLettre);
		ser.modifierHistoriqueLettre(cert);
		FacesContext face = FacesContext.getCurrentInstance();
		blocage=false;
		face.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "",
				"Lettre Modifiée Avec succées"));
		// motifCertificat = null;

	}

	private String remplaceMot(String sonTexte, String txtFind,
			String txtReplace) {
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

	public String intialeTextLettre() {
		Lettre lett = new Lettre();
		LettreService ser = new LettreService();
		lett = ser.recherchelettreParLibellelettre(nomLettre);
		String rem = lett.getTextLettre();
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");
		CfclientService se = new CfclientService();
		cfclient = se.RechercheCfclient(idPatient);
		Cabinet cab = new Cabinet();
		CabinetService serCabinet = new CabinetService();
		cab = serCabinet.rechercheTousCabinet().get(0);

		if ((cfclient.getPrenom() != null) || (cfclient.getNom() != null))
			rem = remplaceMot(rem, "$NP",
					cfclient.getPrenom() + " " + cfclient.getNom());
		else
			rem = remplaceMot(rem, "$NP", "");
		if (Module.age(cfclient.getDateNaiss()) != null) {
			rem = remplaceMot(rem, "$Age", Module.calculAgeEnAns(cfclient.getDateNaiss())+" Ans");
		} else
			rem = remplaceMot(rem, "$Age", "");

		if (cab.getDocteur() != null)
			rem = remplaceMot(rem, "$Docteur", cab.getDocteur());
		else
			rem = remplaceMot(rem, "$Docteur", "");
		if (code != null)
			rem = remplaceMot(rem, "$code", code);
		else
			rem = remplaceMot(rem, "$code", "");
		if (v2SigneClinique != null)
			rem = remplaceMot(rem, "$signeClinique", v2SigneClinique);
		else
			rem = remplaceMot(rem, "$signeClinique", "");
		if (v1Nature != null)
			rem = remplaceMot(rem, "$Nature", v1Nature);
		else
			rem = remplaceMot(rem, "$Nature", "");

		if (clinique != null)
			rem = remplaceMot(rem, "$clinique", clinique);
		else
			rem = remplaceMot(rem, "$clinique", "");
		

		if (acte != null) {

			rem = remplaceMot(rem, "$DateAct", acte);
		} else {
			rem = remplaceMot(rem, "$DateAct", "");
		}
		if (description != null)
			rem = remplaceMot(rem, "$desc", description);
		else
			rem = remplaceMot(rem, "$desc", "");
		if (dateLet != null) {
			rem = remplaceMot(rem, "$DateL", dateLet);
		} else
			rem = remplaceMot(rem, "$DateL", "");
		if (autre != null) {
			rem = remplaceMot(rem, "$autre", autre);
		} else
			rem = remplaceMot(rem, "$autre", "");

		if (ddr != null) {
			rem = remplaceMot(rem, "$Ddr", ddr);
		} else
			rem = remplaceMot(rem, "$Ddr", "");

		if (debutGross != null) {
			rem = remplaceMot(rem, "$DebutGross", debutGross);
		} else

			rem = remplaceMot(rem, "$DebutGross", "");
		if (termeprevue != null) {
			rem = remplaceMot(rem, "$termeprevue", termeprevue);
		} else
			rem = remplaceMot(rem, "$termeprevue", "");
		if (termeactuel != null) {
			rem = remplaceMot(rem, "$termeactuel", termeactuel);
		} else
			rem = remplaceMot(rem, "$termeactuel", "");
		if (rubeoole != null) {
			rem = remplaceMot(rem, "$rubeoole", rubeoole);
		} else

			rem = remplaceMot(rem, "$rubeoole", "");
		if (frotti != null)
			rem = remplaceMot(rem, "$frotti", frotti);
		else
			rem = remplaceMot(rem, "$frotti", "");

		if (gs != null) {
			rem = remplaceMot(rem, "$gs", gs);
		} else
			rem = remplaceMot(rem, "$gs", "");
		if (rh != null) {
			rem = remplaceMot(rem, "$rh", rh);
		} else
			rem = remplaceMot(rem, "$rh", "");
		if (resultatfrotti != null) {
			rem = remplaceMot(rem, "$resultatfrotti", resultatfrotti);
		} else
			rem = remplaceMot(rem, "$resultatfrotti", "");
		if (toxo != null) {
			rem = remplaceMot(rem, "$toxo", toxo);
		} else
			rem = remplaceMot(rem, "$toxo", "");
		if (tpha != null)
			rem = remplaceMot(rem, "$tpha", tpha);
		else
			rem = remplaceMot(rem, "$tpha", "");

		if (diagnostic != null) {
			rem = remplaceMot(rem, "$diag", diagnostic);
		} else
			rem = remplaceMot(rem, "$diag", "");

		return (rem);
	}

	public void viewLettreselect(ActionEvent actionEvent) throws SQLException,
			Exception {

		String nomReport = "lettrerep";
		if (selectedhistolettre.getLettre().getNomLettre()
				.equals("Lettre Confidentielle"))
			nomReport = "lettreconfidentielle";
		if (selectedhistolettre.getLettre().getNomLettre()
				.equals("Lettre d'accouchement"))
			nomReport = "lettreacouch";
		if (selectedhistolettre.getLettre().getNomLettre()
				.equals("Lettre de réponse a une demande de prise en charge"))
			nomReport = "lettrereponsedemandedepriseencharge";
		if (selectedhistolettre.getLettre().getNomLettre()
				.equals("Lettre de prise en charge"))
			nomReport = "lettrereponse";

		Connection connection = (Connection) DriverManager.getConnection(
				HibernateUtil.url, HibernateUtil.login, HibernateUtil.pass);
		File jasper = new File(FacesContext.getCurrentInstance()
				.getExternalContext()
				.getRealPath("/reports/" + nomReport + ".jasper"));
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("idlettre", selectedhistolettre.getIdHistoriquelettre());
		byte[] bytes = JasperRunManager.runReportToPdf(jasper.getPath(), param,
				connection);
		HttpServletResponse response = (HttpServletResponse) FacesContext
				.getCurrentInstance().getExternalContext().getResponse();
		response.setContentType("application/pdf");
		response.setContentLength(bytes.length);
		ServletOutputStream outStream = response.getOutputStream();
		outStream.write(bytes, 0, bytes.length);
		outStream.flush();
		outStream.close();
		FacesContext.getCurrentInstance().responseComplete();
	}

	public void ajoutLettreReponseDemande() throws SQLException, Exception {
		// confidentielle
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");
		historiqueLettre let = new historiqueLettre();
		CfclientService se = new CfclientService();
		cfclient = se.RechercheCfclient(idPatient);
		let.setCfclient(cfclient);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		let.setDatelettre(sdf.parse(dateLet));
		let.setDateActe(sdf.parse(acte));

		let.setCode(code);
		let.setClinique(clinique);
		let.setDescription(description);
		Lettre c = new LettreService()
				.recherchelettreParLibellelettre(nomLettre);
		let.setLettre(c);
		if (c != null)
			if (c.getTextLettre() != null) {
				String textelettre = c.getTextLettre();
				textelettre = intialeTextLettre();
				let.setTextLettre(textelettre);
			}

		if (action.equals("Ajout")) {
			historiqueLettreService serc = new historiqueLettreService();
			serc.ajoutHistoriqueLettre(let);
			FacesContext face = FacesContext.getCurrentInstance();
			blocage=false;
			face.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"", "Lettre ajoutée avec succées"));

			// Impression
			historiqueLettreService ser = new historiqueLettreService();
			List<historiqueLettre> lettr = ser
					.rechercheTousHistoriqueLettre(idPatient);
			if (lettr != null && lettr.size() > 0) {
				historiqueLettre o = lettr.get(0);
				selectedhistolettre = o;
			}
		}

		if (action.equals("Modification")) {
			historiqueLettreService serc = new historiqueLettreService();
			let.setIdHistoriquelettre(idHistoriquelettre);
			serc.modifierHistoriqueLettre(let);
			selectedhistolettre = let;
			FacesContext face = FacesContext.getCurrentInstance();
			blocage=false;
			face.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"", "Lettre modifiée avec succées"));
			RequestContext.getCurrentInstance().update("f1:growl");
		}
		// String nomReport = "lettrereponce";
		String nomReport = "lettreconfidentielle";

		Connection connection = (Connection) DriverManager.getConnection(
				HibernateUtil.url, HibernateUtil.login, HibernateUtil.pass);
		File jasper = new File(FacesContext.getCurrentInstance()
				.getExternalContext()
				.getRealPath("/reports/" + nomReport + ".jasper"));
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("idlettre", selectedhistolettre.getIdHistoriquelettre());
		byte[] bytes = JasperRunManager.runReportToPdf(jasper.getPath(), param,
				connection);
		HttpServletResponse response = (HttpServletResponse) FacesContext
				.getCurrentInstance().getExternalContext().getResponse();
		response.setContentType("application/pdf");
		response.setContentLength(bytes.length);
		ServletOutputStream outStream = response.getOutputStream();
		outStream.write(bytes, 0, bytes.length);
		outStream.flush();
		outStream.close();
		FacesContext.getCurrentInstance().responseComplete();
	}

	public void ajoutLettreAccouchement() throws SQLException, Exception {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");
		historiqueLettre let = new historiqueLettre();
		CfclientService se = new CfclientService();
		cfclient = se.RechercheCfclient(idPatient);
		let.setCfclient(cfclient);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		let.setDatelettre(sdf.parse(dateLet));
		let.setDdr(ddr);
		let.setDebutGross(debutGross);
		let.setTermeactuel(termeactuel);
		let.setTermeprevue(termeprevue);
		let.setToxo(toxo);
		let.setTpha(tpha);
		let.setRubeoole(rubeoole);
		let.setFrotti(frotti);
		let.setGs(gs);
		let.setRh(rh);
		let.setResultatfrotti(resultatfrotti);
		let.setAutre(autre);

		Lettre c = new LettreService()
				.recherchelettreParLibellelettre(nomLettre);
		let.setLettre(c);
		if (c != null)
			if (c.getTextLettre() != null) {
				String textelettre = c.getTextLettre();
				textelettre = intialeTextLettre();
				let.setTextLettre(textelettre);
			}

		if (action.equals("Ajout")) {
			historiqueLettreService serc = new historiqueLettreService();
			serc.ajoutHistoriqueLettre(let);
			FacesContext face = FacesContext.getCurrentInstance();
			blocage=false;
			face.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"", "Lettre ajoutée avec succées"));
			// Impression
			historiqueLettreService ser = new historiqueLettreService();
			List<historiqueLettre> lettr = ser
					.rechercheTousHistoriqueLettre(idPatient);
			if (lettr != null && lettr.size() > 0) {
				historiqueLettre o = lettr.get(0);
				selectedhistolettre = o;
			}
		}
		if (action.equals("Modification")) {
			historiqueLettreService serc = new historiqueLettreService();
			let.setIdHistoriquelettre(idHistoriquelettre);
			serc.modifierHistoriqueLettre(let);
			selectedhistolettre = let;
			FacesContext face = FacesContext.getCurrentInstance();
			blocage=false;
			face.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"", "Lettre modifiée avec succées"));
			RequestContext.getCurrentInstance().update("f1:growl");
		}
		String nomReport = "lettreacouch";
		Connection connection = (Connection) DriverManager.getConnection(
				HibernateUtil.url, HibernateUtil.login, HibernateUtil.pass);
		File jasper = new File(FacesContext.getCurrentInstance()
				.getExternalContext()
				.getRealPath("/reports/" + nomReport + ".jasper"));
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("idlettre", selectedhistolettre.getIdHistoriquelettre());
		byte[] bytes = JasperRunManager.runReportToPdf(jasper.getPath(), param,
				connection);
		HttpServletResponse response = (HttpServletResponse) FacesContext
				.getCurrentInstance().getExternalContext().getResponse();
		response.setContentType("application/pdf");
		response.setContentLength(bytes.length);
		ServletOutputStream outStream = response.getOutputStream();
		outStream.write(bytes, 0, bytes.length);
		outStream.flush();
		outStream.close();
		FacesContext.getCurrentInstance().responseComplete();

	}

	public void ajoutLettreReponse() throws SQLException, Exception {
		//reponce a une demande de prise en charge
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");
		historiqueLettre let = new historiqueLettre();
		CfclientService se = new CfclientService();
		cfclient = se.RechercheCfclient(idPatient);
		let.setCfclient(cfclient);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date d = sdf.parse(dateLet);

		let.setDatelettre(d);
		let.setDiagnostic(diagnostic);

		Lettre c = new LettreService()
				.recherchelettreParLibellelettre(nomLettre);
		let.setLettre(c);
		if (c != null)
			if (c.getTextLettre() != null) {
				String textelettre = c.getTextLettre();
				textelettre = intialeTextLettre();
				let.setTextLettre(textelettre);
			}

		if (action.equals("Ajout")) {
			historiqueLettreService serc = new historiqueLettreService();
			serc.ajoutHistoriqueLettre(let);

			FacesContext face = FacesContext.getCurrentInstance();
			blocage=false;
			face.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"", "Lettre Ajoutée Avec succées"));

			// Impression
			historiqueLettreService ser = new historiqueLettreService();
			List<historiqueLettre> lettr = ser
					.rechercheTousHistoriqueLettre(idPatient);
			if (lettr != null && lettr.size() > 0) {
				historiqueLettre o = lettr.get(0);
				selectedhistolettre = o;
			}
		}
		if (action.equals("Modification")) {
			historiqueLettreService serc = new historiqueLettreService();
			let.setIdHistoriquelettre(idHistoriquelettre);

			serc.modifierHistoriqueLettre(let);
			selectedhistolettre = let;
			FacesContext face = FacesContext.getCurrentInstance();
			blocage=false;
			face.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"", "Lettre modifiée avec succées"));
			RequestContext.getCurrentInstance().update("f1:growl");
		}
		String nomReport = "lettrereponsedemandedepriseencharge";

		Connection connection = (Connection) DriverManager.getConnection(
				HibernateUtil.url, HibernateUtil.login, HibernateUtil.pass);
		File jasper = new File(FacesContext.getCurrentInstance()
				.getExternalContext()
				.getRealPath("/reports/" + nomReport + ".jasper"));
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("idlettre", selectedhistolettre.getIdHistoriquelettre());

		/*
		 * String defaultPDFFont = "Arial";
		 * 
		 * JRProperties.setProperty("net.sf.jasperreports.awt.ignore.missing.font"
		 * , "true");
		 * JRProperties.setProperty("net.sf.jasperreports.default.font.name",
		 * defaultPDFFont);
		 * 
		 * JasperReport jasperReport =
		 * JasperCompileManager.compileReport(reportSource); JasperPrint
		 * jasperPrint = JasperFillManager.fillReport(jasperReport, params);
		 * 
		 * JasperExportManager.exportReportToPdfFile(jasperPrint,
		 * outputFileName);
		 */

		byte[] bytes = JasperRunManager.runReportToPdf(jasper.getPath(), param,
				connection);
		HttpServletResponse response = (HttpServletResponse) FacesContext
				.getCurrentInstance().getExternalContext().getResponse();
		response.setContentType("application/pdf");
		response.setContentLength(bytes.length);
		ServletOutputStream outStream = response.getOutputStream();
		outStream.write(bytes, 0, bytes.length);
		outStream.flush();
		outStream.close();
		FacesContext.getCurrentInstance().responseComplete();
	}
	public void ajoutLettrePriseEnCharge() throws SQLException, Exception {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");
		historiqueLettre let = new historiqueLettre();
		CfclientService se = new CfclientService();
		cfclient = se.RechercheCfclient(idPatient);
		let.setCfclient(cfclient);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date d = sdf.parse(dateLet);

		let.setDatelettre(d);
		let.setV2(v2SigneClinique);
		let.setV1(v1Nature);

		Lettre c = new LettreService()
				.recherchelettreParLibellelettre(nomLettre);
		let.setLettre(c);
		if (c != null)
			if (c.getTextLettre() != null) {
				String textelettre = c.getTextLettre();
				textelettre = intialeTextLettre();
				let.setTextLettre(textelettre);
			}

		if (action.equals("Ajout")) {
			historiqueLettreService serc = new historiqueLettreService();
			serc.ajoutHistoriqueLettre(let);

			FacesContext face = FacesContext.getCurrentInstance();
			blocage=false;
			face.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"", "Lettre Ajoutée Avec succées"));

			// Impression
			historiqueLettreService ser = new historiqueLettreService();
			List<historiqueLettre> lettr = ser
					.rechercheTousHistoriqueLettre(idPatient);
			if (lettr != null && lettr.size() > 0) {
				historiqueLettre o = lettr.get(0);
				selectedhistolettre = o;
			}
		}
		if (action.equals("Modification")) {
			historiqueLettreService serc = new historiqueLettreService();
			let.setIdHistoriquelettre(idHistoriquelettre);

			serc.modifierHistoriqueLettre(let);
			selectedhistolettre = let;
			FacesContext face = FacesContext.getCurrentInstance();
			blocage=false;
			face.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"", "Lettre modifiée avec succées"));
			RequestContext.getCurrentInstance().update("f1:growl");
		}
		String nomReport = "lettrereponse";

		Connection connection = (Connection) DriverManager.getConnection(
				HibernateUtil.url, HibernateUtil.login, HibernateUtil.pass);
		File jasper = new File(FacesContext.getCurrentInstance()
				.getExternalContext()
				.getRealPath("/reports/" + nomReport + ".jasper"));
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("idlettre", selectedhistolettre.getIdHistoriquelettre());

		/*
		 * String defaultPDFFont = "Arial";
		 * 
		 * JRProperties.setProperty("net.sf.jasperreports.awt.ignore.missing.font"
		 * , "true");
		 * JRProperties.setProperty("net.sf.jasperreports.default.font.name",
		 * defaultPDFFont);
		 * 
		 * JasperReport jasperReport =
		 * JasperCompileManager.compileReport(reportSource); JasperPrint
		 * jasperPrint = JasperFillManager.fillReport(jasperReport, params);
		 * 
		 * JasperExportManager.exportReportToPdfFile(jasperPrint,
		 * outputFileName);
		 */

		byte[] bytes = JasperRunManager.runReportToPdf(jasper.getPath(), param,
				connection);
		HttpServletResponse response = (HttpServletResponse) FacesContext
				.getCurrentInstance().getExternalContext().getResponse();
		response.setContentType("application/pdf");
		response.setContentLength(bytes.length);
		ServletOutputStream outStream = response.getOutputStream();
		outStream.write(bytes, 0, bytes.length);
		outStream.flush();
		outStream.close();
		FacesContext.getCurrentInstance().responseComplete();
	}

	public void intialiserDateLettre() {
		action = "Ajout";
		Date actuelle = new Date();
		// * Definition du format utilise pour les dates DateFormat

		Format format = new SimpleDateFormat("dd/MM/yyyy");
		String dateLettre = format.format(actuelle);
		acte = dateLettre;
		dateLet = dateLettre;
		selectedhistolettre = null;
		ancienValeurDateCertif = format.format(actuelle);
	}

	public void refresh() {
		initialitationDonneesLettre();
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("Lettres");
		} catch (Exception e) {
		}
	}

	public historiqueLettre getSelectedhistolettre() {
		return selectedhistolettre;
	}

	public void setSelectedhistolettre(historiqueLettre selectedhistolettre) {
		this.selectedhistolettre = selectedhistolettre;
	}

	public String getAutre() {
		return autre;
	}

	public void setAutre(String autre) {
		this.autre = autre;
	}

	public void intialiserDonneesLettreAccouchement() {
		// initialisation les champs de lettre d'accouchement
		action = "Ajout";
		Date actuelle = new Date();
		// * Definition du format utilise pour les dates DateFormat
		Format format = new SimpleDateFormat("dd/MM/yyyy");
		acte = format.format(actuelle);
		dateLet = format.format(actuelle);
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		idPatient = (Integer) session.getAttribute("idu");

		CfclientService se = new CfclientService();
		cfclient = se.RechercheCfclient(idPatient);
		ddr = cfclient.getDdr();
		debutGross = cfclient.getDdg();
		termeprevue = cfclient.gettPrevu();
		termeactuel = cfclient.gettActuel();
		rubeoole = cfclient.getRubeole();
		frotti = cfclient.getDateFrotti();
		gs = cfclient.getGs();
		rh = cfclient.getRh();
		resultatfrotti = cfclient.getResultatFrotti();
		toxo = cfclient.getToxo();
		tpha = cfclient.getTpha();
		selectedhistolettre = null;

	}

	public String closeDiag() {
		return null;
	}

	public String getAncientext() {
		return ancientext;
	}

	public void setAncientext(String ancientext) {
		this.ancientext = ancientext;
	}

	public void annulerModification() {
		textLettre = ancientext;
	}

	public void textChange() {
		setTextLettre(textLettre);
	}

	public void initialitationDonneesLettre() {
		textLettre = null;
		idHistoriquelettre = null;
		nomLettre = null;
		dateLet = null;
		ddr = null;
		debutGross = null;
v2SigneClinique=null;
v1Nature=null;
		frotti = null;
		gs = null;
		rh = null;
		rubeoole = null;
		termeactuel = null;
		lettre = null;
		resultatfrotti = null;
		termeprevue = null;
		code = null;
		acte = null;

		autre = null;
		toxo = null;
		tpha = null;
		clinique = null;
		description = null;
		diagnostic = null;
		selectedhistolettre = null;
	}

	public String getNomletrr() {
		return nomletrr;
	}

	public void setNomletrr(String nomletrr) {
		this.nomletrr = nomletrr;
	}

	public String getTextselect() {
		return textselect;
	}

	public void setTextselect(String textselect) {
		this.textselect = textselect;
	}

	public void dateActeChange() {
		setActe(acte);
	}

	public void codeChange() {
		setCode(code);
	}

	public void cliniqueChange() {
		setClinique(clinique);
	}

	public void descriptionChange() {
		setDescription(description);
	}

	public void ddrChange() {
		setDdr(ddr);
	}

	public void debutGrossChange() {
		setDebutGross(debutGross);
	}

	public void termeprevueChange() {
		setTermeprevue(termeprevue);
	}

	public void termeactuelChange() {
		setTermeactuel(termeactuel);
	}

	public void toxoChange() {
		setToxo(toxo);
	}

	public void tphaChange() {
		setTpha(tpha);
	}

	public void rubeooleChange() {
		setRubeoole(rubeoole);
	}

	public void frottiChange() {
		setFrotti(frotti);
	}

	public void gsChange() {
		setGs(gs);
	}

	public void rhChange() {
		setRh(rh);
	}

	public void resultatfrottiChange() {
		setResultatfrotti(resultatfrotti);
	}

	public void autreChange() {
		setAutre(autre);
	}

	public void diagnosticChange() {
		setDiagnostic(diagnostic);
	}

	public void dateLetChange() {
		setDateLet(dateLet);
	}

	public void verifierDate() {
		// * Definition du format utilise pour les dates DateFormat

		FacesContext face = FacesContext.getCurrentInstance();
		if (Module.corigerDate(dateLet) != null) {
			this.setDateLet(Module.corigerDate(dateLet));
		}
		if (!(Module.verifierDate(dateLet).equals("")))

		{
			blocage=true;
			face.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"", Module.verifierDate(dateLet)));
			
			dateLet = ancienValeurDateCertif;
		} else {
			ancienValeurDateCertif = dateLet;
		}

	}
	public void verifieractele()
	{
		
		FacesContext face = FacesContext.getCurrentInstance();
		if (Module.corigerDate(acte) != null) {
			this.setActe(Module.corigerDate(acte));
		}
		if (!(Module.verifierDate(acte).equals("")))

		{
			blocage=true;
			face.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"", Module.verifierDate(acte)));
			
			acte = ancienValeurDateCertif;
		} else {
			ancienValeurDateCertif = acte;
		}
		
	}

	public void modifierLettre(historiqueLettre h) {
		action = "Modification";
		RequestContext context = RequestContext.getCurrentInstance();
		nomLettre = h.getLettre().getNomLettre();
		textLettre = h.getTextLettre();
		idHistoriquelettre = h.getIdHistoriquelettre();

		Format format = new SimpleDateFormat("dd/MM/yyyy");
		if (h.getDatelettre() != null)
			dateLet = format.format(h.getDatelettre());

		ddr = h.getDdr();
		debutGross = h.getDebutGross();

		frotti = h.getFrotti();
		gs = h.getGs();
		rh = h.getRh();
		rubeoole = h.getRubeoole();
		termeactuel = h.getTermeactuel();
		lettre = h.getLettre();
		resultatfrotti = h.getResultatfrotti();
		termeprevue = h.getTermeprevue();
		code = h.getCode();
		if (h.getDateActe() != null)
			acte = format.format(h.getDateActe());

		autre = h.getAutre();
		toxo = h.getToxo();
		tpha = h.getTpha();
		clinique = h.getClinique();
		description = h.getDescription();
		diagnostic = h.getDiagnostic();

		if (nomLettre
				.equals("Lettre de réponse à une demande de prise en charge")) {
			context.execute("PF('lettrereponse').show();");

		}
		if (nomLettre.equals("Lettre d'accouchement")) {
			context.execute("PF('lettreAccouchement').show();");

		}
		if (nomLettre.equals("Lettre de réponse")) {
			context.execute("PF('lettreReponse2').show();");

		}

	}

	public void goToAccueil() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {

			context.getExternalContext().redirect("Accueil");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void goToRead() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {

			context.getExternalContext().redirect("FichePatiente");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void initialeRetour() {
		nomLettre = null;
		textLettre = null;
		goToRead();
	}

	public boolean isBlocage() {
		return blocage;
	}

	public void setBlocage(boolean blocage) {
		this.blocage = blocage;
	}
	public void V2SigneCliniqueChange()
	{
		setV2SigneClinique(v2SigneClinique);
		
	}

}

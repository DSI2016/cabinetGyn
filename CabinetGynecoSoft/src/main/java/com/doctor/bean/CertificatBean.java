package com.doctor.bean;

// Generated 18 ao�t 2014 11:50:48 by Hibernate Tools 3.4.0.CR1

//import java.awt.event.ActionEvent;
import java.io.File;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JasperRunManager;

import org.primefaces.event.SelectEvent;

import com.doctor.dao.HibernateUtil;
import com.doctor.persistance.Certificat;
import com.doctor.persistance.Cfclient;
import com.doctor.service.CertificatService;
import com.mysql.jdbc.Connection;

@ManagedBean(name = "certificatBean")
@SessionScoped
public class CertificatBean implements java.io.Serializable {

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;

	private Integer idcertificat;
	private String nomCertificat;
	private String remarque;
	private String remarques;
	private Date dateCertif;
	private Date datereprise;
	private Double dureederepos;
	private Cfclient cfclient;
	private Date adaterdu;
	private Date datedelagression;
	private String type;
	private String accompagnant;
	private String lesions;
	private String nomprenom;
	private Double heurelagr;
	private Double minutelagr;
	private Double heuresys;
	private Double minutesys;
	private String inapte;
	private String cin;
	private Date livreele;
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

	private Set<Cfclient> cfclients = new HashSet<Cfclient>(0);
	private Certificat selectedCertif;
	private List<String> types = new ArrayList<String>();

	public Cfclient getCfclient() {
		return cfclient;
	}

	public void setCfclient(Cfclient cfclient) {
		this.cfclient = cfclient;
	}

	private String valeurRecherche;

	public String getValeurRecherche() {
		return valeurRecherche;
	}

	public void setValeurRecherche(String valeurRecherche) {
		this.valeurRecherche = valeurRecherche;
	}

	public void annulerRecherche() {
		valeurRecherche = null;
	}

	public Set<Cfclient> getCfclients() {
		return cfclients;
	}

	public void setCfclients(Set<Cfclient> cfclients) {
		this.cfclients = cfclients;
	}

	private List<Certificat> certificats = new ArrayList<Certificat>();
	// action est un attribut pour différencier l'ajout de la modification
	private String action;

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public Integer getIdcertificat() {
		return this.idcertificat;
	}

	public void setIdcertificat(Integer idcertificat) {
		this.idcertificat = idcertificat;
	}

	public String getNomCertificat() {
		return nomCertificat;
	}

	public void setNomCertificat(String nomCertificat) {
		this.nomCertificat = nomCertificat;
	}

	public String getRemarque() {
		
		return remarque;
	}

	public void setRemarque(String remarque) {
		this.remarque = remarque;
		
	}

	public String getRemarques() {
		return remarques;
	}

	public void setRemarques(String remarques) {
		this.remarques = remarques;
	}

	public Date getDateCertif() {
		return dateCertif;
	}

	public void setDateCertif(Date dateCertif) {
		this.dateCertif = dateCertif;
	}

	public Date getDatereprise() {
		return datereprise;
	}

	public void setDatereprise(Date datereprise) {
		this.datereprise = datereprise;
	}

	public Double getDureederepos() {
		return dureederepos;
	}

	public void setDureederepos(Double dureederepos) {
		this.dureederepos = dureederepos;
	}

	public Date getAdaterdu() {
		return adaterdu;
	}

	public void setAdaterdu(Date adaterdu) {
		this.adaterdu = adaterdu;
	}

	public Date getDatedelagression() {
		return datedelagression;
	}

	public void setDatedelagression(Date datedelagression) {
		this.datedelagression = datedelagression;
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

	public String getNomprenom() {
		return nomprenom;
	}

	public void setNomprenom(String nomprenom) {
		this.nomprenom = nomprenom;
	}

	public Double getHeurelagr() {
		return heurelagr;
	}

	public void setHeurelagr(Double heurelagr) {
		this.heurelagr = heurelagr;
	}

	public Double getMinutelagr() {
		return minutelagr;
	}

	public void setMinutelagr(Double minutelagr) {
		this.minutelagr = minutelagr;
	}

	public Double getHeuresys() {
		return heuresys;
	}

	public void setHeuresys(Double heuresys) {
		this.heuresys = heuresys;
	}

	public Double getMinutesys() {
		return minutesys;
	}

	public void setMinutesys(Double minutesys) {
		this.minutesys = minutesys;
	}

	public String getInapte() {
		return inapte;
	}

	public void setInapte(String inapte) {
		this.inapte = inapte;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public Date getLivreele() {
		return livreele;
	}

	public void setLivreele(Date livreele) {
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

	public List<String> getTypes() {
		types.clear();
		types.add(new String("Repos"));
		types.add(new String("Prolongation de Repos"));
		types.add(new String("Repos Cnss"));

		return types;
	}
	public void setTypes(List<String> types) {
		this.types = types;
	}

	public List<Certificat> getCertificats() {

		CertificatService ser = new CertificatService();
		if (valeurRecherche != null)
			certificats = ser.rechercheFiltre(valeurRecherche);
		else
			certificats = ser.rechercheTousCertificat();
		return certificats;

	}

	public void setCertificats(List<Certificat> certificats) {
		this.certificats = certificats;
	}

	public void modifierCertificat(Certificat cert) {

		idcertificat = cert.getIdcertificat();
		nomCertificat = cert.getNomCertificat();
		remarque = cert.getRemarque();
		action = "Modifier";
	}

	public void ajouterCertificat() {
		action = "Ajouter";
	}

	public String closeDiag() {
		idcertificat = null;
		nomCertificat = null;
		remarque = null;
		return null;
	}

	public void Supprimer(Integer id) {
		// FacesContext faces = FacesContext.getCurrentInstance();
		CertificatService ser = new CertificatService();

		ser.supprimerCertificat(id);

	}

	public void onRowSelectcertif(SelectEvent event) {

		Certificat c = (Certificat) event.getObject();
		selectedCertif = c;
		nomCertificat = c.getNomCertificat();
		remarque = c.getRemarque();
		idcertificat = c.getIdcertificat();
		action = "Modifier";

	}

	public void validation() {
		CertificatService ser = new CertificatService();

		FacesContext faces = FacesContext.getCurrentInstance();

		if (action.equals("Modifier")) {
			if (nomCertificat == null || (nomCertificat.trim().length() == 0)) {// tester
																				// si
																				// cette
																				// zone
																				// de
																				// text
																				// est
																				// vide
				faces.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
						"", "la zone text est vide"));	
			} else // tester si cette certificat existe déjà
			{
				Certificat d = new Certificat(selectedCertif.getNomCertificat());

				Certificat d2 = ser.rechercheParCertificat(selectedCertif
						.getNomCertificat());
				if ((d2 != null)
						&& !d2.getIdcertificat().equals(
								selectedCertif.getIdcertificat())) { // c-à-d
																		// n'existe
																		// pas
																		// certificat
																		// avec
																		// cette
																		// //
																		// "certificat"

					faces.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
							"", "La certificat \""
							+ nomCertificat + "\" existe déja."));	

					
				}

				else {
					d.setIdcertificat(idcertificat);
					d.setRemarque(remarque);
					ser.modifierCertificat(d);

					faces.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
							"", "Certificat modifiée avec succès."));	
					
				}

			}
		}

		else if (action.equals("Ajouter")) {

			if (nomCertificat == null || (nomCertificat.trim().length() == 0)) {// tester
																				// si
																				// cette
																				// zone
																				// de
																				// text
																				// est
																				// vide
				faces.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"", "la zone text est vide"));
			} else // tester si cette certificat existe déjà
			{
				Certificat d3 = ser.rechercheParCertificat(nomCertificat);
				if (d3 == null) { // c-à-d n'existe pas certificat avec cette //
									// "certificat"
					Certificat d1 = new Certificat(nomCertificat);
					d1.setRemarque(remarque);
					ser.ajoutCertificat(d1);
					faces.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
							"", "Certificat ajouter avec succés"));

				} else {// faces.addMessage(null,new FacesMessage(
						// "Cette certificat existe déja."));
					faces.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
							"", "La certificat \""
									+ nomCertificat + "\" existe déja."));
					
				}
			}
		}

		// nomCertificat = null;
		// idcertificat = null;
		// remarque=null;
	}

	public void viewCertificat(ActionEvent actionEvent) throws SQLException,
			Exception {
		String nomReport = "gestionmodelecertificat";

		Connection connection = (Connection) DriverManager.getConnection(
				HibernateUtil.url, HibernateUtil.login, HibernateUtil.pass);
		File jasper = new File(FacesContext.getCurrentInstance()
				.getExternalContext()
				.getRealPath("/reports/" + nomReport + ".jasper"));
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("idcert", selectedCertif.getIdcertificat());
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

	public Certificat getSelectedCertif() {
		return selectedCertif;
	}

	public void setSelectedCertif(Certificat selectedCertif) {
		this.selectedCertif = selectedCertif;
	}

	public void retour() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {

			context.getExternalContext().redirect("Modelle-Rapport");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void gotoAcceuil() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {

			context.getExternalContext().redirect("Accueil");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}

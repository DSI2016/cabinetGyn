package com.doctor.bean;

import java.io.File;
import java.sql.DriverManager;
import java.sql.SQLException;
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

import net.sf.jasperreports.engine.JasperRunManager;

import org.primefaces.event.SelectEvent;

import com.doctor.dao.HibernateUtil;
import com.doctor.persistance.Lettre;
import com.doctor.service.LettreService;
import com.mysql.jdbc.Connection;

@ManagedBean(name = "lettreBean")
@SessionScoped
public class lettreBean {
	private Integer idlettre;
	private Date Datelettre;
	private String code;
	private Date dateActe;
	private String clinique;
	private String description;
	private String ddr;
	private String debutGross;
	private String termeprevue;
	private String termeactuel;
	private String rubeoole;
	private String frotti;
	private String gs;
	private String rh;
	private String resultatfrotti;
	private String diagnostic;
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
	private String nomLettre;
	private String textLettre;
	private String action;
	private String toxo;
	private String tpha;
	private Lettre selectedLettre;
	private List<Lettre> lettres = new ArrayList<Lettre>();
	private String autre;

	public List<Lettre> getLettres() {
		LettreService ser = new LettreService();
		lettres = ser.rechercheTouslettre();
		return lettres;
	}

	public void setLettres(List<Lettre> lettres) {
		this.lettres = lettres;
	}

	public Integer getIdlettre() {
		return idlettre;
	}

	public void setIdlettre(Integer idlettre) {
		this.idlettre = idlettre;
	}

	public Date getDatelettre() {
		return Datelettre;
	}

	public void setDatelettre(Date datelettre) {
		Datelettre = datelettre;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getDateActe() {
		return dateActe;
	}

	public void setDateActe(Date dateActe) {
		this.dateActe = dateActe;
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

	public String getNomLettre() {
		return nomLettre;
	}

	public void setNomLettre(String nomLettre) {
		this.nomLettre = nomLettre;
	}

	public String getTextLettre() {
		return textLettre;
	}

	public void setTextLettre(String textLettre) {
		this.textLettre = textLettre;
	}

	public void modifierLettre(Lettre cert) {

		idlettre = cert.getIdlettre();
		nomLettre = cert.getNomLettre();
		textLettre = cert.getTextLettre();
		action = "Modifier";

		// selectedCertif=cert;

	}

	public void ajouterCertificat() {
		action = "Ajouter";
	}

	public String closeDiag() {
		idlettre = null;
		nomLettre = null;
		textLettre = null;
		return null;
	}

	public void Supprimer(Integer id) {
		LettreService ser = new LettreService();
		ser.supprimerlettre(id);
	}

	public void onRowSelectlettre(SelectEvent event) {
		Lettre c = (Lettre) event.getObject();

		selectedLettre = c;
		nomLettre = c.getNomLettre();
		textLettre = c.getTextLettre();
		idlettre = c.getIdlettre();
		action = "Modifier";

	}

	public void validation() {
		LettreService ser = new LettreService();

		FacesContext faces = FacesContext.getCurrentInstance();

		if (action.equals("Modifier")) {
			if (nomLettre == null || (nomLettre.trim().length() == 0)) {// tester
																		// si
																		// cette
																		// zone
																		// de
																		// text
																		// est
																		// vide
				faces.addMessage(null,
						new FacesMessage("la zone text est vide"));
			} else // tester si cette lettre existe déjà
			{
				Lettre d = new Lettre(selectedLettre.getNomLettre());

				{
					d.setIdlettre(idlettre);
					d.setTextLettre(textLettre);
					ser.modifierlettre(d);

					faces.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
							"", "Lettre modifiée avec succès."));
					
				}

			}
		}

		else if (action.equals("Ajouter")) {

			if (nomLettre == null || (nomLettre.trim().length() == 0)) {// tester
																		// si
																		// cette
																		// zone
																		// de
																		// text
																		// est
			
				faces.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"", "la zone text est vide"));// vide
				
			}
			// tester si cette certificat existe déjà

			// c-à-d n'existe pas certificat avec cette // "certificat"
			Lettre d1 = new Lettre(nomLettre);
			d1.setTextLettre(textLettre);
			ser.ajoutLettre(d1);
			faces.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"", "Lettre modifiée avec succès."));

		}
	}

	// nomCertificat = null;
	// idcertificat = null;
	// remarque=null;

	public void viewCertificat(ActionEvent actionEvent) throws SQLException,
			Exception {
		String nomReport = "modelelettre4";

		if (idlettre == 1) {
			// nomReport = "modelelettredereponsea";
			nomReport = "reportTest";
		} else if ((idlettre == 2) || (idlettre == 3)) {
			nomReport = "modelelettre4";
		}

		Connection connection = (Connection) DriverManager.getConnection(
				HibernateUtil.url, HibernateUtil.login, HibernateUtil.pass);
		File jasper = new File(FacesContext.getCurrentInstance()
				.getExternalContext()
				.getRealPath("/reports/" + nomReport + ".jasper"));
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("idlettre", idlettre);
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

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public Lettre getSelectedLettre() {
		return selectedLettre;
	}

	public void setSelectedLettre(Lettre selectedLettre) {
		this.selectedLettre = selectedLettre;
	}

	public String getAutre() {
		return autre;
	}

	public void setAutre(String autre) {
		this.autre = autre;
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
	
	
	
	
	
	
	public void gotoRapport() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {

			context.getExternalContext().redirect("Modelle-Rapport");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}

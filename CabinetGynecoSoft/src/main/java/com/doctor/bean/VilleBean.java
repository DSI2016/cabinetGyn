package com.doctor.bean;


//import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperRunManager;

import org.primefaces.context.RequestContext;

import com.doctor.persistance.Cfclient;
import com.doctor.persistance.Ville;
import com.doctor.service.CfclientService;
import com.doctor.service.VilleService;
import com.mysql.jdbc.Connection;

@ManagedBean(name = "villeBean")
@SessionScoped
public class VilleBean implements java.io.Serializable {

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;

	private Integer idville;
	private String ville;
	private Set<Cfclient> cfclients = new HashSet<Cfclient>(0);
	private int currentP;

	public int getCurrentP() {

		return currentP;
	}

	public void setCurrentP(int currentP) {
		this.currentP = currentP;
	}

	

	private String valeurRecherche;

	public String getValeurRecherche() {
		valeurRecherche = Module.rechercheVille;
		return valeurRecherche;
	}

	public void setValeurRecherche(String valeurRecherche) {
		Module.rechercheVille = valeurRecherche;
		this.valeurRecherche = valeurRecherche;
	}

	public void annulerRecherche() {
		Module.rechercheVille = "";
		valeurRecherche = null;
	}

	public Set<Cfclient> getCfclients() {
		return cfclients;
	}

	public void setCfclients(Set<Cfclient> cfclients) {
		this.cfclients = cfclients;
	}

	private List<Ville> villes = new ArrayList<Ville>();
	// action est un attribut pour différencier l'ajout de la modification
	private String action;

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public Integer getIdville() {
		return this.idville;
	}

	public void setIdville(Integer idville) {
		this.idville = idville;
	}

	public String getVille() {
		return this.ville;

	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public List<Ville> getVilles() {

		FacesContext.getCurrentInstance().getViewRoot();

		VilleService ser = new VilleService();
		if (valeurRecherche != null)
			villes = ser.rechercheFiltre(valeurRecherche);
		else
			villes = ser.rechercheTousVille();
		return villes;

	}

	public void setVilles(List<Ville> villes) {
		this.villes = villes;
	}

	public void modifierVille(Ville d) {
		idville = d.getIdville();
		ville = d.getVille();
		action = "Modification";

	}

	public void ajouterVille() {
		action = "Ajout";
	}

	public String closeDiag() {
		idville = null;
		ville = null;
		return null;
	}

	public void Supprimer(Integer id) {
		FacesContext faces = FacesContext.getCurrentInstance();
		VilleService ser = new VilleService();
		CfclientService ser02 = new CfclientService();
		List<Cfclient> l = ser02.RechercheParVille(id);
		if (l != null && l.size() == 0) {
			ser.supprimerVille(id);
			faces.addMessage(null, new FacesMessage(
					"Ville supprimée avec succès."));
		} else
			faces.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"Suppression impossible!  Ville utilisée.", ""));

		FacesContext context2 = FacesContext.getCurrentInstance();
		context2.getExternalContext().getFlash()
				.setKeepMessages(true);
		try {
			context2.getExternalContext().redirect("GestionVille");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void validation() {
		VilleService ser = new VilleService();

		FacesContext faces = FacesContext.getCurrentInstance();
		RequestContext context = RequestContext.getCurrentInstance();
		boolean addValid = false;

		if (action.equals("Modification")) {
			if (ville == null || (ville.trim().length() == 0)) {// tester si
																// cette zone de
																// text est vide
				faces.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_ERROR,
						"Veuillez donner le nom de la ville.", null));
				addValid = false;
			} else // tester si cette ville existe déjà
			{
				Ville d = new Ville(ville);

				Ville d2 = ser.rechercheParVille(ville);

				if ((d2 != null) && !d2.getIdville().equals(idville)) {
					// c-à-d n'existe pas ville avec cette "ville"
					faces.addMessage(null, new FacesMessage(
							FacesMessage.SEVERITY_ERROR, "La ville \"" + ville
									+ "\" existe déjà.", null));
					addValid = false;
				}

				else {
					d.setIdville(idville);
					ser.modifierVille(d);
					faces.addMessage(null, new FacesMessage(
							"Ville est modifiée avec succès."));
					addValid = true;
					initialisation();
					RequestContext.getCurrentInstance().update("f1");

					FacesContext context2 = FacesContext.getCurrentInstance();
					context2.getExternalContext().getFlash()
							.setKeepMessages(true);
					try {
						context2.getExternalContext().redirect("GestionVille");
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}

			}
		}

		else if (action.equals("Ajout")) {

			if (ville == null || (ville.trim().length() == 0)) {// tester si
																// cette zone de
																// text est vide
				faces.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_ERROR,
						"Veuillez donner le nom de la ville.", null));
				addValid = false;
			} else // tester si cette ville existe déjà
			{
				Ville d3 = ser.rechercheParVille(ville);
				if (d3 == null) { // c-à-d n'existe pas ville avec cette //
									// "ville"
					Ville d1 = new Ville(ville);
					ser.ajoutVille(d1);
					faces.addMessage(null, new FacesMessage("La ville \""
							+ ville + "\" est ajoutée avec succès."));
					addValid = true;
					initialisation();
					RequestContext.getCurrentInstance().update("f1");
					FacesContext context2 = FacesContext.getCurrentInstance();
					context2.getExternalContext().getFlash()
							.setKeepMessages(true);
					try {
						context2.getExternalContext().redirect("GestionVille");
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				} else {
					faces.addMessage(null, new FacesMessage(
							FacesMessage.SEVERITY_ERROR, "La ville \"" + ville
									+ "\" existe déjà.", null));
					addValid = false;
				}
			}
		}
		context.addCallbackParam("addValid", addValid);

	}

	public void initialisation() {
		ville = null;
		idville = null;
	}

	JasperPrint jasperPrint;

	public void init() throws SQLException, JRException, IOException {
		Connection connection = (Connection) DriverManager.getConnection(
				"jdbc:mysql://localhost/docteurbase", "root", "root");
		String reportPath = FacesContext.getCurrentInstance()
				.getExternalContext().getRealPath("reports/report1.jasper");
		jasperPrint = JasperFillManager
				.fillReport(reportPath, null, connection);
	}

	public void PDF(ActionEvent actionEvent) {
		try {
			init();
			HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext
					.getCurrentInstance().getExternalContext().getResponse();
			httpServletResponse.addHeader("Content-disposition",
					"attachment; filename=ListeVille.pdf");
			httpServletResponse.setContentType("application/pdf");
			ServletOutputStream servletOutputStream = httpServletResponse
					.getOutputStream();
			JasperExportManager.exportReportToPdfStream(jasperPrint,
					servletOutputStream);
			servletOutputStream.flush();
			servletOutputStream.close();
		} catch (Exception e) {
			System.out.println("excep" + e.getMessage());
			e.printStackTrace();
		}
		FacesContext.getCurrentInstance().responseComplete();
	}

	public void viewPDF(ActionEvent actionEvent) throws SQLException, Exception {
		Connection connection = (Connection) DriverManager.getConnection(
				"jdbc:mysql://localhost/docteurbase", "root", "root");
		File jasper = new File(FacesContext.getCurrentInstance()
				.getExternalContext().getRealPath("/reports/report1.jasper"));
		byte[] bytes = JasperRunManager.runReportToPdf(jasper.getPath(), null,
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

}

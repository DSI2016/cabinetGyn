package com.doctor.bean;

// Generated 18 ao�t 2014 11:50:48 by Hibernate Tools 3.4.0.CR1

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import com.doctor.persistance.Cfclient;
import com.doctor.persistance.EtatFinGross;
import com.doctor.persistance.HistoriqueGross;
import com.doctor.service.EtatFinGrossService;
import com.doctor.service.HistoriqueGrossService;

@ManagedBean(name = "etatFinGrossBean")
@SessionScoped
public class EtatFinGrossBean implements java.io.Serializable {

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;

	private Integer idEtatFinGross;
	private boolean increment = true;
	private int currentP;

	public int getCurrentP() {
		return currentP;
	}

	public void setCurrentP(int currentP) {
		this.currentP = currentP;
	}

	public boolean isIncrement() {
		return increment;
	}

	public void setIncrement(boolean increment) {
		this.increment = increment;
	}

	public String getEtatFinG() {
		return etatFinG;
	}

	public void setEtatFinG(String etatFinG) {
		this.etatFinG = etatFinG;
	}

	private String etatFinG;
	private Set<Cfclient> cfclients = new HashSet<Cfclient>(0);
	private List<EtatFinGross> etatFinGrosss = new ArrayList<EtatFinGross>();
	// action est un attribut pour différencier l'ajout de la modification
	private String action;

	private String valeurRecherche;

	public Integer getIdEtatFinGross() {

		return idEtatFinGross;
	}

	public void setIdEtatFinGross(Integer idEtatFinGross) {
		this.idEtatFinGross = idEtatFinGross;
	}

	public String getValeurRecherche() {
		valeurRecherche = Module.rechercheEtatGross;
		return valeurRecherche;
	}

	public void setValeurRecherche(String valeurRecherche) {
		Module.rechercheEtatGross = valeurRecherche;
		this.valeurRecherche = valeurRecherche;
	}

	public void annulerRecherche() {
		Module.rechercheEtatGross = "";
		valeurRecherche = null;
	}

	public Set<Cfclient> getCfclients() {
		return cfclients;
	}

	public void setCfclients(Set<Cfclient> cfclients) {
		this.cfclients = cfclients;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public List<EtatFinGross> getEtatFinGrosss() {

		EtatFinGrossService ser = new EtatFinGrossService();
		if (valeurRecherche != null)
			etatFinGrosss = ser.rechercheFiltre(valeurRecherche);
		else
			etatFinGrosss = ser.rechercheTousEtatFinGross();
		return etatFinGrosss;

	}

	public void setEtatFinGrosss(List<EtatFinGross> etatFinGs) {
		this.etatFinGrosss = etatFinGs;
	}

	public void modifierEtatFinGross(EtatFinGross d) {
		idEtatFinGross = d.getIdEtatFinGross();
		etatFinG = d.getEtatFinG();
		increment = d.isIncrementation();
		action = "Modification";

	}

	public void ajouterEtatFinGross() {
		action = "Ajout";
	}

	public String closeDiag() {
		idEtatFinGross = null;
		etatFinG = null;
		increment = true;
		return null;
	}

	public void Supprimer(Integer id) {

		FacesContext faces = FacesContext.getCurrentInstance();
		List<HistoriqueGross> hist = new HistoriqueGrossService()
				.rechercheHistoriqueParEtatGross(id);
		if (hist != null && hist.size() > 0)
			faces.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"Suppression impossible! Etat utilisé.", null));
		else {
			EtatFinGrossService ser = new EtatFinGrossService();
			ser.supprimerEtatFinGross(id);
			faces.addMessage(
					null,
					new FacesMessage(
							"Etat supprimé avec succès."));
			FacesContext context2 = FacesContext.getCurrentInstance();
			context2.getExternalContext().getFlash().setKeepMessages(true);
			try {
				context2.getExternalContext().redirect(
						"GestionEtatFinGrossesses");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}

	}

	public void validation() {
		EtatFinGrossService ser = new EtatFinGrossService();

		FacesContext faces = FacesContext.getCurrentInstance();
		RequestContext context = RequestContext.getCurrentInstance();
		boolean addValid = false;
		if (action.equals("Modification")) {
			if (etatFinG == null || (etatFinG.trim().length() == 0)) {

				faces.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_ERROR,
						"Veuillez donner le nom de l'état.", null));
				addValid = false;
			} else // tester si cette etatFinG existe déjà
			{
				EtatFinGross d = new EtatFinGross();
				d.setEtatFinG(etatFinG);
				EtatFinGross d2 = ser.rechercheParEtatFinGross(etatFinG);
				if (d2 != null
						&& !d2.getIdEtatFinGross().equals(idEtatFinGross)) {
					faces.addMessage(null, new FacesMessage(
							FacesMessage.SEVERITY_ERROR, "L'état \"" + etatFinG
									+ "\" existe déjà.", null));
					addValid = false;

				} else {
					d.setIdEtatFinGross(idEtatFinGross);
					d.setIncrementation(increment);
					ser.modifierEtatFinGross(d);
					faces.addMessage(null, new FacesMessage(
							"Etat est modifié avec succès."));
					addValid = true;
					initialisation();
					RequestContext.getCurrentInstance().update("f1");
					FacesContext context2 = FacesContext.getCurrentInstance();
					context2.getExternalContext().getFlash()
							.setKeepMessages(true);
					try {
						context2.getExternalContext().redirect(
								"GestionEtatFinGrossesses");
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
			}
		}

		else if (action.equals("Ajout")) {

			if (etatFinG == null || (etatFinG.trim().length() == 0)) {
				faces.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_ERROR,
						"Veuillez donner le nom de l'état.", null));
				addValid = false;
			} else // tester si cette etatFinG existe déjà
			{
				EtatFinGross d3 = ser.rechercheParEtatFinGross(etatFinG);
				if (d3 == null) { // c-à-d n'existe pas etatFinG avec cette //
									// "etatFinG"
					EtatFinGross d1 = new EtatFinGross();
					d1.setEtatFinG(etatFinG);
					d1.setIncrementation(increment);
					ser.ajoutEtatFinGross(d1);
					faces.addMessage(null, new FacesMessage(
							"Etat ajouté avec succès."));
					addValid = true;
					initialisation();
					RequestContext.getCurrentInstance().update("f1");
					FacesContext context2 = FacesContext.getCurrentInstance();
					context2.getExternalContext().getFlash()
							.setKeepMessages(true);
					try {
						context2.getExternalContext().redirect(
								"GestionEtatFinGrossesses");
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}

				} else {// faces.addMessage(null,new FacesMessage(
						// "Cette etatFinG existe déja."));
					faces.addMessage(null, new FacesMessage(
							FacesMessage.SEVERITY_ERROR, "L'état \"" + etatFinG
									+ "\" existe déjà.", null));
					addValid = false;
				}
			}
		}
		context.addCallbackParam("addValid", addValid);
	}

	public void initialisation() {
		etatFinG = null;
		idEtatFinGross = null;
		increment = true;
	}
}

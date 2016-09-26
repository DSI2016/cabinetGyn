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
import com.doctor.persistance.EtatBebe;
import com.doctor.persistance.HistoriqueGross;
import com.doctor.service.EtatBebeService;
import com.doctor.service.HistoriqueGrossService;

@ManagedBean(name = "etatBebeBean")
@SessionScoped
public class EtatBebeBean implements java.io.Serializable {

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;

	private Integer idetatBebe;
	private String etatBebe;
	private Set<Cfclient> cfclients = new HashSet<Cfclient>(0);

	private int currentP;

	public int getCurrentP() {
		return currentP;
	}

	public void setCurrentP(int currentP) {
		this.currentP = currentP;
	}

	private String valeurRecherche;
	private boolean increment = true;

	public boolean isIncrement() {
		return increment;
	}

	public void setIncrement(boolean increment) {
		this.increment = increment;
	}

	public String getValeurRecherche() {
		valeurRecherche=Module.rechercheEtatBebe;
		return valeurRecherche;
	}

	public void setValeurRecherche(String valeurRecherche) {
		Module.rechercheEtatBebe=valeurRecherche;
		this.valeurRecherche = valeurRecherche;
	}

	public void annulerRecherche() {
		Module.rechercheEtatBebe="";
		valeurRecherche = null;
	}

	public Set<Cfclient> getCfclients() {
		return cfclients;
	}

	public void setCfclients(Set<Cfclient> cfclients) {
		this.cfclients = cfclients;
	}

	private List<EtatBebe> etatBebes = new ArrayList<EtatBebe>();
	// action est un attribut pour différencier l'ajout de la modification
	private String action;

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public Integer getIdetatBebe() {
		return this.idetatBebe;
	}

	public void setIdetatBebe(Integer idetatBebe) {
		this.idetatBebe = idetatBebe;
	}

	public String getEtatBebe() {
		return this.etatBebe;
	}

	public void setEtatBebe(String etatBebe) {
		this.etatBebe = etatBebe;
	}

	public List<EtatBebe> getEtatBebes() {

		EtatBebeService ser = new EtatBebeService();
		if (valeurRecherche != null)
			etatBebes = ser.rechercheFiltre(valeurRecherche);
		else
			etatBebes = ser.rechercheTousEtatBebe();
		return etatBebes;

	}

	public void setEtatBebes(List<EtatBebe> etatBebes) {
		this.etatBebes = etatBebes;
	}

	public void modifierEtatBebe(EtatBebe d) {
		idetatBebe = d.getIdetatBebe();
		etatBebe = d.getEtatBebe();
		increment = d.isIncrementation();
		action = "Modification";

	}

	public void ajouterEtatBebe() {
		initialisation();
		action = "Ajout";
	}

	public String closeDiag() {
		idetatBebe = null;
		etatBebe = null;
		increment = true;
		return null;
	}

	public void Supprimer(Integer id) {
		FacesContext faces = FacesContext.getCurrentInstance();
		List<HistoriqueGross> hist = new HistoriqueGrossService()
				.rechercheHistoriqueParEtatBebe(id);
		if (hist != null && hist.size() > 0)
			faces.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"Suppression impossible! Etat utilisé.", null));
		else {
			EtatBebeService ser = new EtatBebeService();
			ser.supprimerEtatBebe(id);
			faces.addMessage(null, new FacesMessage(
					"Etat supprimé avec succès."));

		}
		FacesContext context2 = FacesContext.getCurrentInstance();
		context2.getExternalContext().getFlash().setKeepMessages(true);
		try {
			context2.getExternalContext().redirect("GestionEtatBebe");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void validation() {
		etatBebe=etatBebe.replaceAll("\\s+", " ");
		EtatBebeService ser = new EtatBebeService();

		FacesContext faces = FacesContext.getCurrentInstance();
		RequestContext context = RequestContext.getCurrentInstance();
		boolean addValid = false;
		if (action.equals("Modification")) {
			if (etatBebe == null || (etatBebe.trim().length() == 0)) {

				faces.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_ERROR,
						"Veuillez donner le nom de l'état.", null));
				addValid = false;
			} else // tester si cette etatBebe existe déjà
			{
				EtatBebe d = new EtatBebe(etatBebe);
				EtatBebe d2 = ser.rechercheParEtatBebe(etatBebe);
				if (d2 != null && !d2.getIdetatBebe().equals(idetatBebe)) {
					faces.addMessage(null, new FacesMessage(
							FacesMessage.SEVERITY_ERROR, "L'état \"" + etatBebe
									+ "\" existe déjà.", null));
					addValid = false;

				} else {
					d.setIdetatBebe(idetatBebe);
					d.setIncrementation(increment);
					ser.modifierEtatBebe(d);
					faces.addMessage(null, new FacesMessage(
							"Etat bébé modifié avec succès."));
					addValid = true;
					initialisation();
					RequestContext.getCurrentInstance().update("f1");
					FacesContext context2 = FacesContext.getCurrentInstance();
					context2.getExternalContext().getFlash()
							.setKeepMessages(true);
					try {
						context2.getExternalContext().redirect(
								"GestionEtatBebe");
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
			}
		}

		else if (action.equals("Ajout")) {

			if (etatBebe == null || (etatBebe.trim().length() == 0)) {
				faces.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_ERROR,
						"Veuillez donner le nom de l'état.", null));
				addValid = false;
			} else // tester si cette etatBebe existe déjà
			{
				EtatBebe d3 = ser.rechercheParEtatBebe(etatBebe);
				if (d3 == null) { // c-à-d n'existe pas etatBebe avec cette //
									// "etatBebe"
					EtatBebe d1 = new EtatBebe(etatBebe);
					d1.setIncrementation(increment);
					ser.ajoutEtatBebe(d1);
					faces.addMessage(null, new FacesMessage(
							"Etat Bébé ajouté avec succès."));
					addValid = true;
					initialisation();
					RequestContext.getCurrentInstance().update("f1");
					FacesContext context2 = FacesContext.getCurrentInstance();
					context2.getExternalContext().getFlash()
							.setKeepMessages(true);
					try {
						context2.getExternalContext().redirect(
								"GestionEtatBebe");
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}

				} else {// faces.addMessage(null,new FacesMessage(
						// "Cette etatBebe existe déja."));

					faces.addMessage(null, new FacesMessage(
							FacesMessage.SEVERITY_ERROR, "L'état \"" + etatBebe
									+ "\" existe déjà.", null));
					addValid = false;

				}
			}
		}
		context.addCallbackParam("addValid", addValid);
	}

	public void initialisation() {
		etatBebe = null;
		idetatBebe = null;
		increment = true;
	}
}

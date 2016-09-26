package com.doctor.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import com.doctor.persistance.MoyenContraception;
import com.doctor.service.MoyenContraceptionService;

@ManagedBean(name = "moyenContraceptionBean")
@SessionScoped
public class MoyenContraceptionBean implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idmoyenContraception;
	private String libMoyenContraception;
	private String action;
	private String valeurRecherche;

	private int currentP;

	public int getCurrentP() {
		return currentP;
	}

	public void setCurrentP(int currentP) {
		this.currentP = currentP;
	}

	public String getValeurRecherche() {
		valeurRecherche = Module.rechercheContracept;
		return valeurRecherche;
	}

	public void setValeurRecherche(String valeurRecherche) {
		Module.rechercheContracept = valeurRecherche;
		this.valeurRecherche = valeurRecherche;
	}

	public void annulerRecherche() {
		Module.rechercheContracept = "";
		valeurRecherche = null;
	}

	private List<MoyenContraception> moyenContraceptions = new ArrayList<MoyenContraception>();

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public Integer getIdmoyenContraception() {
		return idmoyenContraception;
	}

	public void setIdmoyenContraception(Integer idmoyenContraception) {
		this.idmoyenContraception = idmoyenContraception;
	}

	public String getLibMoyenContraception() {
		return libMoyenContraception;
	}

	public void setLibMoyenContraception(String libMoyenContraception) {
		this.libMoyenContraception = libMoyenContraception;
	}

	public List<MoyenContraception> getMoyenContraceptions() {
		MoyenContraceptionService ser = new MoyenContraceptionService();
		if (valeurRecherche == null)
			moyenContraceptions = ser.rechercheTousMoyenContraception();
		else
			moyenContraceptions = ser.rechercheFiltre(valeurRecherche);
		return moyenContraceptions;
	}

	public void setMoyenContraceptions(
			List<MoyenContraception> moyenContraceptions) {
		this.moyenContraceptions = moyenContraceptions;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void ajouterMoyenContraception() {
		initialisation();
		action = "Ajout";
	}

	public String closeDiag() {
		idmoyenContraception = null;
		libMoyenContraception = null;
		return null;
	}

	public void modifierMoyenContraception(MoyenContraception d) {
		idmoyenContraception = d.getIdmoyenContraception();
		libMoyenContraception = d.getLibMoyenContraception();
		action = "Modification";

	}

	public void Supprimer(Integer id) {
		FacesContext faces = FacesContext.getCurrentInstance();
		MoyenContraceptionService ser = new MoyenContraceptionService();
		ser.supprimerMoyenContraception(id);
		faces.addMessage(null, new FacesMessage(
				"Moyen de contraception supprimé avec succès."));
		FacesContext context2 = FacesContext.getCurrentInstance();
		context2.getExternalContext().getFlash().setKeepMessages(true);
		try {
			context2.getExternalContext().redirect("GestionMoyenContraception");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void validation() {
		libMoyenContraception=libMoyenContraception.replaceAll("\\s+", " ");
		MoyenContraceptionService ser = new MoyenContraceptionService();

		FacesContext faces = FacesContext.getCurrentInstance();
		RequestContext context = RequestContext.getCurrentInstance();
		boolean addValid = false;
		if (action.equals("Modification")) {
			if (libMoyenContraception == null
					|| (libMoyenContraception.trim().length() == 0)) {
				faces.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_ERROR,
						"Veuillez donner le nom du moyen de contraception.",
						null));
				addValid = false;
			} else {
				MoyenContraception d = new MoyenContraception(
						libMoyenContraception);
				MoyenContraception d2 = ser
						.rechercheMoyenContraceptionParLibelleMoyenContraception(libMoyenContraception);

				if (d2 != null
						&& !d2.getIdmoyenContraception().equals(
								idmoyenContraception)) {

					faces.addMessage(null, new FacesMessage(
							FacesMessage.SEVERITY_ERROR,
							"Le moyen \"" + libMoyenContraception
									+ "\" existe déjà.", null));
					addValid = false;

				} else {
					d.setIdmoyenContraception(idmoyenContraception);
					d.setLibMoyenContraception(libMoyenContraception);
					ser.modifierMoyenContraception(d);
					faces.addMessage(null,
							new FacesMessage("Le moyen modifié avec succès."));
					addValid = true;
					initialisation();
					RequestContext.getCurrentInstance().update("f1");
					FacesContext context2 = FacesContext.getCurrentInstance();
					context2.getExternalContext().getFlash()
							.setKeepMessages(true);
					try {
						context2.getExternalContext().redirect(
								"GestionMoyenContraception");
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}

				}
			}
		}

		else

		if (action.equals("Ajout")) {

			if (libMoyenContraception == null
					|| (libMoyenContraception.trim().length() == 0)) {
				faces.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_ERROR,
						"Veuillez donner le nom du moyen de contraception.",
						null));
				addValid = false;
			} else // tester si cette etat existe déjà
			{

				MoyenContraception d3 = ser
						.rechercheMoyenContraceptionParLibelleMoyenContraception(libMoyenContraception);

				if (d3 == null) {

					MoyenContraception d1 = new MoyenContraception(
							libMoyenContraception);

					ser.ajoutMoyenContraception(d1);
					faces.addMessage(null, new FacesMessage("Le moyen \""
							+ libMoyenContraception + "\" ajouté avec succès."));
					addValid = true;
					initialisation();
					RequestContext.getCurrentInstance().update("f1");
					FacesContext context2 = FacesContext.getCurrentInstance();
					context2.getExternalContext().getFlash()
							.setKeepMessages(true);
					try {
						context2.getExternalContext().redirect(
								"GestionMoyenContraception");
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}

				} else

				{
					faces.addMessage(null, new FacesMessage(
							FacesMessage.SEVERITY_ERROR,
							"Le moyen \"" + libMoyenContraception
									+ "\" existe déjà.", null));
					addValid = false;
				}

			}
		}

		context.addCallbackParam("addValid", addValid);

	}

	public void initialisation() {
		libMoyenContraception = null;

		idmoyenContraception = null;
	}
}

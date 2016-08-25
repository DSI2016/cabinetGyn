package com.doctor.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import com.doctor.persistance.AntecedentChir;
import com.doctor.persistance.AntecedentFam;
import com.doctor.persistance.AntecedentMed;
import com.doctor.service.AntecedentChirService;
import com.doctor.service.AntecedentFamService;
import com.doctor.service.AntecedentMedService;

@ManagedBean(name = "gestionAntecedentBean")
@SessionScoped
public class GestionAntecedentBean {
	private String valeurRecherche;
	private int index;
	private String actionAnt;
	private String typeAnt;
	private String nomAntecedent;
	private Integer idantecedentChir;
	private Integer idantecedentMed;
	private Integer idantecedentFam;
	private List<AntecedentChir> antecedentChirs = new ArrayList<AntecedentChir>();
	private List<AntecedentMed> antecedentMeds = new ArrayList<AntecedentMed>();
	private List<AntecedentFam> antecedentFams = new ArrayList<AntecedentFam>();
	private int currentP1;
	private int currentP2;
	private int currentP3;

	@PostConstruct
	public void init() {
		if (valeurRecherche != null && valeurRecherche.length() > 0) {
			antecedentChirs = new AntecedentChirService()
					.rechercheParFilterAntecedentChir(valeurRecherche);
			antecedentMeds = new AntecedentMedService()
					.rechercheTousAntecedentMed(valeurRecherche);
			antecedentFams = new AntecedentFamService()
					.rechercheTousAntecedentFam(valeurRecherche);
		} else {
			antecedentChirs = new AntecedentChirService()
					.rechercheTousAntecedentChir();
			antecedentMeds = new AntecedentMedService()
					.rechercheTousAntecedentMed();
			antecedentFams = new AntecedentFamService()
					.rechercheTousAntecedentFam();
		}

	}

	// affectation des action et type antécédent lors de gestion
	public void ajouterAntecedentMed() {
		actionAnt = "Ajout";
		typeAnt = "médical";
	}

	public void ajouterAntecedentFam() {
		actionAnt = "Ajout";
		typeAnt = "familial";
	}

	public void ajouterAntecedentChir() {
		actionAnt = "Ajout";
		typeAnt = "chirugical";
	}

	public void validerAntecedent() {
		FacesContext faces = FacesContext.getCurrentInstance();
		RequestContext context = RequestContext.getCurrentInstance();
		boolean addValid = false;

		// Controle de saisi nom obligatoire
		if (nomAntecedent == null || nomAntecedent.trim().length() == 0) {
			faces.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"Veuillez donner le nom de l'antécédent.", ""));
			addValid = false;
		}

		if (faces.getMessageList().size() == 0) {
			if (actionAnt.equals("Ajout")) {
				// Controle de saisie de l'unicité
				if (typeAnt.equals("médical")) {
					AntecedentMed antM = new AntecedentMedService()
							.rechercheParAntecedentMed(nomAntecedent);
					if (antM != null) {
						faces.addMessage(null, new FacesMessage(
								FacesMessage.SEVERITY_ERROR,
								"Il exist déjà un antécédent sous le nom \" "
										+ nomAntecedent + " \".", ""));
						addValid = false;
					} else {
						AntecedentMed a = new AntecedentMed();
						a.setAntMedical(nomAntecedent);
						new AntecedentMedService().ajoutAntecedentMed(a);
						faces.addMessage(null, new FacesMessage(
								FacesMessage.SEVERITY_INFO, "L'antécédent \" "
										+ nomAntecedent
										+ " \" est ajouté avec succès.", ""));
						addValid = true;
						initialisationDialog();
						RequestContext.getCurrentInstance().update("f1");
						FacesContext context2 = FacesContext
								.getCurrentInstance();
						context2.getExternalContext().getFlash()
								.setKeepMessages(true);
						try {

							context2.getExternalContext().redirect(
									"GestionAntecedents");
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}

					}

				} else if (typeAnt.equals("familial")) {
					AntecedentFam antF = new AntecedentFamService()
							.rechercheParAntecedentFam(nomAntecedent);
					if (antF != null) {
						faces.addMessage(null, new FacesMessage(
								FacesMessage.SEVERITY_ERROR,
								"Il exist déjà un antécédent sous le nom \" "
										+ nomAntecedent + " \".", ""));
						addValid = false;
					} else {
						AntecedentFam a = new AntecedentFam();
						a.setAntFamilial(nomAntecedent);
						new AntecedentFamService().ajoutAntecedentFam(a);
						faces.addMessage(null, new FacesMessage(
								FacesMessage.SEVERITY_INFO, "L'antécédent \" "
										+ nomAntecedent
										+ " \" est ajouté avec succès.", ""));
						addValid = true;
						initialisationDialog();
						RequestContext.getCurrentInstance().update("f1");
						FacesContext context2 = FacesContext
								.getCurrentInstance();
						context2.getExternalContext().getFlash()
								.setKeepMessages(true);
						try {

							context2.getExternalContext().redirect(
									"GestionAntecedents");
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}

					}
				} else if (typeAnt.equals("chirugical")) {
					AntecedentChir antC = new AntecedentChirService()
							.rechercheParAntecedentChir(nomAntecedent);
					if (antC != null) {
						faces.addMessage(null, new FacesMessage(
								FacesMessage.SEVERITY_ERROR,
								"Il exist déjà un antécédent sous le nom \" "
										+ nomAntecedent + " \".", ""));
						addValid = false;
					} else {
						AntecedentChir a = new AntecedentChir();
						a.setAntChirugical(nomAntecedent);
						new AntecedentChirService().ajoutAntecedentChir(a);
						faces.addMessage(null, new FacesMessage(
								FacesMessage.SEVERITY_INFO, "L'antécédent \" "
										+ nomAntecedent
										+ " \" est ajouté avec succès.", ""));
						addValid = true;
						initialisationDialog();
						RequestContext.getCurrentInstance().update("f1");
						FacesContext context2 = FacesContext
								.getCurrentInstance();
						context2.getExternalContext().getFlash()
								.setKeepMessages(true);
						try {

							context2.getExternalContext().redirect(
									"GestionAntecedents");
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}
					}
				}

			} else if (actionAnt.equals("Modification")) {
				if (typeAnt.equals("médical")) {
					AntecedentMed antM = new AntecedentMedService()
							.rechercheParAntecedentMed(nomAntecedent);
					if (antM != null) {
						if (!antM.getIdantecedentMed().equals(idantecedentMed)) {
							faces.addMessage(null, new FacesMessage(
									FacesMessage.SEVERITY_ERROR,
									"Il exist déjà un antécédent sous le nom \" "
											+ nomAntecedent + " \".", ""));
							addValid = false;
						} else {
							AntecedentMed a = new AntecedentMed();
							a.setAntMedical(nomAntecedent);
							a.setIdantecedentMed(idantecedentMed);
							new AntecedentMedService().modifierAntecedentMed(a);
							faces.addMessage(null, new FacesMessage(
									FacesMessage.SEVERITY_INFO,
									"L'antécédent \" " + nomAntecedent
											+ " \" modifié avec succès", ""));
							addValid = true;
							initialisationDialog();
							RequestContext.getCurrentInstance().update("f1");
							FacesContext context2 = FacesContext
									.getCurrentInstance();
							context2.getExternalContext().getFlash()
									.setKeepMessages(true);
							try {

								context2.getExternalContext().redirect(
										"GestionAntecedents");
							} catch (Exception e) {
								System.out.println(e.getMessage());
							}

						}

					} else {
						AntecedentMed a = new AntecedentMed();
						a.setAntMedical(nomAntecedent);
						a.setIdantecedentMed(idantecedentMed);
						new AntecedentMedService().modifierAntecedentMed(a);
						faces.addMessage(null, new FacesMessage(
								FacesMessage.SEVERITY_INFO, "L'antécédent \" "
										+ nomAntecedent
										+ " \" est ajouté avec succès.", ""));
						addValid = true;
						initialisationDialog();
						RequestContext.getCurrentInstance().update("f1");
						FacesContext context2 = FacesContext
								.getCurrentInstance();
						context2.getExternalContext().getFlash()
								.setKeepMessages(true);
						try {

							context2.getExternalContext().redirect(
									"GestionAntecedents");
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}

					}

				} else if (typeAnt.equals("familial")) {
					AntecedentFam antF = new AntecedentFamService()
							.rechercheParAntecedentFam(nomAntecedent);
					if (antF != null) {
						if (!antF.getIdantecedentFam().equals(idantecedentFam)) {
							faces.addMessage(null, new FacesMessage(
									FacesMessage.SEVERITY_ERROR,
									"Il exist déjà un antécédent sous le nom \" "
											+ nomAntecedent + " \".", ""));
							addValid = false;
						} else {
							AntecedentFam a = new AntecedentFam();
							a.setAntFamilial(nomAntecedent);
							a.setIdantecedentFam(idantecedentFam);
							new AntecedentFamService().modifierAntecedentFam(a);
							faces.addMessage(null, new FacesMessage(
									FacesMessage.SEVERITY_INFO,
									"L'antécédent \" " + nomAntecedent
											+ " \" modifié avec succès", ""));
							addValid = true;
							initialisationDialog();
							RequestContext.getCurrentInstance().update("f1");
							FacesContext context2 = FacesContext
									.getCurrentInstance();
							context2.getExternalContext().getFlash()
									.setKeepMessages(true);
							try {

								context2.getExternalContext().redirect(
										"GestionAntecedents");
							} catch (Exception e) {
								System.out.println(e.getMessage());
							}

						}

					} else {
						AntecedentFam a = new AntecedentFam();
						a.setAntFamilial(nomAntecedent);
						a.setIdantecedentFam(idantecedentFam);
						new AntecedentFamService().modifierAntecedentFam(a);
						faces.addMessage(null, new FacesMessage(
								FacesMessage.SEVERITY_INFO, "L'antécédent \" "
										+ nomAntecedent
										+ " \" modifié avec succès", ""));
						addValid = true;
						initialisationDialog();
						RequestContext.getCurrentInstance().update("f1");
						FacesContext context2 = FacesContext
								.getCurrentInstance();
						context2.getExternalContext().getFlash()
								.setKeepMessages(true);
						try {

							context2.getExternalContext().redirect(
									"GestionAntecedents");
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}

					}
				} else if (typeAnt.equals("chirugical")) {
					AntecedentChir antC = new AntecedentChirService()
							.rechercheParAntecedentChir(nomAntecedent);
					if (antC != null) {
						if (!antC.getIdantecedentChir()
								.equals(idantecedentChir)) {
							faces.addMessage(null, new FacesMessage(
									FacesMessage.SEVERITY_ERROR,
									"Il exist déjà un antécédent sous le nom \" "
											+ nomAntecedent + " \".", ""));
							addValid = false;
						} else {
							AntecedentChir a = new AntecedentChir();
							a.setAntChirugical(nomAntecedent);
							a.setIdantecedentChir(idantecedentChir);
							new AntecedentChirService()
									.modifierAntecedentChir(a);
							faces.addMessage(null, new FacesMessage(
									FacesMessage.SEVERITY_INFO,
									"L'antécédent \" " + nomAntecedent
											+ " \" modifié avec succès", ""));
							addValid = true;
							initialisationDialog();
							RequestContext.getCurrentInstance().update("f1");
							FacesContext context2 = FacesContext
									.getCurrentInstance();
							context2.getExternalContext().getFlash()
									.setKeepMessages(true);
							try {

								context2.getExternalContext().redirect(
										"GestionAntecedents");
							} catch (Exception e) {
								System.out.println(e.getMessage());
							}
						}
					} else {
						AntecedentChir a = new AntecedentChir();
						a.setAntChirugical(nomAntecedent);
						a.setIdantecedentChir(idantecedentChir);
						new AntecedentChirService().modifierAntecedentChir(a);
						faces.addMessage(null, new FacesMessage(
								FacesMessage.SEVERITY_INFO, "L'antécédent \" "
										+ nomAntecedent
										+ " \" modifié avec succès", ""));
						addValid = true;
						initialisationDialog();
						RequestContext.getCurrentInstance().update("f1");
						FacesContext context2 = FacesContext
								.getCurrentInstance();
						context2.getExternalContext().getFlash()
								.setKeepMessages(true);
						try {

							context2.getExternalContext().redirect(
									"GestionAntecedents");
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}
					}
				}
			}
		}
		context.addCallbackParam("addValid", addValid);

	}

	public void initialisationDialog() {
		actionAnt = null;
		typeAnt = null;
		nomAntecedent = null;
		idantecedentChir = null;
		idantecedentFam = null;
		idantecedentMed = null;

	}

	public void suppressionAntMed(AntecedentMed ant) {
		new AntecedentMedService().supprimerAntecedentMed(ant
				.getIdantecedentMed());
		FacesContext faces = FacesContext.getCurrentInstance();
		faces.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
				"L'antécédent \" " + ant.getAntMedical()
						+ " \" est supprimé avec succès.", ""));
		FacesContext context2 = FacesContext.getCurrentInstance();
		context2.getExternalContext().getFlash().setKeepMessages(true);
		index = 0;
		try {

			context2.getExternalContext().redirect("GestionAntecedents");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void suppressionAntFam(AntecedentFam ant) {
		new AntecedentFamService().supprimerAntecedentFam(ant
				.getIdantecedentFam());
		FacesContext faces = FacesContext.getCurrentInstance();
		faces.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
				"L'antécédent \" " + ant.getAntFamilial()
						+ " \" est supprimé avec succès.", ""));
		FacesContext context2 = FacesContext.getCurrentInstance();
		context2.getExternalContext().getFlash().setKeepMessages(true);
		index = 2;
		try {

			context2.getExternalContext().redirect("GestionAntecedents");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void suppressionAntChir(AntecedentChir ant) {
		new AntecedentChirService().supprimerAntecedentChir(ant
				.getIdantecedentChir());
		FacesContext faces = FacesContext.getCurrentInstance();
		faces.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
				"L'antécédent \" " + ant.getAntChirugical()
						+ " \" est supprimé avec succès.", ""));
		FacesContext context2 = FacesContext.getCurrentInstance();
		context2.getExternalContext().getFlash().setKeepMessages(true);
		index = 1;
		try {

			context2.getExternalContext().redirect("GestionAntecedents");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void modificationAntMed(AntecedentMed ant) {
		actionAnt = "Modification";
		typeAnt = "médical";
		nomAntecedent = ant.getAntMedical();
		idantecedentMed = ant.getIdantecedentMed();
	}

	public void modificationAntFam(AntecedentFam ant) {
		actionAnt = "Modification";
		typeAnt = "familial";
		nomAntecedent = ant.getAntFamilial();
		idantecedentFam = ant.getIdantecedentFam();
	}

	public void modificationAntChir(AntecedentChir ant) {
		actionAnt = "Modification";
		typeAnt = "chirugical";
		nomAntecedent = ant.getAntChirugical();
		idantecedentChir = ant.getIdantecedentChir();
	}

	public void annulerRecherche() {
		Module.rechercheAntecedent = "";
		valeurRecherche = null;
	}

	public String getValeurRecherche() {
		valeurRecherche = Module.rechercheAntecedent;
		init();
		return valeurRecherche;
	}

	public void setValeurRecherche(String valeurRecherche) {
		Module.rechercheAntecedent = valeurRecherche;
		this.valeurRecherche = valeurRecherche;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getActionAnt() {
		return actionAnt;
	}

	public void setActionAnt(String actionAnt) {
		this.actionAnt = actionAnt;
	}

	public String getTypeAnt() {
		return typeAnt;
	}

	public void setTypeAnt(String typeAnt) {
		this.typeAnt = typeAnt;
	}

	public String getNomAntecedent() {
		return nomAntecedent;
	}

	public void setNomAntecedent(String nomAntecedent) {
		this.nomAntecedent = nomAntecedent;
	}

	public Integer getIdantecedentChir() {
		return idantecedentChir;
	}

	public void setIdantecedentChir(Integer idantecedentChir) {
		this.idantecedentChir = idantecedentChir;
	}

	public Integer getIdantecedentMed() {
		return idantecedentMed;
	}

	public void setIdantecedentMed(Integer idantecedentMed) {
		this.idantecedentMed = idantecedentMed;
	}

	public Integer getIdantecedentFam() {
		return idantecedentFam;
	}

	public void setIdantecedentFam(Integer idantecedentFam) {
		this.idantecedentFam = idantecedentFam;
	}

	public List<AntecedentChir> getAntecedentChirs() {
		return antecedentChirs;
	}

	public void setAntecedentChirs(List<AntecedentChir> antecedentChirs) {
		this.antecedentChirs = antecedentChirs;
	}

	public List<AntecedentMed> getAntecedentMeds() {
		return antecedentMeds;
	}

	public void setAntecedentMeds(List<AntecedentMed> antecedentMeds) {
		this.antecedentMeds = antecedentMeds;
	}

	public List<AntecedentFam> getAntecedentFams() {
		return antecedentFams;
	}

	public void setAntecedentFams(List<AntecedentFam> antecedentFams) {
		this.antecedentFams = antecedentFams;
	}

	public int getCurrentP1() {
		return currentP1;
	}

	public void setCurrentP1(int currentP1) {
		this.currentP1 = currentP1;
	}

	public int getCurrentP2() {
		return currentP2;
	}

	public void setCurrentP2(int currentP2) {
		this.currentP2 = currentP2;
	}

	public int getCurrentP3() {
		return currentP3;
	}

	public void setCurrentP3(int currentP3) {
		this.currentP3 = currentP3;
	}

}

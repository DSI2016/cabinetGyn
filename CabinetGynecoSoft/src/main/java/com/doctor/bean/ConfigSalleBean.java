package com.doctor.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import com.doctor.persistance.TabSalle;
import com.doctor.service.TabSalleService;

@ManagedBean(name = "configSalleBean")
@SessionScoped
public class ConfigSalleBean {

	private List<TabSalle> tabSalles = new ArrayList<TabSalle>();
	private List<Integer> ordres = new ArrayList<Integer>();
	private List<Integer> ordresModif = new ArrayList<Integer>();
	private Integer idTabSalle;
	private String nomTab;

	private String nomTab2;
	private Integer index;// order de tab
	private String indexString;
	private Boolean active;
	private Boolean ordreDiff;// order generale
	private Integer choix = 1;

	private String tabselectionne;

	private TabSalle tab = new TabSalle();

	public String getNomTab2() {
		return nomTab2;
	}

	public void setNomTab2(String nomTab2) {
		System.out.println("nomTab2====>>>>>" + nomTab2);
		this.nomTab2 = nomTab2;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Boolean getOrdreDiff() {
		return ordreDiff;
	}

	public void setOrdreDiff(Boolean ordreDiff) {
		this.ordreDiff = ordreDiff;
	}

	public Integer getChoix() {
		return choix;
	}

	public void setChoix(Integer choix) {
		this.choix = choix;
	}

	public String getTabselectionne() {
		return tabselectionne;
	}

	public void setTabselectionne(String tabselectionne) {
		this.tabselectionne = tabselectionne;
	}

	public List<Integer> getOrdres() {
		int i;
		ordres.clear();
		TabSalleService ser = new TabSalleService();
		List<TabSalle> tabSallesActiv = new ArrayList<TabSalle>();
		tabSallesActiv = ser.rechercheParActive();
		for (i = 1; i <= tabSallesActiv.size(); i++) {

			ordres.add(i);
		}
		System.out.println("valeur de i == " + i);

		ordres.add(i);
		return ordres;
	}

	public void setOrdres(List<Integer> ordres) {
		this.ordres = ordres;
	}

	public List<Integer> getOrdresModif() {

		int i;
		ordresModif.clear();
		TabSalleService ser = new TabSalleService();
		List<TabSalle> tabSallesActiv = new ArrayList<TabSalle>();
		tabSallesActiv = ser.rechercheParActive();
		for (i = 1; i <= tabSallesActiv.size(); i++) {

			ordresModif.add(i);
		}

		return ordresModif;
	}

	public void setOrdresModif(List<Integer> ordresModif) {
		this.ordresModif = ordresModif;
	}

	public String getIndexString() {
		return indexString;
	}

	public void setIndexString(String indexString) {
		this.indexString = indexString;
	}

	public Integer getIdTabSalle() {
		return idTabSalle;
	}

	public void setIdTabSalle(Integer idTabSalle) {
		this.idTabSalle = idTabSalle;
	}

	public String getNomTab() {
		return nomTab;
	}

	public void setNomTab(String nomTab) {
		System.out.println("nom tab set" + nomTab);
		this.nomTab = nomTab;
	}

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public List<TabSalle> getTabSalles() {
		TabSalleService ser = new TabSalleService();
		tabSalles = ser.rechercheToutTabSalle();
		return tabSalles;
	}

	public void setTabSalles(List<TabSalle> tabSalles) {
		this.tabSalles = tabSalles;
	}

	public void modifierCons(TabSalle ts) {
		idTabSalle = ts.getIdTabSalle();
		nomTab = ts.getNomTab();
		index = ts.getOrdre();
		indexString = ts.getOrdre() + "";
		active = ts.isActive();
		ordreDiff = ts.isOrdreDifferent();

	}

	public void validation() {
		nomTab2 = nomTab2.replaceAll("\\s+", " ");
		TabSalleService ser = new TabSalleService();
		System.out.println("nomTab2== " + nomTab2);
		List<TabSalle> tabSallesActiv = new ArrayList<TabSalle>();
		tabSallesActiv = ser.rechercheParActive();
		FacesContext faces = FacesContext.getCurrentInstance();
		RequestContext context = RequestContext.getCurrentInstance();
		boolean addValid = false;

		if (nomTab2 == null || (nomTab2.trim().length() == 0)) {

			faces.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"Veuillez donner le nom de tab.", null));

		} else {

			tab.setNomTab(nomTab2);
			idTabSalle = tab.getIdTabSalle();
			TabSalle t2 = ser.rechercheParNomTab(nomTab2);
			if (t2 != null && !t2.getIdTabSalle().equals(idTabSalle)) { // tester
																		// si
																		// cette
																		// tab
																		// existe
																		// déjà

				faces.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_ERROR, "Tab \"" + nomTab2
								+ "\" existe déjà.", null));

			}

			else {// nom tab n'existe pas

				System.out.println("index===" + index);

				if (index == null) {

					faces.addMessage(null, new FacesMessage(
							FacesMessage.SEVERITY_ERROR,
							"Veuillez donner l'ordre de tab.", null));

				} else {

					List<TabSalle> tabSallesParOrdr = new ArrayList<TabSalle>();
					tabSallesParOrdr = ser.rechercheParOrd(index);

					if (tabSallesActiv.size() > 0) {

						if (tabSallesParOrdr.size() > 0) {

							if (choix == 1) {// cad permuter

								TabSalle ts = new TabSalle();// tab à déplacer
																// avec
																// le
																// new
																// tab activé
								if (tabSallesParOrdr.size() != 0)
									ts = tabSallesParOrdr.get(0);
								ts.setOrdre(tabSallesActiv.size() + 1);
								ser.modifierTabSalle(ts);

								// tab.setActive(true);
								// tab.setOrdre(index);
								// tab.setOrdreDifferent(ordreDiff);
								addValid = true;
								// ser.modifierTabSalle(tab);
								// context.execute("PF('dialogActiv').hide();");

							} else {// cad glisser

								for (int i = tabSallesActiv.size(); i >= index; i--) {
									TabSalle t = tabSallesActiv.get(i - 1);
									t.setOrdre(i + 1);
									ser.modifierTabSalle(t);

								}

								// tab.setActive(true);
								// tab.setOrdre(index);
								// tab.setOrdreDifferent(ordreDiff);
								addValid = true;
								// ser.modifierTabSalle(tab);

							}
						}

					} else {

						index = 1;
					}

				}

				tab.setActive(true);
				tab.setOrdre(index);
				tab.setOrdreDifferent(ordreDiff);

				ser.modifierTabSalle(tab);
				// context.execute("PF('dialogActiv').hide();");
				faces.getExternalContext().getFlash().setKeepMessages(true);
				faces.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_INFO,
						"Tab modifiée avec succès.", null));
				FacesContext context2 = FacesContext.getCurrentInstance();
				try {
					context2.getExternalContext().redirect(
							"ConfigurationSalleAtt");
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

			}

		}

	}

	public void desactiverTab(TabSalle ts) {

		TabSalleService ser = new TabSalleService();
		TabSalle tabSal = new TabSalle();
		List<TabSalle> tabSallesActiv = new ArrayList<TabSalle>();
		tabSallesActiv = ser.rechercheParActive();
		int indexTabADesactiver = ts.getOrdre();

		for (int j = 0; j < tabSallesActiv.size(); j++) {

			int indx = tabSallesActiv.get(j).getOrdre();// parcourir indexs de
														// liste

			if (indx > indexTabADesactiver) {
				int idTab = tabSallesActiv.get(j).getIdTabSalle();
				tabSal = ser.rechercheParId(idTab);// recuperer l'objet dont
													// l'index est sup a l'index
													// à désactiver
				// int newIndx=tabSal.getIndex()-1;
				tabSal.setOrdre(tabSal.getOrdre() - 1);
				ser.modifierTabSalle(tabSal);

			}
		}

		tabSal = ser.rechercheParId(ts.getIdTabSalle());
		tabSal.setOrdre(0);
		tabSal.setActive(false);
		ser.modifierTabSalle(tabSal);

		FacesContext faces = FacesContext.getCurrentInstance();

		faces.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Tab désactivée avec succès.", null));

	}

	public void activerTab(TabSalle tabSal) {
		tab = tabSal;

		/*
		 * int i; ordres.clear(); TabSalleService ser= new TabSalleService();
		 * List<TabSalle> tabSallesActiv = new ArrayList<TabSalle>();
		 * tabSallesActiv= ser.rechercheParActive(); for(i=1; i<=
		 * tabSallesActiv.size();i++){
		 * 
		 * ordres.add(i); } System.out.println("valeur de i == "+i);
		 * 
		 * ordres.add(i);
		 */

	}

	public void onchageOrdr() {

		System.out.println("get in order methode");
		TabSalleService ser = new TabSalleService();
		List<TabSalle> tabSallesActiv = new ArrayList<TabSalle>();
		List<TabSalle> tabSallesParOrdr = new ArrayList<TabSalle>();
		tabSallesActiv = ser.rechercheParActive();
		tabSallesParOrdr = ser.rechercheParOrd(index);

		System.out.println("l'index dans onchange ordr== " + index);

		if (tabSallesActiv.size() > 0 && tabSallesParOrdr.size() > 0) {

			tabselectionne = tabSallesParOrdr.get(0).getNomTab();

			if (index < tabSallesActiv.size() + 1) {
				RequestContext context = RequestContext.getCurrentInstance();
				context.execute("PF('Dlg2').show();");
			}

		}

		initialisation();

	}

	public void recupererDonnees(TabSalle ts) {

		tab = ts;
		idTabSalle = ts.getIdTabSalle();
		nomTab2 = ts.getNomTab();
		ordreDiff = ts.isOrdreDifferent();
		index = ts.getOrdre();

		System.out.println("index dans recup donné" + index);

		System.out.println("recup donn; idTabSalle== " + idTabSalle);

	}

	public void validationModif() {
		boolean addValid = false;
		nomTab2 = nomTab2.replaceAll("\\s+", " ");
		TabSalleService ser = new TabSalleService();

		List<TabSalle> tabSallesActiv = new ArrayList<TabSalle>();
		tabSallesActiv = ser.rechercheParActive();
		FacesContext faces = FacesContext.getCurrentInstance();
		RequestContext context = RequestContext.getCurrentInstance();

		if (nomTab2 == null || (nomTab2.trim().length() == 0)) {

			faces.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"Veuillez donner le nom de tab.", null));

		} else {

			tab.setNomTab(nomTab2);
			idTabSalle = tab.getIdTabSalle();
			TabSalle t2 = ser.rechercheParNomTab(nomTab2);

			if ((t2 != null) && !t2.getIdTabSalle().equals(idTabSalle)) {// tester
																			// si
																			// cette
																			// tab
																			// existe
																			// déjà
				faces.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_ERROR, "Tab \"" + nomTab2
								+ "\" existe déjà.", null));

			} else {// nom tab n'existe pas

				if (choix != null) {
					if (choix == 1) {// cad permuter
						List<TabSalle> tabSallesParOrdr = new ArrayList<TabSalle>();
						tabSallesParOrdr = ser.rechercheParOrd(index);
						TabSalle ts = new TabSalle();// tab à déplacer avec le
														// new
														// tab activé
						if (tabSallesParOrdr != null)
							ts = tabSallesParOrdr.get(0);
						ts.setOrdre(tab.getOrdre());
						ser.modifierTabSalle(ts);

						tab.setActive(true);
						tab.setOrdre(index);
						tab.setOrdreDifferent(ordreDiff);
						// ser.modifierTabSalle(tab);
						// context.execute("PF('dialogModif').hide();");

					} else {// cad glisser

						for (int i = tab.getOrdre(); i >= index; i--) {
							TabSalle t = tabSallesActiv.get(i - 1);
							t.setOrdre(i + 1);
							ser.modifierTabSalle(t);

						}

						tab.setOrdre(index);

					}

				}

				tab.setIdTabSalle(idTabSalle);
				ser.modifierTabSalle(tab);

				addValid = true;
				initialisation();
				// context.execute("PF('dialogModif').hide();");
				faces.getExternalContext().getFlash().setKeepMessages(true);
				faces.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_INFO,
						"Tab modifiée avec succès.", null));
				FacesContext context2 = FacesContext.getCurrentInstance();
				try {
					context2.getExternalContext().redirect(
							"ConfigurationSalleAtt");
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}

		}
	}

	public void initialisation() {

		idTabSalle = null;
		nomTab2 = null;
		index = null;
		indexString = null;
		active = null;
		ordreDiff = null;
		choix = 1;

	}

	public boolean afficheModif(TabSalle tabSal) {

		return tabSal.isActive();

	}

}

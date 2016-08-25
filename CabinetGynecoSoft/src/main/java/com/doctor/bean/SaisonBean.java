package com.doctor.bean;

// Generated 18 ao�t 2014 11:50:48 by Hibernate Tools 3.4.0.CR1

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.doctor.Exceptions.SelectionException;
import com.doctor.persistance.Horaire;
import com.doctor.persistance.Jour;
import com.doctor.persistance.Saison;
import com.doctor.service.HoraireService;
import com.doctor.service.JourService;
import com.doctor.service.SaisonService;

@ManagedBean(name = "saisonBean")
@SessionScoped
public class SaisonBean implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idSaison;
	private List<Saison> Saisons = new ArrayList<Saison>();
	private int select;
	private Saison DEF = getSaisons().get(0);
	private Saison ETE = getSaisons().get(1);
	private Saison RAM = getSaisons().get(2);
	private String hiver;
	private String ramadhan;
	private String eteDuree;
	private int idHorDefLun = -1;
	private int idHorDefMar = -1;
	private int idHorDefMer = -1;
	private int idHorDefJeu = -1;
	private int idHorDefVen = -1;
	private int idHorDefSam = -1;
	private int idHorDefDim = -1;

	private int idHorEteLun = -1;
	private int idHorEteMar = -1;
	private int idHorEteMer = -1;
	private int idHorEteJeu = -1;
	private int idHorEteVen = -1;
	private int idHorEteSam = -1;
	private int idHorEteDim = -1;

	private int idHorRamLun = -1;
	private int idHorRamMar = -1;
	private int idHorRamMer = -1;
	private int idHorRamJeu = -1;
	private int idHorRamVen = -1;
	private int idHorRamSam = -1;
	private int idHorRamDim = -1;

	private int idHor2DefLun = -1;
	private int idHor2DefMar = -1;
	private int idHor2DefMer = -1;
	private int idHor2DefJeu = -1;
	private int idHor2DefVen = -1;
	private int idHor2DefSam = -1;
	private int idHor2DefDim = -1;

	private int idHor2EteLun = -1;
	private int idHor2EteMar = -1;
	private int idHor2EteMer = -1;
	private int idHor2EteJeu = -1;
	private int idHor2EteVen = -1;
	private int idHor2EteSam = -1;
	private int idHor2EteDim = -1;

	private int idHor2RamLun = -1;
	private int idHor2RamMar = -1;
	private int idHor2RamMer = -1;
	private int idHor2RamJeu = -1;
	private int idHor2RamVen = -1;
	private int idHor2RamSam = -1;
	private int idHor2RamDim = -1;

	private String saisonEnCour;
	private String debutSaison;
	private String finSaison;
	private String valeurRetour;

	public Integer getIdSaison() {
		return idSaison;
	}

	public void setIdSaison(Integer idSaison) {
		this.idSaison = idSaison;
	}

	public String getDebutSaison() {
		return debutSaison;
	}

	public void setDebutSaison(String debutSaison) {
		this.debutSaison = debutSaison;
	}

	public String getFinSaison() {
		return finSaison;
	}

	public void setFinSaison(String finSaison) {
		this.finSaison = finSaison;
	}

	public void setEteDuree(String eteDuree) {
		this.eteDuree = eteDuree;
	}

	public int getIdHorDefLun() {
		if (DEF.getLun().getHoraire() != null)
			idHorDefLun = DEF.getLun().getHoraire().getIdHoraire();
		return idHorDefLun;
	}

	public String getHiver() {

		SaisonService ser = new SaisonService();
		Saisons = ser.rechercheTousSaisonAvecJointure();
		Format format = new SimpleDateFormat("dd/MM/yyyy");

		String deb = format.format(Saisons.get(0).getDebut());
		String f = format.format(Saisons.get(0).getFin());
		hiver = "  du " + deb + " au " + f + " ";
		return hiver;
	}

	public void setHiver(String hiver) {
		this.hiver = hiver;
	}

	public String getRamadhan() {
		SaisonService ser = new SaisonService();
		Saisons = ser.rechercheTousSaisonAvecJointure();
		Format format = new SimpleDateFormat("dd/MM/yyyy");
		String deb = format.format(Saisons.get(2).getDebut());
		String f = format.format(Saisons.get(2).getFin());
		ramadhan = "  du " + deb + " au " + f + " ";
		return ramadhan;
	}

	public void setRamadhan(String ramadhan) {
		this.ramadhan = ramadhan;
	}

	public String getEteDuree() {
		SaisonService ser = new SaisonService();
		Saisons = ser.rechercheTousSaisonAvecJointure();
		Format format = new SimpleDateFormat("dd/MM/yyyy");

		String deb = format.format(Saisons.get(1).getDebut());
		String f = format.format(Saisons.get(1).getFin());
		eteDuree = "  du " + deb + " au " + f + " ";
		return eteDuree;
	}

	public String getSaisonEnCour() {
		return saisonEnCour;
	}

	public void setSaisonEnCour(String saisonEnCour) {
		this.saisonEnCour = saisonEnCour;
	}

	public void setIdHorDefLun(int idHorDefLun) {
		HoraireService ser01 = new HoraireService();
		JourService ser02 = new JourService();
		Horaire H = ser01.rechercheHoraireParId(idHorDefLun);
		DEF.getLun().setHoraire(H);
		ser02.modifierJour(DEF.getLun());
		this.idHorDefLun = idHorDefLun;
	}

	public int getIdHorDefMar() {
		if (DEF.getMar().getHoraire() != null)
			idHorDefMar = DEF.getMar().getHoraire().getIdHoraire();
		return idHorDefMar;
	}

	public void setIdHorDefMar(int idHorDefMar) {
		HoraireService ser01 = new HoraireService();
		JourService ser02 = new JourService();
		Horaire H = ser01.rechercheHoraireParId(idHorDefMar);
		DEF.getMar().setHoraire(H);
		ser02.modifierJour(DEF.getMar());
		this.idHorDefMar = idHorDefMar;
	}

	public int getIdHorDefMer() {
		if (DEF.getMer().getHoraire() != null)
			idHorDefMer = DEF.getMer().getHoraire().getIdHoraire();
		return idHorDefMer;
	}

	public void setIdHorDefMer(int idHorDefMer) {
		HoraireService ser01 = new HoraireService();
		JourService ser02 = new JourService();
		Horaire H = ser01.rechercheHoraireParId(idHorDefMer);
		DEF.getMer().setHoraire(H);
		ser02.modifierJour(DEF.getMer());
		this.idHorDefMer = idHorDefMer;
	}

	public int getIdHorDefJeu() {
		if (DEF.getJeu().getHoraire() != null)
			idHorDefJeu = DEF.getJeu().getHoraire().getIdHoraire();
		return idHorDefJeu;
	}

	public void setIdHorDefJeu(int idHorDefJeu) {
		HoraireService ser01 = new HoraireService();
		JourService ser02 = new JourService();
		Horaire H = ser01.rechercheHoraireParId(idHorDefJeu);
		DEF.getJeu().setHoraire(H);
		ser02.modifierJour(DEF.getJeu());
		this.idHorDefJeu = idHorDefJeu;
	}

	public int getIdHorDefVen() {
		if (DEF.getVen().getHoraire() != null)
			idHorDefVen = DEF.getVen().getHoraire().getIdHoraire();
		return idHorDefVen;
	}

	public void setIdHorDefVen(int idHorDefVen) {
		HoraireService ser01 = new HoraireService();
		JourService ser02 = new JourService();
		Horaire H = ser01.rechercheHoraireParId(idHorDefVen);
		DEF.getVen().setHoraire(H);
		ser02.modifierJour(DEF.getVen());
		this.idHorDefVen = idHorDefVen;
	}

	public int getIdHorDefSam() {
		if (DEF.getSam().getHoraire() != null)
			idHorDefSam = DEF.getSam().getHoraire().getIdHoraire();
		return idHorDefSam;
	}

	public void setIdHorDefSam(int idHorDefSam) {
		HoraireService ser01 = new HoraireService();
		JourService ser02 = new JourService();
		Horaire H = ser01.rechercheHoraireParId(idHorDefSam);
		DEF.getSam().setHoraire(H);
		ser02.modifierJour(DEF.getSam());
		this.idHorDefSam = idHorDefSam;
	}

	public int getIdHorDefDim() {
		if (DEF.getDim().getHoraire() != null)
			idHorDefDim = DEF.getDim().getHoraire().getIdHoraire();
		return idHorDefDim;
	}

	public void setIdHorDefDim(int idHorDefDim) {
		HoraireService ser01 = new HoraireService();
		JourService ser02 = new JourService();
		Horaire H = ser01.rechercheHoraireParId(idHorDefDim);
		DEF.getDim().setHoraire(H);
		ser02.modifierJour(DEF.getDim());
		this.idHorDefDim = idHorDefDim;
	}

	public int getIdHorEteLun() {
		if (ETE.getLun().getHoraire() != null)
			idHorEteLun = ETE.getLun().getHoraire().getIdHoraire();
		return idHorEteLun;
	}

	public void setIdHorEteLun(int idHorEteLun) {
		HoraireService ser01 = new HoraireService();
		JourService ser02 = new JourService();
		Horaire H = ser01.rechercheHoraireParId(idHorEteLun);
		ETE.getLun().setHoraire(H);
		ser02.modifierJour(ETE.getLun());
		this.idHorEteLun = idHorEteLun;
	}

	public int getIdHorEteMar() {
		if (ETE.getMar().getHoraire() != null)
			idHorEteMar = ETE.getMar().getHoraire().getIdHoraire();
		return idHorEteMar;
	}

	public void setIdHorEteMar(int idHorEteMar) {
		HoraireService ser01 = new HoraireService();
		JourService ser02 = new JourService();
		Horaire H = ser01.rechercheHoraireParId(idHorEteMar);
		ETE.getMar().setHoraire(H);
		ser02.modifierJour(ETE.getMar());
		this.idHorEteMar = idHorEteMar;
	}

	public int getIdHorEteMer() {
		if (ETE.getMer().getHoraire() != null)
			idHorEteMer = ETE.getMer().getHoraire().getIdHoraire();
		return idHorEteMer;
	}

	public void setIdHorEteMer(int idHorEteMer) {
		HoraireService ser01 = new HoraireService();
		JourService ser02 = new JourService();
		Horaire H = ser01.rechercheHoraireParId(idHorEteMer);
		ETE.getMer().setHoraire(H);
		ser02.modifierJour(ETE.getMer());
		this.idHorEteMer = idHorEteMer;
	}

	public int getIdHorEteJeu() {
		if (ETE.getJeu().getHoraire() != null)
			idHorEteJeu = ETE.getJeu().getHoraire().getIdHoraire();
		return idHorEteJeu;
	}

	public void setIdHorEteJeu(int idHorEteJeu) {
		HoraireService ser01 = new HoraireService();
		JourService ser02 = new JourService();
		Horaire H = ser01.rechercheHoraireParId(idHorEteJeu);
		ETE.getJeu().setHoraire(H);
		ser02.modifierJour(ETE.getJeu());
		this.idHorEteJeu = idHorEteJeu;
	}

	public int getIdHorEteVen() {
		if (ETE.getVen().getHoraire() != null)
			idHorEteVen = ETE.getVen().getHoraire().getIdHoraire();
		return idHorEteVen;
	}

	public void setIdHorEteVen(int idHorEteVen) {
		HoraireService ser01 = new HoraireService();
		JourService ser02 = new JourService();
		Horaire H = ser01.rechercheHoraireParId(idHorEteVen);
		ETE.getVen().setHoraire(H);
		ser02.modifierJour(ETE.getVen());
		this.idHorEteVen = idHorEteVen;
	}

	public int getIdHorEteSam() {
		if (ETE.getSam().getHoraire() != null)
			idHorEteSam = ETE.getSam().getHoraire().getIdHoraire();
		return idHorEteSam;
	}

	public void setIdHorEteSam(int idHorEteSam) {
		HoraireService ser01 = new HoraireService();
		JourService ser02 = new JourService();
		Horaire H = ser01.rechercheHoraireParId(idHorEteSam);
		ETE.getSam().setHoraire(H);
		ser02.modifierJour(ETE.getSam());
		this.idHorEteSam = idHorEteSam;
	}

	public int getIdHorEteDim() {
		if (ETE.getDim().getHoraire() != null)
			idHorEteDim = ETE.getDim().getHoraire().getIdHoraire();
		return idHorEteDim;
	}

	public void setIdHorEteDim(int idHorEteDim) {
		HoraireService ser01 = new HoraireService();
		JourService ser02 = new JourService();
		Horaire H = ser01.rechercheHoraireParId(idHorEteDim);
		ETE.getDim().setHoraire(H);
		ser02.modifierJour(ETE.getDim());
		this.idHorEteDim = idHorEteDim;
	}

	public int getIdHorRamLun() {
		if (RAM.getLun().getHoraire() != null)
			idHorRamLun = RAM.getLun().getHoraire().getIdHoraire();
		return idHorRamLun;
	}

	public void setIdHorRamLun(int idHorRamLun) {
		HoraireService ser01 = new HoraireService();
		JourService ser02 = new JourService();
		Horaire H = ser01.rechercheHoraireParId(idHorRamLun);
		RAM.getLun().setHoraire(H);
		ser02.modifierJour(RAM.getLun());
		this.idHorRamLun = idHorRamLun;
	}

	public int getIdHorRamMar() {
		if (RAM.getMar().getHoraire() != null)
			idHorRamMar = RAM.getMar().getHoraire().getIdHoraire();
		return idHorRamMar;
	}

	public void setIdHorRamMar(int idHorRamMar) {
		HoraireService ser01 = new HoraireService();
		JourService ser02 = new JourService();
		Horaire H = ser01.rechercheHoraireParId(idHorRamMar);
		RAM.getMar().setHoraire(H);
		ser02.modifierJour(RAM.getMar());
		this.idHorRamMar = idHorRamMar;
	}

	public int getIdHorRamMer() {
		if (RAM.getMer().getHoraire() != null)
			idHorRamMer = RAM.getMer().getHoraire().getIdHoraire();
		return idHorRamMer;
	}

	public void setIdHorRamMer(int idHorRamMer) {
		HoraireService ser01 = new HoraireService();
		JourService ser02 = new JourService();
		Horaire H = ser01.rechercheHoraireParId(idHorRamMer);
		RAM.getMer().setHoraire(H);
		ser02.modifierJour(RAM.getMer());
		this.idHorRamMer = idHorRamMer;
	}

	public int getIdHorRamJeu() {
		if (RAM.getJeu().getHoraire() != null)
			idHorRamJeu = RAM.getJeu().getHoraire().getIdHoraire();
		return idHorRamJeu;
	}

	public void setIdHorRamJeu(int idHorRamJeu) {
		HoraireService ser01 = new HoraireService();
		JourService ser02 = new JourService();
		Horaire H = ser01.rechercheHoraireParId(idHorRamJeu);
		RAM.getJeu().setHoraire(H);
		ser02.modifierJour(RAM.getJeu());
		this.idHorRamJeu = idHorRamJeu;
	}

	public int getIdHorRamVen() {
		if (RAM.getVen().getHoraire() != null)
			idHorRamVen = RAM.getVen().getHoraire().getIdHoraire();
		return idHorRamVen;
	}

	public void setIdHorRamVen(int idHorRamVen) {
		HoraireService ser01 = new HoraireService();
		JourService ser02 = new JourService();
		Horaire H = ser01.rechercheHoraireParId(idHorRamVen);
		RAM.getVen().setHoraire(H);
		ser02.modifierJour(RAM.getVen());
		this.idHorRamVen = idHorRamVen;
	}

	public int getIdHorRamSam() {
		if (RAM.getSam().getHoraire() != null)
			idHorRamSam = RAM.getSam().getHoraire().getIdHoraire();
		return idHorRamSam;
	}

	public void setIdHorRamSam(int idHorRamSam) {
		HoraireService ser01 = new HoraireService();
		JourService ser02 = new JourService();
		Horaire H = ser01.rechercheHoraireParId(idHorRamSam);
		RAM.getSam().setHoraire(H);
		ser02.modifierJour(RAM.getSam());
		this.idHorRamSam = idHorRamSam;
	}

	public int getIdHorRamDim() {
		if (RAM.getDim().getHoraire() != null)
			idHorRamDim = RAM.getDim().getHoraire().getIdHoraire();
		return idHorRamDim;
	}

	public void setIdHorRamDim(int idHorRamDim) {
		HoraireService ser01 = new HoraireService();
		JourService ser02 = new JourService();
		Horaire H = ser01.rechercheHoraireParId(idHorRamDim);
		RAM.getDim().setHoraire(H);
		ser02.modifierJour(RAM.getDim());
		this.idHorRamDim = idHorRamDim;
	}

	public int getIdHor2DefLun() {
		if (DEF.getLun().getHoraire2() != null)
			idHor2DefLun = DEF.getLun().getHoraire2().getIdHoraire();
		return idHor2DefLun;
	}

	public void setIdHor2DefLun(int idHor2DefLun) {
		HoraireService ser01 = new HoraireService();
		JourService ser02 = new JourService();
		Horaire H = ser01.rechercheHoraireParId(idHor2DefLun);
		DEF.getLun().setHoraire2(H);
		ser02.modifierJour(DEF.getLun());
		this.idHor2DefLun = idHor2DefLun;
	}

	public int getIdHor2DefMar() {
		if (DEF.getMer().getHoraire2() != null)
			idHor2DefMar = DEF.getMar().getHoraire2().getIdHoraire();
		return idHor2DefMar;
	}

	public void setIdHor2DefMar(int idHor2DefMar) {
		HoraireService ser01 = new HoraireService();
		JourService ser02 = new JourService();
		Horaire H = ser01.rechercheHoraireParId(idHor2DefMar);
		DEF.getMar().setHoraire2(H);
		ser02.modifierJour(DEF.getMar());
		this.idHor2DefMar = idHor2DefMar;
	}

	public int getIdHor2DefMer() {
		if (DEF.getMer().getHoraire2() != null)
			idHor2DefMer = DEF.getMer().getHoraire2().getIdHoraire();
		return idHor2DefMer;
	}

	public void setIdHor2DefMer(int idHor2DefMer) {
		HoraireService ser01 = new HoraireService();
		JourService ser02 = new JourService();
		Horaire H = ser01.rechercheHoraireParId(idHor2DefMer);
		DEF.getMer().setHoraire2(H);
		ser02.modifierJour(DEF.getMer());
		this.idHor2DefMer = idHor2DefMer;
	}

	public int getIdHor2DefJeu() {
		if (DEF.getJeu().getHoraire2() != null)
			idHor2DefJeu = DEF.getJeu().getHoraire2().getIdHoraire();
		return idHor2DefJeu;
	}

	public void setIdHor2DefJeu(int idHor2DefJeu) {
		HoraireService ser01 = new HoraireService();
		JourService ser02 = new JourService();
		Horaire H = ser01.rechercheHoraireParId(idHor2DefJeu);
		DEF.getJeu().setHoraire2(H);
		ser02.modifierJour(DEF.getJeu());
		this.idHor2DefJeu = idHor2DefJeu;
	}

	public int getIdHor2DefVen() {
		if (DEF.getVen().getHoraire2() != null)
			idHor2DefVen = DEF.getVen().getHoraire2().getIdHoraire();
		return idHor2DefVen;
	}

	public void setIdHor2DefVen(int idHor2DefVen) {
		HoraireService ser01 = new HoraireService();
		JourService ser02 = new JourService();
		Horaire H = ser01.rechercheHoraireParId(idHor2DefVen);
		DEF.getVen().setHoraire2(H);
		ser02.modifierJour(DEF.getVen());
		this.idHor2DefVen = idHor2DefVen;
	}

	public int getIdHor2DefSam() {
		if (DEF.getSam().getHoraire2() != null)
			idHor2DefSam = DEF.getSam().getHoraire2().getIdHoraire();
		return idHor2DefSam;
	}

	public void setIdHor2DefSam(int idHor2DefSam) {
		HoraireService ser01 = new HoraireService();
		JourService ser02 = new JourService();
		Horaire H = ser01.rechercheHoraireParId(idHor2DefSam);
		DEF.getSam().setHoraire2(H);
		ser02.modifierJour(DEF.getSam());
		this.idHor2DefSam = idHor2DefSam;
	}

	public int getIdHor2DefDim() {
		if (DEF.getDim().getHoraire2() != null)
			idHor2DefDim = DEF.getDim().getHoraire2().getIdHoraire();
		return idHor2DefDim;
	}

	public void setIdHor2DefDim(int idHor2DefDim) {
		HoraireService ser01 = new HoraireService();
		JourService ser02 = new JourService();
		Horaire H = ser01.rechercheHoraireParId(idHor2DefDim);
		DEF.getDim().setHoraire2(H);
		ser02.modifierJour(DEF.getDim());
		this.idHor2DefDim = idHor2DefDim;
	}

	public int getIdHor2EteLun() {
		if (ETE.getLun().getHoraire2() != null)
			idHor2EteLun = ETE.getLun().getHoraire2().getIdHoraire();
		return idHor2EteLun;
	}

	public void setIdHor2EteLun(int idHor2EteLun) {
		HoraireService ser01 = new HoraireService();
		JourService ser02 = new JourService();
		Horaire H = ser01.rechercheHoraireParId(idHor2EteLun);
		ETE.getLun().setHoraire2(H);
		ser02.modifierJour(ETE.getLun());
		this.idHor2EteLun = idHor2EteLun;
	}

	public int getIdHor2EteMar() {
		if (ETE.getMar().getHoraire2() != null)
			idHor2EteMar = ETE.getMar().getHoraire2().getIdHoraire();
		return idHor2EteMar;
	}

	public void setIdHor2EteMar(int idHor2EteMar) {
		HoraireService ser01 = new HoraireService();
		JourService ser02 = new JourService();
		Horaire H = ser01.rechercheHoraireParId(idHor2EteMar);
		ETE.getMar().setHoraire2(H);
		ser02.modifierJour(ETE.getMar());
		this.idHor2EteMar = idHor2EteMar;
	}

	public int getIdHor2EteMer() {
		if (ETE.getMer().getHoraire2() != null)
			idHor2EteMer = ETE.getMer().getHoraire2().getIdHoraire();
		return idHor2EteMer;
	}

	public void setIdHor2EteMer(int idHor2EteMer) {
		HoraireService ser01 = new HoraireService();
		JourService ser02 = new JourService();
		Horaire H = ser01.rechercheHoraireParId(idHor2EteMer);
		ETE.getMer().setHoraire2(H);
		ser02.modifierJour(ETE.getMer());
		this.idHor2EteMer = idHor2EteMer;
	}

	public int getIdHor2EteJeu() {
		if (ETE.getJeu().getHoraire2() != null)
			idHor2EteJeu = ETE.getJeu().getHoraire2().getIdHoraire();
		return idHor2EteJeu;
	}

	public void setIdHor2EteJeu(int idHor2EteJeu) {
		HoraireService ser01 = new HoraireService();
		JourService ser02 = new JourService();
		Horaire H = ser01.rechercheHoraireParId(idHor2EteJeu);
		ETE.getJeu().setHoraire2(H);
		ser02.modifierJour(ETE.getJeu());
		this.idHor2EteJeu = idHor2EteJeu;
	}

	public int getIdHor2EteVen() {
		if (ETE.getVen().getHoraire2() != null)
			idHor2EteVen = ETE.getVen().getHoraire2().getIdHoraire();
		return idHor2EteVen;
	}

	public void setIdHor2EteVen(int idHor2EteVen) {
		HoraireService ser01 = new HoraireService();
		JourService ser02 = new JourService();
		Horaire H = ser01.rechercheHoraireParId(idHor2EteVen);
		ETE.getVen().setHoraire2(H);
		ser02.modifierJour(ETE.getVen());
		this.idHor2EteVen = idHor2EteVen;
	}

	public int getIdHor2EteSam() {
		if (ETE.getSam().getHoraire2() != null)
			idHor2EteSam = ETE.getSam().getHoraire2().getIdHoraire();
		return idHor2EteSam;
	}

	public void setIdHor2EteSam(int idHor2EteSam) {
		HoraireService ser01 = new HoraireService();
		JourService ser02 = new JourService();
		Horaire H = ser01.rechercheHoraireParId(idHor2EteSam);
		ETE.getSam().setHoraire2(H);
		ser02.modifierJour(ETE.getSam());
		this.idHor2EteSam = idHor2EteSam;
	}

	public int getIdHor2EteDim() {
		if (ETE.getDim().getHoraire2() != null)
			idHor2EteDim = ETE.getDim().getHoraire2().getIdHoraire();
		return idHor2EteDim;
	}

	public void setIdHor2EteDim(int idHor2EteDim) {
		HoraireService ser01 = new HoraireService();
		JourService ser02 = new JourService();
		Horaire H = ser01.rechercheHoraireParId(idHor2EteDim);
		ETE.getDim().setHoraire2(H);
		ser02.modifierJour(ETE.getDim());
		this.idHor2EteDim = idHor2EteDim;
	}

	public int getIdHor2RamLun() {
		if (RAM.getLun().getHoraire2() != null)
			idHor2RamLun = RAM.getLun().getHoraire2().getIdHoraire();
		return idHor2RamLun;
	}

	public void setIdHor2RamLun(int idHor2RamLun) {
		HoraireService ser01 = new HoraireService();
		JourService ser02 = new JourService();
		Horaire H = ser01.rechercheHoraireParId(idHor2RamLun);
		RAM.getLun().setHoraire2(H);
		ser02.modifierJour(RAM.getLun());
		this.idHor2RamLun = idHor2RamLun;
	}

	public int getIdHor2RamMar() {
		if (RAM.getMar().getHoraire2() != null)
			idHor2RamMar = RAM.getMar().getHoraire2().getIdHoraire();
		return idHor2RamMar;
	}

	public void setIdHor2RamMar(int idHor2RamMar) {
		HoraireService ser01 = new HoraireService();
		JourService ser02 = new JourService();
		Horaire H = ser01.rechercheHoraireParId(idHor2RamMar);
		RAM.getMar().setHoraire2(H);
		ser02.modifierJour(RAM.getMar());
		this.idHor2RamMar = idHor2RamMar;
	}

	public int getIdHor2RamMer() {
		if (RAM.getMer().getHoraire2() != null)
			idHor2RamMer = RAM.getMer().getHoraire2().getIdHoraire();
		return idHor2RamMer;
	}

	public void setIdHor2RamMer(int idHor2RamMer) {
		HoraireService ser01 = new HoraireService();
		JourService ser02 = new JourService();
		Horaire H = ser01.rechercheHoraireParId(idHor2RamMer);
		RAM.getMer().setHoraire2(H);
		ser02.modifierJour(RAM.getMer());
		this.idHor2RamMer = idHor2RamMer;
	}

	public int getIdHor2RamJeu() {
		if (RAM.getJeu().getHoraire2() != null)
			idHor2RamJeu = RAM.getJeu().getHoraire2().getIdHoraire();
		return idHor2RamJeu;
	}

	public void setIdHor2RamJeu(int idHor2RamJeu) {
		HoraireService ser01 = new HoraireService();
		JourService ser02 = new JourService();
		Horaire H = ser01.rechercheHoraireParId(idHor2RamJeu);
		RAM.getJeu().setHoraire2(H);
		ser02.modifierJour(RAM.getJeu());
		this.idHor2RamJeu = idHor2RamJeu;
	}

	public int getIdHor2RamVen() {
		if (RAM.getVen().getHoraire2() != null)
			idHor2RamVen = RAM.getVen().getHoraire2().getIdHoraire();
		return idHor2RamVen;
	}

	public void setIdHor2RamVen(int idHor2RamVen) {
		HoraireService ser01 = new HoraireService();
		JourService ser02 = new JourService();
		Horaire H = ser01.rechercheHoraireParId(idHor2RamVen);
		RAM.getVen().setHoraire2(H);
		ser02.modifierJour(RAM.getVen());
		this.idHor2RamVen = idHor2RamVen;
	}

	public int getIdHor2RamSam() {
		if (RAM.getSam().getHoraire2() != null)
			idHor2RamSam = RAM.getSam().getHoraire2().getIdHoraire();
		return idHor2RamSam;
	}

	public void setIdHor2RamSam(int idHor2RamSam) {
		HoraireService ser01 = new HoraireService();
		JourService ser02 = new JourService();
		Horaire H = ser01.rechercheHoraireParId(idHor2RamSam);
		RAM.getSam().setHoraire2(H);
		ser02.modifierJour(RAM.getSam());
		this.idHor2RamSam = idHor2RamSam;
	}

	public int getIdHor2RamDim() {
		if (RAM.getDim().getHoraire2() != null)
			idHor2RamDim = RAM.getDim().getHoraire2().getIdHoraire();
		return idHor2RamDim;
	}

	public void setIdHor2RamDim(int idHor2RamDim) {
		HoraireService ser01 = new HoraireService();
		JourService ser02 = new JourService();
		Horaire H = ser01.rechercheHoraireParId(idHor2RamDim);
		RAM.getDim().setHoraire2(H);
		ser02.modifierJour(RAM.getDim());
		this.idHor2RamDim = idHor2RamDim;
	}

	public Saison getDEF() {
		DEF = getSaisons().get(0);
		return DEF;
	}

	public void setDEF(Saison dEF) {
		DEF = dEF;
	}

	public Saison getETE() {
		ETE = getSaisons().get(1);
		return ETE;
	}

	public void setETE(Saison eTE) {
		ETE = eTE;
	}

	public Saison getRAM() {
		RAM = getSaisons().get(2);
		return RAM;
	}

	public void setRAM(Saison rAM) {
		RAM = rAM;
	}

	public List<Saison> getSaisons() {
		SaisonService ser = new SaisonService();
		Saisons = ser.rechercheTousSaisonAvecJointure();
		return Saisons;
	}

	public void setSaisons(List<Saison> saisons) {
		Saisons = saisons;
	}

	public int getSelect() {
		if (DEF.getSelect() == 1)
			select = 0;
		if (ETE.getSelect() == 1)
			select = 1;
		if (RAM.getSelect() == 1)
			select = 2;
		return select;
	}

	public void setSelect(int select) {
		this.select = select;
	}


	public void change(Jour jr) {
		JourService ser = new JourService();
		jr.change();
		ser.modifierJour(jr);
	}

	public boolean toBoolean(int i) {
		if (i == 0)
			return false;
		else
			return true;
	}

	public String getEtat(int etat) {
		if (etat == 1)
			return "active";
		else
			return "desactive";
	}

	public void enArriere() {
		// rechercher nous sommes dans quels saison par rapport date du jour

		// redirection

		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("GestionHoraireTravail");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void retour() throws Exception {
		SaisonService ser = new SaisonService();
		Saisons = ser.rechercheTousSaisonAvecJointure();
		FacesContext faces = FacesContext.getCurrentInstance();
		for (int i = 0; i < Saisons.size(); i++) {
			if (Saisons.get(i).getLun().getActive() == 1
					&& Saisons.get(i).getLun().getHoraire() == null) {
				faces.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_ERROR, "Erreur !",
						"Remplire les horaires des jours de travaille          ("
								+ Saisons.get(i).getLun().getNom() + " de "
								+ Saisons.get(i).getNom() + ")"));
				throw new SelectionException();
			}
			if (Saisons.get(i).getMar().getActive() == 1
					&& Saisons.get(i).getMar().getHoraire() == null) {
				faces.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_ERROR, "Erreur !",
						"Remplire les horaires des jours de travaille          ("
								+ Saisons.get(i).getMar().getNom() + " de "
								+ Saisons.get(i).getNom() + ")"));
				throw new SelectionException();
			}
			if (Saisons.get(i).getMer().getActive() == 1
					&& Saisons.get(i).getMer().getHoraire() == null) {
				faces.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_ERROR, "Erreur !",
						"Remplire les horaires des jours de travaille          ("
								+ Saisons.get(i).getMer().getNom() + " de "
								+ Saisons.get(i).getNom() + ")"));
				throw new SelectionException();
			}
			if (Saisons.get(i).getJeu().getActive() == 1
					&& Saisons.get(i).getJeu().getHoraire() == null) {
				faces.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_ERROR, "Erreur !",
						"Remplire les horaires des jours de travaille          ("
								+ Saisons.get(i).getJeu().getNom() + " de "
								+ Saisons.get(i).getNom() + ")"));
				throw new SelectionException();
			}
			if (Saisons.get(i).getVen().getActive() == 1
					&& Saisons.get(i).getVen().getHoraire() == null) {
				faces.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_ERROR, "Erreur !",
						"Remplire les horaires des jours de travaille          ("
								+ Saisons.get(i).getVen().getNom() + " de "
								+ Saisons.get(i).getNom() + ")"));
				throw new SelectionException();
			}
			if (Saisons.get(i).getSam().getActive() == 1
					&& Saisons.get(i).getSam().getHoraire() == null) {
				faces.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_ERROR, "Erreur !",
						"Remplire les horaires des jours de travaille          ("
								+ Saisons.get(i).getSam().getNom() + " de "
								+ Saisons.get(i).getNom() + ")"));
				throw new SelectionException();
			}
			if (Saisons.get(i).getDim().getActive() == 1
					&& Saisons.get(i).getDim().getHoraire() == null) {
				faces.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_ERROR, "Erreur !",
						"Remplire les horaires des jours de travaille          ("
								+ Saisons.get(i).getDim().getNom() + " de "
								+ Saisons.get(i).getNom() + ")"));
				throw new SelectionException();
			}
		}

	}

	@PostConstruct
	public void init() {
		// rechercher nous sommes dans quels saison par rapport date du jour
		Date aujourdhui = new Date();
		SaisonService ser = new SaisonService();
		Saisons = ser.rechercheTousSaisonAvecJointure();

		if (Saisons.get(2).getDebut() != null
				&& Saisons.get(2).getFin() != null
				&& aujourdhui.after(Saisons.get(2).getDebut())
				&& aujourdhui.before(Saisons.get(2).getFin())) {
			saisonEnCour = "de Ramadhan";
			DEF.setSelect(0);
			ETE.setSelect(0);
			RAM.setSelect(1);
			ser.modifierSaison(DEF);
			ser.modifierSaison(ETE);
			ser.modifierSaison(RAM);
		}

		else if (Saisons.get(1).getDebut() != null
				&& Saisons.get(1).getFin() != null
				&& aujourdhui.after(Saisons.get(1).getDebut())
				&& aujourdhui.before(Saisons.get(1).getFin())) {
			saisonEnCour = "d'été";
			DEF.setSelect(0);
			ETE.setSelect(1);
			RAM.setSelect(0);
			ser.modifierSaison(DEF);
			ser.modifierSaison(ETE);
			ser.modifierSaison(RAM);

		} else {
			saisonEnCour = "d'hiver";
			DEF.setSelect(1);
			ETE.setSelect(0);
			RAM.setSelect(0);
			ser.modifierSaison(DEF);
			ser.modifierSaison(ETE);
			ser.modifierSaison(RAM);
		}
	}

	public void modiferSaison(Integer id) {
		idSaison = id;
		SaisonService ser = new SaisonService();
		Saison saison = ser.rechercheSaisonParId(id);
		Format format = new SimpleDateFormat("dd/MM/yyyy");
		debutSaison = format.format(saison.getDebut());
		finSaison = format.format(saison.getFin());
	}



	public String getValeurRetour() {
		return valeurRetour;
	}

	public void setValeurRetour(String valeurRetour) {
		this.valeurRetour = valeurRetour;
	}

	public void goToHoraire() {
		HttpSession session2 = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		session2.setAttribute("valeurRetour", "Rendez-Vous");
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("GestionHoraireTravail");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void goToHoraireparamt() {
		HttpSession session2 = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		session2.setAttribute("valeurRetour", "Parametrage");
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("GestionHoraireTravail");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void rediretRetour() {
		if (valeurRetour.equals("")) {
			try {
				FacesContext.getCurrentInstance().getExternalContext()
						.redirect("Rendez-Vous");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} else {

			try {
				FacesContext.getCurrentInstance().getExternalContext()
						.redirect(valeurRetour);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public void goToReglageSaison()

	{
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("ReglageSaison");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}

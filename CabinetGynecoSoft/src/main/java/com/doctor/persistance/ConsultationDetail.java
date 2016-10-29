package com.doctor.persistance;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class ConsultationDetail implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idConsultationDetail;
	private Date dateConsultation;
	private String ddr;
	private String ddg;
	private String termePrevu;
	private String termeActuel;
	private double honoraire;
	private String toxo;
	private boolean ddgCorigee;
	private String tpha;
	private String rubeole;
	private String poids;
	private String tas;
	private String tad;
	private String hu;
	private String sInf;
	private String leuorhee;
	private String col;
	private String motifCons;
	private String symptome;
	private String examen;
	private String diagnostique;

	private String seins;
	private String tv;
	private String speculum;
	private String dateFrotti;
	private String resultatFrotti;
	// variable pour dire si nous avons radio et analyses ou nn
	private String radio;
	private String analyse;
	private Cfclient cfclient;
	private Consultation consultation;
	// le vaiable de consultation echo obs

	private int trim;
	private double bip;
	private double femur;
	private double dat;
	private double ca;
	private double lcc;
	private double sac;
	private String tonique;
	private String echomoyen;
	private String morphologie;
	private String conclusionobs;
	private String annexesobs;
	private String presentation;
	private String vesicule;
	private String ac;
	private String mf;
	private String ef;
	private String placenta;
	private String liq;
	private String trophoblaste;
	private double honorairesobs;

	// le vaiable de consultation echo gynécologie

	private String indications;
	private String contours;
	private String echostructure;
	private String ligne;
	private String annexes;
	private String conclusion;
	private Integer longueur;
	private Integer larg;
	private Integer diam;
	private Uterus uterus;
	private String cat;
	private String notes;
	private boolean consGrossType;
	private int nbAnalyse;
	private int nbRadio;
	private int nbOrd;

	public int getNbAnalyse() {
		return nbAnalyse;
	}

	public void setNbAnalyse(int nbAnalyse) {
		this.nbAnalyse = nbAnalyse;
	}

	public int getNbRadio() {
		return nbRadio;
	}

	public void setNbRadio(int nbRadio) {
		this.nbRadio = nbRadio;
	}

	public int getNbOrd() {
		return nbOrd;
	}

	public void setNbOrd(int nbOrd) {
		this.nbOrd = nbOrd;
	}

	public String getCat() {
		return cat;
	}

	public void setCat(String cat) {
		this.cat = cat;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public boolean isConsGrossType() {
		return consGrossType;
	}

	public void setConsGrossType(boolean consGrossType) {
		this.consGrossType = consGrossType;
	}

	private Set<Ordonnance> ordonnances = new HashSet<Ordonnance>(0);

	public Set<Ordonnance> getOrdonnances() {
		return ordonnances;
	}

	public Integer getLongueur() {
		return longueur;
	}

	public void setLongueur(Integer longueur) {
		this.longueur = longueur;
	}

	public void setOrdonnances(Set<Ordonnance> ordonnances) {
		this.ordonnances = ordonnances;
	}

	public ConsultationDetail() {

	}

	public String getRadio() {

		return radio;
	}

	public void setRadio(String radio) {
		this.radio = radio;
	}

	public String getAnalyse() {
		return analyse;
	}

	public void setAnalyse(String analyse) {
		this.analyse = analyse;
	}

	public Integer getIdConsultationDetail() {
		return idConsultationDetail;
	}

	public void setIdConsultationDetail(Integer idConsultationDetail) {
		this.idConsultationDetail = idConsultationDetail;
	}

	public Date getDateConsultation() {
		
		return dateConsultation;
	}

	public void setDateConsultation(Date dateConsultation) {
		this.dateConsultation = dateConsultation;
	}

	public String getDdr() {
		return ddr;
	}

	public void setDdr(String ddr) {
		this.ddr = ddr;
	}

	public String getDdg() {
		return ddg;
	}

	public void setDdg(String ddg) {
		this.ddg = ddg;
	}

	public String getTermePrevu() {
		return termePrevu;
	}

	public void setTermePrevu(String termePrevu) {
		this.termePrevu = termePrevu;
	}

	public String getTermeActuel() {
		return termeActuel;
	}

	public void setTermeActuel(String termeActuel) {
		this.termeActuel = termeActuel;
	}

	public double getHonoraire() {
		return honoraire;
	}

	public void setHonoraire(double honoraire) {
		this.honoraire = honoraire;
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

	public String getRubeole() {
		return rubeole;
	}

	public void setRubeole(String rubeole) {
		this.rubeole = rubeole;
	}

	public String getPoids() {
		return poids;
	}

	public void setPoids(String poids) {
		this.poids = poids;
	}

	public String getTas() {
		return tas;
	}

	public void setTas(String tas) {
		this.tas = tas;
	}

	public String getTad() {
		return tad;
	}

	public void setTad(String tad) {
		this.tad = tad;
	}

	public String getHu() {
		return hu;
	}

	public void setHu(String hu) {
		this.hu = hu;
	}

	public String getsInf() {
		return sInf;
	}

	public void setsInf(String sInf) {
		this.sInf = sInf;
	}

	public String getLeuorhee() {
		return leuorhee;
	}

	public void setLeuorhee(String leuorhee) {
		this.leuorhee = leuorhee;
	}

	public String getCol() {
		return col;
	}

	public void setCol(String col) {
		this.col = col;
	}

	public String getMotifCons() {
		return motifCons;
	}

	public void setMotifCons(String motifCons) {
		this.motifCons = motifCons;
	}

	public String getSymptome() {
		return symptome;
	}

	public void setSymptome(String symptome) {
		this.symptome = symptome;
	}

	public String getExamen() {
		return examen;
	}

	public void setExamen(String examen) {
		this.examen = examen;
	}

	public String getDiagnostique() {
		return diagnostique;
	}

	public void setDiagnostique(String diagnostique) {
		this.diagnostique = diagnostique;
	}

	public String getSeins() {
		return seins;
	}

	public void setSeins(String seins) {
		this.seins = seins;
	}

	public String getTv() {
		return tv;
	}

	public void setTv(String tv) {
		this.tv = tv;
	}

	public String getSpeculum() {
		return speculum;
	}

	public void setSpeculum(String speculum) {
		this.speculum = speculum;
	}

	public String getDateFrotti() {
		return dateFrotti;
	}

	public void setDateFrotti(String dateFrotti) {
		this.dateFrotti = dateFrotti;
	}

	public String getResultatFrotti() {
		return resultatFrotti;
	}

	public void setResultatFrotti(String resultatFrotti) {
		this.resultatFrotti = resultatFrotti;
	}

	public Cfclient getCfclient() {
		return cfclient;
	}

	public void setCfclient(Cfclient cfclient) {
		this.cfclient = cfclient;
	}

	public Consultation getConsultation() {
		return consultation;
	}

	public void setConsultation(Consultation consultation) {
		this.consultation = consultation;
	}

	public String getIndications() {
		return indications;
	}

	public void setIndications(String indications) {
		this.indications = indications;
	}

	public String getContours() {
		return contours;
	}

	public void setContours(String contours) {
		this.contours = contours;
	}

	public String getEchostructure() {
		return echostructure;
	}

	public void setEchostructure(String echostructure) {
		this.echostructure = echostructure;
	}

	public String getLigne() {
		return ligne;
	}

	public void setLigne(String ligne) {
		this.ligne = ligne;
	}

	public String getAnnexes() {
		return annexes;
	}

	public void setAnnexes(String annexes) {
		this.annexes = annexes;
	}

	public String getConclusion() {
		return conclusion;
	}

	public void setConclusion(String conclusion) {
		this.conclusion = conclusion;
	}

	public Integer getLarg() {
		return larg;
	}

	public void setLarg(Integer larg) {
		this.larg = larg;
	}

	public Integer getDiam() {
		return diam;
	}

	public void setDiam(Integer diam) {
		this.diam = diam;
	}

	public Uterus getUterus() {
		return uterus;
	}

	public void setUterus(Uterus uterus) {
		this.uterus = uterus;
	}

	public int getTrim() {
		return trim;
	}

	public void setTrim(int trim) {
		this.trim = trim;
	}

	public double getBip() {
		return bip;
	}

	public void setBip(double bip) {
		this.bip = bip;
	}

	public double getFemur() {
		return femur;
	}

	public void setFemur(double femur) {
		this.femur = femur;
	}

	public double getDat() {
		return dat;
	}

	public void setDat(double dat) {
		this.dat = dat;
	}

	public double getCa() {
		return ca;
	}

	public void setCa(double ca) {
		this.ca = ca;
	}

	public double getLcc() {
		return lcc;
	}

	public void setLcc(double lcc) {
		this.lcc = lcc;
	}

	public double getSac() {
		return sac;
	}

	public void setSac(double sac) {
		this.sac = sac;
	}

	public String getTonique() {
		return tonique;
	}

	public void setTonique(String tonique) {
		this.tonique = tonique;
	}

	public String getEchomoyen() {
		return echomoyen;
	}

	public void setEchomoyen(String echomoyen) {
		this.echomoyen = echomoyen;
	}

	public String getMorphologie() {
		return morphologie;
	}

	public void setMorphologie(String morphologie) {
		this.morphologie = morphologie;
	}

	public String getConclusionobs() {
		return conclusionobs;
	}

	public void setConclusionobs(String conclusionobs) {
		this.conclusionobs = conclusionobs;
	}

	public String getAnnexesobs() {
		return annexesobs;
	}

	public void setAnnexesobs(String annexesobs) {
		this.annexesobs = annexesobs;
	}

	public String getPresentation() {
		return presentation;
	}

	public void setPresentation(String presentation) {
		this.presentation = presentation;
	}

	public String getVesicule() {
		return vesicule;
	}

	public void setVesicule(String vesicule) {
		this.vesicule = vesicule;
	}

	public String getAc() {
		return ac;
	}

	public void setAc(String ac) {
		this.ac = ac;
	}

	public String getMf() {
		return mf;
	}

	public void setMf(String mf) {
		this.mf = mf;
	}

	public String getEf() {
		return ef;
	}

	public void setEf(String ef) {
		this.ef = ef;
	}

	public String getPlacenta() {
		return placenta;
	}

	public void setPlacenta(String placenta) {
		this.placenta = placenta;
	}

	public String getLiq() {
		return liq;
	}

	public void setLiq(String liq) {
		this.liq = liq;
	}

	public String getTrophoblaste() {
		return trophoblaste;
	}

	public void setTrophoblaste(String trophoblaste) {
		this.trophoblaste = trophoblaste;
	}

	public double getHonorairesobs() {
		return honorairesobs;
	}

	public void setHonorairesobs(double honorairesobs) {
		this.honorairesobs = honorairesobs;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ac == null) ? 0 : ac.hashCode());
		result = prime * result + ((analyse == null) ? 0 : analyse.hashCode());
		result = prime * result + ((annexes == null) ? 0 : annexes.hashCode());
		result = prime * result
				+ ((annexesobs == null) ? 0 : annexesobs.hashCode());
		long temp;
		temp = Double.doubleToLongBits(bip);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(ca);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((cat == null) ? 0 : cat.hashCode());
		result = prime * result + ((col == null) ? 0 : col.hashCode());
		result = prime * result
				+ ((conclusion == null) ? 0 : conclusion.hashCode());
		result = prime * result
				+ ((conclusionobs == null) ? 0 : conclusionobs.hashCode());

		result = prime * result + (consGrossType ? 1231 : 1237);
		result = prime * result + (ddgCorigee ? 1231 : 1237);
		result = prime * result
				+ ((contours == null) ? 0 : contours.hashCode());
		temp = Double.doubleToLongBits(dat);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime
				* result
				+ ((dateConsultation == null) ? 0 : dateConsultation.hashCode());
		result = prime * result
				+ ((dateFrotti == null) ? 0 : dateFrotti.hashCode());
		result = prime * result + ((ddg == null) ? 0 : ddg.hashCode());
		result = prime * result + ((ddr == null) ? 0 : ddr.hashCode());
		result = prime * result
				+ ((diagnostique == null) ? 0 : diagnostique.hashCode());
		result = prime * result + ((diam == null) ? 0 : diam.hashCode());
		result = prime * result
				+ ((echomoyen == null) ? 0 : echomoyen.hashCode());
		result = prime * result
				+ ((echostructure == null) ? 0 : echostructure.hashCode());
		result = prime * result + ((ef == null) ? 0 : ef.hashCode());
		result = prime * result + ((examen == null) ? 0 : examen.hashCode());
		temp = Double.doubleToLongBits(femur);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(honoraire);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(honorairesobs);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((hu == null) ? 0 : hu.hashCode());
		result = prime
				* result
				+ ((idConsultationDetail == null) ? 0 : idConsultationDetail
						.hashCode());
		result = prime * result
				+ ((indications == null) ? 0 : indications.hashCode());
		result = prime * result + ((larg == null) ? 0 : larg.hashCode());
		temp = Double.doubleToLongBits(lcc);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result
				+ ((leuorhee == null) ? 0 : leuorhee.hashCode());
		result = prime * result + ((ligne == null) ? 0 : ligne.hashCode());
		result = prime * result + ((liq == null) ? 0 : liq.hashCode());
		result = prime * result
				+ ((longueur == null) ? 0 : longueur.hashCode());
		result = prime * result + ((mf == null) ? 0 : mf.hashCode());
		result = prime * result
				+ ((morphologie == null) ? 0 : morphologie.hashCode());
		result = prime * result
				+ ((motifCons == null) ? 0 : motifCons.hashCode());
		result = prime * result + nbAnalyse;
		result = prime * result + nbOrd;
		result = prime * result + nbRadio;
		result = prime * result + ((notes == null) ? 0 : notes.hashCode());
		result = prime * result
				+ ((placenta == null) ? 0 : placenta.hashCode());
		result = prime * result + ((poids == null) ? 0 : poids.hashCode());
		result = prime * result
				+ ((presentation == null) ? 0 : presentation.hashCode());
		result = prime * result + ((radio == null) ? 0 : radio.hashCode());
		result = prime * result
				+ ((resultatFrotti == null) ? 0 : resultatFrotti.hashCode());
		result = prime * result + ((rubeole == null) ? 0 : rubeole.hashCode());
		result = prime * result + ((sInf == null) ? 0 : sInf.hashCode());
		temp = Double.doubleToLongBits(sac);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((seins == null) ? 0 : seins.hashCode());
		result = prime * result
				+ ((speculum == null) ? 0 : speculum.hashCode());
		result = prime * result
				+ ((symptome == null) ? 0 : symptome.hashCode());
		result = prime * result + ((tad == null) ? 0 : tad.hashCode());
		result = prime * result + ((tas == null) ? 0 : tas.hashCode());
		result = prime * result
				+ ((termeActuel == null) ? 0 : termeActuel.hashCode());
		result = prime * result
				+ ((termePrevu == null) ? 0 : termePrevu.hashCode());
		result = prime * result + ((tonique == null) ? 0 : tonique.hashCode());
		result = prime * result + ((toxo == null) ? 0 : toxo.hashCode());
		result = prime * result + ((tpha == null) ? 0 : tpha.hashCode());
		result = prime * result + trim;
		result = prime * result
				+ ((trophoblaste == null) ? 0 : trophoblaste.hashCode());
		result = prime * result + ((tv == null) ? 0 : tv.hashCode());
		result = prime * result
				+ ((vesicule == null) ? 0 : vesicule.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConsultationDetail other = (ConsultationDetail) obj;
		if (ac == null) {
			if (other.ac != null)
				return false;
		} else if (!ac.equals(other.ac))
			return false;
		if (analyse == null) {
			if (other.analyse != null)
				return false;
		} else if (!analyse.equals(other.analyse))
			return false;
		if (annexes == null) {
			if (other.annexes != null)
				return false;
		} else if (!annexes.equals(other.annexes))
			return false;
		if (annexesobs == null) {
			if (other.annexesobs != null)
				return false;
		} else if (!annexesobs.equals(other.annexesobs))
			return false;
		if (Double.doubleToLongBits(bip) != Double.doubleToLongBits(other.bip))
			return false;
		if (Double.doubleToLongBits(ca) != Double.doubleToLongBits(other.ca))
			return false;
		if (cat == null) {
			if (other.cat != null)
				return false;
		} else if (!cat.equals(other.cat))
			return false;
		if (col == null) {
			if (other.col != null)
				return false;
		} else if (!col.equals(other.col))
			return false;
		if (conclusion == null) {
			if (other.conclusion != null)
				return false;
		} else if (!conclusion.equals(other.conclusion))
			return false;
		if (conclusionobs == null) {
			if (other.conclusionobs != null)
				return false;
		} else if (!conclusionobs.equals(other.conclusionobs))
			return false;
		if (ddgCorigee != other.ddgCorigee)
			return false;
		if (ddgCorigee != other.ddgCorigee)
			return false;
		if (contours == null) {
			if (other.contours != null)
				return false;
		} else if (!contours.equals(other.contours))
			return false;
		if (Double.doubleToLongBits(dat) != Double.doubleToLongBits(other.dat))
			return false;
		if (dateConsultation == null) {
			if (other.dateConsultation != null)
				return false;
		} else if (!dateConsultation.equals(other.dateConsultation))
			return false;
		if (dateFrotti == null) {
			if (other.dateFrotti != null)
				return false;
		} else if (!dateFrotti.equals(other.dateFrotti))
			return false;
		if (ddg == null) {
			if (other.ddg != null)
				return false;
		} else if (!ddg.equals(other.ddg))
			return false;
		if (ddr == null) {
			if (other.ddr != null)
				return false;
		} else if (!ddr.equals(other.ddr))
			return false;
		if (diagnostique == null) {
			if (other.diagnostique != null)
				return false;
		} else if (!diagnostique.equals(other.diagnostique))
			return false;
		if (diam == null) {
			if (other.diam != null)
				return false;
		} else if (!diam.equals(other.diam))
			return false;
		if (echomoyen == null) {
			if (other.echomoyen != null)
				return false;
		} else if (!echomoyen.equals(other.echomoyen))
			return false;
		if (echostructure == null) {
			if (other.echostructure != null)
				return false;
		} else if (!echostructure.equals(other.echostructure))
			return false;
		if (ef == null) {
			if (other.ef != null)
				return false;
		} else if (!ef.equals(other.ef))
			return false;
		if (examen == null) {
			if (other.examen != null)
				return false;
		} else if (!examen.equals(other.examen))
			return false;
		if (Double.doubleToLongBits(femur) != Double
				.doubleToLongBits(other.femur))
			return false;
		if (Double.doubleToLongBits(honoraire) != Double
				.doubleToLongBits(other.honoraire))
			return false;
		if (Double.doubleToLongBits(honorairesobs) != Double
				.doubleToLongBits(other.honorairesobs))
			return false;
		if (hu == null) {
			if (other.hu != null)
				return false;
		} else if (!hu.equals(other.hu))
			return false;
		if (idConsultationDetail == null) {
			if (other.idConsultationDetail != null)
				return false;
		} else if (!idConsultationDetail.equals(other.idConsultationDetail))
			return false;
		if (indications == null) {
			if (other.indications != null)
				return false;
		} else if (!indications.equals(other.indications))
			return false;
		if (larg == null) {
			if (other.larg != null)
				return false;
		} else if (!larg.equals(other.larg))
			return false;
		if (Double.doubleToLongBits(lcc) != Double.doubleToLongBits(other.lcc))
			return false;
		if (leuorhee == null) {
			if (other.leuorhee != null)
				return false;
		} else if (!leuorhee.equals(other.leuorhee))
			return false;
		if (ligne == null) {
			if (other.ligne != null)
				return false;
		} else if (!ligne.equals(other.ligne))
			return false;
		if (liq == null) {
			if (other.liq != null)
				return false;
		} else if (!liq.equals(other.liq))
			return false;
		if (longueur == null) {
			if (other.longueur != null)
				return false;
		} else if (!longueur.equals(other.longueur))
			return false;
		if (mf == null) {
			if (other.mf != null)
				return false;
		} else if (!mf.equals(other.mf))
			return false;
		if (morphologie == null) {
			if (other.morphologie != null)
				return false;
		} else if (!morphologie.equals(other.morphologie))
			return false;
		if (motifCons == null) {
			if (other.motifCons != null)
				return false;
		} else if (!motifCons.equals(other.motifCons))
			return false;
		
		if (nbAnalyse != other.nbAnalyse)
			return false;
		if (nbOrd != other.nbOrd)
			return false;
		if (nbRadio != other.nbRadio)
			return false;
		
		if (notes == null) {
			if (other.notes != null)
				return false;
		} else if (!notes.equals(other.notes))
			return false;
		if (placenta == null) {
			if (other.placenta != null)
				return false;
		} else if (!placenta.equals(other.placenta))
			return false;
		if (poids == null) {
			if (other.poids != null)
				return false;
		} else if (!poids.equals(other.poids))
			return false;
		if (presentation == null) {
			if (other.presentation != null)
				return false;
		} else if (!presentation.equals(other.presentation))
			return false;
		if (radio == null) {
			if (other.radio != null)
				return false;
		} else if (!radio.equals(other.radio))
			return false;
		if (resultatFrotti == null) {
			if (other.resultatFrotti != null)
				return false;
		} else if (!resultatFrotti.equals(other.resultatFrotti))
			return false;
		if (rubeole == null) {
			if (other.rubeole != null)
				return false;
		} else if (!rubeole.equals(other.rubeole))
			return false;
		if (sInf == null) {
			if (other.sInf != null)
				return false;
		} else if (!sInf.equals(other.sInf))
			return false;
		if (Double.doubleToLongBits(sac) != Double.doubleToLongBits(other.sac))
			return false;
		if (seins == null) {
			if (other.seins != null)
				return false;
		} else if (!seins.equals(other.seins))
			return false;
		if (speculum == null) {
			if (other.speculum != null)
				return false;
		} else if (!speculum.equals(other.speculum))
			return false;
		if (symptome == null) {
			if (other.symptome != null)
				return false;
		} else if (!symptome.equals(other.symptome))
			return false;
		if (tad == null) {
			if (other.tad != null)
				return false;
		} else if (!tad.equals(other.tad))
			return false;
		if (tas == null) {
			if (other.tas != null)
				return false;
		} else if (!tas.equals(other.tas))
			return false;
		if (termeActuel == null) {
			if (other.termeActuel != null)
				return false;
		} else if (!termeActuel.equals(other.termeActuel))
			return false;
		if (termePrevu == null) {
			if (other.termePrevu != null)
				return false;
		} else if (!termePrevu.equals(other.termePrevu))
			return false;
		if (tonique == null) {
			if (other.tonique != null)
				return false;
		} else if (!tonique.equals(other.tonique))
			return false;
		if (toxo == null) {
			if (other.toxo != null)
				return false;
		} else if (!toxo.equals(other.toxo))
			return false;
		if (tpha == null) {
			if (other.tpha != null)
				return false;
		} else if (!tpha.equals(other.tpha))
			return false;
		if (trim != other.trim)
			return false;
		if (trophoblaste == null) {
			if (other.trophoblaste != null)
				return false;
		} else if (!trophoblaste.equals(other.trophoblaste))
			return false;
		if (tv == null) {
			if (other.tv != null)
				return false;
		} else if (!tv.equals(other.tv))
			return false;
		if (vesicule == null) {
			if (other.vesicule != null)
				return false;
		} else if (!vesicule.equals(other.vesicule))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ConsultationDetail [idConsultationDetail="
				+ idConsultationDetail + ", dateConsultation="
				+ dateConsultation + ", ddr=" + ddr + ", ddg=" + ddg
				+ ", termePrevu=" + termePrevu + ", termeActuel=" + termeActuel
				+ ", honoraire=" + honoraire + ", toxo=" + toxo + ", tpha="
				+ tpha + ", rubeole=" + rubeole + ", poids=" + poids + ", tas="
				+ tas + ", tad=" + tad + ", hu=" + hu + ", sInf=" + sInf
				+ ", leuorhee=" + leuorhee + ", col=" + col + ", motifCons="
				+ motifCons + ", symptome=" + symptome + ", examen=" + examen
				+ ", diagnostique=" + diagnostique + ", seins=" + seins
				+ ", tv=" + tv + ", speculum=" + speculum + ", dateFrotti="
				+ dateFrotti + ", resultatFrotti=" + resultatFrotti
				+ ", radio=" + radio + ", analyse=" + analyse + ", trim="
				+ trim + ", bip=" + bip + ", femur=" + femur + ", dat=" + dat
				+ ", ca=" + ca + ", lcc=" + lcc + ", sac=" + sac + ", tonique="
				+ tonique + ", echomoyen=" + echomoyen + ", morphologie="
				+ morphologie + ", conclusionobs=" + conclusionobs
				+ ", annexesobs=" + annexesobs + ", presentation="
				+ presentation + ", vesicule=" + vesicule + ", ac=" + ac
				+ ", mf=" + mf + ", ef=" + ef + ", placenta=" + placenta
				+ ", liq=" + liq + ", trophoblaste=" + trophoblaste
				+ ", honorairesobs=" + honorairesobs + ", indications="
				+ indications + ", contours=" + contours + ", echostructure="
				+ echostructure + ", ligne=" + ligne + ", annexes=" + annexes
				+ ", conclusion=" + conclusion + ", longueur=" + longueur
				+ ", larg=" + larg + ", diam=" + diam + ", cat=" + cat
				+ ", notes=" + notes + ", consGrossType=" + consGrossType
				+ ", nbAnalyse=" + nbAnalyse + ", nbRadio=" + nbRadio
				+ ", nbOrd=" + nbOrd + "]";
	}

	public boolean isDdgCorigee() {
		return ddgCorigee;
	}

	public void setDdgCorigee(boolean ddgCorigee) {
		this.ddgCorigee = ddgCorigee;
	}

}

package com.doctor.bean;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.primefaces.context.RequestContext;

import com.doctor.persistance.Consultation;
import com.doctor.persistance.ConsultationDetail;
import com.doctor.service.ConsultaionService;
import com.doctor.service.ConsultationDetailService;

@ManagedBean(name = "recapBean")
@SessionScoped
public class RecapBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Consultation> consultations = new ArrayList<Consultation>();
	List<ConsultationDetail> consDets = new ArrayList<ConsultationDetail>();
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	private Integer nbrCons;

	private int totalCons;
	private double totalHon;

	private int idConsultation;

	private String dateRecapDeb;
	private String dateRecapFin;

	public Integer getNbrCons() {
		return nbrCons;
	}

	public void setNbrCons(Integer nbrCons) {
		this.nbrCons = nbrCons;
	}

	public String getDateRecapDeb() {
		return dateRecapDeb;
	}

	public void setDateRecapDeb(String dateRecapDeb) {
		this.dateRecapDeb = dateRecapDeb;
	}

	public String getDateRecapFin() {
		return dateRecapFin;
	}

	public void setDateRecapFin(String dateRecapFin) {
		this.dateRecapFin = dateRecapFin;
	}

	public int getIdConsultation() {
		return idConsultation;
	}

	public void setIdConsultation(int idConsultation) {
		this.idConsultation = idConsultation;
	}

	public List<ConsultationDetail> consDetavecId(int id) {
		ConsultationDetailService ser = new ConsultationDetailService();
		if (dateRecapDeb != null && !dateRecapDeb.equals("")
				&& dateRecapFin != null && !dateRecapFin.equals("")) {
			if (dateRecapDeb.equals(dateRecapFin)) {
				Date d1 = null;
				try {
					d1 = formatter.parse(dateRecapDeb);

				} catch (ParseException e) {

					e.printStackTrace();
				}
				consDets = ser.rechercheConsultationByIdCons(id, d1);
				// nbrCons=consDets.size();
			} else {

				Date d1 = null;
				Date d2 = null;

				try {
					d1 = formatter.parse(dateRecapDeb);
					d2 = formatter.parse(dateRecapFin);
				} catch (ParseException e) {

					e.printStackTrace();
				}

				consDets = ser.rechercheConsultationByIdConsEntreDeuxDate(id,
						d1, d2);
				

			}

		}
		return consDets;
	}

	public void goToRecap() {

		dateRecapDeb = formatter.format(new Date());
		dateRecapFin = formatter.format(new Date());

		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("Recap");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public double getTotalHon() {
		ConsultationDetailService ser = new ConsultationDetailService();
		List<ConsultationDetail> l = new ArrayList<ConsultationDetail>();

		if (dateRecapDeb.equals(dateRecapFin)) {
			Date d1 = null;
			try {
				d1 = formatter.parse(dateRecapDeb);

			} catch (ParseException e) {

				e.printStackTrace();
			}
			l = ser.rechercheConsultationByDate(d1);
			// nbrCons=l.size();

		} else {
			Date d1 = null;
			Date d2 = null;
			try {
				d1 = formatter.parse(dateRecapDeb);
				d2 = formatter.parse(dateRecapFin);

			} catch (ParseException e) {

				e.printStackTrace();
			}
			l = ser.rechercheConsultationDeuxDate(d1, d2);
			// nbrCons=l.size();
		}

		double hon = 0;
		for (int i = 0; i < l.size(); i++) {
			hon = hon + l.get(i).getHonoraire();

		}
		totalHon = hon;

		return totalHon;
	}

	public void setTotalHon(double totalHon) {
		this.totalHon = totalHon;
	}

	public int getTotalCons() {
		ConsultationDetailService ser = new ConsultationDetailService();

		if (dateRecapDeb.equals(dateRecapFin)) {
			Date d1 = null;
			try {
				d1 = formatter.parse(dateRecapDeb);

			} catch (ParseException e) {

				e.printStackTrace();
			}
			totalCons = ser.rechercheConsultationByDate(d1).size();

		} else {
			Date d1 = null;
			Date d2 = null;
			try {
				d1 = formatter.parse(dateRecapDeb);
				d2 = formatter.parse(dateRecapFin);

			} catch (ParseException e) {

				e.printStackTrace();
			}
			totalCons = ser.rechercheConsultationDeuxDate(d1, d2).size();

		}

		return totalCons;
	}

	public void setTotalCons(int totalCons) {
		this.totalCons = totalCons;
	}

	public List<Consultation> getConsultations() {
		ConsultaionService serCons = new ConsultaionService();
		consultations = serCons.rechercheToutConsultation();
		return consultations;
	}

	public void setConsultations(List<Consultation> consultations) {
		this.consultations = consultations;
	}

	public int calculerTotalCons(int idCons) {

		idConsultation = idCons;
		/*
		 * ConsultationDetailService ser = new ConsultationDetailService();
		 * 
		 * List<ConsultationDetail> l = new ArrayList<ConsultationDetail>(); l =
		 * ser.rechercheConsultationByIdCons(idCons, new Date());
		 */

		// ////////////////////////
		List<ConsultationDetail> l = new ArrayList<ConsultationDetail>();
		ConsultationDetailService ser = new ConsultationDetailService();
		if (dateRecapDeb.equals(dateRecapFin)) {
			Date d1 = null;
			try {
				d1 = formatter.parse(dateRecapDeb);

			} catch (ParseException e) {

				e.printStackTrace();
			}
			l = ser.rechercheConsultationByIdCons(idCons, d1);
		} else {

			Date d1 = null;
			Date d2 = null;

			try {
				d1 = formatter.parse(dateRecapDeb);
				d2 = formatter.parse(dateRecapFin);
			} catch (ParseException e) {

				e.printStackTrace();
			}

			l = ser.rechercheConsultationByIdConsEntreDeuxDate(idCons, d1, d2);

		}

		return l.size();

	}

	public void lePatient(Integer c) {
		// Module.idpatient = c;

		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		session.setAttribute("idu", c);
		session.setAttribute("retouraction", "Patients");
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("FichePatiente");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void recchercher() {
		FacesContext face = FacesContext.getCurrentInstance();

		
		if (Module.verifierDate(dateRecapDeb) == null
				&& Module.verifierDate(dateRecapDeb) == null) {
			
			try {
				FacesContext.getCurrentInstance().getExternalContext()
						.redirect("Recap");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		} else {
			if (Module.verifierDate(dateRecapDeb) != null)
				face.addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR,"La date de début"+ Module
								.verifierDate(dateRecapDeb), ""));
			if (Module.verifierDate(dateRecapFin) != null)
				face.addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR,"La date de fin" +Module
								.verifierDate(dateRecapFin), ""));

			dateRecapDeb = formatter.format(new Date());
			dateRecapFin = formatter.format(new Date());

		}
		// FacesContext context = FacesContext.getCurrentInstance();
		// context.getExternalContext().getFlash().setKeepMessages(true);

	}

}

package com.doctor.bean;

import java.io.Serializable;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Random;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.doctor.persistance.Cabinet;
import com.doctor.service.CabinetService;

@ManagedBean(name = "cabinetBean")
@SessionScoped
public class CabinetBean implements Serializable {

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;

	private Integer idcabinet;
	private String docteur;
	private String adresse;
	private String tel1;
	private String tel2;
	private String gsm1;
	private String gsm2;
	private String fax;
	private String eMail;
	private String specialite;
	private String nbrPost;

	public String getSpecialite() {
		return specialite;
	}

	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}

	public Integer getIdcabinet() {
		return idcabinet;
	}

	public void setIdcabinet(Integer idcabinet) {
		this.idcabinet = idcabinet;
	}

	public String getDocteur() {
		return docteur;
	}

	public void setDocteur(String docteur) {
		this.docteur = docteur;
	}

	public String getAdresse() {
return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTel1() {
		return tel1;
	}

	public void setTel1(String tel1) {
		this.tel1 = tel1;
	}

	public String getTel2() {
		return tel2;
	}

	public void setTel2(String tel2) {
		this.tel2 = tel2;
	}

	public String getGsm1() {
		return gsm1;
	}

	public void setGsm1(String gsm1) {
		this.gsm1 = gsm1;
	}

	public String getGsm2() {
		return gsm2;
	}

	public void setGsm2(String gsm2) {
		this.gsm2 = gsm2;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	@PostConstruct
	public void init() {
		CabinetService ser = new CabinetService();
		Cabinet c = new Cabinet();
		List<Cabinet> cab = ser.rechercheTousCabinet();
		if (cab != null && cab.size()> 0) {
			c = ser.rechercheTousCabinet().get(0);
			idcabinet = c.getIdcabinet();
			docteur = c.getDocteur();
			adresse = c.getAdresse();
			tel1 = c.getTel1();
			tel2 = c.getTel2();
			gsm1 = c.getGsm1();
			gsm2 = c.getGsm2();
			fax = c.getFax();
			eMail = c.geteMail();
			specialite = c.getSpecialite();
		}

	}

	public void valider() {
		String nbrposttraiter;
		Cabinet c = new Cabinet();
		CabinetService ser = new CabinetService();
		c.setIdcabinet(idcabinet);
		c.setDocteur(docteur);
		c.setAdresse(adresse);
		c.setTel1(tel1);
		c.setTel2(tel2);
		c.setGsm1(gsm1);
		c.setGsm2(gsm2);
		c.setFax(fax);
		c.seteMail(eMail);
		if(Module.isNumeric(nbrPost)==true)
		{	
			Random r = new Random();
					int n = 100000 + r.nextInt(900000);
					String nString=n+"";
					System.out.println("nstring "+nString);
			System.out.println("random"+nString.substring(0, 3)+nbrPost+2+nString.substring(3, nString.length()));
			nbrposttraiter=nString.substring(0, 3)+nbrPost+nString.substring(3, nString.length());
			c.setNbPost(nbrposttraiter);
			
			InetAddress[] adrServeurs;
			try {
				adrServeurs = InetAddress.getAllByName("www.microsoft.com");
			
			
			System.out.println("Adresses Microsoft : ");
			for (int i = 0; i > adrServeurs.length; i++) {
			System.out.println("     "+adrServeurs[i].getHostAddress());
			}
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}
			
		//	ServerSocket server = null; //Initialize server socket here.

//			try {
//				Socket client = server.accept();
//				String hostName = client.getInetAddress().getHostName();
//	            System.out.println("pc connecter"+hostName);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			
//            
//			}
//			try {
//				InetAddress[] adr= InetAddress.
//				String address = InetAddress.getLocalHost().getHostName();
//				for(int i=0;i<adr.length;i++)
//				{
//				System.out.println("pc connecter"+adr[i]);
//				}
//			} catch (UnknownHostException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
		else
		
		ser.modifierCabinet(c);
	}

	public String getNbrPost() {
		return nbrPost;
	}

	public void setNbrPost(String nbrPost) {
		this.nbrPost = nbrPost;
	}
	

}

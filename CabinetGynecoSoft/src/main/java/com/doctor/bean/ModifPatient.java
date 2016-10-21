package com.doctor.bean;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.List;

import com.doctor.persistance.Cabinet;
import com.doctor.persistance.Certificat;
import com.doctor.persistance.Cfclient;
import com.doctor.persistance.HistoriqueCertif;
import com.doctor.persistance.Lettre;
import com.doctor.persistance.Ordonnance;
import com.doctor.persistance.historiqueLettre;
import com.doctor.service.CabinetService;
import com.doctor.service.CertificatService;
import com.doctor.service.CfclientService;
import com.doctor.service.HistoriqueCertifService;
import com.doctor.service.LettreService;
import com.doctor.service.OrdonnanceService;
import com.doctor.service.historiqueLettreService;

public class ModifPatient {
	public static void corigerCfClient() {
		CfclientService sr = new CfclientService();
		List<Cfclient> patients = new CfclientService().rechercheToutPatients();
		// Cfclient patients.get(i)=new Cfclient();
		for (int i = 0; i < patients.size(); i++) {
			// System.out.println("code" + patients.get(i).getCode());
			if (patients.get(i).getCode() != null) {
				if ((patients.get(i).getConsang()) != null) {
					patients.get(i).setConsang(
							patients.get(i).getConsang().trim());
				}
				if ((patients.get(i).getCycleType()) != null) {
					patients.get(i).setCycleType(
							patients.get(i).getCycleType().trim());
				}

				if ((patients.get(i).getRegleType()) != null) {
					patients.get(i).setRegleType(
							patients.get(i).getRegleType().trim());
				}
				if ((patients.get(i).getRue()) != null) {
					patients.get(i).setRue(patients.get(i).getRue().trim());
				}
				patients.get(i).setPrenomNomConjoint(
						patients.get(i).getPrenom() + " "
								+ patients.get(i).getNomC());
				sr.modifierPatient(patients.get(i));
			}

		}

		// patients.get(i) = sr.RechercheCfclient(311);
		// System.out.println(patients.get(i).getConsang() + "5");
		// patients.get(i).setConsang(patients.get(i).getConsang().trim());
		// sr.modifierPatient(patients.get(i));
		// System.out.println(patients.get(i).getConsang() + "5");
	}

	public static String remplaceMot(String sonTexte, String txtFind,
			String txtReplace) {
		String tmp;

		int lgFind = txtFind.length();
		if ((sonTexte != null) && (txtFind != null) && (txtReplace != null)) {
			int lgReplace = txtReplace.length();
			if (txtReplace != null) {
				for (int k = 0; k < (sonTexte.length() - lgFind); k++) {
					try {
						tmp = sonTexte.substring(k, k + lgFind);
					} catch (Exception e) {
						break;
					}
					if (tmp.equalsIgnoreCase(txtFind)) {
						sonTexte = sonTexte.substring(0, k)
								+ txtReplace
								+ sonTexte.substring(k + lgFind,
										sonTexte.length());
						k = k + lgReplace;
					}
				}
			}

			return (sonTexte);

		} else
			return (" ");

	}

	public static String intialeTextCertificats(String motifCertificat,
			HistoriqueCertif histo) {

		Certificat certif = new Certificat();
		CertificatService ser = new CertificatService();
		certif = ser.rechercheCertificatParLibelleCertificat(motifCertificat);
		String rem = certif.getRemarque();

		// idPatient = (Integer) session.getAttribute("idu");
		Cfclient cfclient = histo.getCfclient();
		Cabinet cab = new Cabinet();
		CabinetService serCabinet = new CabinetService();
		cab = serCabinet.rechercheTousCabinet().get(0);
		if (histo.getLivreele() != null) {
			
			rem = remplaceMot(rem, "$livreele", histo.getLivreele());// remplaser
																		// $livree

		} else
			rem = remplaceMot(rem, "$livreele", "");

		if ((cfclient.getPrenom() != null) || (cfclient.getNom() != null))
			rem = remplaceMot(rem, "$NP",
					cfclient.getPrenom() + " " + cfclient.getNom());
		else
			rem = remplaceMot(rem, "$NP", "");
		if (cab.getDocteur() != null)
			rem = remplaceMot(rem, "$Docteur", cab.getDocteur());
		else
			rem = remplaceMot(rem, "$Docteur", "");
		if (histo.getCin() != null)
			rem = remplaceMot(rem, "$Cin", histo.getCin());
		else
			rem = remplaceMot(rem, "$Cin", "");
		if (histo.getA() != null)
			rem = remplaceMot(rem, "$Lieu", histo.getA());
		else
			rem = remplaceMot(rem, "$Lieu", "");
		if (histo.getDureederepos() != 0)
			rem = remplaceMot(rem, "$DRP", histo.getDureederepos() + "");
		else
			rem = remplaceMot(rem, "$DRP", "");
		if (histo.getAdaterdu() != null) {
			Format formatter2 = new SimpleDateFormat("dd/MM/yyyy");
			String l2 = formatter2.format(histo.getAdaterdu());
			rem = remplaceMot(rem, "$ADate", l2);
		} else
			rem = remplaceMot(rem, "$ADate", "");
		if (histo.getType() != null)
			rem = remplaceMot(rem, "$Type", histo.getType());
		else
			rem = remplaceMot(rem, "$Type", "");
		if (histo.getDateCertif() != null) {
			Format formatter3 = new SimpleDateFormat("dd/MM/yyyy");
			String l3 = formatter3.format(histo.getDateCertif());
			rem = remplaceMot(rem, "$Datec", l3);

		} else
			rem = remplaceMot(rem, "$Datec", "");
		if (histo.getAccompagnant() != null) {
			rem = remplaceMot(rem, "$accompagnant", histo.getAccompagnant());
		} else
			rem = remplaceMot(rem, "$accompagnant", "");
		if (histo.getDatereprise() != null) {
			Format formatter = new SimpleDateFormat("dd/MM/yyyy");
			String reprise = formatter.format(histo.getDatereprise());
			rem = remplaceMot(rem, "$Dreprise", reprise);
		} else
			rem = remplaceMot(rem, "$Dreprise", "");

		if (histo.getLesions() != null) {
			rem = remplaceMot(rem, "$Lesions", histo.getLesions());
		} else
			rem = remplaceMot(rem, "$Lesions", "");
		if (histo.getInapte() != null) {
			rem = remplaceMot(rem, "$Inapte", histo.getInapte());
		}
		rem = remplaceMot(rem, "$Inapte", "");
		if (histo.getRemarques() != null) {
			rem = remplaceMot(rem, "$remarque", histo.getRemarques());
		} else
			rem = remplaceMot(rem, "$remarque", "");
		if (histo.getDatedelagression() != null) {
			Format formatter1 = new SimpleDateFormat("dd/MM/yyyy");
			String dg = formatter1.format(histo.getDatedelagression());
			rem = remplaceMot(rem, "$DAgr", dg);
		} else
			rem = remplaceMot(rem, "$DAgr", "");
		if (histo.getHeurelagr() != 0) {
			rem = remplaceMot(rem, "$HAgr", histo.getHeurelagr() + "");
		} else
			rem = remplaceMot(rem, "$HAgr", "");
		if (histo.getMinutelagr() != 0) {
			rem = remplaceMot(rem, "$MAgr", histo.getMinutelagr() + "");
		} else
			rem = remplaceMot(rem, "$MAgr", "");
		if (histo.getHeuresys() != 0) {
			rem = remplaceMot(rem, "$HSys", histo.getHeuresys() + "");
		} else
			rem = remplaceMot(rem, "$HSys", "");
		if (histo.getMinutesys() != 0) {
			rem = remplaceMot(rem, "$MSys", histo.getMinutesys() + "");
		} else
			rem = remplaceMot(rem, "$MSys", "");
		return (rem);
	}

	public static void corigerHistoriqueCertif() {
		HistoriqueCertifService sr = new HistoriqueCertifService();
		List<HistoriqueCertif> certifs = sr.rechercheTousHistoriqueCertif();
		Certificat typeCertif = new Certificat();
		for (int i = 0; i < certifs.size(); i++) {
			if (certifs.get(i).getCertificat() != null) {
				typeCertif = certifs.get(i).getCertificat();

				if (typeCertif != null)
					if (typeCertif.getRemarque() != null) {
						String textecertif = typeCertif.getRemarque();
						textecertif = intialeTextCertificats(
								typeCertif.getNomCertificat(), certifs.get(i));
						certifs.get(i).setRemarque(textecertif);
					}

				sr.modifierHistoriqueCertif(certifs.get(i));
				System.out.println("modif"
						+ certifs.get(i).getIdHistoriqueCertif());
				System.out.println("code patient"
						+ certifs.get(i).getCfclient().getCode());
			}

		}
	}

	public static void corigerHistoriqueCertifCERTIFPRESENCE() {
		HistoriqueCertifService sr = new HistoriqueCertifService();
		List<HistoriqueCertif> certifs = sr
				.rechercheTousHistoriqueCertifByPatientBycertifpresaccom();
		Certificat typeCertif = new Certificat();
		for (int i = 0; i < certifs.size(); i++) {
			if (certifs.get(i).getCertificat() != null) {
				typeCertif = certifs.get(i).getCertificat();

				if (typeCertif != null)
					if (typeCertif.getRemarque() != null) {
						String textecertif = typeCertif.getRemarque();
						textecertif = intialeTextCertificats(
								typeCertif.getNomCertificat(), certifs.get(i));
						certifs.get(i).setRemarque(textecertif);
					}

				sr.modifierHistoriqueCertif(certifs.get(i));
				System.out.println("modif"
						+ certifs.get(i).getIdHistoriqueCertif());
				System.out.println("code patient"
						+ certifs.get(i).getCfclient().getCode());
			}

		}
	}

	public static String intialeTextLettre(String motifLettre,
			historiqueLettre histo) {

		Lettre lett = new Lettre();
		LettreService ser = new LettreService();
		lett = ser.recherchelettreParLibellelettre(motifLettre);
		String rem = lett.getTextLettre();

		Cabinet cab = new Cabinet();
		CabinetService serCabinet = new CabinetService();
		cab = serCabinet.rechercheTousCabinet().get(0);
		if (histo.getCfclient() != null) {
			Cfclient cfclient = histo.getCfclient();
			if ((cfclient.getPrenom() != null) || (cfclient.getNom() != null))
				rem = remplaceMot(rem, "$NP", cfclient.getPrenom() + " "
						+ cfclient.getNom());
			else
				rem = remplaceMot(rem, "$NP", "");
			if (Module.age(cfclient.getDateNaiss()) != null) {
				rem = remplaceMot(rem, "$Age",
						Module.age(cfclient.getDateNaiss()));
			} else
				rem = remplaceMot(rem, "$Age", "");
		}
		if (cab.getDocteur() != null)
			rem = remplaceMot(rem, "$Docteur", cab.getDocteur());
		else
			rem = remplaceMot(rem, "$Docteur", "");
		if (histo.getCode() != null)
			rem = remplaceMot(rem, "$code", histo.getCode());
		else
			rem = remplaceMot(rem, "$code", "");
		if (histo.getV2() != null)
			rem = remplaceMot(rem, "$signeClinique", histo.getV2());
		else
			rem = remplaceMot(rem, "$signeClinique", "");
		if (histo.getV1() != null)
			rem = remplaceMot(rem, "$Nature", histo.getV1());
		else
			rem = remplaceMot(rem, "$Nature", "");
		if (histo.getClinique() != null)
			rem = remplaceMot(rem, "$clinique", histo.getClinique());
		else
			rem = remplaceMot(rem, "$clinique", "");

		if (histo.getDateActe() != null) {
			Format formatter3 = new SimpleDateFormat("dd/MM/yyyy");
			String l3 = formatter3.format(histo.getDateActe());
			rem = remplaceMot(rem, "$DateAct", l3);
		} else {
			rem = remplaceMot(rem, "$DateAct", "");
		}
		if (histo.getDescription() != null)
			rem = remplaceMot(rem, "$desc", histo.getDescription());
		else
			rem = remplaceMot(rem, "$desc", "");
		if (histo.getDatelettre() != null) {
			Format formatter3 = new SimpleDateFormat("dd/MM/yyyy");
			String l4 = formatter3.format(histo.getDatelettre());
			rem = remplaceMot(rem, "$DateL", l4);
		} else
			rem = remplaceMot(rem, "$DateL", "");
		if (histo.getAutre() != null) {
			rem = remplaceMot(rem, "$autre", histo.getAutre());
		} else
			rem = remplaceMot(rem, "$autre", "");

		if (histo.getDdr() != null) {
			rem = remplaceMot(rem, "$Ddr", histo.getDdr());
		} else
			rem = remplaceMot(rem, "$Ddr", "");

		if (histo.getDebutGross() != null) {
			rem = remplaceMot(rem, "$DebutGross", histo.getDebutGross());
		} else

			rem = remplaceMot(rem, "$DebutGross", "");
		if (histo.getTermeprevue() != null) {
			rem = remplaceMot(rem, "$termeprevue", histo.getTermeprevue());
		} else
			rem = remplaceMot(rem, "$termeprevue", "");
		if (histo.getTermeactuel() != null) {
			rem = remplaceMot(rem, "$termeactuel", histo.getTermeactuel());
		} else
			rem = remplaceMot(rem, "$termeactuel", "");
		if (histo.getRubeoole() != null) {
			rem = remplaceMot(rem, "$rubeoole", histo.getRubeoole());
		} else

			rem = remplaceMot(rem, "$rubeoole", "");
		if (histo.getFrotti() != null)
			rem = remplaceMot(rem, "$frotti", histo.getFrotti());
		else
			rem = remplaceMot(rem, "$frotti", "");

		if (histo.getGs() != null) {
			rem = remplaceMot(rem, "$gs", histo.getGs());
		} else
			rem = remplaceMot(rem, "$gs", "");
		if (histo.getRh() != null) {
			rem = remplaceMot(rem, "$rh", histo.getRh());
		} else
			rem = remplaceMot(rem, "$rh", "");
		if (histo.getResultatfrotti() != null) {
			rem = remplaceMot(rem, "$resultatfrotti", histo.getResultatfrotti());
		} else
			rem = remplaceMot(rem, "$resultatfrotti", "");
		if (histo.getToxo() != null) {
			rem = remplaceMot(rem, "$toxo", histo.getToxo());
		} else
			rem = remplaceMot(rem, "$toxo", "");
		if (histo.getTpha() != null)
			rem = remplaceMot(rem, "$tpha", histo.getTpha());
		else
			rem = remplaceMot(rem, "$tpha", "");

		if (histo.getDiagnostic() != null) {
			rem = remplaceMot(rem, "$diag", histo.getDiagnostic());
		} else
			rem = remplaceMot(rem, "$diag", "");

		return (rem);

	}

	public static void corigerHistoriqueLettre() {
		historiqueLettreService sr = new historiqueLettreService();
		List<historiqueLettre> lettres = sr.rechercheTousHistoriqueLettre();
		Lettre typeLettre = new Lettre();
		for (int i = 0; i < lettres.size(); i++) {
			if (lettres.get(i).getLettre() != null) {
				typeLettre = lettres.get(i).getLettre();

				if (typeLettre != null)
					if (typeLettre.getTextLettre() != null) {
						String textelettre = typeLettre.getTextLettre();
						textelettre = intialeTextLettre(
								typeLettre.getNomLettre(), lettres.get(i));
						lettres.get(i).setTextLettre(textelettre);
					}

				sr.modifierHistoriqueLettre(lettres.get(i));
				System.out.println("modif"
						+ lettres.get(i).getIdHistoriquelettre());
				System.out.println("code patient"
						+ lettres.get(i).getCfclient().getCode());
			}

		}
	}

	public static void MajOrdonnance() {
		List<Ordonnance> ords = new OrdonnanceService()
				.rechercheTousOrdonnance();
		for (int i = 0; i < ords.size(); i++) {
			if (ords.get(i).getPatient() != null) {
				Cfclient c = new CfclientService().RechercheCfclient(ords
						.get(i).getPatient().getCode());
				ords.get(i).setProprietaire(c.getPrenom() + " " + c.getNom());
				new OrdonnanceService().modifierOrdonnance(ords.get(i));
			}
		}
	}

	public static int compteurChar(String str, char ch) {
		int compteur = 0;
		for (int i = 0; i < str.length(); i++)
			if (str.charAt(i) == ch)
				compteur++;
		return compteur;
	}

	public static void corigerCategoriePatientelle() {
		CfclientService sr = new CfclientService();
		List<Cfclient> patients = new CfclientService().rechercheToutPatients();
		// Cfclient patients.get(i)=new Cfclient();
		int nbrMoins = 0;
		int nbrPlus = 0;
		for (int i = 0; i < patients.size(); i++) {
			System.out.println("code" + patients.get(i).getCode());
			if (patients.get(i).getCode() != null) {
				if ((patients.get(i).getCategorie()) != null) {

					if ((compteurChar(patients.get(i).getCategorie().trim(),
							'+') == 0)
							&& (compteurChar(patients.get(i).getCategorie()
									.trim(), '-') != 0)) {
						nbrMoins = compteurChar(patients.get(i).getCategorie()
								.trim(), '-');

						if (nbrMoins == 1)
							patients.get(i)
									.setCategoriEtoile("etoileNegative1");
						if (nbrMoins == 2)
							patients.get(i)
									.setCategoriEtoile("etoileNegative2");
						if ((nbrMoins == 3) || (nbrMoins > 3))
							patients.get(i)
									.setCategoriEtoile("etoileNegative3");
					}

					if ((compteurChar(patients.get(i).getCategorie().trim(),
							'+') != 0)
							&& (compteurChar(patients.get(i).getCategorie()
									.trim(), '-') == 0)) {
						nbrPlus = compteurChar(patients.get(i).getCategorie()
								.trim(), '+');

						if (nbrPlus == 1)
							patients.get(i)
									.setCategoriEtoile("etoilePositive1");
						if (nbrPlus == 2)
							patients.get(i)
									.setCategoriEtoile("etoilePositive2");
						if (nbrPlus == 3)
							patients.get(i)
									.setCategoriEtoile("etoilePositive3");
						if (nbrPlus == 4)
							patients.get(i).setCategoriEtoile("etoileExtra");
					}

					if ((compteurChar(patients.get(i).getCategorie().trim(),
							'+') != 0)
							&& (compteurChar(patients.get(i).getCategorie()
									.trim(), '-') != 0)) {
						nbrPlus = compteurChar(patients.get(i).getCategorie()
								.trim(), '+');

						nbrMoins = compteurChar(patients.get(i).getCategorie()
								.trim(), '-');
						if ((nbrPlus == 1) && (nbrMoins == 1)) {

							patients.get(i).setCategoriEtoile("etoileMoyen");
						}
						if (nbrPlus == nbrMoins) {

							patients.get(i).setCategoriEtoile("etoileMoyen");
						}

					}
					if ((compteurChar(patients.get(i).getCategorie().trim(),
							'+') == 0)
							&& (compteurChar(patients.get(i).getCategorie()
									.trim(), '-') == 0)) {

						patients.get(i).setCategoriEtoile("etoileMoyen");

					}
					if (((patients.get(i).getCategorie()) == null)
							|| (patients.get(i).getCategorie()).equals("")) {
						patients.get(i).setCategoriEtoile("etoileMoyen");
					}
				}
			}
			sr.modifierPatient(patients.get(i));
		}

	}

	public static void main(String[] args) {
		// corigerCfClient();
		// corigerHistoriqueCertif();
		// corigerHistoriqueLettre();
		// corigerHistoriqueCertifCERTIFPRESENCE();
		// MajOrdonnance();
		corigerCategoriePatientelle();
	}

}

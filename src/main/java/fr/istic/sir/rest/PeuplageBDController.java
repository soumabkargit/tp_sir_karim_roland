package fr.istic.sir.rest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import daoImpl.AllergieDaoImpl;
import daoImpl.ParticipantDaoImpl;
import daoImpl.PreferenceAlimentaireDaoImpl;
import daoImpl.ReunionDaoImpl;
import daoImpl.SondageDateDaoImpl;
import daoImpl.SondageDateLieuDaoImpl;
import daoImpl.SondageLieuDaoImpl;
import daoImpl.UtilisateurDaoImpl;
import entity.Allergie;
import entity.Participant;
import entity.PreferenceAlimentaire;
import entity.Reunion;
import entity.SondageDate;
import entity.SondageDateLieu;
import entity.SondageLieu;
import entity.Utilisateur;

@Path("/peuplageBD")
public class PeuplageBDController {
	
	private UtilisateurDaoImpl serviceUtilisateurDaoImpl = new UtilisateurDaoImpl();
	private ParticipantDaoImpl serviceParticipantDaoImpl = new ParticipantDaoImpl();
	
	private ReunionDaoImpl serviceReunionDaoImpl = new ReunionDaoImpl();
	
	private SondageLieuDaoImpl serviceSondageLieuDaoImpl = new SondageLieuDaoImpl();
	private SondageDateLieuDaoImpl serviceSondageDateLieuDaoImpl = new SondageDateLieuDaoImpl();
	private SondageDateDaoImpl serviceSondageDateDaoImpl = new SondageDateDaoImpl();
		
	private PreferenceAlimentaireDaoImpl servicePreferenceAlimentaireDaoImpl = new PreferenceAlimentaireDaoImpl();
	private AllergieDaoImpl serviceAllergieDaoImpl = new AllergieDaoImpl();
	
	private Collection <Participant> participantsSondageDateLieu;
	private Collection <Participant> participantsSondageLieu;
	private Collection <Participant> participantsSondageDate;
	
	
	@GET
    @Produces({ MediaType.APPLICATION_JSON })
	public String peuple() throws ParseException {
	/***
	 *    Debut senario
	 *    creation de 3 utilisateurs, 90 participants, 3 sondageDate, 3 SondageLieu, 3 sondageDateLieu, 3 reunions
	 *    3 allergies, 10 preferenceAlimentaires
	 *    chaque utilisateur cree un type de sondage et 30 participants respective participe au sondage
	 *    les preferencens et les allergies sont assignees aux participant respectivement
	 ***/
	
		
		serviceUtilisateurDaoImpl.beginTransaction();
		Utilisateur utilisateurDateLieu = new Utilisateur();
		utilisateurDateLieu.setEmailUtilisateur("soumabkar@gmail.com");
		utilisateurDateLieu.setNom("SOUMAHORO");
		utilisateurDateLieu.setPrenom("Abdoul-Karim");
		utilisateurDateLieu.setMotPasse("soumabkar");
		serviceUtilisateurDaoImpl.addUtilisateur(utilisateurDateLieu);
			
	 
			Utilisateur utilisateurDate = new Utilisateur();
			utilisateurDate.setEmailUtilisateur("anohabbah@gmail.com");
			utilisateurDate.setNom("ABBAH");
			utilisateurDate.setPrenom("ANOH");
			utilisateurDate.setMotPasse("Elephants");
			serviceUtilisateurDaoImpl.addUtilisateur(utilisateurDate);
			
			Utilisateur utilisateurLieu = new Utilisateur();
			utilisateurLieu.setEmailUtilisateur("maudmcok@gmail.com");
			utilisateurLieu.setNom("MAUD");
			utilisateurLieu.setPrenom("Charles-Olivier");
			utilisateurLieu.setMotPasse("maudmcok");
			serviceUtilisateurDaoImpl.addUtilisateur(utilisateurLieu);
		
		serviceUtilisateurDaoImpl.commitTransaction();
		
		
		
		
		
		
		

		serviceReunionDaoImpl.beginTransaction();
		Reunion reunion0 = new Reunion();
		reunion0.setIntitule("Revision sir");
		reunion0.setResume("Preparation de l'examen de sir");
		serviceReunionDaoImpl.addReunion(reunion0);
		
		Reunion reunion1 = new Reunion();
		reunion1.setIntitule("Soiree chez Abbah");
		reunion1.setResume("Rencontre en pote, partie de code puis faire le show");
		serviceReunionDaoImpl.addReunion(reunion1);
		
		Reunion reunion2 = new Reunion();
		reunion2.setIntitule("Soiree chez Chris");
		reunion2.setResume("Rencontre en pote, preparation des examens, organisations de projets ...");
		serviceReunionDaoImpl.addReunion(reunion2);
		serviceReunionDaoImpl.commitTransaction();
		
		

		serviceSondageLieuDaoImpl.beginTransaction();
		SondageLieu sondageLieu0 = new SondageLieu();
		sondageLieu0.setReunion(reunion0);
		sondageLieu0.setLieuSondage("Rennes");
		//sondageLieu0.setParticipants(participantsSondageLieu);
		sondageLieu0.setPauseDejeunerSondage(true);
		sondageLieu0.setUtilisateurSondageLieu(utilisateurLieu);
		serviceSondageLieuDaoImpl.addSondageLieu(sondageLieu0);
		
		
		SondageLieu sondageLieu1 = new SondageLieu();
		sondageLieu1.setReunion(reunion1);
		sondageLieu1.setLieuSondage("Monpelier");
		//sondageLieu2.setParticipants(participantsSondageDate);
		sondageLieu1.setPauseDejeunerSondage(true);
		sondageLieu1.setUtilisateurSondageLieu(utilisateurDate);
		serviceSondageLieuDaoImpl.addSondageLieu(sondageLieu1);

		SondageLieu sondageLieu3 = new SondageLieu();
		sondageLieu3.setReunion(reunion2);
		sondageLieu3.setLieuSondage("Seguela");
		//sondageLieu3.setParticipants(participantsSondageLieu);
		sondageLieu3.setPauseDejeunerSondage(false);
		sondageLieu3.setUtilisateurSondageLieu(utilisateurDateLieu);
		serviceSondageLieuDaoImpl.addSondageLieu(sondageLieu3);
		serviceSondageLieuDaoImpl.commitTransaction();
		
		
		
		
		serviceSondageDateLieuDaoImpl.beginTransaction();
		SondageDateLieu sondageDateLieu0 = new SondageDateLieu();
		sondageDateLieu0.setReunion(reunion1);
		sondageDateLieu0.setLieuSondageDateLieu("Paris"); 
		Date date0 = null;
	    SimpleDateFormat simpleDateFormat0 = new SimpleDateFormat("dd/MM/yyyy");
	    String date01 = "01/04/2019";
	    date0 = simpleDateFormat0.parse(date01);
		sondageDateLieu0.setDateSondageDateLieu(date0);
		//sondageDateLieu0.setParticipants(participantsSondageLieu);
		sondageDateLieu0.setPauseDejeunerSondage(true);
		sondageDateLieu0.setUtilisateurSondageDateLieu(utilisateurDateLieu);
		serviceSondageDateLieuDaoImpl.addSondageDateLieu(sondageDateLieu0);
		
		SondageDateLieu sondageDateLieu1 = new SondageDateLieu();
		sondageDateLieu1.setReunion(reunion2);
		sondageDateLieu1.setLieuSondageDateLieu("Abidjan"); 
		Date date1 = null;
	    SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
	    String date11 = "02/04/2019";
	    date1 = simpleDateFormat1.parse(date11);
		sondageDateLieu1.setDateSondageDateLieu(date1);
		//sondageDateLieu0.setParticipants(participantsSondageLieu);
		sondageDateLieu1.setPauseDejeunerSondage(true);
		sondageDateLieu1.setUtilisateurSondageDateLieu(utilisateurDate);
		serviceSondageDateLieuDaoImpl.addSondageDateLieu(sondageDateLieu1);
		
		
		SondageDateLieu sondageDateLieu2 = new SondageDateLieu();
		sondageDateLieu2.setReunion(reunion0);
		sondageDateLieu2.setLieuSondageDateLieu("Dakar"); 
		Date date2 = null;
	    SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd/MM/yyyy");
	    String date21 = "03/04/2019";
	    date2 = simpleDateFormat2.parse(date21);
		sondageDateLieu2.setDateSondageDateLieu(date2);
		//sondageDateLieu0.setParticipants(participantsSondageLieu);
		sondageDateLieu2.setPauseDejeunerSondage(false);
		sondageDateLieu2.setUtilisateurSondageDateLieu(utilisateurLieu);
		serviceSondageDateLieuDaoImpl.addSondageDateLieu(sondageDateLieu2);
		
		
		
		serviceSondageDateLieuDaoImpl.commitTransaction();
		
		
		serviceSondageDateDaoImpl.beginTransaction();
		SondageDate sondageDate0 = new SondageDate();
		sondageDate0.setReunion(reunion2);
		Date date3 = null;
	    SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat("dd/MM/yyyy");
	    String date31 = "04/04/2019";
	    date3 = simpleDateFormat3.parse(date31);
	    sondageDate0.setDateSondage(date3);
		//sondageDate0.setParticipants(participantsSondageLieu);
		sondageDate0.setPauseDejeunerSondage(true);
		sondageDate0.setUtilisateurSondageDate(utilisateurLieu);
		serviceSondageDateDaoImpl.addSondageDate(sondageDate0);
		
		
		SondageDate sondageDate1 = new SondageDate();
		sondageDate1.setReunion(reunion0);
		Date date4 = null;
	    SimpleDateFormat simpleDateFormat4 = new SimpleDateFormat("dd/MM/yyyy");
	    String date32 = "05/04/2019";
	    date4 = simpleDateFormat4.parse(date32);
	    sondageDate1.setDateSondage(date4);
		//sondageDate0.setParticipants(participantsSondageLieu);
	    sondageDate1.setPauseDejeunerSondage(true);
	    sondageDate1.setUtilisateurSondageDate(utilisateurDateLieu);
		serviceSondageDateDaoImpl.addSondageDate(sondageDate1);
		
		
		SondageDate sondageDate2 = new SondageDate();
		sondageDate2.setReunion(reunion1);
		Date date5 = null;
	    SimpleDateFormat simpleDateFormat5 = new SimpleDateFormat("dd/MM/yyyy");
	    String date33 = "06/04/2019";
	    date5 = simpleDateFormat5.parse(date33);
	    sondageDate2.setDateSondage(date5);
		//sondageDate0.setParticipants(participantsSondageLieu);
		sondageDate2.setPauseDejeunerSondage(false);
		sondageDate2.setUtilisateurSondageDate(utilisateurDate);
		serviceSondageDateDaoImpl.addSondageDate(sondageDate2);
		
		
		
		serviceSondageDateDaoImpl.commitTransaction();
		
		
		
		
		
		
		
		serviceAllergieDaoImpl.beginTransaction();
		Allergie allergie0 = new Allergie();
		allergie0.setLibelleAllergie("allergie 0");
		//allergie0.setParticipants(participantsSondageDate);
		serviceAllergieDaoImpl.addAllergie(allergie0);
		
		Allergie allergie1 = new Allergie();
		allergie1.setLibelleAllergie("allergie 1");
		//allergie1.setParticipants(participantsSondageLieu);
		serviceAllergieDaoImpl.addAllergie(allergie1);
		
		Allergie allergie2 = new Allergie();
		allergie2.setLibelleAllergie("allergie 2");
	//	allergie2.setParticipants(participantsSondageDateLieu);
		serviceAllergieDaoImpl.addAllergie(allergie2);	
		serviceAllergieDaoImpl.commitTransaction();
		
		
		

		servicePreferenceAlimentaireDaoImpl.beginTransaction();
		PreferenceAlimentaire preferenceAlimentaire0 = new PreferenceAlimentaire();
		preferenceAlimentaire0.setLibellePreferenceAlimentaire("preference 0");
		servicePreferenceAlimentaireDaoImpl.addPreferenceAlimentaire(preferenceAlimentaire0);
		
		PreferenceAlimentaire preferenceAlimentaire1 = new PreferenceAlimentaire();
		preferenceAlimentaire1.setLibellePreferenceAlimentaire("preference 1");
		servicePreferenceAlimentaireDaoImpl.addPreferenceAlimentaire(preferenceAlimentaire1);
		
		PreferenceAlimentaire preferenceAlimentaire2 = new PreferenceAlimentaire();
		preferenceAlimentaire2.setLibellePreferenceAlimentaire("preference 2");
		servicePreferenceAlimentaireDaoImpl.addPreferenceAlimentaire(preferenceAlimentaire2);
		
		PreferenceAlimentaire preferenceAlimentaire3 = new PreferenceAlimentaire();
		preferenceAlimentaire3.setLibellePreferenceAlimentaire("preference 3");
		servicePreferenceAlimentaireDaoImpl.addPreferenceAlimentaire(preferenceAlimentaire3);
		
		PreferenceAlimentaire preferenceAlimentaire4 = new PreferenceAlimentaire();
		preferenceAlimentaire4.setLibellePreferenceAlimentaire("preference 4");
		servicePreferenceAlimentaireDaoImpl.addPreferenceAlimentaire(preferenceAlimentaire4);
		
		PreferenceAlimentaire preferenceAlimentaire5 = new PreferenceAlimentaire();
		preferenceAlimentaire5.setLibellePreferenceAlimentaire("preference 5");
		servicePreferenceAlimentaireDaoImpl.addPreferenceAlimentaire(preferenceAlimentaire5);
		
		PreferenceAlimentaire preferenceAlimentaire6 = new PreferenceAlimentaire();
		preferenceAlimentaire6.setLibellePreferenceAlimentaire("preference 6");
		servicePreferenceAlimentaireDaoImpl.addPreferenceAlimentaire(preferenceAlimentaire6);
		
		PreferenceAlimentaire preferenceAlimentaire7 = new PreferenceAlimentaire();
		preferenceAlimentaire7.setLibellePreferenceAlimentaire("preference 7");
		servicePreferenceAlimentaireDaoImpl.addPreferenceAlimentaire(preferenceAlimentaire7);
		
		PreferenceAlimentaire preferenceAlimentaire8 = new PreferenceAlimentaire();
		preferenceAlimentaire8.setLibellePreferenceAlimentaire("preference 8");
		servicePreferenceAlimentaireDaoImpl.addPreferenceAlimentaire(preferenceAlimentaire8);
		
		PreferenceAlimentaire preferenceAlimentaire9 = new PreferenceAlimentaire();
		preferenceAlimentaire9.setLibellePreferenceAlimentaire("preference 9");
		servicePreferenceAlimentaireDaoImpl.addPreferenceAlimentaire(preferenceAlimentaire9);
		
		servicePreferenceAlimentaireDaoImpl.commitTransaction();
		
		
		
		
		

		
		serviceParticipantDaoImpl.beginTransaction();
		
		Allergie a0 = new Allergie();
		Allergie a1 = new Allergie();
		Allergie a2 = new Allergie();
		
		a0=serviceAllergieDaoImpl.getAllergieById(1);
		a1=serviceAllergieDaoImpl.getAllergieById(2);
		a2=serviceAllergieDaoImpl.getAllergieById(3);
		
		Collection<Allergie> allergies0 = new ArrayList<Allergie>();
		Collection<Allergie> allergies1 = new ArrayList<Allergie>();
		Collection<Allergie> allergies2 = new ArrayList<Allergie>();
		
		Collection<Allergie> allergies3 = new ArrayList<Allergie>();
		Collection<Allergie> allergies4 = new ArrayList<Allergie>();
		Collection<Allergie> allergies5 = new ArrayList<Allergie>();
		
		Collection<Allergie> allergies6 = new ArrayList<Allergie>();
		
		allergies0.add(a0);
		allergies1.add(a1);
		allergies2.add(a2);
		
		allergies3.add(a0);
		allergies3.add(a1);
		allergies4.add(a0);
		allergies4.add(a2);
		allergies5.add(a1);
		allergies5.add(a2);
		
		allergies6.add(a0);
		allergies6.add(a1);
		allergies6.add(a2);
		
		SondageDate s00 = new SondageDate();
		SondageDate s01 = new SondageDate();
		SondageDate s02 = new SondageDate();
		
		s00=serviceSondageDateDaoImpl.getSondageDateById(7);
		s01=serviceSondageDateDaoImpl.getSondageDateById(8);
		s02=serviceSondageDateDaoImpl.getSondageDateById(9);
		
		Collection<SondageDate> sondageDates0 = new ArrayList<SondageDate>();
		Collection<SondageDate> sondageDates1 = new ArrayList<SondageDate>();
		Collection<SondageDate> sondageDates2 = new ArrayList<SondageDate>();
		
		Collection<SondageDate> sondageDates3 = new ArrayList<SondageDate>();
		Collection<SondageDate> sondageDates4 = new ArrayList<SondageDate>();
		Collection<SondageDate> sondageDates5 = new ArrayList<SondageDate>();
		
		Collection<SondageDate> sondageDates6 = new ArrayList<SondageDate>();
		
		sondageDates0.add(s00);
		sondageDates1.add(s01);
		sondageDates2.add(s02);
		
		sondageDates3.add(s00);
		sondageDates3.add(s01);
		sondageDates4.add(s01);
		sondageDates4.add(s02);
		sondageDates5.add(s00);
		sondageDates5.add(s02);
		
		sondageDates6.add(s00);
		sondageDates6.add(s01);
		sondageDates6.add(s02);
		
		SondageDateLieu s10 = new SondageDateLieu();
		SondageDateLieu s11 = new SondageDateLieu();
		SondageDateLieu s12 = new SondageDateLieu();
		
		Collection<SondageDateLieu> sondageDateLieux0 = new ArrayList<SondageDateLieu>();
		Collection<SondageDateLieu> sondageDateLieux1 = new ArrayList<SondageDateLieu>();
		Collection<SondageDateLieu> sondageDateLieux2 = new ArrayList<SondageDateLieu>();
		
		Collection<SondageDateLieu> sondageDateLieux3 = new ArrayList<SondageDateLieu>();
		Collection<SondageDateLieu> sondageDateLieux4 = new ArrayList<SondageDateLieu>();
		Collection<SondageDateLieu> sondageDateLieux5 = new ArrayList<SondageDateLieu>();
		
		Collection<SondageDateLieu> sondageDateLieux6 = new ArrayList<SondageDateLieu>();
		
		SondageLieu s20 = new SondageLieu();
		SondageLieu s21 = new SondageLieu();
		SondageLieu s22 = new SondageLieu();
		
		Collection<SondageLieu> sondageLieux0 = new ArrayList<SondageLieu>();
		Collection<SondageLieu> sondageLieux1 = new ArrayList<SondageLieu>();
		Collection<SondageLieu> sondageLieux2 = new ArrayList<SondageLieu>();
		
		Collection<SondageLieu> sondageLieux3 = new ArrayList<SondageLieu>();
		Collection<SondageLieu> sondageLieux4 = new ArrayList<SondageLieu>();
		Collection<SondageLieu> sondageLieux5 = new ArrayList<SondageLieu>();
		
		Collection<SondageLieu> sondageLieux6 = new ArrayList<SondageLieu>();

		Participant participantDateLieu = new Participant();
		participantDateLieu.setEmailUtilisateur("mtouganroland@gmail.com");
		participantDateLieu.setNom("TOUGAN");
		participantDateLieu.setPrenom("Roland");
		participantDateLieu.setAllergies(allergies0);
		participantDateLieu.setPreferenceAlimentaire(preferenceAlimentaire0);
		serviceParticipantDaoImpl.addParticipant(participantDateLieu);
		
		Participant participantDate = new Participant();
		participantDate.setEmailUtilisateur("_mtouganroland@gmail.com");
		participantDate.setNom("TOUGAN");
		participantDate.setPrenom("Roland");
		participantDate.setAllergies(allergies1);
		participantDate.setPreferenceAlimentaire(preferenceAlimentaire1);
		participantDate.setSondageDate(sondageDates6);
		serviceParticipantDaoImpl.addParticipant(participantDate);
		
		Participant participantLieu = new Participant();
		participantLieu.setEmailUtilisateur("__mtouganroland@gmail.com");
		participantLieu.setNom("TOUGAN");
		participantLieu.setPrenom("Roland");
		participantLieu.setPreferenceAlimentaire(preferenceAlimentaire2);
		participantLieu.setAllergies(allergies2);
		serviceParticipantDaoImpl.addParticipant(participantLieu);
		
		for (int i = 0; i <= 99; i++) {
			Participant participant = new Participant();
			participant.setEmailUtilisateur(i+"participant@gmail.com");
			participant.setNom("nom_"+i);
			participant.setPrenom("prenom_"+i);
			 
			if (i<=9) {
				participant.setPreferenceAlimentaire(preferenceAlimentaire0);
				participant.setAllergies(allergies0);
			}else if (10>=i || i<=19) {
				participant.setPreferenceAlimentaire(preferenceAlimentaire1);
				participant.setAllergies(allergies1);
			}else if (20>=i || i<=29) {
				participant.setPreferenceAlimentaire(preferenceAlimentaire2);
				participant.setAllergies(allergies2);
			}
			else if (30>=i || i<=39) {
				participant.setPreferenceAlimentaire(preferenceAlimentaire3);
				participant.setAllergies(allergies3);
			}
			else if (40>=i || i<=49) {
				participant.setPreferenceAlimentaire(preferenceAlimentaire4);
				participant.setAllergies(allergies4);
			}
			else if (50>=i || i<=59) {
				participant.setPreferenceAlimentaire(preferenceAlimentaire5);
				participant.setAllergies(allergies5);
			}
			else if (60>=i || i<=69) {
				participant.setPreferenceAlimentaire(preferenceAlimentaire6);
				participant.setAllergies(allergies6);
			}
			else if (70>=i || i<=79) {
				participant.setPreferenceAlimentaire(preferenceAlimentaire7);
				participant.setAllergies(allergies0);
			}
			else if (80>=i || i<=89) {
				participant.setPreferenceAlimentaire(preferenceAlimentaire8);
				participant.setAllergies(allergies1);
			}
			else 
			{
				participant.setPreferenceAlimentaire(preferenceAlimentaire9);
				participant.setAllergies(allergies2);
			}
			
			serviceParticipantDaoImpl.addParticipant(participant);
		}
		serviceParticipantDaoImpl.commitTransaction();
		
		
		

		
		/*

		serviceUtilisateurDaoImpl.beginTransaction();
		Utilisateur utilisateurAbdoul_Karim0 = new Utilisateur();
		utilisateurAbdoul_Karim0 = serviceUtilisateurDaoImpl.getUtilisateurById("soumabkar@gmail.com");
		SondageLieu sondageLieuAbdoul_karim0 = new SondageLieu();
		sondageLieuAbdoul_karim0 = serviceSondageLieuDaoImpl.getSondageLieuById(1);
		Collection<SondageLieu> ListSondageLieuAbdoul_karim0 = new ArrayList<SondageLieu>();
		ListSondageLieuAbdoul_karim0.add(sondageLieuAbdoul_karim0);
		utilisateurAbdoul_Karim0.setSondageLieu(ListSondageLieuAbdoul_karim0);
		serviceUtilisateurDaoImpl.updateUtilisateur(utilisateurAbdoul_Karim0);
		
		Utilisateur utilisateurAbbah0 = new Utilisateur();
		utilisateurAbbah0 = serviceUtilisateurDaoImpl.getUtilisateurById("anohabbah@gmail.com");
		SondageLieu sondageLieuAbbah0 = new SondageLieu();
		sondageLieuAbbah0 = serviceSondageLieuDaoImpl.getSondageLieuById(2);
		Collection<SondageLieu> ListSondageLieuAbbah0 = new ArrayList<SondageLieu>();
		ListSondageLieuAbbah0.add(sondageLieuAbbah0);
		utilisateurAbbah0.setSondageLieu(ListSondageLieuAbbah0);
		serviceUtilisateurDaoImpl.updateUtilisateur(utilisateurAbbah0);
		
		
		Utilisateur utilisateurMaud0 = new Utilisateur();
		utilisateurMaud0 = serviceUtilisateurDaoImpl.getUtilisateurById("maudmcok@gmail.com");
		SondageLieu sondageLieuMaud0 = new SondageLieu();
		sondageLieuMaud0 = serviceSondageLieuDaoImpl.getSondageLieuById(3);
		Collection<SondageLieu> ListSondageLieuMaud0 = new ArrayList<SondageLieu>();
		ListSondageLieuMaud0.add(sondageLieuMaud0);
		utilisateurMaud0.setSondageLieu(ListSondageLieuAbbah0);
		serviceUtilisateurDaoImpl.updateUtilisateur(utilisateurMaud0);
		
		
		
		serviceUtilisateurDaoImpl.commitTransaction();
		
		
		
		
		serviceUtilisateurDaoImpl.beginTransaction();
		Utilisateur utilisateurAbdoul_Karim1 = new Utilisateur();
		utilisateurAbdoul_Karim1 = serviceUtilisateurDaoImpl.getUtilisateurById("soumabkar@gmail.com");
		SondageDateLieu sondageDateLieuAbdoul_karim1 = new SondageDateLieu();
		sondageDateLieuAbdoul_karim1 = serviceSondageDateLieuDaoImpl.getSondageDateLieuById(4);
		Collection<SondageDateLieu> ListSondageDateLieuAbdoul_karim1 = new ArrayList<SondageDateLieu>();
		ListSondageDateLieuAbdoul_karim1.add(sondageDateLieuAbdoul_karim1);
		utilisateurAbdoul_Karim1.setSondageDateLieu(ListSondageDateLieuAbdoul_karim1);
		serviceUtilisateurDaoImpl.updateUtilisateur(utilisateurAbdoul_Karim1);
		
		Utilisateur utilisateurAbbah1 = new Utilisateur();
		utilisateurAbbah1 = serviceUtilisateurDaoImpl.getUtilisateurById("anohabbah@gmail.com");
		SondageDateLieu sondageDateLieuAbbah1 = new SondageDateLieu();
		sondageDateLieuAbbah1 = serviceSondageDateLieuDaoImpl.getSondageDateLieuById(5);
		Collection<SondageDateLieu> ListSondageDateLieuAbbah1 = new ArrayList<SondageDateLieu>();
		ListSondageDateLieuAbbah1.add(sondageDateLieuAbbah1);
		utilisateurAbbah1.setSondageDateLieu(ListSondageDateLieuAbbah1);
		serviceUtilisateurDaoImpl.updateUtilisateur(utilisateurAbbah1);
		
		
		Utilisateur utilisateurMaud1 = new Utilisateur();
		utilisateurMaud1 = serviceUtilisateurDaoImpl.getUtilisateurById("maudmcok@gmail.com");
		SondageDateLieu sondageDateLieuMaud1 = new SondageDateLieu();
		sondageDateLieuMaud1 = serviceSondageDateLieuDaoImpl.getSondageDateLieuById(6);
		Collection<SondageDateLieu> ListSondageDateLieuMaud1 = new ArrayList<SondageDateLieu>();
		ListSondageDateLieuMaud1.add(sondageDateLieuMaud1);
		utilisateurMaud1.setSondageDateLieu(ListSondageDateLieuMaud1);
		serviceUtilisateurDaoImpl.updateUtilisateur(utilisateurMaud1);
		
		
		
		serviceUtilisateurDaoImpl.commitTransaction();
		
		
		
		serviceUtilisateurDaoImpl.beginTransaction();
		Utilisateur utilisateurAbdoul_Karim2 = new Utilisateur();
		utilisateurAbdoul_Karim2 = serviceUtilisateurDaoImpl.getUtilisateurById("soumabkar@gmail.com");
		SondageDate sondageDateAbdoul_karim2 = new SondageDate();
		sondageDateAbdoul_karim2 = serviceSondageDateDaoImpl.getSondageDateById(7);
		Collection<SondageDate> ListSondageDateAbdoul_karim2 = new ArrayList<SondageDate>();
		ListSondageDateAbdoul_karim2.add(sondageDateAbdoul_karim2);
		utilisateurAbdoul_Karim2.setSondageDates(ListSondageDateAbdoul_karim2);
		serviceUtilisateurDaoImpl.updateUtilisateur(utilisateurAbdoul_Karim2);
		
		Utilisateur utilisateurAbbah2 = new Utilisateur();
		utilisateurAbbah2 = serviceUtilisateurDaoImpl.getUtilisateurById("anohabbah@gmail.com");
		SondageDate sondageDateAbbah2 = new SondageDate();
		sondageDateAbbah2 = serviceSondageDateDaoImpl.getSondageDateById(8);
		Collection<SondageDate> ListSondageDateAbbah2 = new ArrayList<SondageDate>();
		ListSondageDateAbbah2.add(sondageDateAbbah2);
		utilisateurAbbah2.setSondageDates(ListSondageDateAbbah2);
		serviceUtilisateurDaoImpl.updateUtilisateur(utilisateurAbbah2);
		
		
		Utilisateur utilisateurMaud2 = new Utilisateur();
		utilisateurMaud2 = serviceUtilisateurDaoImpl.getUtilisateurById("maudmcok@gmail.com");
		SondageDate sondageDateMaud2 = new SondageDate();
		sondageDateMaud2 = serviceSondageDateDaoImpl.getSondageDateById(9);
		Collection<SondageDate> ListSondageDateMaud2 = new ArrayList<SondageDate>();
		ListSondageDateMaud2.add(sondageDateMaud2);
		utilisateurMaud2.setSondageDates(ListSondageDateMaud2);
		serviceUtilisateurDaoImpl.updateUtilisateur(utilisateurMaud2);
		
		
		
		serviceUtilisateurDaoImpl.commitTransaction();
		
		
		
		*/
			
		
		
		
		
		return "Okay, waih c'est bon";
	}

}

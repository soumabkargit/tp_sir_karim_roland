package fr.istic.sir.rest;

import java.util.Collection;

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
import entity.Participant;
import entity.Reunion;
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
	public String peuple() {
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
		
		serviceParticipantDaoImpl.beginTransaction();
		Participant participant0 = new Participant();
		participant0.setEmailUtilisateur("mtouganroland@gmail.com");
		participant0.setNom("TOUGAN");
		participant0.setPrenom("Roland");
		serviceParticipantDaoImpl.addParticipant(participant0);
		
		for (int i = 1; i <= 89; i++) {
			Participant participant = new Participant();
			participant.setEmailUtilisateur("mtouganroland@gmail.com"+i);
			participant.setNom("TOUGAN"+i);
			participant.setPrenom("Roland"+i);
			serviceParticipantDaoImpl.addParticipant(participant);
		}
		serviceParticipantDaoImpl.commitTransaction();
		
		
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
		
		
		
		return "Okay, waih c'est bon";
	}

}

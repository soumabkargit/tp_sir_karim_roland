package entity;

import java.util.Collection;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@DiscriminatorValue(value="SondageLieu")
@NamedQueries({
    @NamedQuery(name = "findAllSondageLieux", query = "SELECT s FROM SondageLieu s")})
public class SondageLieu extends Sondage {

	private String lieuSondage;
	private boolean pauseDejeunerSondageLieu;
	private Collection <Participant> participants;
	private Utilisateur utilisateurSondageLieu;
	
	public String getLieuSondage() {
		return lieuSondage;
	}
	public void setLieuSondage(String lieuSondage) {
		this.lieuSondage = lieuSondage;
	}
	public boolean isPauseDejeuner() {
		return pauseDejeunerSondageLieu;
	}
	public void setPauseDejeuner(boolean pauseDejeuner) {
		this.pauseDejeunerSondageLieu = pauseDejeuner;
	}
	public boolean isPauseDejeunerSondageLieu() {
		return pauseDejeunerSondageLieu;
	}
	public void setPauseDejeunerSondageLieu(boolean pauseDejeunerSondageLieu) {
		this.pauseDejeunerSondageLieu = pauseDejeunerSondageLieu;
	}
	@ManyToMany(mappedBy="sondageLieux")
	public Collection<Participant> getParticipants() {
		return participants;
	}
	public void setParticipants(Collection<Participant> participants) {
		this.participants = participants;
	}
	
	@ManyToOne
	public Utilisateur getUtilisateurSondageLieu() {
		return utilisateurSondageLieu;
	}
	public void setUtilisateurSondageLieu(Utilisateur utilisateurSondageDate) {
		this.utilisateurSondageLieu = utilisateurSondageDate;
	}

}

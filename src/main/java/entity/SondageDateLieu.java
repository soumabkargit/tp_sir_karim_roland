package entity;

import java.util.Collection;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@DiscriminatorValue(value="SondageDateLieu")
@NamedQueries({
    @NamedQuery(name = "findAllSondageDateLieux", query = "SELECT s FROM SondageDateLieu s")})
public class SondageDateLieu extends Sondage {
	
	@Temporal(TemporalType.DATE)
	private Date dateSondageDateLieu;
	private boolean pauseDejeuneSondageDateLieur;
	private String lieuSondageDateLieu;
	private Collection <Participant> participants;
	private Utilisateur utilisateurSondageDateLieu;
	
	
	public Date getDateSondageDateLieu() {
		return dateSondageDateLieu;
	}
	public void setDateSondageDateLieu(Date dateSondageDateLieu) {
		this.dateSondageDateLieu = dateSondageDateLieu;
	}
	public boolean isPauseDejeuneSondageDateLieur() {
		return pauseDejeuneSondageDateLieur;
	}
	public void setPauseDejeuneSondageDateLieur(boolean pauseDejeuneSondageDateLieur) {
		this.pauseDejeuneSondageDateLieur = pauseDejeuneSondageDateLieur;
	}
	public String getLieuSondageDateLieu() {
		return lieuSondageDateLieu;
	}
	public void setLieuSondageDateLieu(String lieuSondageDateLieu) {
		this.lieuSondageDateLieu = lieuSondageDateLieu;
	}
	
	@ManyToMany(mappedBy="sondageDateLieux")
	public Collection<Participant> getParticipants() {
		return participants;
	}
	public void setParticipants(Collection<Participant> participants) {
		this.participants = participants;
	}
	
	@ManyToOne
	public Utilisateur getUtilisateurSondageDateLieu() {
		return utilisateurSondageDateLieu;
	}
	public void setUtilisateurSondageDateLieu(Utilisateur utilisateurSondageDateLieu) {
		this.utilisateurSondageDateLieu = utilisateurSondageDateLieu;
	}
	
}

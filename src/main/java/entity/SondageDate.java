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
@DiscriminatorValue(value="SondageDate")
@NamedQueries({
    @NamedQuery(name = "findAllSondageDates", query = "SELECT s FROM SondageDate s")})
public class SondageDate extends Sondage {
	
	@Temporal(TemporalType.DATE)
	private Date dateSondageDate;
	private boolean pauseDejeunerSondageDate;
	private Collection <Participant> participants;
	private Utilisateur utilisateurSondageDate;
	
	
	public Date getDateSondageDate() {
		return dateSondageDate;
	}
	public void setDateSondage(Date dateSondageDate) {
		this.dateSondageDate = dateSondageDate;
	}
	public boolean isPauseDejeuner() {
		return pauseDejeunerSondageDate;
	}
	public void setPauseDejeuner(boolean pauseDejeunerSondageDate) {
		this.pauseDejeunerSondageDate = pauseDejeunerSondageDate;
	}
	public boolean isPauseDejeunerSondageDate() {
		return pauseDejeunerSondageDate;
	}
	public void setPauseDejeunerSondageDate(boolean pauseDejeunerSondageDate) {
		this.pauseDejeunerSondageDate = pauseDejeunerSondageDate;
	}
	@ManyToMany(mappedBy="sondageDate")
	public Collection<Participant> getParticipants() {
		return participants;
	}
	public void setParticipants(Collection<Participant> participants) {
		this.participants = participants;
	}
	public void setDateSondageDate(Date dateSondageDate) {
		this.dateSondageDate = dateSondageDate;
	}
	
	@ManyToOne
	public Utilisateur getUtilisateurSondageDate() {
		return utilisateurSondageDate;
	}
	public void setUtilisateurSondageDate(Utilisateur utilisateurSondageDate) {
		this.utilisateurSondageDate = utilisateurSondageDate;
	}

}

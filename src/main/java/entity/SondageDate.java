package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonManagedReference;

@Entity
@DiscriminatorValue(value="SondageDate")
@NamedQueries({
    @NamedQuery(name = "findAllSondageDates", query = "SELECT s FROM SondageDate s")})
public class SondageDate extends Sondage implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Temporal(TemporalType.DATE)
	private Date dateSondageDate;
	private Collection <Participant> participants;
	private Utilisateur utilisateurSondageDate;
	
	
	public Date getDateSondageDate() {
		return dateSondageDate;
	}
	public void setDateSondage(Date dateSondageDate) {
		this.dateSondageDate = dateSondageDate;
	} 

	@JsonManagedReference
	@ManyToMany(cascade = CascadeType.ALL, fetch= FetchType.EAGER)
	public Collection<Participant> getParticipants() {
		return participants;
	}
	public void setParticipants(Collection<Participant> participants) {
		this.participants = participants;
	}
	public void setDateSondageDate(Date dateSondageDate) {
		this.dateSondageDate = dateSondageDate;
	}
    @JsonBackReference
	@ManyToOne
	public Utilisateur getUtilisateurSondageDate() {
		return utilisateurSondageDate;
	}
	public void setUtilisateurSondageDate(Utilisateur utilisateurSondageDate) {
		this.utilisateurSondageDate = utilisateurSondageDate;
	}

}

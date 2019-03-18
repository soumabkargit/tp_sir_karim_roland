package entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonManagedReference;

@Entity
@DiscriminatorValue(value="SondageLieu")
@NamedQueries({
    @NamedQuery(name = "findAllSondageLieux", query = "SELECT s FROM SondageLieu s")})
public class SondageLieu extends Sondage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String lieuSondage;
	private Collection <Participant> participants;
	private Utilisateur utilisateurSondageLieu;
	
	public String getLieuSondage() {
		return lieuSondage;
	}
	public void setLieuSondage(String lieuSondage) {
		this.lieuSondage = lieuSondage;
	}

	@JsonManagedReference
	@ManyToMany(cascade = CascadeType.ALL, fetch= FetchType.EAGER)
	public Collection<Participant> getParticipants() {
		return participants;
	}
	public void setParticipants(Collection<Participant> participants) {
		this.participants = participants;
	}
	 @JsonBackReference
	@ManyToOne
	public Utilisateur getUtilisateurSondageLieu() {
		return utilisateurSondageLieu;
	}
	public void setUtilisateurSondageLieu(Utilisateur utilisateurSondageDate) {
		this.utilisateurSondageLieu = utilisateurSondageDate;
	}

}

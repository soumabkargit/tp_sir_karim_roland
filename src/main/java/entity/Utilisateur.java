package entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import org.codehaus.jackson.annotate.JsonManagedReference;

@Entity
@DiscriminatorValue(value="Utilisateur")
@NamedQueries({
    @NamedQuery(name = "findAllUtilisateurs", query = "SELECT u FROM Utilisateur u")})
public class Utilisateur extends UserDoodle implements Serializable {

	private String motPasse;
    private Collection<SondageDate> sondageDates;
    private Collection<SondageLieu> sondageLieux;
    private Collection<SondageDateLieu> sondageDateLieux;

	public String getMotPasse() {
		return motPasse;
	}

	public void setMotPasse(String motPasse) {
		this.motPasse = motPasse;
	}

    

	@JsonManagedReference
	@OneToMany(mappedBy="utilisateurSondageLieu",cascade = CascadeType.ALL, fetch= FetchType.EAGER)
	public Collection<SondageLieu> getSondageLieux() {
		return sondageLieux;
	}

	public void setSondageLieu(Collection<SondageLieu> sondageLieux) {
		this.sondageLieux = sondageLieux;
	}	
	@JsonManagedReference
	@OneToMany(mappedBy="utilisateurSondageDateLieu",cascade = CascadeType.ALL, fetch= FetchType.EAGER)
	public Collection<SondageDateLieu> getSondageDateLieu() {
		return sondageDateLieux;
	}

	public void setondageDateLieu(Collection<SondageDateLieu> sondageDateLieu) {
		this.sondageDateLieux = sondageDateLieu;
	}

	@JsonManagedReference
	@OneToMany(mappedBy="utilisateurSondageDate",cascade = CascadeType.ALL, fetch= FetchType.EAGER)
	public Collection<SondageDate> getSondageDates() {
		return sondageDates;
	}

	public void setSondageDates(Collection<SondageDate> sondageDates) {
		this.sondageDates = sondageDates;
	}

	
	
	public void setSondageLieux(Collection<SondageLieu> sondageLieux) {
		this.sondageLieux = sondageLieux;
	}

	public void setSondageDateLieu(Collection<SondageDateLieu> sondageDateLieu) {
		this.sondageDateLieux = sondageDateLieu;
	}	
	
	
}

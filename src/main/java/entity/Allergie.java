package entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.codehaus.jackson.annotate.JsonManagedReference;

@Entity
public class Allergie implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idAllergie;
	private String libelleAllergie;
	private Collection<Participant> participants;
	
	@Id
	@GeneratedValue
	public int getIdAllergie() {
		return idAllergie;
	}
	public void setIdAllergie(int idAllergie) {
		this.idAllergie = idAllergie;
	}
	public String getLibelleAllergie() {
		return libelleAllergie;
	}
	public void setLibelleAllergie(String libelleAllergie) {
		this.libelleAllergie = libelleAllergie;
	}
	
	@JsonManagedReference
	@ManyToMany(cascade = CascadeType.ALL, fetch= FetchType.EAGER)
	public Collection<Participant> getParticipants() {
		return participants;
	}
	public void setParticipants(Collection<Participant> participants) {
		this.participants = participants;
	}
	
	
	

}

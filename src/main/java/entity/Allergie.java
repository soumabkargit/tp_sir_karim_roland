package entity;

import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Allergie {
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
	
	@ManyToMany(mappedBy="allergies")
	public Collection<Participant> getParticipants() {
		return participants;
	}
	public void setParticipants(Collection<Participant> participants) {
		this.participants = participants;
	}
	
	
	

}

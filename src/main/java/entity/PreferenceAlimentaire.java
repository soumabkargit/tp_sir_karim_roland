package entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import org.codehaus.jackson.annotate.JsonManagedReference;

@Entity
@NamedQueries({
    @NamedQuery(name = "findAllPreferenceAlimentaires", query = "SELECT p FROM Reunion p")})
public class PreferenceAlimentaire implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private int idPreferenceAlimentaire;
private String libellePreferenceAlimentaire;
private Collection<Participant> participants;

@Id
@GeneratedValue
public int getIdPreferenceAlimentaire() {
	return idPreferenceAlimentaire;
}
public void setIdPreferenceAlimentaire(int idPreferenceAlimentaire) {
	this.idPreferenceAlimentaire = idPreferenceAlimentaire;
}
public String getLibellePreferenceAlimentaire() {
	return libellePreferenceAlimentaire;
}
public void setLibellePreferenceAlimentaire(String libellePreferenceAlimentaire) {
	this.libellePreferenceAlimentaire = libellePreferenceAlimentaire;
}

@JsonManagedReference
@OneToMany(mappedBy="preferenceAlimentaire",cascade = CascadeType.ALL, fetch= FetchType.EAGER)
public Collection<Participant> getParticipants() {
	return participants;
}
public void setParticipants(Collection<Participant> participants) {
	this.participants = participants;
}



}

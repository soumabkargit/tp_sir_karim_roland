package entity;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;


@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="discriminatorSondage",
discriminatorType=DiscriminatorType.STRING)
public abstract class Sondage {

	private int idSondage;
	private Reunion reunion;
	
	@Id
	@GeneratedValue
	public int getIdSondage() {
		return idSondage;
	}
	public void setIdSondage(int idSondage) {
		this.idSondage = idSondage;
	}
	

	@ManyToOne
	public Reunion getReunion() {
		return reunion;
	}
	public void setReunion(Reunion reunion) {
		this.reunion = reunion;
	}


}

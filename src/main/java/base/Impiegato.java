package base;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "impiegato")

public class Impiegato {
	
	@Id             //LA CHIAMO ID PERCHè è LA CHIAVE PRIMARIA, NON PERCHE è IL NOME DELL'ATTRIBUTO
	private int id;
	
	@Column (name = "firstname")  //LE COLONNE LE METTO SOLO SE IL NOME CHE USO QUI E IN TABELLA CAMBIA, SE NO FA NULLA
	private String firstname;
	
	@Column (name = "lastname")
	private String lastname;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

}

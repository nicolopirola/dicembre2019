package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "users")
public class Users {

	@Id
	private int id;
	private String name;
	private String address;
	private String email;
	private String phone;

	public void Users() {

	}

	public void Users(int id, String name, String address, String email, String phone) {
		this.setId(id);
		this.setName(name);
		this.setAddress(address);
		this.setEmail(email);
		this.setPhone(phone);
	}

	public void printUtente() {
		System.out.println(this.getId());
		System.out.println(this.getName());
		System.out.println(this.getAddress());
		System.out.println( this.getEmail());
		System.out.println(this.getPhone());
		System.out.println("----------------------\n");
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}

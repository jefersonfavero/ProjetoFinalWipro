package Wipro.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Client{
	@Id	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String CPF;
	private String name;
	private String address;
	//@OneToOne //(mappedBy = "client", cascade = CascadeType.REMOVE)
	//private CurrentAccount currentaccount;
	

//	public CurrentAccount getCurrentaccount() {
//		return currentaccount;
//	}
//
//	public void setCurrentaccount(CurrentAccount currentaccount) {
//		this.currentaccount = currentaccount;
//	}

	public Client() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(id);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		return Objects.equals(id, other.id);
	}

	public Account getAccount() {
		return getAccount();
	}

	public void consultExtract() {
		
	}
	
}

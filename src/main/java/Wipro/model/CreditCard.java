package Wipro.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.transaction.Transactional;

@Entity
public class CreditCard implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String cardNumber;
	private String CVV;
	@OneToOne
	private Client client;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getCVV() {
		return CVV;
	}
	public void setCVV(String cVV) {
		CVV = cVV;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}

	
	
}

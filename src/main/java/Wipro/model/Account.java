package Wipro.model;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)               
public abstract class Account{
	@Id	@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
	private String number;
	private double balance;
	private boolean status;
    private String tipo;
    @OneToOne//(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinColumn(name = "id_servico", nullable = false)
	private Client client;
    @OneToOne
	private Agency agency;
    @OneToOne//(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinColumn(name = "credit_id")
	private CreditCard creditcard;
    
	public Integer getId() {
		return id;
	}
	public String getNumber() {
		return number;
	}
	public double getBalance() {
		return balance;
	}
	public boolean isStatus() {
		return status;
	}
	public String getTipo() {
		return tipo;
	}
	public Client getClient() {
		return client;
	}
	public Agency getAgency() {
		return agency;
	}
	public CreditCard getCreditcard() {
		return creditcard;
	}
	public void generateExtract() {
		
	}
	public void consultAccountData() {
		
	}
	private void moneyDeposit() {
		// TODO Auto-generated method stub

	}
	private void moneyWithdraw() {
		// TODO Auto-generated method stub

	}
	@Override
	public int hashCode() {
		return Objects.hash(balance, id, number, status, tipo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		return Double.doubleToLongBits(balance) == Double.doubleToLongBits(other.balance)
				&& Objects.equals(id, other.id) && Objects.equals(number, other.number) && status == other.status
				&& Objects.equals(tipo, other.tipo);
	}
    
}
	
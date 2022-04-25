package Wipro.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
//@PrimaryKeyJoinColumn(name="idConta")
public class CurrentAccount{
	@Id	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String number;
	private double balance;
	private boolean status;
    private String tipo;
    @OneToOne //(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    //@JoinColumn(name = "id_servico", nullable = false)
	private Client client;
    @OneToOne
	private Agency agency;
    @OneToOne //(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    //@JoinColumn(name = "credit_id")
	private CreditCard creditcard;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
		CurrentAccount other = (CurrentAccount) obj;
		return Objects.equals(id, other.id);
	}
	
}

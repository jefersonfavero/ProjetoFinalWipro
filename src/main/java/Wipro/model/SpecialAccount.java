package Wipro.model;

import javax.persistence.Entity;

@Entity
public class SpecialAccount extends Account{
//	@Id	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Float limite;
//	private Integer id;
//	
//	public Integer getId() {
//		return id;
//	}
//	
//	public void setId(Integer id) {
//		this.id = id;
//	}

	public Float getLimite() {
		return limite;
	}

	public void setLimite(Float limite) {
		this.limite = limite;
	}
	


	
}

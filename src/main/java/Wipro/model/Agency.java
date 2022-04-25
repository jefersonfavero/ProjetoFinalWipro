package Wipro.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.transaction.Transactional;

@Entity
public class Agency implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String CNPJ;
	private String agencyNumber;
	private String agencyName;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCNPJ() {
		return CNPJ;
	}
	public void setCNPJ(String cNPJ) {
		CNPJ = cNPJ;
	}
	public String getAgencyNumber() {
		return agencyNumber;
	}
	public void setAgencyNumber(String agencyNumber) {
		this.agencyNumber = agencyNumber;
	}
	public String getAgencyName() {
		return agencyName;
	}
	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}
	@Override
	public int hashCode() {
		return Objects.hash(CNPJ, agencyName, agencyNumber, id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Agency other = (Agency) obj;
		return Objects.equals(CNPJ, other.CNPJ) && Objects.equals(agencyName, other.agencyName)
				&& Objects.equals(agencyNumber, other.agencyNumber) && Objects.equals(id, other.id);
	}
	
	

	
}

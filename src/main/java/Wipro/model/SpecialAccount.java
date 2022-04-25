package Wipro.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="idConta")
public class SpecialAccount extends Account{
	@Id	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private double limit;
	
	public double getLimit() {
		return limit;
	}
	public void setLimit(double limit) {
		this.limit = limit;
	}
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
		result = prime * result + Objects.hash(id, limit);
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
		SpecialAccount other = (SpecialAccount) obj;
		return Objects.equals(id, other.id) && Double.doubleToLongBits(limit) == Double.doubleToLongBits(other.limit);
	}

	
}

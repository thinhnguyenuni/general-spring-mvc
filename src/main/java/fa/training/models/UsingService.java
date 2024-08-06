package fa.training.models;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Positive;

@Entity
@Table(name = "SUDUNGDICHVU")
@AssociationOverrides({
		@AssociationOverride(name = "usingServicePK.customer", joinColumns = @JoinColumn(name = "MaKH")),
		@AssociationOverride(name = "usingServicePK.service", joinColumns = @JoinColumn(name = "MaDV")) })
public class UsingService {

	@EmbeddedId
	private UsingServicePK usingServicePK;

	@Column(name = "SoLuong")
	@Positive(message = "Số phải lớn hơn 0")
	private Integer quantity;

	public UsingServicePK getUsingServicePK() {
		return usingServicePK;
	}

	public void setUsingServicePK(UsingServicePK usingServicePK) {
		this.usingServicePK = usingServicePK;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public UsingService() {
	}

	public UsingService(UsingServicePK usingServicePK, Integer quantity) {
		this.usingServicePK = usingServicePK;
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "UsingService [usingServicePK=" + usingServicePK + ", quantity=" + quantity + "]";
	}

}

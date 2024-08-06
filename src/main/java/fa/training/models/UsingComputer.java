package fa.training.models;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Positive;

@Entity
@Table(name = "SUDUNGMAY")
@AssociationOverrides({
		@AssociationOverride(name = "usingComputerPK.customer", joinColumns = @JoinColumn(name = "MaKH")),
		@AssociationOverride(name = "usingComputerPK.computer", joinColumns = @JoinColumn(name = "MaMay")) })
public class UsingComputer {

	@EmbeddedId
	@Valid
	private UsingComputerPK usingComputerPK;

	@Column(name = "SoGioSuDung")
	@Positive(message = "Số phải lớn hơn 0")
	private Double duration;

	public UsingComputerPK getUsingComputerPK() {
		return usingComputerPK;
	}

	public void setUsingComputerPK(UsingComputerPK usingComputerPK) {
		this.usingComputerPK = usingComputerPK;
	}

	public Double getDuration() {
		return duration;
	}

	public void setDuration(Double duration) {
		this.duration = duration;
	}

	public UsingComputer() {
	}

	public UsingComputer(UsingComputerPK usingComputerPK, Double duration) {
		this.usingComputerPK = usingComputerPK;
		this.duration = duration;
	}

	public UsingComputer(UsingComputerPK usingComputerPK) {
		this.usingComputerPK = usingComputerPK;
	}

	@Override
	public String toString() {
		return "UsingComputer [usingComputerPK=" + usingComputerPK + ", duration=" + duration + "]";
	}

}

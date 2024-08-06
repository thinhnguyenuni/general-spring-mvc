package fa.training.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "MAY")
public class Computer {

	@Id
	@Column(name = "MaMay")
	@Pattern(regexp = "^MM\\d{3}$", message = "Nhập không đúng định dạng (MMxxx)")
	private String id;

	@Column(name = "ViTri", columnDefinition = "nvarchar(100)")
	@NotBlank(message = "Trường không được để trống")
	private String location;

	@Column(name = "TrangThai", columnDefinition = "nvarchar(30)")
	@NotBlank(message = "Trường không được để trống")
	private String status;

	@OneToMany(mappedBy = "usingComputerPK.computer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<UsingComputer> usingComputers;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set<UsingComputer> getUsingComputers() {
		return usingComputers;
	}

	public void setUsingComputers(Set<UsingComputer> usingComputers) {
		this.usingComputers = usingComputers;
	}

	public Computer() {
	}

	public Computer(String id, String location, String status, Set<UsingComputer> usingComputers) {
		this.id = id;
		this.location = location;
		this.status = status;
		this.usingComputers = usingComputers;
	}

	public Computer(String id, String location, String status) {
		this.id = id;
		this.location = location;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Computer [id=" + id + ", location=" + location + ", status=" + status + "]";
	}

}

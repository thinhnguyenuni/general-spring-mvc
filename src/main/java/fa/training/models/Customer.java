package fa.training.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "KHACHHANG")
public class Customer {
	@Id
	@Column(name = "MaKH")
	@Pattern(regexp = "^KH\\d{5}$", message = "Nhập không đúng định dạng (KHxxxxx)")
	private String id;

	@Column(name = "TenKH", columnDefinition = "nvarchar(100)")
	@NotBlank(message = "Trường không được để trống")
	private String name;

	@Column(name = "DiaChi", columnDefinition = "nvarchar(200)")
	@NotBlank(message = "Trường không được để trống")
	private String address;

	@Column(name = "SoDienThoai", columnDefinition = "varchar(13)")
//	@Pattern(regexp = "^[090|091|\\(84\\)\\+90|\\(84\\)\\+91]\\d{7}$", message = "Nhập không đúng định dạng")
	private String phone;

	@Column(name = "DiaChiEmail", columnDefinition = "varchar(100)")
	@NotBlank(message = "Trường không được để trống")
	@Email(message = "Nhập không đúng định dạng email")
	private String email;

	@OneToMany(mappedBy = "usingServicePK.customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<UsingService> usingServices;

	@OneToMany(mappedBy = "usingComputerPK.customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<UsingComputer> usingComputers;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<UsingService> getUsingServices() {
		return usingServices;
	}

	public void setUsingServices(Set<UsingService> usingServices) {
		this.usingServices = usingServices;
	}

	public Set<UsingComputer> getUsingComputers() {
		return usingComputers;
	}

	public void setUsingComputers(Set<UsingComputer> usingComputers) {
		this.usingComputers = usingComputers;
	}

	public Customer() {
	}

	public Customer(String id, String name, String address, String phone, String email, Set<UsingService> usingServices,
			Set<UsingComputer> usingComputers) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.usingServices = usingServices;
		this.usingComputers = usingComputers;
	}

	public Customer(String id, String name, String address, String phone, String email) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.email = email;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", address=" + address + ", phone=" + phone + ", email="
				+ email + "]";
	}

}

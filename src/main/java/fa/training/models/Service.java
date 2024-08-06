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
import javax.validation.constraints.Positive;

@Entity
@Table(name = "DICHVU")
public class Service {

	@Id
	@Column(name = "MaDV")
	@Pattern(regexp = "^DV\\d{3}$", message = "Nhập không đúng định dạng (DVxxx)")
	private String id;

	@Column(name = "TenDV", columnDefinition = "nvarchar(100)")
	@NotBlank(message = "Trường không được để trống")
	private String name;

	@Column(name = "DonViTinh", columnDefinition = "nvarchar(30)")
	@NotBlank(message = "Trường không được để trống")
	private String unit;

	@Column(name = "DonGia")
	@Positive(message = "Số phải lớn hơn 0")
	private Integer price;

	@OneToMany(mappedBy = "usingServicePK.service", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<UsingService> usingServices;

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

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Set<UsingService> getUsingServices() {
		return usingServices;
	}

	public void setUsingServices(Set<UsingService> usingServices) {
		this.usingServices = usingServices;
	}

	public Service() {
	}

	public Service(String id, String name, String unit, Integer price) {
		this.id = id;
		this.name = name;
		this.unit = unit;
		this.price = price;
	}

	public Service(String id, String name, String unit, Integer price, Set<UsingService> usingServices) {
		this.id = id;
		this.name = name;
		this.unit = unit;
		this.price = price;
		this.usingServices = usingServices;
	}

	@Override
	public String toString() {
		return "Service [id=" + id + ", name=" + name + ", unit=" + unit + ", price=" + price + "]";
	}

}

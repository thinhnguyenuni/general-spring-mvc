package fa.training.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.validation.constraints.PastOrPresent;

import org.springframework.format.annotation.DateTimeFormat;

@Embeddable
public class UsingServicePK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne(fetch = FetchType.LAZY)
	private Customer customer;

	@ManyToOne(fetch = FetchType.LAZY)
	private Service service;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "NgaySuDung")
	@PastOrPresent(message = "Ngày không được lớn hơn ngày hiện tại")
	private LocalDate date;

	@DateTimeFormat(pattern = "HH:mm")
	@Column(name = "GioSuDung")
	private LocalTime time;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public UsingServicePK() {
	}

	public UsingServicePK(LocalDate date, LocalTime time) {
		super();
		this.date = date;
		this.time = time;
	}

	public UsingServicePK(Customer customer, Service service, LocalDate date, LocalTime time) {
		this.customer = customer;
		this.service = service;
		this.date = date;
		this.time = time;
	}

	@Override
	public String toString() {
		return "UsingServicePK [customerID=" + (customer == null ? null : customer.getId()) + ", serviceID="
				+ (service == null ? null : service.getId()) + ", date=" + date + ", time=" + time + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(customer, date, service, time);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsingServicePK other = (UsingServicePK) obj;
		return Objects.equals(customer, other.customer) && Objects.equals(date, other.date)
				&& Objects.equals(service, other.service) && Objects.equals(time, other.time);
	}

}

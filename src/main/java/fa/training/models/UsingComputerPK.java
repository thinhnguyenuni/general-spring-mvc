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
public class UsingComputerPK implements Serializable {

	private static final long serialVersionUID = 1L;
	@ManyToOne(fetch = FetchType.LAZY)
	private Customer customer;

	@ManyToOne(fetch = FetchType.LAZY)
	private Computer computer;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "NgayBatDauSuDung")
	@PastOrPresent(message = "Ngày không được lớn hơn ngày hiện tại")
	private LocalDate date;

	@DateTimeFormat(pattern = "HH:mm")
	@Column(name = "GioBatDauSuDung")
	private LocalTime time;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Computer getComputer() {
		return computer;
	}

	public void setComputer(Computer computer) {
		this.computer = computer;
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

	public UsingComputerPK() {
	}

	public UsingComputerPK(Customer customer, Computer computer, LocalDate date, LocalTime time) {
		this.customer = customer;
		this.computer = computer;
		this.date = date;
		this.time = time;
	}

	public UsingComputerPK(LocalDate date, LocalTime time) {
		this.date = date;
		this.time = time;
	}

	@Override
	public String toString() {
		return "UsingComputerPK [customerID=" + (customer == null ? null : customer.getId()) + ", computerID="
				+ (computer == null ? null : computer.getId()) + ", date=" + date + ", time=" + time + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(computer, customer, date, time);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsingComputerPK other = (UsingComputerPK) obj;
		return Objects.equals(computer, other.computer) && Objects.equals(customer, other.customer)
				&& Objects.equals(date, other.date) && Objects.equals(time, other.time);
	}

}

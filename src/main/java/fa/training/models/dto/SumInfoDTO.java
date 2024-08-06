package fa.training.models.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class SumInfoDTO {
	 	private String customerId;
	    private String customerName;
	    private String computerID;
	    private String location;
	    private String status;
	    private LocalDate usingComputerDate;
	    private LocalTime usingComputerTime;
	    private Double duration;
	    private String serviceID;
	    private LocalDate usingServiceDate;
	    private LocalTime usingServiceTime;
	    private Integer quantity;
	    private Integer price;
	    private Integer totalCost;
		public String getCustomerId() {
			return customerId;
		}
		public void setCustomerId(String customerId) {
			this.customerId = customerId;
		}
		public String getCustomerName() {
			return customerName;
		}
		public void setCustomerName(String customerName) {
			this.customerName = customerName;
		}
		public String getComputerID() {
			return computerID;
		}
		public void setComputerID(String computerID) {
			this.computerID = computerID;
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
		public LocalDate getUsingComputerDate() {
			return usingComputerDate;
		}
		public void setUsingComputerDate(LocalDate usingComputerDate) {
			this.usingComputerDate = usingComputerDate;
		}
		public LocalTime getUsingComputerTime() {
			return usingComputerTime;
		}
		public void setUsingComputerTime(LocalTime usingComputerTime) {
			this.usingComputerTime = usingComputerTime;
		}
		public Double getDuration() {
			return duration;
		}
		public void setDuration(Double duration) {
			this.duration = duration;
		}
		public String getServiceID() {
			return serviceID;
		}
		public void setServiceID(String serviceID) {
			this.serviceID = serviceID;
		}
		public LocalDate getUsingServiceDate() {
			return usingServiceDate;
		}
		public void setUsingServiceDate(LocalDate usingServiceDate) {
			this.usingServiceDate = usingServiceDate;
		}
		public LocalTime getUsingServiceTime() {
			return usingServiceTime;
		}
		public void setUsingServiceTime(LocalTime usingServiceTime) {
			this.usingServiceTime = usingServiceTime;
		}
		public Integer getQuantity() {
			return quantity;
		}
		public void setQuantity(Integer quantity) {
			this.quantity = quantity;
		}
		public Integer getPrice() {
			return price;
		}
		public void setPrice(Integer price) {
			this.price = price;
		}
		public Integer getTotalCost() {
			return totalCost;
		}
		public void setTotalCost(Integer totalCost) {
			this.totalCost = totalCost;
		}
		
		public SumInfoDTO() {
		}
		
		public SumInfoDTO(String customerId, String customerName, String computerID, String location, String status,
				LocalDate usingComputerDate, LocalTime usingComputerTime, Double duration, String serviceID,
				LocalDate usingServiceDate, LocalTime usingServiceTime, Integer quantity, Integer price) {
			super();
			this.customerId = customerId;
			this.customerName = customerName;
			this.computerID = computerID;
			this.location = location;
			this.status = status;
			this.usingComputerDate = usingComputerDate;
			this.usingComputerTime = usingComputerTime;
			this.duration = duration;
			this.serviceID = serviceID;
			this.usingServiceDate = usingServiceDate;
			this.usingServiceTime = usingServiceTime;
			this.quantity = quantity;
			this.price = price;
		}
		@Override
		public String toString() {
			return "SumInfoDTO [customerId=" + customerId + ", customerName=" + customerName + ", computerID="
					+ computerID + ", location=" + location + ", status=" + status + ", usingComputerDate="
					+ usingComputerDate + ", usingComputerTime=" + usingComputerTime + ", duration=" + duration
					+ ", serviceID=" + serviceID + ", usingServiceDate=" + usingServiceDate + ", usingServiceTime="
					+ usingServiceTime + ", quantity=" + quantity + ", price=" + price + ", totalCost=" + totalCost
					+ "]";
		}
		
	    
}

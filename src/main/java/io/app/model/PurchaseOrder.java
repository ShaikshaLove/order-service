package io.app.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import io.app.enums.OrderStatus;
@Entity
public class PurchaseOrder {
	@Id
	@GenericGenerator(name="id-gen",strategy = "io.app.generator.OrderIdGenerator")
	@GeneratedValue(generator = "id-gen")
	private String orderId;
	
	private Integer customerId;
	
	private Double orderAmount;
	
	@Temporal(TemporalType.DATE)
	private Date placedDate;
	
	@Enumerated(EnumType.STRING)
	private OrderStatus orderStatus;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	List<OrderDetail> orderDetails=new ArrayList<>();
	
	
	
	public Double getOrderAmount() {
		return orderAmount;
	}
	public void setOrderAmount(Double orderAmount) {
		this.orderAmount = orderAmount;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public OrderStatus getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}
	
	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}
	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}
	public PurchaseOrder() {
		super();
	}

	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public Date getPlacedDate() {
		return placedDate;
	}
	public void setPlacedDate(Date placedDate) {
		this.placedDate = placedDate;
	}
	
}

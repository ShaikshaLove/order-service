package io.app.dto;

import java.util.List;

import io.app.model.OrderDetail;

public class OrderDTO {
	private Integer customerId;
	private Double totalCost;
	
	private List<OrderDetail> cartItems;

	public Double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;
	}
	
	
	public List<OrderDetail> getCartItems() {
		return cartItems;
	}
	public void setCartItems(List<OrderDetail> cartItems) {
		this.cartItems = cartItems;
	}
	public OrderDTO() {
		super();
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	@Override
	public String toString() {
		return "OrederDTO [customerId=" + customerId + ", totalCost=" + totalCost + ", cartItems=" + cartItems + "]";
	}
	 
	
}

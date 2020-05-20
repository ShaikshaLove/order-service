package io.app.dto;
public class OrderLineDTO {
	private Integer quantity;
	private Double cost;
    private String productId;
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Double getCost() {
		return cost;
	}
	public void setCost(Double cost) {
		this.cost = cost;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	@Override
	public String toString() {
		return "OrderLineDTO [quantity=" + quantity + ", cost=" + cost + ", productId=" + productId + "]";
	}
}

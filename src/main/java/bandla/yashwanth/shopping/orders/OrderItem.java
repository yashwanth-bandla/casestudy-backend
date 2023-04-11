package bandla.yashwanth.shopping.orders;

import java.io.Serializable;

import bandla.yashwanth.shopping.product.ProductInfo;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class OrderItem implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderItemId;
	@OneToOne
	private ProductInfo product;
	private int quantity;
	
	
	public int getOrderItemId() {
		return orderItemId;
	}
	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
	}
	public ProductInfo getProduct() {
		return product;
	}
	public void setProduct(ProductInfo product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "OrderItem [orderItemId=" + orderItemId + ", product=" + product + ", quantity=" + quantity + "]";
	}
	public OrderItem(ProductInfo product, int quantity) {
		super();
		this.product = product;
		this.quantity = quantity;
	}
	public OrderItem() {
		super();
		// TODO Auto-generated constructor stub
	}
}

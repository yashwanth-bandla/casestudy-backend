package bandla.yashwanth.shopping.orders;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Orders implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;

	@OneToMany
	@ElementCollection(targetClass=OrderItem.class)
	private List<OrderItem> orderedProducts;
	
	private String orderStatus;

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public List<OrderItem> getOrderedProducts() {
		return orderedProducts;
	}

	public void setOrderedProducts(List<OrderItem> orderedProducts) {
		this.orderedProducts = orderedProducts;
	}

	public Orders(int orderId, List<OrderItem> orderedProducts, String orderStatus) {
		super();
		this.orderId = orderId;
		this.orderedProducts = orderedProducts;
		this.orderStatus = orderStatus;
	}

	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", orderedProducts=" + orderedProducts + ", orderStatus=" + orderStatus
				+ "]";
	}

	public Orders() {
		super();
	}
}

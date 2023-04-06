package bandla.yashwanth.shopping;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Cart implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cartId;

	@OneToMany
	@ElementCollection(targetClass=CartItem.class)
	private List<CartItem> products;
	

	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public List<CartItem> getProducts() {
		return products;
	}
	public void setProducts(List<CartItem> products) {
		this.products = products;
	}
	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", products=" + products + "]";
	}
	public Cart(int cartId, List<CartItem> products) {
		super();
		this.cartId = cartId;
		this.products = products;
	}
	public Cart() {
		super();
	}
	

}

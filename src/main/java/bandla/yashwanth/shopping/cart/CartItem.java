package bandla.yashwanth.shopping.cart;

import java.io.Serializable;

import bandla.yashwanth.shopping.product.ProductInfo;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class CartItem implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cartItemId;
	@OneToOne
	private ProductInfo product;
	private int quantity;
	
	
	public int getCartItemId() {
		return cartItemId;
	}
	public void setCartItemId(int cartItemId) {
		this.cartItemId = cartItemId;
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
		return "CartItem [cartItemId=" + cartItemId + ", product=" + product + ", quantity=" + quantity + "]";
	}
	public CartItem(ProductInfo product, int quantity) {
		super();
		this.product = product;
		this.quantity = quantity;
	}
	public CartItem() {
		super();
		
	}
}

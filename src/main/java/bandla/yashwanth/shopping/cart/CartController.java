package bandla.yashwanth.shopping.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "*")
public class CartController {
	
	
	
	@Autowired
	private DoGetCart doGetCart;
	
	@Autowired
	private DoGetCartItem doGetCartItem;
	
	
	@Autowired
	private DoAddToCart doAddToCart;
	
	@Autowired
	private DoRemoveFromCart doRemoveFromCart;
	
	@Autowired
	private DoReduceQuantity doReduceQuantity;

	
	@GetMapping("/cart/{userId}/getCart")
	public ResponseEntity<Cart>  getCart(@PathVariable("userId") int userId) {
		Cart returnedCart = doGetCart.doGetCart(userId);
		return new ResponseEntity<>(returnedCart, HttpStatus.OK);
	}
	
	@GetMapping("/cart/{userId}/getCartItem/{cartitemId}")
	public ResponseEntity<CartItem> getCartItem(@PathVariable("userId") int userId, @PathVariable("cartitemId") int cartitemId) {
		CartItem returnedCartItem = doGetCartItem.getCartItem(userId, cartitemId);
		return new ResponseEntity<>(returnedCartItem, HttpStatus.OK);
	}
	@GetMapping("/cart/{userId}/add/{productId}")
	public ResponseEntity<CartItem> addToCart(@PathVariable("userId") int userId, @PathVariable("productId") int productId) {
		CartItem returnedCartItem = doAddToCart.addToCart(userId,productId);
		return new ResponseEntity<>(returnedCartItem, HttpStatus.OK);
	}
	
	@GetMapping("/cart/{userId}/remove/{productId}")
	public void removeFromCart(@PathVariable("userId") int userId, @PathVariable("productId") int productId) {
		doRemoveFromCart.removeFromCart(userId,productId);
	}
	
	@GetMapping("/cart/{userId}/reduceQuantity/{productId}")
	public ResponseEntity<CartItem> reduceQuantity(@PathVariable("userId") int userId, @PathVariable("productId") int productId) {
		CartItem returnedCartItem = doReduceQuantity.reduceQuantity(userId, productId);
		return new ResponseEntity<>(returnedCartItem, HttpStatus.OK);
	}
}

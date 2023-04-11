package bandla.yashwanth.shopping.cart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import bandla.yashwanth.shopping.product.ProductInfoRepository;
import bandla.yashwanth.shopping.user.UserInfo;
import bandla.yashwanth.shopping.user.UserInfoRepository;

@Service
public class DoRemoveFromCart {

	@Autowired
	private UserInfoRepository userInfoRepository;

	@Autowired
	private CartItemRepository cartItemRepository;

	public void removeFromCart(int userId, int productId) {

		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		userId = userInfoRepository.getUserByUserName(email).getUserId();

//		TODO: ProductInfo productToRemove = productInfoRepository.findById(productId).get(); //getting the product to be removed
		UserInfo userInfo = userInfoRepository.findById(userId).get(); // getting the user
		List<CartItem> cartItemsList = userInfo.getCart().getProducts(); // getting the list of cart items

		String productName = "";

		for (CartItem item : cartItemsList) {
			if (item.getProduct().getId() == productId) {// checking for matching product in the list
				productName = item.getProduct().getName(); // saving the product name in a variable
				cartItemsList.remove(item);// removing the product from the cartitem list
				cartItemRepository.delete(item); // removing the cart item from cartitemrepository
				userInfo.getCart().setProducts(cartItemsList); // setting the products in the user
				userInfoRepository.save(userInfo);// saving the updated user
				break;
			}
		}

	}
}

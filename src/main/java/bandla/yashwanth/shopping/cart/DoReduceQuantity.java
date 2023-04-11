package bandla.yashwanth.shopping.cart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import bandla.yashwanth.shopping.user.UserInfo;
import bandla.yashwanth.shopping.user.UserInfoRepository;

@Service
public class DoReduceQuantity {

	@Autowired
	private UserInfoRepository userInfoRepository;

	@Autowired
	private CartItemRepository cartItemRepository;

	public CartItem reduceQuantity(int userId, int productId) {

		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		userId = userInfoRepository.getUserByUserName(email).getUserId();

		UserInfo userInfo = userInfoRepository.findById(userId).get(); // getting the user
		List<CartItem> cartItemsList = userInfo.getCart().getProducts(); // getting the list of cart items

		CartItem changedItem = new CartItem();

		for (CartItem item : cartItemsList) {
			if (item.getProduct().getId() == productId) {// checking for matching product in the list
				item.setQuantity(item.getQuantity() - 1); // reducing the quantity of products
				changedItem = item;
				if (item.getQuantity() == 0) { // removing the product if quantity is zero
					cartItemsList.remove(item);
					cartItemRepository.delete(item);
				}
//				cartItemRepository.delete(item);// removing the cart item from cartitemrepository
				userInfo.getCart().setProducts(cartItemsList); // setting the new cartitems list to user

				userInfoRepository.save(userInfo);
				break;
			}
		}
		return changedItem;
	}
}

package bandla.yashwanth.shopping.cart;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import bandla.yashwanth.shopping.user.UserInfoRepository;

@Service
public class DoGetCartItem {
	
	@Autowired
	private UserInfoRepository userInfoRepository;
	
	@Autowired
	private CartItemRepository cartItemRepository;
	
	
	public CartItem getCartItem(int userId, int cartitemId) {
		String email = SecurityContextHolder.getContext().getAuthentication()
                .getName();
		userId = userInfoRepository.getUserByUserName(email).getUserId();
		return cartItemRepository.findById(cartitemId).get();

	}
}

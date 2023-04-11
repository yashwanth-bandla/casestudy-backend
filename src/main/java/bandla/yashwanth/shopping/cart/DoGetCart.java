package bandla.yashwanth.shopping.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import bandla.yashwanth.shopping.user.UserInfoRepository;
@Service
public class DoGetCart {
	
	@Autowired
	private UserInfoRepository userInfoRepository;
	
	public Cart doGetCart(int userId) {
		String email = SecurityContextHolder.getContext().getAuthentication()
                .getName();
		userId = userInfoRepository.getUserByUserName(email).getUserId();
//		System.out.println(userId);
		Cart returnedCart = userInfoRepository.findById(userId).get().getCart();
		if(returnedCart==null) {
			return new Cart();
		} else {
			return returnedCart;
		}
	}
}

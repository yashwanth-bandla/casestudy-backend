package bandla.yashwanth.shopping.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import bandla.yashwanth.shopping.Cart;
import bandla.yashwanth.shopping.UserInfo;
import bandla.yashwanth.shopping.dao.UserInfoRepository;
@Service
public class DoGetCart {
	
	
	public static Cart doGetCart(int userId, UserInfoRepository userInfoRepository) {
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

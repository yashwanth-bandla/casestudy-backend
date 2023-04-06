package bandla.yashwanth.shopping.controllers;


import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import bandla.yashwanth.shopping.CartItem;
import bandla.yashwanth.shopping.dao.CartItemRepository;
import bandla.yashwanth.shopping.dao.UserInfoRepository;

@Service
public class DoGetCartItem {
	
	
	public static CartItem doGetCartItem(int userId, int cartitemId, UserInfoRepository userInfoRepository, CartItemRepository cartItemRepository) {
		String email = SecurityContextHolder.getContext().getAuthentication()
                .getName();
		userId = userInfoRepository.getUserByUserName(email).getUserId();
		return cartItemRepository.findById(cartitemId).get();
//		try {
//			return userInfoRepository.findById(userId).get().getCart().getProducts().get(cartitemId-1);
//		} catch (Exception e) {
//			return new CartItem();
//		}
	}
}

package bandla.yashwanth.shopping.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import bandla.yashwanth.shopping.CartItem;
import bandla.yashwanth.shopping.dao.CartItemRepository;
import bandla.yashwanth.shopping.dao.UserInfoRepository;

public class DoGetCartItem {
	
	
	public static CartItem doGetCartItem(int userId, int cartitemId, UserInfoRepository userInfoRepository, CartItemRepository cartItemRepository) {

		return cartItemRepository.findById(cartitemId).get();
//		try {
//			return userInfoRepository.findById(userId).get().getCart().getProducts().get(cartitemId-1);
//		} catch (Exception e) {
//			return new CartItem();
//		}
	}
}

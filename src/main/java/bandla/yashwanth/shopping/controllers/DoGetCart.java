package bandla.yashwanth.shopping.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import bandla.yashwanth.shopping.Cart;
import bandla.yashwanth.shopping.dao.CartRepository;
import bandla.yashwanth.shopping.dao.UserInfoRepository;

public class DoGetCart {
	
	
	public static Cart doGetCart(int userId, UserInfoRepository userInfoRepository) {
		Cart returnedCart = userInfoRepository.findById(userId).get().getCart();
		if(returnedCart==null) {
			return new Cart();
		} else {
			return returnedCart;
		}
	}
}

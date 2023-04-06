package bandla.yashwanth.shopping.controllers;

import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import bandla.yashwanth.shopping.CartItem;
import bandla.yashwanth.shopping.UserInfo;
import bandla.yashwanth.shopping.dao.CartItemRepository;
import bandla.yashwanth.shopping.dao.CartRepository;
import bandla.yashwanth.shopping.dao.ProductInfoRepository;
import bandla.yashwanth.shopping.dao.UserInfoRepository;
@Service
public class DoRemoveFromCart {
	public static void doRemoveFromCart(
			int userId,
			int productId, 
			UserInfoRepository userInfoRepository, 
			ProductInfoRepository productInfoRepository,
			CartItemRepository cartItemRepository,
			CartRepository cartRepository
			) {
		
		String email = SecurityContextHolder.getContext().getAuthentication()
                .getName();
		userId = userInfoRepository.getUserByUserName(email).getUserId();
		
//		TODO: ProductInfo productToRemove = productInfoRepository.findById(productId).get(); //getting the product to be removed
		UserInfo userInfo = userInfoRepository.findById(userId).get(); //getting the user
		List<CartItem> cartItemsList = userInfo.getCart().getProducts(); //getting the list of cart items
		
		String productName = "";
		
		for(CartItem item: cartItemsList) {
			if(item.getProduct().getId() == productId) {//checking for matching product in the list
				productName = item.getProduct().getName(); //saving the product name in a variable
				cartItemsList.remove(item);//removing the product from the cartitem list
				userInfo.getCart().setProducts(cartItemsList); //setting the products in the user
				userInfoRepository.save(userInfo);//saving the updated user
				break;
			}
		}
		
	}
}

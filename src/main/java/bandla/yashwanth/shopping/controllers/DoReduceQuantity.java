package bandla.yashwanth.shopping.controllers;

import java.util.List;

import bandla.yashwanth.shopping.CartItem;
import bandla.yashwanth.shopping.UserInfo;
import bandla.yashwanth.shopping.dao.UserInfoRepository;

public class DoReduceQuantity {
	public static CartItem doReduceQuantity(int userId, 
											int productId, 
											UserInfoRepository userInfoRepository) 
	{
		UserInfo userInfo = userInfoRepository.findById(userId).get(); //getting the user
		List<CartItem> cartItemsList = userInfo.getCart().getProducts(); //getting the list of cart items
		
		CartItem changedItem = new CartItem();
		
		for(CartItem item: cartItemsList) {
			if(item.getProduct().getId() == productId) {//checking for matching product in the list
				item.setQuantity(item.getQuantity() - 1); //reducing the quantity of products
				changedItem = item;
				if(item.getQuantity() == 0) { //removing the product if quantity is zero
					cartItemsList.remove(item);
				}
				userInfo.getCart().setProducts(cartItemsList); //setting the new cartitems list to user
				
				userInfoRepository.save(userInfo);
				break;
			}
		}
		return changedItem;
	}
}

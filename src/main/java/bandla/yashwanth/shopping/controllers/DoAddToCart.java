package bandla.yashwanth.shopping.controllers;

import java.util.ArrayList;
import java.util.List;

import bandla.yashwanth.shopping.Cart;
import bandla.yashwanth.shopping.CartItem;
import bandla.yashwanth.shopping.ProductInfo;
import bandla.yashwanth.shopping.UserInfo;
import bandla.yashwanth.shopping.dao.CartItemRepository;
import bandla.yashwanth.shopping.dao.CartRepository;
import bandla.yashwanth.shopping.dao.ProductInfoRepository;
import bandla.yashwanth.shopping.dao.UserInfoRepository;

public class DoAddToCart {
	public static CartItem doAddToCart(
									int userId,
									int productId, 
									UserInfoRepository userInfoRepository, 
									ProductInfoRepository productInfoRepository,
									CartItemRepository cartItemRepository,
									CartRepository cartRepository
									) 
	{
		ProductInfo productToAdd = productInfoRepository.findById(productId).get();  //to be added product
//		CartItem cartItemToAdd = new CartItem(); 
//		cartItemToAdd.setProduct(productToAdd);
//		cartItemToAdd.setQuantity(1);
//		CartItem addedCartItem = cartItemRepository.save(cartItemToAdd);  //creating a cartitem object to store the product
//		
//		Cart newCart = new Cart();
//		List<CartItem> cartItemList = new ArrayList<>();  //creating a new cart to store the list of cartItems
		

		UserInfo userInfo = userInfoRepository.findById(userId).get(); //getting the user info
		Cart cart = userInfo.getCart();  // current cart of the user
		if (cart==null) { //if the current cart of the user is empty, create a new cart 
			
			CartItem cartItemToAdd = new CartItem(); 
			cartItemToAdd.setProduct(productToAdd);
			cartItemToAdd.setQuantity(1);
			CartItem addedCartItem = cartItemRepository.save(cartItemToAdd);  //creating a cartitem object to store the product
			
			Cart newCart = new Cart(); //creating a new cart to store the list of cartItems
			List<CartItem> cartItemList = new ArrayList<>();  //creating a new list of cartitems
			
			cartItemList.add(addedCartItem);  // adding the cart item to a new list of cartItems
			newCart.setProducts(cartItemList); 
			Cart returnedCart = cartRepository.save(newCart); //creating and saving a new cart with the added cart item
			userInfo.setCart(returnedCart); //setting the cart property of user to the new cart
			
			UserInfo finalUserInfo =  userInfoRepository.save(userInfo); //saving the user with updated cart
			System.out.println(finalUserInfo);
			
			
			return addedCartItem; //returning the added cart item
		}
		
		
		List<CartItem> userCartItems = cart.getProducts(); //if user has an existing cart, get the list of cart items
		
		
		
		boolean increasedQuantity = false; //a flag to check if item is present in cart
		for(CartItem item : userCartItems) {
			if (productToAdd.equals(item.getProduct())){ //if cartitem is already present in cart
				item.setQuantity(item.getQuantity() + 1);  //increasing the quantity of cartitem
				CartItem returnedCartItem = cartItemRepository.save(item); //saving the cartitem
				cart = cartRepository.save(cart); //saving the updated cart
				
				UserInfo finalUserInfo =  userInfoRepository.save(userInfo);  //saving the updated user
				increasedQuantity = true;
				System.out.println(finalUserInfo);
				
				return returnedCartItem;  //returning the updated cart item
			}
		}
		if(increasedQuantity == false) { //if the added item is not already present in cart
			
			CartItem cartItemToAdd = new CartItem(); 
			cartItemToAdd.setProduct(productToAdd);
			cartItemToAdd.setQuantity(1);
			CartItem addedCartItem = cartItemRepository.save(cartItemToAdd);  //creating and saving a cartitem object to store the product
			
			userCartItems.add(addedCartItem); //adding the cartitem to list of cartitems in cart
			cart.setProducts(userCartItems); //setting the changed cartitems list for user
			cartRepository.save(cart); //saving the updated cart
			UserInfo finalUserInfo =  userInfoRepository.save(userInfo); //saving the updated user
			System.out.println(finalUserInfo);
			
			return addedCartItem;
		}
		return null;
		
	}
}

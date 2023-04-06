package bandla.yashwanth.shopping.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import bandla.yashwanth.shopping.CartItem;
import bandla.yashwanth.shopping.OrderItem;
import bandla.yashwanth.shopping.Orders;
import bandla.yashwanth.shopping.UserInfo;
import bandla.yashwanth.shopping.dao.CartItemRepository;
import bandla.yashwanth.shopping.dao.CartRepository;
import bandla.yashwanth.shopping.dao.OrderItemRepository;
import bandla.yashwanth.shopping.dao.OrdersRepository;
import bandla.yashwanth.shopping.dao.UserInfoRepository;

@Service
public class DoCreateOrder {
	public static Orders doCreateOrder(int userId,UserInfoRepository userInfoRepository,CartRepository cartRepository,OrdersRepository ordersRepository, OrderItemRepository orderItemRepository) {
		
		String email = SecurityContextHolder.getContext().getAuthentication()
                .getName();
		userId = userInfoRepository.getUserByUserName(email).getUserId();
//		System.out.println(userId);
		
		UserInfo userInfo = userInfoRepository.findById(userId).get();
		
		if(userInfo.getOrders()==null) {
			List<OrderItem> newOrderItemList = new ArrayList<OrderItem>();
			Orders newOrder = new Orders();
			
//			OrderItem item = new OrderItem();
			for(CartItem i : userInfo.getCart().getProducts()) {
				OrderItem item = new OrderItem();
				item.setProduct(i.getProduct());
				item.setQuantity(i.getQuantity());
				
				OrderItem savedItem =  orderItemRepository.save(item);
				newOrderItemList.add(savedItem);
				
				
			}
			newOrder.setOrderedProducts(newOrderItemList);
			newOrder.setOrderStatus("pending");
			ordersRepository.save(newOrder);
			userInfo.setCart(null);
			userInfo.setOrders(newOrder);
			userInfoRepository.save(userInfo);
			
			
			
//			Orders newOrder = new Orders();
//			newOrder.setOrderedProducts((userInfo.getCart().getProducts()));
//			newOrder.setOrderStatus("pending");
//			ordersRepository.save(newOrder);
//			userInfo.setCart(null);
//			userInfo.setOrders(newOrder);
//			userInfoRepository.save(userInfo);
		} else {
			
			List<OrderItem> newOrderItemList = userInfo.getOrders().getOrderedProducts();
		
			for(CartItem i : userInfo.getCart().getProducts()) {
				OrderItem item = new OrderItem();
				item.setProduct(i.getProduct());
				item.setQuantity(i.getQuantity());
				
				OrderItem savedItem =  orderItemRepository.save(item);
				newOrderItemList.add(savedItem);
				
				
			}
			
			userInfo.getOrders().setOrderedProducts(newOrderItemList);
			userInfo.getOrders().setOrderStatus("Shipped");
			userInfo.setCart(null);
			userInfoRepository.save(userInfo);
			
			
			
			
			
			
			
//			Orders totalOrders =userInfo.getOrders().getOrderedProducts().addAll(userInfo.getCart().getProducts());
			
//			Orders newOrder = new Orders();
//			newOrder.setOrderId((userInfo.getCart().getCartId()));
//			newOrder.setOrderedProducts((userInfo.getCart().getProducts()));
//			newOrder.setOrderStatus("pending");
//			ordersRepository.save(newOrder);
//			userInfo.setCart(null);
//			userInfoRepository.save(userInfo);
			
			
			
			
			
			
			
		}
		
//		userInfo.getOrders().setOrderId(userInfo.getCart().getCartId());
//		userInfo.getOrders().setOrderedProducts(userInfo.getCart().getProducts());
//		userInfo.getOrders().setOrderStatus("pending");
		

		
		
		// by creating order item 
//		OrderItem item = new OrderItem();
//		for(CartItem i : userInfo.getCart().getProducts()) {
//			
//			item.setProduct(i.getProduct());
//			item.setQuantity(i.getQuantity());
			
//		}
		
		
		return null;
	}
}

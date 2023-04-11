package bandla.yashwanth.shopping.orders;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import bandla.yashwanth.shopping.cart.Cart;
import bandla.yashwanth.shopping.cart.CartItem;
import bandla.yashwanth.shopping.cart.CartRepository;
import bandla.yashwanth.shopping.user.UserInfo;
import bandla.yashwanth.shopping.user.UserInfoRepository;

@Service
public class DoCreateOrder {

	@Autowired
	private UserInfoRepository userInfoRepository;

	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private OrdersRepository ordersRepository;

	@Autowired
	private OrderItemRepository orderItemRepository;

	public Orders createOrder(int userId) {

		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		userId = userInfoRepository.getUserByUserName(email).getUserId();

		UserInfo userInfo = userInfoRepository.findById(userId).get();

		// common code for if-else
		List<OrderItem> newOrderItemList = new ArrayList<OrderItem>();
		Orders newOrder = new Orders();
		for (CartItem i : userInfo.getCart().getProducts()) {
			OrderItem item = new OrderItem();
			item.setProduct(i.getProduct());
			item.setQuantity(i.getQuantity());

			OrderItem savedItem = orderItemRepository.save(item);
			newOrderItemList.add(savedItem);

		}

		newOrder.setOrderedProducts(newOrderItemList);
		newOrder.setOrderStatus("pending..");
		Orders savedNewOrder = ordersRepository.save(newOrder);

	//	if (userInfo.getOrders() == null) {
//			List<OrderItem> newOrderItemList = new ArrayList<OrderItem>();
//			Orders newOrder = new Orders();
//			
//			for(CartItem i : userInfo.getCart().getProducts()) {
//				OrderItem item = new OrderItem();
//				item.setProduct(i.getProduct());
//				item.setQuantity(i.getQuantity());
//				
//				OrderItem savedItem =  orderItemRepository.save(item);
//				newOrderItemList.add(savedItem);
//				
//				
//			}
//			newOrder.setOrderedProducts(newOrderItemList);
//			newOrder.setOrderStatus("Pending");
//			ordersRepository.save(newOrder);
//			userInfo.setCart(null);
//			userInfo.setOrders(newOrder);
//			userInfoRepository.save(userInfo);

			// important code: for if orders is null for new users

//			System.out.println("printing this if orders is null for new user");
//			
//			List<Orders> newListOfOrders = new ArrayList<Orders>();
//			newListOfOrders.add(savedNewOrder);
//			userInfo.setOrders(newListOfOrders);
//			userInfo.setCart(new Cart());
//			userInfoRepository.save(userInfo);

	//	} else {

//			List<OrderItem> newOrderItemList = userInfo.getOrders().getOrderedProducts();
//		
//			for(CartItem i : userInfo.getCart().getProducts()) {
//				OrderItem item = new OrderItem();
//				item.setProduct(i.getProduct());
//				item.setQuantity(i.getQuantity());
//				
//				OrderItem savedItem =  orderItemRepository.save(item);
//				newOrderItemList.add(savedItem);
//				
//				
//			}
//			
//			userInfo.getOrders().setOrderedProducts(newOrderItemList);
//			userInfo.getOrders().setOrderStatus("Pending");
//			userInfo.setCart(null);
//			userInfoRepository.save(userInfo);

			List<Orders> originaListOfOrders = userInfo.getOrders();
			originaListOfOrders.add(savedNewOrder);
			userInfo.setOrders(originaListOfOrders);
			Cart emptyCart = new Cart();
			cartRepository.save(emptyCart);
			userInfo.setCart(emptyCart);
			userInfoRepository.save(userInfo);
	//	}

		return null;
	}
}

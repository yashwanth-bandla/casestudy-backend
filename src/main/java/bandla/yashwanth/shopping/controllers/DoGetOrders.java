package bandla.yashwanth.shopping.controllers;

import org.springframework.security.core.context.SecurityContextHolder;

import bandla.yashwanth.shopping.Orders;
import bandla.yashwanth.shopping.UserInfo;
import bandla.yashwanth.shopping.dao.CartRepository;
import bandla.yashwanth.shopping.dao.OrderItemRepository;
import bandla.yashwanth.shopping.dao.OrdersRepository;
import bandla.yashwanth.shopping.dao.UserInfoRepository;

public class DoGetOrders {
	public static Orders doGetOrders(int userId, UserInfoRepository userInfoRepository, CartRepository cartRepository,
			OrdersRepository ordersRepository, OrderItemRepository orderItemRepository) {
		
		String email = SecurityContextHolder.getContext().getAuthentication()
                .getName();
		userId = userInfoRepository.getUserByUserName(email).getUserId();
		
		UserInfo userInfo = userInfoRepository.findById(userId).get();
		return userInfo.getOrders();
	}
}

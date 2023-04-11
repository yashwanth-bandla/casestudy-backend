package bandla.yashwanth.shopping.orders;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import bandla.yashwanth.shopping.cart.CartRepository;
import bandla.yashwanth.shopping.user.UserInfo;
import bandla.yashwanth.shopping.user.UserInfoRepository;

@Service
public class DoGetOrders {
	
	@Autowired
	private UserInfoRepository userInfoRepository;

	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private OrdersRepository ordersRepository;

	@Autowired
	private OrderItemRepository orderItemRepository;
	
	public List<Orders> getOrders(int userId) {

		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		userId = userInfoRepository.getUserByUserName(email).getUserId();

		UserInfo userInfo = userInfoRepository.findById(userId).get();
		return userInfo.getOrders();
	}
}

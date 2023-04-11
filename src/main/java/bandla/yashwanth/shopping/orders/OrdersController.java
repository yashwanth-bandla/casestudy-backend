package bandla.yashwanth.shopping.orders;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class OrdersController {
	
	@Autowired
	private DoCreateOrder doCreateOrder;
	@Autowired
	private DoGetOrders doGetOrders;
	
	@GetMapping("/order/{userId}/createOrder")
	public Orders createOrder(@PathVariable("userId") int userId) {
		return doCreateOrder.createOrder(userId);
	}
	
	@GetMapping("/order/{userId}/getOrders")
	public List<Orders> getOrders(@PathVariable("userId") int userId) {
		return doGetOrders.getOrders(userId);
	}
}

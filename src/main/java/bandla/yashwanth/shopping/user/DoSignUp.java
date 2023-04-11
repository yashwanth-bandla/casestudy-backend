package bandla.yashwanth.shopping.user;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import bandla.yashwanth.shopping.cart.Cart;
import bandla.yashwanth.shopping.cart.CartRepository;
import bandla.yashwanth.shopping.orders.Orders;
import bandla.yashwanth.shopping.orders.OrdersRepository;

@Service
public class DoSignUp {

	@Autowired
	private UserInfoRepository userInfoRepository;

	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public void signUp(UserInfo user) {

		if (user.getEmail() == null || user.getEmail().equals("") || user.getName() == null || user.getName().equals("")
				|| user.getPassword() == null || user.getPassword().equals("") || user.getPhone() < 0) {
			return;
		}

		UserInfo givenUser = new UserInfo();
		givenUser.setName(user.getName());
		givenUser.setEmail(user.getEmail());
	//	givenUser.setPassword(user.getPassword());// use password encoder here passwordEncoder.encode(user.getPassword())
		givenUser.setPassword(passwordEncoder.encode(user.getPassword()));
		givenUser.setPhone(user.getPhone());
		givenUser.setRole("normal");

		Address givenAddress = new Address();
		givenAddress.setCity(user.getAddress().getCity());
		givenAddress.setState(user.getAddress().getState());
		givenAddress.setStreet(user.getAddress().getStreet());
		givenAddress.setPincode(user.getAddress().getPincode());

		Address savedAddress = addressRepository.save(givenAddress);

		givenUser.setAddress(savedAddress);

		List<Orders> emptyOrders = new ArrayList<Orders>();
//		ordersRepository.save(emptyOrders);

		Cart emptyCart = new Cart();
		cartRepository.save(emptyCart);

		givenUser.setOrders(emptyOrders);
		givenUser.setCart(emptyCart);

		UserInfo savedUser = userInfoRepository.save(givenUser);

		return;

	}
}

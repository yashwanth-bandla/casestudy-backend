package bandla.yashwanth.shopping.controllers;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import bandla.yashwanth.shopping.Address;
import bandla.yashwanth.shopping.UserInfo;
import bandla.yashwanth.shopping.dao.AddressRepository;
import bandla.yashwanth.shopping.dao.UserInfoRepository;

@Service
public class DoSignUp {
	public static void doSignUp(UserInfo user, UserInfoRepository userInfoRepository,
			AddressRepository addressRepository, PasswordEncoder passwordEncoder) {

		if (user.getEmail()==null || user.getEmail().equals("") || user.getName() == null
				|| user.getName().equals("") || user.getPassword() == null || user.getPassword().equals("") || user.getPhone()<0) {
			return;
		}

		UserInfo givenUser = new UserInfo();
		givenUser.setName(user.getName());
		givenUser.setEmail(user.getEmail());
		givenUser.setPassword(user.getPassword());// use password encoder here
		givenUser.setPhone(user.getPhone());
		givenUser.setRole("normal");

		Address givenAddress = new Address();
		givenAddress.setCity(user.getAddress().getCity());
		givenAddress.setState(user.getAddress().getState());
		givenAddress.setStreet(user.getAddress().getStreet());
		givenAddress.setPincode(user.getAddress().getPincode());

		Address savedAddress = addressRepository.save(givenAddress);

		givenUser.setAddress(savedAddress);

		UserInfo savedUser = userInfoRepository.save(givenUser);

		return;

	}
}

package bandla.yashwanth.shopping.controllers;


import org.springframework.security.crypto.password.PasswordEncoder;

import bandla.yashwanth.shopping.Address;
import bandla.yashwanth.shopping.UserInfo;
import bandla.yashwanth.shopping.dao.AddressRepository;
import bandla.yashwanth.shopping.dao.UserInfoRepository;

public class DoSignUp {
	public static void doSignUp(UserInfo user,UserInfoRepository userInfoRepository, AddressRepository addressRepository, PasswordEncoder passwordEncoder ) {
		
		UserInfo givenUser = new UserInfo();
		givenUser.setName(user.getName());
		givenUser.setEmail(user.getEmail());
		givenUser.setPassword(user.getPassword());//use password encoder here
		givenUser.setPhone(user.getPhone());
		givenUser.setRole("normal");
		
		Address givenAddress = new Address();
		givenAddress.setCity(user.getAddress().getCity());
		givenAddress.setState(user.getAddress().getState());
		givenAddress.setStreet(user.getAddress().getStreet());
		givenAddress.setPincode(user.getAddress().getPincode());
		
		Address savedAddress= addressRepository.save(givenAddress);
		
		givenUser.setAddress(savedAddress);
		
		UserInfo savedUser = userInfoRepository.save(givenUser);
		
		return ;

		
	}
}

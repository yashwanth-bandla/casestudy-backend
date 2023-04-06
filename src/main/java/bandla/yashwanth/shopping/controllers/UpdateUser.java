package bandla.yashwanth.shopping.controllers;

import org.springframework.stereotype.Service;

import bandla.yashwanth.shopping.UserInfo;
import bandla.yashwanth.shopping.dao.UserInfoRepository;
@Service
public class UpdateUser {
	public static void updateUser(UserInfo user, UserInfoRepository userInfoRepository) {
	
		UserInfo returnedUser = userInfoRepository.findById(user.getUserId()).get();
		if(user.getEmail()!=null) {
			returnedUser.setEmail(user.getEmail());
		}
		if(user.getName()!=null) {
			returnedUser.setName(user.getName());
		}
		if(user.getPassword()!=null) {
			returnedUser.setPassword(user.getPassword());
		}
		if(user.getPhone() != 0) {
			returnedUser.setPhone(user.getPhone());
		}
		if(user.getAddress()!=null) {
			returnedUser.setAddress(user.getAddress());
		}
//		if(user.getCart()!=null) {
//			returnedUser.setCart(user.getCart());
//		}
		
		
		
		userInfoRepository.save(returnedUser);
	}
}

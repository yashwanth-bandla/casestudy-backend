package bandla.yashwanth.shopping.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import bandla.yashwanth.shopping.UserInfo;
import bandla.yashwanth.shopping.dao.CategoryRepository;
import bandla.yashwanth.shopping.dao.UserInfoRepository;



public class CheckLogin {
	
	@Autowired
	CategoryRepository categoryRepository;
	
	public static UserInfo checkLogin(UserInfo user, UserInfoRepository userInfoRepository) {

		// login verification does not occur here
		//it occurs in generateToken() method in JwtController class
		return new UserInfo();
	}
}

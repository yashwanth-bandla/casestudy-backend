package bandla.yashwanth.shopping.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import bandla.yashwanth.shopping.UserInfo;
import bandla.yashwanth.shopping.dao.UserInfoRepository;

public class GetUser {
	public static UserInfo getUser(int userId, UserInfoRepository userInfoRepository) {

			return userInfoRepository.findById(userId).get();
		
	}
}

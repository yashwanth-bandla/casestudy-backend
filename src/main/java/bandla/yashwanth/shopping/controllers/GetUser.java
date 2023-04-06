package bandla.yashwanth.shopping.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import bandla.yashwanth.shopping.UserInfo;
import bandla.yashwanth.shopping.dao.UserInfoRepository;
@Service
public class GetUser {
	public static UserInfo getUser(int userId, UserInfoRepository userInfoRepository) {
		
		String email = SecurityContextHolder.getContext().getAuthentication()
                .getName();
		userId = userInfoRepository.getUserByUserName(email).getUserId();

			return userInfoRepository.findById(userId).get();
		
	}
}

package bandla.yashwanth.shopping.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
@Service
public class GetUser {
	
	@Autowired
	UserInfoRepository userInfoRepository;
	
	public UserInfo getProfile(int userId) {
		
		String email = SecurityContextHolder.getContext().getAuthentication()
                .getName();
		userId = userInfoRepository.getUserByUserName(email).getUserId();

			return userInfoRepository.findById(userId).get();
		
	}
}

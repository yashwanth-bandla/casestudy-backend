package bandla.yashwanth.shopping.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UpdateUser {
	
	@Autowired
	UserInfoRepository userInfoRepository;
	
	public void updateProfile(UserInfo user) {
	
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
		
		
		
		userInfoRepository.save(returnedUser);
	}
}

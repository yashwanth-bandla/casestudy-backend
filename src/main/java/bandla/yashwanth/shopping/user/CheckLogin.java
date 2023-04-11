package bandla.yashwanth.shopping.user;

import org.springframework.stereotype.Service;


@Service
public class CheckLogin {
	
	public UserInfo checkLogin(UserInfo user) {

		// login verification does not occur here
		//it occurs in generateToken() method in JwtController class
		return new UserInfo();
	}
}

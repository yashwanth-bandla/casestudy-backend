package bandla.yashwanth.shopping.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bandla.yashwanth.shopping.product.CategoryRepository;


@Service
public class CheckLogin {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private UserInfoRepository userInfoRepository;
	
	public UserInfo checkLogin(UserInfo user) {

		// login verification does not occur here
		//it occurs in generateToken() method in JwtController class
		return new UserInfo();
	}
}

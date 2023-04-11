package bandla.yashwanth.shopping.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import bandla.yashwanth.shopping.user.UserInfo;
import bandla.yashwanth.shopping.user.UserInfoRepository;

@Component
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserInfoRepository userInfoRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserInfo user = userInfoRepository.getUserByUserName(username);
		
		if(user==null) {
			throw new UsernameNotFoundException("Could not find User with given email!");
		}
		
		CustomUserDetails customUserDetails = new CustomUserDetails(user);
		
		return customUserDetails;
	}

}

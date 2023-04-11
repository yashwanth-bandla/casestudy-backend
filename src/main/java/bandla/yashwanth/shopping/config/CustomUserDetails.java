package bandla.yashwanth.shopping.config;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import bandla.yashwanth.shopping.user.UserInfo;

public class CustomUserDetails implements UserDetails{
	
	private UserInfo userInfo;

	public CustomUserDetails(UserInfo userInfo) {
		super();
		this.userInfo = userInfo;
	}


	@Override
	public String getPassword() {
		return userInfo.getPassword();
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority("ROLE_" +userInfo.getRole());
		
		return List.of(simpleGrantedAuthority);
	}

	@Override
	public String getUsername() {
		return userInfo.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return  true;
	}

}

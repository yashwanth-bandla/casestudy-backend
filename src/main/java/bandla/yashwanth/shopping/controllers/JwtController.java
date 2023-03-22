package bandla.yashwanth.shopping.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bandla.yashwanth.shopping.config.CustomUserDetailsService;
import bandla.yashwanth.shopping.dao.UserInfoRepository;
import bandla.yashwanth.shopping.helper.JwtRequest;
import bandla.yashwanth.shopping.helper.JwtResponse;
import bandla.yashwanth.shopping.helper.JwtUtil;

@CrossOrigin(origins = "*")
@RestController
public class JwtController {

//    @Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) 
//             throws Exception {
//        return authenticationConfiguration.getAuthenticationManager();
//    }
	@Autowired
	private UserInfoRepository userInfoRepository;

	
	@Autowired 
	private AuthenticationManager authenticationManager;
	
	
	  
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@PostMapping("/token") //was "/"
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception{
		System.out.println(jwtRequest);
		
		try {
			System.out.println("in jwt controller try block start");
			this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));
			System.out.println("in jwt controller try block");
		} catch (UsernameNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("bad credentials");
			throw new Exception("bad credentials");
		} catch (Exception e) {
			System.out.println("bad credentials");
			throw new Exception("bad credentials");
		}
		
		UserDetails userDetails = this.customUserDetailsService.loadUserByUsername(jwtRequest.getUsername());
		
		String token = this.jwtUtil.generateToken(userDetails);
		System.out.println("JWT "+token);
		System.out.println("token generation successful");
		
		int userId= userInfoRepository.getUserByUserName(jwtRequest.getUsername()).getUserId();
		
		JwtResponse tosendJwtResponse = new JwtResponse();
		tosendJwtResponse.setId(userId);
		tosendJwtResponse.setToken(token);
		
		return ResponseEntity.ok(tosendJwtResponse);
		
	}
}

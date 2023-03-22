package bandla.yashwanth.shopping.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfiguration {
	
	@Autowired
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
	
	
	@Autowired
	private JwtAuthenticationFilter jwtfilter;

    @Bean
    public PasswordEncoder passwordEncoder() {
//    	PasswordEncoder encoder = NoOpPasswordEncoder.getInstance();
        return NoOpPasswordEncoder.getInstance();
  // 	return new BCryptPasswordEncoder();
    }
	
//    @Bean
//    public AuthenticationManager authenticationManagerbean() {
//    	return super.authenticationManager();
//    }
    
    
    
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) 
             throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
    

	

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity
		.cors().and().csrf().disable()
			.authorizeHttpRequests()
			.requestMatchers("/token","/signup")
			.permitAll()
			.anyRequest()
			.authenticated()
			.and()		
			.exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint)
			.and()
			.formLogin();
		//CONFIRM THIS ORDER!!!!!!!!!
		
	httpSecurity.addFilterBefore(jwtfilter, UsernamePasswordAuthenticationFilter.class);
		
		return httpSecurity.build();
	}
	
	
}

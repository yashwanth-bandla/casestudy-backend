package bandla.yashwanth.shopping.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import bandla.yashwanth.shopping.UserInfo;
import bandla.yashwanth.shopping.dao.CategoryRepository;
import bandla.yashwanth.shopping.dao.UserInfoRepository;



public class CheckLogin {
	
	@Autowired
	CategoryRepository categoryRepository;
	
	public static UserInfo checkLogin(UserInfo user, UserInfoRepository userInfoRepository) {
//		Configuration con = new Configuration().configure().addAnnotatedClass(UserInfo.class);		
//		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();	
//		SessionFactory sf = con.buildSessionFactory(reg);		
//		Session session = sf.openSession();
//		Transaction transaction = session.beginTransaction();
//
//		int i = 1;
//		UserInfo user1;
//		
//		while(true) {
//			user1 = (UserInfo)session.get(UserInfo.class, i); 	
//			if(user.getEmail().equals(user1.getEmail()) && user.getPassword().equals(user1.getPassword())) {
//				return user1;
//			}
//			i++;
//			if((UserInfo)session.get(UserInfo.class, i) == null) {
//				transaction.commit();
//				return new UserInfo();
//				
//			}
//		}
		
		
		
		int i = 1;
		UserInfo user1;
		
		while(true) {
			 	
			user1  = userInfoRepository.findById(i).get();
			
			if(user.getEmail().equals(user1.getEmail()) && user.getPassword().equals(user1.getPassword())) {
				return user1;
			}
			i++;
			if(userInfoRepository.findById(i).isEmpty()) {
				return new UserInfo();
			}
		}
		
		
		
		

		
		
	}
}

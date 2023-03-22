package bandla.yashwanth.shopping.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import bandla.yashwanth.shopping.UserInfo;
import bandla.yashwanth.shopping.dao.UserInfoRepository;

public class GetUser {
	public static UserInfo getUser(int userId, UserInfoRepository userInfoRepository) {
//		Configuration con = new Configuration().configure().addAnnotatedClass(UserInfo.class);
//		
//		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
//		
//		SessionFactory sf = con.buildSessionFactory(reg);
//		
//		Session session = sf.openSession();
//		
//		Transaction transaction = session.beginTransaction();
//		
//		int i = 1;
//		UserInfo user1;
//		
//		while(true) {
//			user1 = (UserInfo)session.get(UserInfo.class, i); 	
//			if(user1.getUserId() == userId) {
//				transaction.commit();
//				return user1;
//			}
//			i++;
//			if(session.get(UserInfo.class, i) == null) {
//				transaction.commit();
//				return new UserInfo();
//				
//			}
//		}
		
//		UserInfo testUserInfo = new UserInfo();
//		Address testAddress = new Address();
//		testAddress.setCity("hyderabad");
//		testAddress.setState("telangana");
//		testAddress.setStreet("kondapur");
//		testAddress.setPincode(505001);
//		
//		testUserInfo.setAddress(testAddress);
//		testUserInfo.setEmail("foo@foo");
//		testUserInfo.setName("testing name");
//		testUserInfo.setPassword("sdf");
//		testUserInfo.setPhone(9879);
//		testUserInfo.setUserId(10);
//		
//		return testUserInfo;
		

		
//		UserInfo userInfo;

			return userInfoRepository.findById(userId).get();


		
	}
}

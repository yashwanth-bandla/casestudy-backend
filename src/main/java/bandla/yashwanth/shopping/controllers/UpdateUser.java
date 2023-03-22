package bandla.yashwanth.shopping.controllers;

import bandla.yashwanth.shopping.UserInfo;
import bandla.yashwanth.shopping.dao.UserInfoRepository;

public class UpdateUser {
	public static void updateUser(UserInfo user, UserInfoRepository userInfoRepository) {
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
//			if(user.getUserId()==user1.getUserId()){
//
//				if(user.getAddress() != null) {
//					user1.setAddress(user.getAddress());
//				}
//				if(user.getEmail() != null) {
//					user1.setEmail(user.getEmail());	
//				}
//				if(user.getName() != null) {
//					user1.setName(user.getName());
//				}
//				if(user.getPhone()!=0) {
//					user1.setPhone(user.getPhone());	
//				}
//
//				
//				
//				session.save(user1);
//				break;
//			}
//			i++;
//			if((UserInfo)session.get(UserInfo.class, i) == null) {
//				break;
//			}
//		}
//
//		transaction.commit();
		
		
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
//		if(user.getCart()!=null) {
//			returnedUser.setCart(user.getCart());
//		}
		
		
		
		userInfoRepository.save(returnedUser);
	}
}

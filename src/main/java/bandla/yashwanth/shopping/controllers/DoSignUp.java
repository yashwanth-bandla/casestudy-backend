package bandla.yashwanth.shopping.controllers;


import bandla.yashwanth.shopping.Address;
import bandla.yashwanth.shopping.UserInfo;
import bandla.yashwanth.shopping.dao.AddressRepository;
import bandla.yashwanth.shopping.dao.UserInfoRepository;

public class DoSignUp {
	public static void doSignUp(UserInfo user,UserInfoRepository userInfoRepository, AddressRepository addressRepository ) {
		
		UserInfo givenUser = new UserInfo();
		givenUser.setName(user.getName());
		givenUser.setEmail(user.getEmail());
		givenUser.setPassword(user.getPassword());
		givenUser.setPhone(user.getPhone());
		givenUser.setRole("normal");
		
		Address givenAddress = new Address();
		givenAddress.setCity(user.getAddress().getCity());
		givenAddress.setState(user.getAddress().getState());
		givenAddress.setStreet(user.getAddress().getStreet());
		givenAddress.setPincode(user.getAddress().getPincode());
		
		Address savedAddress= addressRepository.save(givenAddress);
		
		givenUser.setAddress(savedAddress);
		
		UserInfo savedUser = userInfoRepository.save(givenUser);
		
		return ;
		
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
		
//		
//		returnedId = (int) session.save(user);
//		
//		transaction.commit();
//		
//		return returnedId;
		
//		int i = 1;
//		UserInfo user1;
//		
//		while(true) {
//			user1 = (UserInfo)session.get(UserInfo.class, i); 	
//			if(user1.getPassword() == user.getPassword() && user1.getEmail() == user1.getPassword()) {
//				return user1.getUserId();
//			}
//			i++;
//			if(session.get(UserInfo.class, i) == null) {
//				return 100;
//				
//			}
//		}
		
//		int returnedId;
		
//		UserInfo returnedUser = userInfoRepository.save(user);
//		
//		return returnedUser.getUserId();
		

		
	}
}

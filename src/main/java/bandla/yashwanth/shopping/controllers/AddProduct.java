package bandla.yashwanth.shopping.controllers;


import bandla.yashwanth.shopping.ProductInfo;

import bandla.yashwanth.shopping.dao.ProductInfoRepository;

public class AddProduct {
	public static void addProduct(ProductInfo product, ProductInfoRepository productInfoRepository) {
//		Configuration con = new Configuration().configure().addAnnotatedClass(ProductInfo.class);
//		
//		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
//		
//		SessionFactory sf = con.buildSessionFactory(reg);
//		
//		Session session = sf.openSession();
//		
//		Transaction transaction = session.beginTransaction();
//		
//		session.save(product);
//		
//		transaction.commit();
		
		productInfoRepository.save(product);
		
		
		
		
		
	}
}

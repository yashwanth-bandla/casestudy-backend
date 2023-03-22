package bandla.yashwanth.shopping.controllers;

import java.util.Optional;

import bandla.yashwanth.shopping.ProductInfo;

import bandla.yashwanth.shopping.dao.ProductInfoRepository;

public class GetProduct {
	public static ProductInfo getProduct(int productId, ProductInfoRepository productInfoRepository) {
//		Configuration con = new Configuration().configure().addAnnotatedClass(ProductInfo.class);	
//		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();	
//		SessionFactory sf = con.buildSessionFactory(reg);		
//		Session session = sf.openSession();		
//		Transaction transaction = session.beginTransaction();
//		ProductInfo product1;
//		int i = 1;
//		
//		while(true) {
//			product1 = (ProductInfo) session.get(ProductInfo.class, i);
//			if(product1.getId()==productId) {
//				return product1;
//			}
//			i++;
//			if(session.get(ProductInfo.class, i)==null) {
//				break;
//			}
//			
//		}
//		
//		transaction.commit();
//		return new ProductInfo();
		

		
		return productInfoRepository.findById(productId).get();
		
	}
}

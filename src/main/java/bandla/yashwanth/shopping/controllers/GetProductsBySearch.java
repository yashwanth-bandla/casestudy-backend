package bandla.yashwanth.shopping.controllers;

import java.util.ArrayList;
import java.util.List;


import bandla.yashwanth.shopping.ProductInfo;

import bandla.yashwanth.shopping.dao.ProductInfoRepository;

public class GetProductsBySearch {
	public static List<ProductInfo> getProductsBySearch(String searchString, ProductInfoRepository productInfoRepository){
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
//		ArrayList<ProductInfo> listBySearch = new ArrayList<ProductInfo>();
//		ProductInfo product1;
//		int i = 1;
//		
//		while(true) {
//			product1 = (ProductInfo) session.get(ProductInfo.class, i);
//			if(product1.getName().contains(searchString) || product1.getDetails().contains(searchString)) {
//				listBySearch.add(product1);
//			}
//			i++;
//			if(session.get(ProductInfo.class, i)==null) {
//				break;
//			}
//			
//		}
//		transaction.commit();
//		return listBySearch;

		
		ArrayList<ProductInfo> listBySearch = new ArrayList<ProductInfo>();
		ProductInfo product1;
		int i = 1;
		
		while(true) {
			product1 = productInfoRepository.findById(i).get();
			if(product1.getName().contains(searchString) || product1.getDetails().contains(searchString)) {
				listBySearch.add(product1);
			}
			i++;
			if(productInfoRepository.findById(i).isEmpty()) {
				break;
			}
			
		}
		return listBySearch;
		
	}
}

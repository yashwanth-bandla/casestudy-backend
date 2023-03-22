package bandla.yashwanth.shopping.controllers;

import bandla.yashwanth.shopping.ProductInfo;

import bandla.yashwanth.shopping.dao.ProductInfoRepository;

public class UpdateProduct {
	public static void updateProduct(ProductInfo product, ProductInfoRepository productInfoRepository) {
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
//		ProductInfo product1;
//		int i = 1;
//		
//		while(true) {
//			product1 = (ProductInfo) session.get(ProductInfo.class, i);
//			if(product.getId() == product1.getId()) {
//				if(product.getCategory() !=null) {
//					product1.setCategory(product.getCategory());
//				}
//				if(product.getDetails() != null) {
//					product1.setDetails(product.getDetails());
//				}
//				if(product.getName() !=null) {
//					product1.setName(product.getName());
//				}
//				if(product.getPrice()!=0) {
//					product1.setPrice(product.getPrice());
//				}
//				if(product.getSubCategory() !=null) {
//					product1.setSubCategory(product.getSubCategory());
//				}
//				session.save(product1);
//				break;
//			}
//			i++;
//			if(session.get(ProductInfo.class, i)==null) {
//				break;
//			}
//			
//		}
//		
//		transaction.commit();
		
		ProductInfo returnedProduct = productInfoRepository.findById(product.getId()).get();
		if(product.getCategory()!=null) {
			returnedProduct.setCategory(product.getCategory());
		}
		if(product.getDetails()!=null) {
			returnedProduct.setDetails(product.getDetails());
		}
		if(product.getName()!=null) {
			returnedProduct.setName(product.getName());
		}
		if(product.getPrice()!=0) {
			returnedProduct.setPrice(product.getPrice());
		}
		if(product.getSubCategory()!=null) {
			returnedProduct.setSubCategory(product.getSubCategory());
		}
		if(product.getImgsrc()!=null) {
			returnedProduct.setImgsrc(product.getImgsrc());
		}
		
		
		productInfoRepository.save(returnedProduct);
	}
}

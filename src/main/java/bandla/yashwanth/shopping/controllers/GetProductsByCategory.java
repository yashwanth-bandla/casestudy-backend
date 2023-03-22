package bandla.yashwanth.shopping.controllers;

import java.util.ArrayList;
import java.util.List;

import bandla.yashwanth.shopping.ProductInfo;

import bandla.yashwanth.shopping.dao.ProductInfoRepository;

public class GetProductsByCategory {
	public static List<ProductInfo> getProductsByCategory(int categoryId, ProductInfoRepository productInfoRepository) {
		
		ArrayList<ProductInfo> listByCategory = new ArrayList<ProductInfo>();
		
		Iterable<ProductInfo> findAll = productInfoRepository.findAll();
		for(ProductInfo itemInfo : findAll) {
			if(itemInfo.getCategory().getCategoryid() == categoryId) {
				listByCategory.add(itemInfo);
			}
		}
		
		
//		int i = 1;
//		
//		while(true) {
//			product1 = productInfoRepository.findById(i).get();
//			if(product1.getCategory().getCategoryid()==categoryId) {
//				listByCategory.add(product1);
//			}
//			i++;
//			if(productInfoRepository.findById(i).isEmpty()) {
//				break;
//			}
//		
//		}
		return listByCategory;
		
	}
}

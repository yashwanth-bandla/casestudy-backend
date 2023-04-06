package bandla.yashwanth.shopping.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import bandla.yashwanth.shopping.ProductInfo;

import bandla.yashwanth.shopping.dao.ProductInfoRepository;
@Service
public class GetProductsByCategory {
	public static List<ProductInfo> getProductsByCategory(int categoryId, ProductInfoRepository productInfoRepository) {
		
		
		//USEFUL CODE
//		ArrayList<ProductInfo> listByCategory = new ArrayList<ProductInfo>();
//		
//		Iterable<ProductInfo> findAll = productInfoRepository.findAll();
//		for(ProductInfo itemInfo : findAll) {
//			if(itemInfo.getCategory().getCategoryid() == categoryId) {
//				listByCategory.add(itemInfo);
//			}
//		}
//		
//		return listByCategory;
		
		return productInfoRepository.getProductsFromRepoByCategoryId(categoryId);
		
	}
}

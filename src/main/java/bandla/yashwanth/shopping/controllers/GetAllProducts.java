package bandla.yashwanth.shopping.controllers;

import java.util.ArrayList;
import java.util.List;

import bandla.yashwanth.shopping.ProductInfo;
import bandla.yashwanth.shopping.dao.ProductInfoRepository;

public class GetAllProducts {
	public static List<ProductInfo> getAllProducts(ProductInfoRepository productInfoRepository){
		ArrayList<ProductInfo> listOfAllProducts = new ArrayList<ProductInfo>();
		
		
		Iterable<ProductInfo> findAll = productInfoRepository.findAll();
		for(ProductInfo itemInfo : findAll) {
			listOfAllProducts.add(itemInfo);
		}
		
		
//		while(true) {
//			listOfAllProducts.add(productInfoRepository.findById(i).get()) ;
//			
//			i++;
//			if(productInfoRepository.findById(i).isEmpty()) {
//				break;
//			}
//		
//		}
		return listOfAllProducts;
	}
}

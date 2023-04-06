package bandla.yashwanth.shopping.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import bandla.yashwanth.shopping.ProductInfo;
import bandla.yashwanth.shopping.dao.ProductInfoRepository;
@Service
public class GetAllProducts {
	public static List<ProductInfo> getAllProducts(ProductInfoRepository productInfoRepository){
		
		//USEFUL CODE
//		ArrayList<ProductInfo> listOfAllProducts = new ArrayList<ProductInfo>();
//		
//		
//		Iterable<ProductInfo> findAll = productInfoRepository.findAll();
//		for(ProductInfo itemInfo : findAll) {
//			listOfAllProducts.add(itemInfo);
//		}
//		
//		
//		return listOfAllProducts;
		
		return productInfoRepository.getAllProductsFromRepo();
	}
}

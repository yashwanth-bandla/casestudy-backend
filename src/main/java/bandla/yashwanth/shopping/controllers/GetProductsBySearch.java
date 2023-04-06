package bandla.yashwanth.shopping.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import bandla.yashwanth.shopping.ProductInfo;

import bandla.yashwanth.shopping.dao.ProductInfoRepository;

@Service
public class GetProductsBySearch {
	public static List<ProductInfo> getProductsBySearch(String searchString,
			ProductInfoRepository productInfoRepository) {

//		ArrayList<ProductInfo> listBySearch = new ArrayList<ProductInfo>();
//		Iterable<ProductInfo> findAll = productInfoRepository.findAll();

		if (searchString.equals("") || searchString == null) {
//			for(ProductInfo itemInfo : findAll) {
//				listBySearch.add(itemInfo);
//			}
//			return listBySearch;

			return productInfoRepository.getAllProductsFromRepo();

		}

//		for (ProductInfo itemInfo : findAll) {
//			if (itemInfo.getName().contains(searchString) || itemInfo.getDetails().contains(searchString)) {
//				listBySearch.add(itemInfo);
//			}

//		}
//		return listBySearch;
		
		return productInfoRepository.getSearchedProductsFromRepo(searchString);

	}
}

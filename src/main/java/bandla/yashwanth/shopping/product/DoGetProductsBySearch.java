package bandla.yashwanth.shopping.product;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoGetProductsBySearch {
	
	@Autowired
	private ProductInfoRepository productInfoRepository;
	
	public List<ProductInfo> getProductsBySearch(String searchString) {

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

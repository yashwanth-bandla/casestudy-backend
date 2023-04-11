package bandla.yashwanth.shopping.product;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class DoGetProductsByCategory {
	
	@Autowired
	private ProductInfoRepository productInfoRepository;
	
	public List<ProductInfo> getProductsByCategory(int categoryId) {
		
		
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

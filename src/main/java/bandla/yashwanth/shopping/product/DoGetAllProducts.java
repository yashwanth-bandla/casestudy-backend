package bandla.yashwanth.shopping.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class DoGetAllProducts {
	
	@Autowired
	private ProductInfoRepository productInfoRepository;
	
	public List<ProductInfo> getAllProducts(){
		
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

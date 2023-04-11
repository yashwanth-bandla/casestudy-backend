package bandla.yashwanth.shopping.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoGetProduct {
	
	@Autowired
	private ProductInfoRepository productInfoRepository;
	
	public ProductInfo getProduct(int productId) {

		return productInfoRepository.findById(productId).get();
		
	}
}

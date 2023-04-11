package bandla.yashwanth.shopping.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
@Service
public class DoGetProduct {
	
	@Autowired
	private ProductInfoRepository productInfoRepository;
	
	public ProductInfo getProduct(int productId) {

		return productInfoRepository.findById(productId).get();
		
	}
}

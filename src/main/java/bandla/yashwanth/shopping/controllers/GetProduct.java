package bandla.yashwanth.shopping.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import bandla.yashwanth.shopping.ProductInfo;

import bandla.yashwanth.shopping.dao.ProductInfoRepository;
@Service
public class GetProduct {
	
	@Autowired
	private static ProductInfoRepository productInfoRepository;
	
	public static ProductInfo getProduct(int productId ) {

		return productInfoRepository.findById(productId).get();
		
	}
}

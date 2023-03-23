package bandla.yashwanth.shopping.controllers;

import java.util.Optional;

import bandla.yashwanth.shopping.ProductInfo;

import bandla.yashwanth.shopping.dao.ProductInfoRepository;

public class GetProduct {
	public static ProductInfo getProduct(int productId, ProductInfoRepository productInfoRepository) {

		return productInfoRepository.findById(productId).get();
		
	}
}

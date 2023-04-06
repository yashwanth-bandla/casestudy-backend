package bandla.yashwanth.shopping.controllers;

import org.springframework.stereotype.Service;

import bandla.yashwanth.shopping.ProductInfo;

import bandla.yashwanth.shopping.dao.ProductInfoRepository;
@Service
public class UpdateProduct {
	public static void updateProduct(ProductInfo product, ProductInfoRepository productInfoRepository) {
		
		ProductInfo returnedProduct = productInfoRepository.findById(product.getId()).get();
//		if(product.getCategory()!=null) {
//			returnedProduct.setCategory(product.getCategory());
//		}
		if(product.getDetails()!=null) {
			returnedProduct.setDetails(product.getDetails());
		}
		if(product.getName()!=null) {
			returnedProduct.setName(product.getName());
		}
		if(product.getPrice()!=0) {
			returnedProduct.setPrice(product.getPrice());
		}
//		if(product.getSubCategory()!=null) {
//			returnedProduct.setSubCategory(product.getSubCategory());
//		}
		if(product.getImgsrc()!=null) {
			returnedProduct.setImgsrc(product.getImgsrc());
		}
		
		
		productInfoRepository.save(returnedProduct);
	}
}

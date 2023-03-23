package bandla.yashwanth.shopping.controllers;


import org.springframework.beans.factory.annotation.Autowired;

import bandla.yashwanth.shopping.Category;
import bandla.yashwanth.shopping.ProductInfo;
import bandla.yashwanth.shopping.SubCategory;
import bandla.yashwanth.shopping.dao.CategoryRepository;
import bandla.yashwanth.shopping.dao.ProductInfoRepository;
import bandla.yashwanth.shopping.dao.SubCategoryRepository;

public class AddProduct {
	

	public static void addProduct(ProductInfo product, ProductInfoRepository productInfoRepository,CategoryRepository categoryRepository,SubCategoryRepository subCategoryRepository) {

		ProductInfo toSaveProduct = new ProductInfo();
		Category existingCategory ;
		SubCategory existingSubCategory;

		if(product.getCategory().getCategory()!=null && product.getCategory().getCategory()!="" && product.getCategory()!=null) {
			
			if(categoryRepository.getCategoryByCategoryName(product.getCategory().getCategory())!=null) {
				existingCategory = categoryRepository.getCategoryByCategoryName(product.getCategory().getCategory());
				toSaveProduct.setCategory(existingCategory);
			} else {
				Category category = new Category();
				category.setCategory(product.getCategory().getCategory());
				 category = categoryRepository.save(category);
				toSaveProduct.setCategory(category);
			}
		}
		if(product.getSubCategory().getName()!=null && product.getSubCategory().getName()!="" && product.getSubCategory()!=null) {
			
			if(subCategoryRepository.getSubCategoryBySubCategoryName(product.getSubCategory().getName())!=null) {
				existingSubCategory = subCategoryRepository.getSubCategoryBySubCategoryName(product.getSubCategory().getName());
				toSaveProduct.setSubCategory(existingSubCategory);
			} else {
				SubCategory subCategory = new SubCategory();
				subCategory.setName(product.getSubCategory().getName());
				subCategory = subCategoryRepository.save(subCategory);
				toSaveProduct.setSubCategory(subCategory);
			}
		}
		toSaveProduct.setName(product.getName());
		toSaveProduct.setDetails(product.getDetails());
		toSaveProduct.setImgsrc(product.getImgsrc());
		toSaveProduct.setPrice(product.getPrice());
		
		//save subcategory also
		
		productInfoRepository.save(toSaveProduct);
		
		
		
		
		
	}
}

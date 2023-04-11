package bandla.yashwanth.shopping.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoAddProduct {
	
	@Autowired
	private ProductInfoRepository productInfoRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private SubCategoryRepository subCategoryRepository;

	public void addProduct(ProductInfo product) {

		ProductInfo toSaveProduct = new ProductInfo();
		Category existingCategory ;
		SubCategory existingSubCategory;

		if(product.getCategory()!=null && product.getCategory().getCategory()!=null && product.getCategory().getCategory()!="") {
			
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

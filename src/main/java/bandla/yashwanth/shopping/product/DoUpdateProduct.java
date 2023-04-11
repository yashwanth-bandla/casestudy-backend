package bandla.yashwanth.shopping.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoUpdateProduct {

	@Autowired
	private ProductInfoRepository productInfoRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private SubCategoryRepository subCategoryRepository;

	public void updateProduct(ProductInfo product) {

		ProductInfo returnedProduct = productInfoRepository.findById(product.getId()).get();
//		if(product.getCategory()!=null) {
//			returnedProduct.setCategory(product.getCategory());
//		}
		if (product.getDetails() != null && product.getDetails() != "") {
			returnedProduct.setDetails(product.getDetails());
		}
		if (product.getName() != null && product.getDetails() != "") {
			returnedProduct.setName(product.getName());
		}
		if (product.getPrice() != 0 && product.getDetails() != "") {
			returnedProduct.setPrice(product.getPrice());
		}
//		if(product.getSubCategory()!=null) {
//			returnedProduct.setSubCategory(product.getSubCategory());
//		}
		if (product.getImgsrc() != null && product.getDetails() != "") {
			returnedProduct.setImgsrc(product.getImgsrc());
		}

		Category existingCategory;
		SubCategory existingSubCategory;

		if (product.getCategory() != null && product.getCategory().getCategory() != null
				&& product.getCategory().getCategory() != "") {

			if (categoryRepository.getCategoryByCategoryName(product.getCategory().getCategory()) != null) {
				existingCategory = categoryRepository.getCategoryByCategoryName(product.getCategory().getCategory());
				returnedProduct.setCategory(existingCategory);
			} else {
				Category category = new Category();
				category.setCategory(product.getCategory().getCategory());
				category = categoryRepository.save(category);
				returnedProduct.setCategory(category);
			}
		}
		if (product.getSubCategory().getName() != null && product.getSubCategory().getName() != ""
				&& product.getSubCategory() != null) {

			if (subCategoryRepository.getSubCategoryBySubCategoryName(product.getSubCategory().getName()) != null) {
				existingSubCategory = subCategoryRepository
						.getSubCategoryBySubCategoryName(product.getSubCategory().getName());
				returnedProduct.setSubCategory(existingSubCategory);
			} else {
				SubCategory subCategory = new SubCategory();
				subCategory.setName(product.getSubCategory().getName());
				subCategory = subCategoryRepository.save(subCategory);
				returnedProduct.setSubCategory(subCategory);
			}
		}

		productInfoRepository.save(returnedProduct);
	}
}

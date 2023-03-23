package bandla.yashwanth.shopping.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import bandla.yashwanth.shopping.Category;
import bandla.yashwanth.shopping.SubCategory;

public interface SubCategoryRepository extends CrudRepository<SubCategory, Integer> {
	@Query("select u from SubCategory u where u.name = :subcategory")
	public SubCategory getSubCategoryBySubCategoryName(@Param("subcategory") String subcategory);
}

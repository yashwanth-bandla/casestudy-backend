package bandla.yashwanth.shopping.product;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface SubCategoryRepository extends CrudRepository<SubCategory, Integer> {
	@Query("select u from SubCategory u where u.name = :subcategory")
	public SubCategory getSubCategoryBySubCategoryName(@Param("subcategory") String subcategory);
	
	@Query("select DISTINCT(s.name) from SubCategory s")
	public List<String> getAllSubCategoryNames();
}

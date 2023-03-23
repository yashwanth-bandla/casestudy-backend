package bandla.yashwanth.shopping.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import bandla.yashwanth.shopping.Category;
import bandla.yashwanth.shopping.UserInfo;

public interface CategoryRepository extends CrudRepository<Category, Integer> {
	@Query("select u from Category u where u.category = :category")
	public Category getCategoryByCategoryName(@Param("category") String category);
}

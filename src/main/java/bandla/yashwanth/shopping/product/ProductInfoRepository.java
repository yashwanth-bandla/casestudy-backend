package bandla.yashwanth.shopping.product;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface ProductInfoRepository extends CrudRepository<ProductInfo, Integer> {
	@Query("select p from ProductInfo p where p.category.categoryid = :id") //this is a JPQL query
//	@Query(
//			  value = "SELECT * FROM USERS u WHERE u.status = 1", 
//			  nativeQuery = true)
	public List<ProductInfo> getProductsFromRepoByCategoryId(@Param("id") int id);
	
	@Query("select p from ProductInfo p")
	public List<ProductInfo> getAllProductsFromRepo();
	
	@Query("select p from ProductInfo p where p.name like %:str% or p.details like %:str%")
	public List<ProductInfo> getSearchedProductsFromRepo(@Param("str") String str);
	
}

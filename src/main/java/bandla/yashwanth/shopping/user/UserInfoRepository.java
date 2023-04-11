package bandla.yashwanth.shopping.user;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface UserInfoRepository extends CrudRepository<UserInfo, Integer> {
	@Query("select u from UserInfo u where u.email = :email") //this is a JPQL query
	public UserInfo getUserByUserName(@Param("email") String email);

}

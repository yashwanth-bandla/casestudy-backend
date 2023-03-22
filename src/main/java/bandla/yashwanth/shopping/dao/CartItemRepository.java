package bandla.yashwanth.shopping.dao;

import org.springframework.data.repository.CrudRepository;

import bandla.yashwanth.shopping.CartItem;

public interface CartItemRepository extends CrudRepository<CartItem, Integer>{

}

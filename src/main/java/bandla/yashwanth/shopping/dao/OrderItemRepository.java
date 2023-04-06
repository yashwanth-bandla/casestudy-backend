package bandla.yashwanth.shopping.dao;

import org.springframework.data.repository.CrudRepository;

import bandla.yashwanth.shopping.OrderItem;

public interface OrderItemRepository extends CrudRepository<OrderItem, Integer> {

}

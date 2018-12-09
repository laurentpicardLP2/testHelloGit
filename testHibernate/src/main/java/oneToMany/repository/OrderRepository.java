package oneToMany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import oneToMany.model.Order;


public interface OrderRepository extends JpaRepository<Order, Long> {

}

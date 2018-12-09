package oneToMany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import oneToMany.model.Customer;


public interface CustomerRepository extends JpaRepository<Customer, Long> {

}

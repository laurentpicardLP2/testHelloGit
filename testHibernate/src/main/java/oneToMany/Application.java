package oneToMany;


import java.util.Arrays;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import oneToMany.model.Customer;
import oneToMany.model.Order;
import oneToMany.repository.CustomerRepository;
import oneToMany.repository.OrderRepository;



@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
    private OrderRepository orderRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Clean up database tables
		customerRepository.deleteAllInBatch();
		orderRepository.deleteAllInBatch();

		

		// Create a customer instance
		Customer customer = new Customer(
				"55 rue de Vincennes, 93100 Montreuil",
				"Philippe"
			);
		Customer customer2 = new Customer(
				"55 rue de Vincennes, 93100 Montreuil",
				"Josselin"
			);

		// Create a Order instance
		Order order1 = new Order("raquette", 45.0, customer);
		Order order2 = new Order("balles", 12, customer);
		
		Collection<Order> orders = Arrays.asList(order1, order2);
		customer.addOrders(orders);

		// Save customer
		customerRepository.save(customer);
		customerRepository.save(customer2);

		// save customers' orders
		orderRepository.saveAll(orders);
		//=========================================
		
		//delete customer => delete cascade order1 & order2
		customerRepository.delete(customer);
		
		//orderRepository.delete(order2);
		
	}


}
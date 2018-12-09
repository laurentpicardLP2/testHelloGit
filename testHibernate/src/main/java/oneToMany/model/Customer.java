package oneToMany.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "Customers")
public class Customer  implements Serializable {

	// default serial
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JoinColumn(name = "Customer_ID")
	private long id;

	@Size(max = 255)
	@Column(name = "Address")
	private String address;

	@Size(max = 65)
	@Column(name = "Name")
	private String name;

	@OneToMany(mappedBy="customer")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Set<Order> orders = new HashSet<Order>();

	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Customer(@Size(max = 255) String address, @Size(max = 65) String name) {
		this.address = address;
		this.name = name;
		this.orders = new HashSet<Order>();
	}

	public boolean addOrders(Collection<Order> newOrders) {
		return this.orders.addAll(newOrders);
	}
	
	public boolean addOrder(Order newOrder) {
		return this.orders.add(newOrder);
	}

}
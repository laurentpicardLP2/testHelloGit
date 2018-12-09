package oneToMany.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "Orders")
public class Order implements Serializable {

	// default serial
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Order_ID")
	private long id;

	@Size(max = 65)
	@Column(name = "Article")
	private String article;

	@Column(name = "Price")
	private double price;

	 @ManyToOne
	 @JoinColumn(name="Customer_ID")
	private Customer customer;

	public Order() {
		// TODO Auto-generated constructor stub
	}

	public Order(@Size(max = 65) String article, double price, Customer customer) {
		this.article = article;
		this.price = price;
		this.customer = customer;
	}

}
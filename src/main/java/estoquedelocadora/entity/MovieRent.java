package estoquedelocadora.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="rents")
public class MovieRent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="person_id")
	private Person person;
	
	private Date pickDate;
	
	private Date deliverDate;
	
	@ManyToMany
	@JoinTable(name="rented_products", joinColumns=@JoinColumn(name="rent_id"),	inverseJoinColumns=@JoinColumn(name="product_id"))
	private List<Product> products;
	
	private boolean delivered;
	
	
	public MovieRent() {
		
	}
	public MovieRent(Long id, Person person, Date pickDate, List<Product> products) {
		super();
		this.id = id;
		this.person = person;
		this.pickDate = pickDate;
		this.products = products;
		this.delivered = false;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public Date getPickDate() {
		return pickDate;
	}
	public void setPickDate(Date pickDate) {
		this.pickDate = pickDate;
	}
	public Date getDeliverDate() {
		return deliverDate;
	}
	public void setDeliverDate(Date deliverDate) {
		this.deliverDate = deliverDate;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public boolean isDelivered() {
		return delivered;
	}
	public void setDelivered(boolean delivered) {
		this.delivered = delivered;
	}
	
	
}

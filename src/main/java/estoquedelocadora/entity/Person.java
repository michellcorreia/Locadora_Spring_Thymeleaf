package estoquedelocadora.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="clients")
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="firstName")
	private String firstName;
	
	@Column(name="lastName")
	private String lastName;
	
	@Column(name="SSN")
	private String socialSecNumber;
	
	@Column(name="birthDate")
	private String birthDate;
	
	@OneToMany
	private List<MovieRent> rents;
	
	public Person() {
		
	}
	public Person(String firstName, String lastName, String socialSecNumber, String birthDate) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.socialSecNumber = socialSecNumber;
		this.birthDate = birthDate;
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getSocialSecNumber() {
		return socialSecNumber;
	}
	public void setSocialSecNumber(String socialSecNumber) {
		this.socialSecNumber = socialSecNumber;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public List<MovieRent> getRents() {
		return rents;
	}
	
	
}

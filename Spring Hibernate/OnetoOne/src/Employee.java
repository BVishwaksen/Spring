

import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.CascadeType;
import javax.persistence.OneToOne;

@Entity
@Table(name="EMPLOYEE_one_to_one")
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@PrimaryKeyJoinColumn
	private int id;
	private String firstName;
	private String lastName;
	private int salary;
	
	@OneToOne(targetEntity=Address.class,cascade=CascadeType.ALL)
	
	private Address address;
	
	public Employee() {}
	public Employee(int id,String firstName,String lastName,int salary) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
	}
	public Employee(int id,String firstName,String lastName,int salary, Address address) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
		this.address = address;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}
	
}

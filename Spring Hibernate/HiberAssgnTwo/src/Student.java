

import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.CascadeType;
import javax.persistence.OneToOne;

@Entity
@Table(name="STUDENT_one_to_one")
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@PrimaryKeyJoinColumn
	private int id;
	private String firstName;
	private String lastName;
	private String branch;
	
	@OneToOne(targetEntity=Address.class,cascade=CascadeType.ALL)
	
	private Address address;
	
	public Student() {}
	public Student(int id,String firstName,String lastName,String branch) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.branch = branch;
	}
	public Student(int id,String firstName,String lastName,String branch, Address address) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.branch = branch;
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
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}
	
}

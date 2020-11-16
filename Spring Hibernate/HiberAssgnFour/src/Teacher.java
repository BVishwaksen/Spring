import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity(name = "Teacher")
public class Teacher {
	private int id;
	private String subject;
	private String firstname;
	private String lastname;
	private Set<Student> student = new HashSet<Student>(0);
	

	Teacher(){
		
	}
	
	Teacher(int id, String subject, String firstname,String lastname){
		this.id = id;
		this.subject = subject;
		this.firstname = firstname;
		this.lastname = lastname;
	}
	
	Teacher(int id, String subject, String firstname,String lastname, Set<Student> student){
		this.id = id;
		this.subject = subject;
		this.firstname = firstname;
		this.lastname = lastname;
		this.student = student;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setSubject(String subject) {
		this.subject = subject;
	}

	public void setFirstName(String firstname) {
		this.firstname = firstname;
	}
	public void setLastName(String lastname) {
		this.lastname = lastname;
	}
	
	public void setStudent(Set<Student> student) {
		this.student = student;
	}

	@Id
	@Column(name="id")
	public int getId() {
		return this.id;
	}
	
	@Column(name = "subject")
	public String getSubject() {
		return subject;
	}

	@Column(name = "firstname")
	public String getFirstName() {
		return firstname;
	}
	
	@Column(name = "lastname")
	public String getLastName() {
		return lastname;
	}

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "TCHRSTU", joinColumns = { @JoinColumn(name = "id") }, inverseJoinColumns = { @JoinColumn(name = "rollno") })
	public Set<Student> getStudent() {
			return student;
	}
	
	@Override
	public String toString() {
		return "Id : "+this.getId()+"\tFirstName : "+this.getFirstName()+"\tLastName : "+this.getLastName()+"\tSubject : "+this.getSubject();
	}
	
}

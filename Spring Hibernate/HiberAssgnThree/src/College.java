import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity(name = "College")
public class College {
	
	private String code;
	private String name;
	private String city;
	private Set<Student> std = new HashSet<Student>(0);
	

	College(){
		
	}
	
	College(String code, String name,String city){
		this.code = code;
		this.name = name;
		this.city = city;
	}
	
	College(String code, String name,String city, Set<Student> std){
		this.code = code;
		this.name = name;
		this.city = city;
		this.std = std;
	}
	
	public void setCode(String code) {
		this.code = code;
	}

	public void setName(String name) {
		this.name = name;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setStd(Set<Student> std) {
		this.std = std;
	}

	@Id
	@Column(name = "code")
	public String getCode() {
		return this.code;
	}

	@Column(name = "name")
	public String getName() {
		return this.name;
	}
	@Column(name="city")
	public String getCity() {
		return city;
	}

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "CLGSTU", joinColumns = { @JoinColumn(name = "code") }, inverseJoinColumns = { @JoinColumn(name = "rollno") })
	public Set<Student> getStd() {
			return this.std;
	}
	
	@Override
	public String toString() {
		return "Code : "+this.getCode()+"\nName : "+this.getName()+"\nCity : "+this.getCity();
	}
	
}

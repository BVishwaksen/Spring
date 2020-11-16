import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="STUDENT_MTM")
public class Student {
	
	@Id
	@Column(name = "rollno")
	private int rollno;
	@Column(name = "name")
	private String name;
	@Column(name = "branch")
	private String branch;
	
	Student(){
		
	}
	
	Student(int rollno, String name,String branch){
		this.rollno = rollno;
		this.name = name;
		this.branch = branch;
	}
	
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setBranch(String branch) {
		this.branch = branch;
	}
	
	public int getRollno() {
		return rollno;
	}
	
	public String getName() {
		return name;
	}
	
	public String getBranch() {
		return branch;
	}
	
	@Override
	public String toString() {
		return "RollNo : "+this.getRollno()+"\nName : "+this.getName()+"\nBranch: "+this.getBranch();
	}
	
}

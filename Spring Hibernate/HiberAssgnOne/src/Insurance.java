
public class Insurance {
	int id;
	private int policyNo;
	private String name;
	private int tenure;
	private int amount;
	
	public Insurance() {}
	public Insurance(int id,int policyNo,String name,int tenure,int amount) {
		this.id=id;
		this.policyNo = policyNo;
		this.name = name;
		this.tenure = tenure;
		this.amount = amount;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPolicyNo() {
		return policyNo;
	}
	public void setPolicyNo(int policyNo) {
		this.policyNo = policyNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTenure() {
		return tenure;
	}
	public void setTenure(int tenure) {
		this.tenure = tenure;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
}

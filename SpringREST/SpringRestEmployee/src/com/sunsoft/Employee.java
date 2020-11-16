package com.sunsoft;

public class Employee {
	private int id;
	private String name;
	private int basic;
	private int hra;
	private int allowance;
	private int deductions;
	private int gross_sal;
	private int final_deductions;
	private int total_sal;
	
	
	Employee(int id,String name,int basic,int hra,int allowance,int deductions) {
		this.id = id;
		this.name = name;
		this.basic = basic;
		this.hra = hra;
		this.allowance = allowance;
		this.deductions = deductions;
	}
	
	private int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	private String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	int getBasic() {
		return basic;
	}
	
	public void setBasic(int basic) {
		this.basic = basic;
	}
	int getHra() {
		return hra;
	}
	
	public void setHra(int hra) {
		this.hra = hra;
	}
	int getAllowance() {
		return allowance;
	}
	
	public void setAllowance(int allowance) {
		this.allowance = allowance;
	}
	int getDeductions() {
		return deductions;
	}
	
	public void setDeductions(int deductions) {
		this.deductions = deductions;
	}
	
	public void setGross_sal(int gross_sal) {
		this.gross_sal = gross_sal;
	}
	public int getGross_sal() {
		return gross_sal;
	}
	public void setFinal_deductions(int final_deductions) {
		this.final_deductions = final_deductions;
	}
	public void setTotal_sal(int total_sal) {
		this.total_sal = total_sal;
	}
	public int getFinal_deductions() {
		return final_deductions;
	}
	
	public String toString() {
		return "Id: "+id+" Name: "+name+" Basic salary: "+basic+" HRA: "+ hra+" Allowances: "+allowance
				+" Deductions: "+deductions+" Gross salary: "+gross_sal+" Final deductions: "+
				final_deductions+" Total salary: "+total_sal;
	}


}

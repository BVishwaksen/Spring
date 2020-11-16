package com.sunsoft.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="InsuranceData")
public class InsuranceData {
	@Id
	@Column
	int id;
	@Column
	String name;
	@Column
	int policyno;
	@Column 
	int tenure;
	@Column 
	int amount;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public int getPolicyno() {
		return policyno;
	}
	public void setPolicyno(int policyno) {
		this.policyno = policyno;
		
	}
}

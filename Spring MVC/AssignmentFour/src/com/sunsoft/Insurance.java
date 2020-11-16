package com.sunsoft;

import java.util.ArrayList;

public class Insurance {
	String name;
	int policyNumber;
	int tensure;
	int amount;
	public void setName(String name){
		this.name=name;
	}
	public String getName() {
		return name;
	}
	public void setPolicyNumber(int policyNumber){
		this.policyNumber=policyNumber;
	}
	public int getPolicyNumber() {
		return policyNumber;
	}
	public void setTensure(int tensure){
		this.tensure=tensure;
	}
	public int getTensure() {
		return tensure;
	}
	public void setAmount(int amount){
		this.amount=amount;
	}
	public int getAmount() {
		return amount;
	}

}

package com.sunsoft;

public class ElectricityMeter {
	private int id;
	private int units;
	private double costPerUnit;
	private double totalBill;
	private String lastDate;
	
	ElectricityMeter(int id,int units,double costPerUnit,String lastDate) {
		this.id = id;
		this.units = units;
		this.costPerUnit = costPerUnit;
		this.lastDate = lastDate;
	}
	private int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	int getUnits() {
		return units;
	}
	
	public void setUnits(int units) {
		this.units = units;
	}
	double getCostPerUnit() {
		return costPerUnit;
	}
	
	public void setCostPerUnit(double costPerUnit) {
		this.costPerUnit = costPerUnit;
	}
	
	public String getLastDate() {
		return lastDate;
	}
	
	public void setLastDate(String lastDate) {
		this.lastDate = lastDate;
	}
	
	public void setTotalBill(double totalBill) {
		this.totalBill = totalBill;
	}
	public String toString() {
		return "Id: "+id+" Consumed Units: "+units+" Cost Per Unit: "+costPerUnit+" Total Bill: "+ totalBill+" Last Date: "+lastDate;
	}
}

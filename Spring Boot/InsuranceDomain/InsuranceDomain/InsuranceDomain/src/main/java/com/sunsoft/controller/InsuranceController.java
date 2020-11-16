package com.sunsoft.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunsoft.dao.InsuranceDao;
import com.sunsoft.model.InsuranceData;
import com.sunsoft.model.UserData;

@RestController
public class InsuranceController {
	@Autowired
	InsuranceDao  insurancedao;
	@RequestMapping("/insert")
	public String insertData()
	{
		InsuranceData insuranceObj1=new InsuranceData();
		insuranceObj1.setId(1);
		insuranceObj1.setName("vishwaksen");
		insuranceObj1.setTenure(15);
		insuranceObj1.setAmount(12000);
		insuranceObj1.setPolicyno(1234);
		
		InsuranceData insuranceObj2=new InsuranceData();
		insuranceObj2.setId(2);
		insuranceObj2.setName("rajashekhar");
		insuranceObj2.setTenure(25);
		insuranceObj2.setAmount(4000);
		insuranceObj2.setPolicyno(4321);
		
		insurancedao.insertData(insuranceObj1);
		insurancedao.insertData(insuranceObj2);
		return "data inserted successfully";
	}
	@RequestMapping("/delete/{id}")
	public String deleteData(@PathVariable ("id") int id) {
		insurancedao.deleteData(id);
		return "record deleted successfully";
	}
	@RequestMapping("/update/{id}/{name}")
	public String updateData(@PathVariable ("id") int id,@PathVariable ("name") String name) {
		
		insurancedao.updateData(id, name);
		return "updated successfully";
	}
	@RequestMapping("/displayAll")
	 public List<InsuranceData>displayAll(){
		  List<InsuranceData> insuranceList=(List<InsuranceData>) insurancedao.displayAll();
		  return insuranceList;
	  }

}


package com.sunsoft.dao;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunsoft.model.InsuranceData;
import com.sunsoft.repository.InsuranceRepository;



@Service
public class InsuranceDao {
	@Autowired
	InsuranceRepository insuranceRepository;
	
	public void insertData(InsuranceData obj) {
		insuranceRepository.save(obj);
	}
	public void deleteData(int id) {
		insuranceRepository.deleteById(id);
	}
	public void updateData(int id,String name) {
		List<InsuranceData> insuranceList=(List<InsuranceData>)  insuranceRepository.findAll();;
		Iterator<InsuranceData> itr = insuranceList.iterator();
		while (itr.hasNext()) {
		   InsuranceData ins = itr.next();
		    if (ins.getId()==id) {
		    	ins.setName(name);
		    	insuranceRepository.save(ins);
		    }
	}
	}
	public List<InsuranceData> displayAll(){
		List<InsuranceData> insuranceList =(List<InsuranceData>) insuranceRepository.findAll();
		return insuranceList;
	}
	
}

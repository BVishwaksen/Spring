package com.sunsoft;
import java.util.HashMap;
import com.sunsoft.ElectricityMeter;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/getbill")
public class ElectricityController {
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public String getMovie(@PathVariable int id) {
		HashMap<Integer,ElectricityMeter> hm1 = new HashMap<Integer,ElectricityMeter>();
		
		hm1.put(1, new ElectricityMeter (1,120,2.59,"12-12-2020"));
		hm1.put(2, new ElectricityMeter (2,160,3.29,"12-12-2020"));
		hm1.put(3, new ElectricityMeter (3,1200,2.00,"12-12-2020"));
		
		ElectricityMeter ele=null;
		
		if(hm1.containsKey(id)) {
			ele = hm1.get(id);
		}
		
		ele.setTotalBill(ele.getCostPerUnit()*ele.getUnits());
		
		return ele.toString();
	
	}
}


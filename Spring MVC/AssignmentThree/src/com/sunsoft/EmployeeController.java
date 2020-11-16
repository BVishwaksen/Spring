package com.sunsoft;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmployeeController{
	@RequestMapping("/calculate/{id1}")
	public String employeeSalary(@RequestParam ("id") int id, @RequestParam("name") String name,
			@RequestParam("basic") int basic,@RequestParam("hra") int hra,@RequestParam("da") int da,
			@RequestParam("it") int it,@RequestParam("deductions") int deductions,
			@PathVariable("id1") int id1, Model m){
			
			if(id==1) {

				float grossSalary = basic + (basic*hra)/100 + (basic*da)/100;
				float netSalary = grossSalary - (basic*it)/100 - deductions;
				m.addAttribute("name",name);
				m.addAttribute("grossSalary",grossSalary);
				m.addAttribute("netSalary",netSalary);
				return "welcomepage";
			}
			return "errorpage";

		

	}
}
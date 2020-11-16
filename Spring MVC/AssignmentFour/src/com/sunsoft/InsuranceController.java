package com.sunsoft;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller()
public class InsuranceController {
	
	//Assign 4
	ArrayList<Insurance> arr=new ArrayList();
	@RequestMapping("/addpolicy")
	public String addUserController(HttpServletRequest request,HttpServletResponse response,Model m) {
		String policyNumber=request.getParameter("policyNumber");
		String name=request.getParameter("name");
		String tensure=request.getParameter("tensure");
		String amount=request.getParameter("amount");
		Insurance i1=new Insurance();
		i1.setName(name);
		i1.setAmount(Integer.parseInt(amount));
		i1.setPolicyNumber(Integer.parseInt(policyNumber));
		i1.setTensure(Integer.parseInt(tensure));
		arr.add(i1);
		return "add";
	}
	@RequestMapping("/displaypolicies")
	public String newController(Model m) {
		m.addAttribute("policies",arr);
		return "view";
	}
	@RequestMapping("/add")
	public String addController(Model m) {
		return "add";
	}
}

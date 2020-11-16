package com.sunsoft.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sunsoft.dao.UserDao;
import com.sunsoft.model.UserData;


@RestController
public class LoginController {
	@Autowired
	UserDao userDao;
	
	@RequestMapping(value="/validity",method=RequestMethod.POST)
	public String displayData(@RequestBody String nameAndPassword)
	{
		List<UserData> userList=userDao.displayAll();
		Iterator<UserData> itr = userList.iterator();
		String[] temp = nameAndPassword.split(" ");
		String username = temp[0];
		String password = temp[1];
		while (itr.hasNext()) {
		    UserData user = itr.next();
		    if (user.getUserName().equals(username) && user.getPassword().equals(password)) {
		    	System.out.println("Valid User");
		    	return "Valid User";
		    }
		}
		System.out.println("Invalid User");
		return "Invalid User";
	}	
}

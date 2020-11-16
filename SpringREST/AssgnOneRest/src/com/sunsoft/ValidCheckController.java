package com.sunsoft;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/validcheck")
public class ValidCheckController {
	@RequestMapping(value="/{id}/{password}", method=RequestMethod.GET)
	public String validateUser(@PathVariable int id, @PathVariable String password) {
		if(id == 116 && password.equals("pass@word1")) {
			return "Valid User";
		}
		return "Invalid User";
	
	}
}

package com.sunsoft;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/getfullname")
public class FullNameController {
	@RequestMapping(value="/{firstname}/{lastname}", method=RequestMethod.GET)
	public String validateUser(@PathVariable String firstname, @PathVariable String lastname) {
		return firstname+" "+lastname;
	}

}

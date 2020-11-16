package com.sunsoft;
import java.util.HashMap;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/check")
public class ValidationController {
	
	@RequestMapping(value="/validity",method=RequestMethod.POST)
	public ResponseEntity<String> checkValidity(@RequestBody String nameAndPassword){
		HashMap<String,String> hashmap = new HashMap<String,String>();
		String userNames[] = {"Vishwaksen","Hemanth","Ayyappa"};
		String passWords[] = {"pass1","pass2","pass3"};
		for(int i=0;i<3;i++) {
			hashmap.put(userNames[i], passWords[i]);
		}
		String[] temp = nameAndPassword.split(" ");
		String name = temp[0];
		String password = temp[1];
		for(int i=0;i<3;i++) {
			if(name.endsWith(userNames[i])) {
				if(password.equals(hashmap.get(name))) {
					System.out.println("Valid User");
					return new ResponseEntity(HttpStatus.CREATED);
				}
				else {
					System.out.println("Invalid User");
					return new ResponseEntity(HttpStatus.CREATED);
				}
			}
		}
		System.out.println("Invalid User");
		return new ResponseEntity(HttpStatus.CREATED);
	}
}


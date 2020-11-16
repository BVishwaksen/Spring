package com.sunsoft.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunsoft.model.UserData;
import com.sunsoft.repository.UserRepository;


@Service
public class UserDao {
	@Autowired
	UserRepository userRepository;
	
	public List<UserData> displayAll(){
		List<UserData> userList = (List<UserData>) userRepository.findAll();
		return userList;
	}
}

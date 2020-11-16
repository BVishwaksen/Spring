package com.sunsoft.repository;

import org.springframework.data.repository.CrudRepository;

import com.sunsoft.model.UserData;

public interface UserRepository extends CrudRepository<UserData,Integer>{

}
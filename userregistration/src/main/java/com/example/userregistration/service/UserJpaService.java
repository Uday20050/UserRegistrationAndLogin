package com.example.userregistration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.userregistration.model.Users;
import com.example.userregistration.repository.UserJpaRepository;
import com.example.userregistration.repository.UserRepository;


@Service
public class UserJpaService implements UserRepository {
	
	@Autowired
	  private UserJpaRepository userJpaRepository;
	@Override
	  public Users addUser(Users user) {
	      userJpaRepository.save(user);
	      return user;
	    
	  }
	@Override
	public Users updatePassword() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
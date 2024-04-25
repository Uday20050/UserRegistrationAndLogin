package com.example.userregistration.repository;

import com.example.userregistration.model.Users;

public interface UserRepository {
	Users addUser(Users user);
	Users updatePassword();
	
}
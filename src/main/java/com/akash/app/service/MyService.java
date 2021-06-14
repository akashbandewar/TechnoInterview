package com.akash.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akash.app.dao.Role;
import com.akash.app.dao.User;
import com.akash.app.dao.Userdto;
import com.akash.app.repo.MyRepository;

@Service
public class MyService {
	
	@Autowired
	MyRepository myRepository;
	
	public List<User> allUsers() {	
		return myRepository.getAllUsers();
	}
	
	public User myProfile(String email) {
		return myRepository.findProfile(email);
	}
	
	public boolean UserExist(String email) {
		User user = myRepository.findProfile(email);
		if(user == null)
			return true;
		return false;
	}  
	
	public void registerUser(User user) {
		//System.out.println(myRepository.findByRoleId(2));
		myRepository.save(user);
	}
	
	public List<User> deleteProfile(String email) {
		myRepository.deleteByEmail(email);
		return myRepository.getAllUsers();
	}
	
	public void updateProfile(Userdto user) {
		myRepository.updateProfile(user.getName(),user.getMobile(),user.getId());
	}
}

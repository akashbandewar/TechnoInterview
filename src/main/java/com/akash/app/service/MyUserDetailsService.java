package com.akash.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.akash.app.dao.MyUserDetails;
import com.akash.app.dao.Role;
import com.akash.app.dao.User;
import com.akash.app.dao.Userdto;
import com.akash.app.repo.MyRepository;

@Service
public class MyUserDetailsService implements UserDetailsService{

	@Autowired
	MyRepository myRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<User> user = myRepository.findByEmail(email);
//		Role role = myRepository.findById(user.getId());
//		Userdto temp = new Userdto(user,role);
		
//		Optional<Userdto> opt = Optional.of(temp);
		
		user.orElseThrow(() -> new UsernameNotFoundException(email + " not found"));
//		User userObject = user.get();
//		boolean enabled = !userObject.isAccountVerified();
//		Optional<Userdto> userdto = new Userdto(user,role.get());
 
		return user.map(MyUserDetails::new).get();
	}
	
} 

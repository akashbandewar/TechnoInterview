package com.akash.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.akash.app.dao.MyUserDetails;
import com.akash.app.dao.User;
import com.akash.app.dao.Userdto;
import com.akash.app.service.MyService;

@Controller
public class MyController {
	
	
	@Autowired
	MyUserDetails myUserDetails;
	
	@Autowired
	MyService myService; 
	
	// GET CURRENT USER
	String getCurrentUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		return currentPrincipalName;
	}
	
	// GET USER ROLE
		String getAuthority() {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			String role = authentication.getAuthorities().toString();
			return role.substring(1,role.length() - 1);
			//return role.slice(0,-2);
		}
	
	//HOMEPAGE
	@RequestMapping("/")
	public String home() {
		System.out.println(getAuthority().toString());
		return "homepage";
	}
	
	//HOMEPAGE
	@RequestMapping("/homepage")
	public String homepage() {
		System.out.println(getAuthority() + " HomePage");
		return "homepage";
	}
	
	//REGISTRATION FORM
	@RequestMapping("/register")
	public String register(ModelMap map) {
		User user = new User();
		map.addAttribute("user", user);
		return "register";
	}
	
	//REGISTER POST METHOD
	@RequestMapping(value = "/registerPost", method = RequestMethod.POST)
	public String registerUser(User user) throws Exception{
		System.out.println(user);
		boolean check = myService.UserExist(user.getEmail());
		if(check) {
			myService.registerUser(user);
			return "homepage";
		}
		else {
			throw new Exception("USER ALREADY EXIST");
		}
	}
	
	//MY PROFILE
	@RequestMapping("/profile")
	public String profile(ModelMap map) {
		User user = myService.myProfile(getCurrentUser());
		map.put("user",user);
		return "profile";
	}
	
	//DELETE USER
		@RequestMapping(value = "/deleteuser",method = RequestMethod.GET)
		public String deleteUser(@RequestParam String email,ModelMap map) {
			List<User> userList = myService.deleteProfile(email);
			map.put("userlist",userList);
			return "allusers";
		}

	//EDIT USER
	@RequestMapping(value = "/edituser",method = RequestMethod.GET)
	public String editUser(@RequestParam String email,ModelMap map) throws Exception{
		User user = myService.myProfile(email);
		System.out.println(getAuthority().toString() + "editUSer");
		if(getAuthority().toString().equals("ADMIN") || getCurrentUser().equals(email)) {
			Userdto userdto = new Userdto();
			userdto.setId(user.getId());
			userdto.setName(user.getName());
			userdto.setEmail(user.getEmail());
			userdto.setMobile(user.getMobile());
			map.addAttribute("userdto", userdto);
			return "edituser";
		}
		else {
			throw new Exception("You are not Authorized for this action");
		}
	}

		
	//UPDATE USER FORM
	@RequestMapping(value = "/updateuser", method = RequestMethod.POST)
	public String updateUser(Userdto userdto) {	
		System.out.println(userdto);
		myService.updateProfile(userdto);
//		map.put("user", userdto);
		return "homepage";
	}
		
	//GET ALL USERS
	@RequestMapping("/allusers")
	public String allUsers(ModelMap map) {
		List<User> userList = myService.allUsers();
		map.put("userlist",userList);
		map.put("session", myUserDetails);
		return "allusers";
	}
}

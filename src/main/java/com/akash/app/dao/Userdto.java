package com.akash.app.dao;

import org.springframework.stereotype.Component;

@Component
public class Userdto {
	
	private int id;
	
	private String name;
	
	private String email;
	
	private String mobile;
	
	

	public Userdto() {
	}

	public Userdto(int id, String name, String email, String mobile) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "Userdto [id=" + id + ", name=" + name + ", email=" + email + ", mobile=" + mobile + "]";
	}
	
	

}

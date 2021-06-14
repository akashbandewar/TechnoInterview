package com.akash.app.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="role")
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="role_id")
	private int role_id;
	
	@Column(name="role")
	private String role;

	public Role(int role_id, String role) {
		super();
		this.role_id = role_id;
		this.role = role;
	}

	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Role [role_id=" + role_id + ", role=" + role + "]";
	}

}

package com.akash.app.dao;

import java.util.Arrays;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="email",unique = true)
	private String email;
	
	@Column(name="mobile")
	private String mobile;
		
	@Column(name="user_password")
	private String userPassword;
	
	private boolean accountVerified = false;
	
	@Column(name = "profileImage", length = 1000)
	private byte[] profileImage;
	
	@OneToMany(mappedBy = "user")
    private Set<SecureToken> tokens;
	
	@ManyToOne()
    @JoinColumn(name = "role_id", referencedColumnName = "role_id")
	private Role role = new Role(2,"USER");
	
	public User() {
	}

	public User(String name, String email, String mobile, String userPassword, byte[] profileImage, Role role) {
		super();
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.userPassword = userPassword;
		this.profileImage = profileImage;
		this.role = role;
	}

	public boolean isAccountVerified() {
		return accountVerified;
	}
	
	public void setAccountVerified(boolean accountVerified) {
		this.accountVerified = accountVerified;
	}
	
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
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

	public String getUserPassword() {
		return userPassword;
	}

	public byte[] getProfileImage() {
		return profileImage;
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

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public void setProfileImage(byte[] profileImage) {
		this.profileImage = profileImage;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", mobile=" + mobile + ", userPassword="
				+ userPassword + ", profileImage=" + Arrays.toString(profileImage) + ", role=" + role + "]";
	}

}

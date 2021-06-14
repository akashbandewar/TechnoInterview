package com.akash.app.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.akash.app.dao.Role;
import com.akash.app.dao.User;
import com.akash.app.dao.Userdto;

@Repository
public interface MyRepository extends JpaRepository<User, Integer> {
	
//	@Query(value= "SELECT u.id,u.name,u.email,u.mobile,u.user_password,u.profile_image FROM user u,role r WHERE u.id = r.id and u.email = ?",nativeQuery = true)
	Optional<User> findByEmail(String email);
	
	@Query(value= "SELECT * from USER where role_id = (select role_id from role where role = 'USER')",nativeQuery = true)
	List<User> getAllUsers();
	
	@Query(value= "SELECT * FROM user WHERE email = ?",nativeQuery = true)
	public User findProfile(String mail);
	
	@Transactional
	@Modifying
	@Query(value= "UPDATE USER SET name = ?, mobile = ? where id = ?",nativeQuery = true)
	void updateProfile(String name, String mobile, int id);
	
	@Transactional
	long deleteByEmail(String email);
	
	@Query(value= "SELECT * FROM role WHERE role_id = ?",nativeQuery = true)
	public Role findByRoleId(int id);
}

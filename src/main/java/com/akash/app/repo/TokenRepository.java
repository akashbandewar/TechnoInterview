package com.akash.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.akash.app.dao.SecureToken;

@Repository
public interface TokenRepository extends JpaRepository<SecureToken,Long>{
	
	SecureToken findByToken(String token);
	
	Long removeByToken(String token);
	
}

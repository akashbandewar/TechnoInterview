package com.akash.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.akash.app.dao.Role;
import com.akash.app.dao.SecureToken;
import com.akash.app.dao.User;
import com.akash.app.dao.Userdto;
import com.akash.app.repo.MyRepository;
import com.akash.app.repo.TokenRepository;

@Service
public class MyService {
	
	@Autowired
	MyRepository myRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
    private JavaMailSender mailSender;
	
    @Autowired
    private SecureTokenService secureTokenService;

    @Autowired
    TokenRepository secureTokenRepository;
    
    
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
		String encodedPass = passwordEncoder.encode(user.getUserPassword());
		user.setUserPassword(encodedPass);
		myRepository.save(user);
		sendRegistrationConfirmationEmail(user);
	}
	
	public void sendRegistrationConfirmationEmail(User user) {
        SecureToken secureToken= secureTokenService.createSecureToken();
        secureToken.setUser(user);
        secureTokenRepository.save(secureToken);
        
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("akash.band@gmail.com");
        message.setTo(user.getEmail());
        message.setSubject("Registration verification Email");
        message.setText("click on the link http://localhost:8080/verifyUser?token="+secureToken.getToken()+" to complete the registration process");
        mailSender.send(message);
	}    
	
	public List<User> deleteProfile(String email) {
		myRepository.deleteByEmail(email);
		return myRepository.getAllUsers();
	}
	
	public void updateProfile(Userdto user) {
		myRepository.updateProfile(user.getName(),user.getMobile(),user.getId());
	}
}

package com.akash.app.dao;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "secureTokens")
public class SecureToken{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String token;

    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp timeStamp;

    @Column(updatable = false)
    @Basic(optional = false)
    private LocalDateTime expireAt;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName ="id")
    private User user;

    @Transient
    private boolean isExpired;
  
    public boolean isExpired() {
        return getExpireAt().isBefore(LocalDateTime.now()); // this is generic implementation, you can always make it timezone specific
    }

	public Long getId() {
		return id;
	}

	public String getToken() {
		return token;
	}

	public Timestamp getTimeStamp() {
		return timeStamp;
	}

	public LocalDateTime getExpireAt() {
		return expireAt;
	}

	public User getUser() {
		return user;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public void setTimeStamp(Timestamp timeStamp) {
		this.timeStamp = timeStamp;
	}

	public void setExpireAt(LocalDateTime expireAt) {
		this.expireAt = expireAt;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setExpired(boolean isExpired) {
		this.isExpired = isExpired;
	}
    
}

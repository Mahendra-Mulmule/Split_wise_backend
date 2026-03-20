package com.Project.Split_wise.Entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Uid;
	private String Uname;
	
	@Column(nullable=false, unique=true)
	private String Uemail;
	
	private String Password;
	
	@CreationTimestamp
	@Column(updatable = false)
	private LocalDateTime CreatedAt;
	
	public User() {
		
	}
	
	public User(int uid, String uname, String uemail, String password, LocalDateTime createdAt) {
		super();
		Uid = uid;
		Uname = uname;
		Uemail = uemail;
		Password = password;
		CreatedAt = createdAt;
	}

	public int getUid() {
		return Uid;
	}

	public void setUid(int uid) {
		Uid = uid;
	}

	public String getUname() {
		return Uname;
	}

	public void setUname(String uname) {
		Uname = uname;
	}

	public String getUemail() {
		return Uemail;
	}

	public void setUemail(String uemail) {
		Uemail = uemail;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public LocalDateTime getCreatedAt() {
		return CreatedAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		CreatedAt = createdAt;
	}
	
	

}

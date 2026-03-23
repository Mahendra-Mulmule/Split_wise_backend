package com.Project.Split_wise.Entity;


import com.fasterxml.jackson.annotation.JsonProperty;

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
	private Integer Uid;
	private String Uname;
	
	@Column(nullable=false, unique=true)
	private String Uemail;
	
	@JsonProperty("password")
	private String Password;
	
	
	public User() {
		
	}


	public Integer getUid() {
		return Uid;
	}


	public void setUid(Integer uid) {
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

	

}

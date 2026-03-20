package com.Project.Split_wise.Service;

import java.util.List;

import com.Project.Split_wise.Entity.User;

public interface UserService {
	
	User registeruser(User user);
	
	List<User>getalluser();
	
	User getuserbyid(Long id);
	
	User updateuser(Long id, User user);
	

}

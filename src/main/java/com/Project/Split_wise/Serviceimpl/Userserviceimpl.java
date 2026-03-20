package com.Project.Split_wise.Serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Project.Split_wise.Entity.User;
import com.Project.Split_wise.Repository.UserRepository;
import com.Project.Split_wise.Service.UserService;

@Service
public class Userserviceimpl implements UserService {

	@Autowired
	private  UserRepository userrepo ;
	
	public Userserviceimpl(UserRepository userrepo) {
		this.userrepo=userrepo;
	}
	
	
	
	@Override
	public User registeruser(User user) {
		// TODO Auto-generated method stub
		return  userrepo.save(user);
	}

	@Override
	public List<User> getalluser() {
		// TODO Auto-generated method stub
		return userrepo.findAll();
	}

	@Override
	public User getuserbyid(Long id) {
		// TODO Auto-generated method stub
		return userrepo.findById(id).orElseThrow(()-> new RuntimeException("user not found "));
	}

	@Override
	public User updateuser(Long id, User user) {
		
		User existinguser=getuserbyid(id);
		
		existinguser.setUname(user.getUname());
		existinguser.setUemail(user.getUemail());
		return userrepo.save(existinguser);
	}

}

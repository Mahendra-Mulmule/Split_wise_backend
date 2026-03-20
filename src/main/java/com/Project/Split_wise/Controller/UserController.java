package com.Project.Split_wise.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Project.Split_wise.Entity.User;
import com.Project.Split_wise.Service.UserService;

@RestController
@RequestMapping("api/users")
public class UserController {
	@Autowired
	private UserService userservice;
	
	@PostMapping
	public User registerUser(@RequestBody User user) {
		return userservice.registeruser(user);
	}
	
	@GetMapping
	public List<User>getAllUsers(){
		return userservice.getalluser();
	}
	@GetMapping("/{id}")
	public User getUserByid(@PathVariable Long id) {
		return userservice.getuserbyid(id);
	}
	
	public User updateuser(@PathVariable Long id, @RequestBody User user) {
		
		return userservice.updateuser(id, user);
	}
}


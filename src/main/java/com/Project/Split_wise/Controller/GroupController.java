package com.Project.Split_wise.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Project.Split_wise.Entity.Group;
import com.Project.Split_wise.Service.GroupService;
import com.Project.Splt_wise.Dto.GroupDto;
@RestController
@RequestMapping("/api/groups")
public class GroupController {
	
	
	@Autowired
    private GroupService groupservice;
	
	@PostMapping
	public Group creatGroup(@RequestBody GroupDto dto) {
		return groupservice.createGroup(dto);
	}
	
	@GetMapping
	public List<Group> getAllGroups(){
		return groupservice.getallGroup();
	}
	@PostMapping("/{groupId}/add/{userId}")
	public String addmember(@PathVariable Long groupId, @PathVariable Long userId) {
		groupservice.addmember(groupId, userId);
		return "member added ";
	}
}

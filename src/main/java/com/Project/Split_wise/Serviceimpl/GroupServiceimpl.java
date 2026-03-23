package com.Project.Split_wise.Serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Project.Split_wise.Entity.Group;
import com.Project.Split_wise.Entity.User;
import com.Project.Split_wise.Repository.GroupRepository;
import com.Project.Split_wise.Repository.UserRepository;
import com.Project.Split_wise.Service.GroupService;
import com.Project.Splt_wise.Dto.GroupDto;

@Service
public class GroupServiceimpl implements GroupService {

	@Autowired
	  private GroupRepository grouprepo;
	@Autowired
	  private UserRepository userrepo;
	
	  
	public GroupServiceimpl(GroupRepository grouprepo, 
							UserRepository userrepo) {
		super();
		this.grouprepo = grouprepo;
		this.userrepo = userrepo;
	}

	
	@Override
	public Group createGroup(GroupDto dto) {
		// TODO Auto-generated method stub
		
		Group group=new Group();
		group.setName(dto.getName());
		
		//member
		List<User> users=userrepo.findAllById(dto.getMemberIds());
		group.setMembers(users);
		
		//createdBy
		
		User createdByuser=userrepo.findById(dto.getCreatedby())
				.orElseThrow(()->new RuntimeException("user not fount"));
		group.setCreatedby(createdByuser);
		return grouprepo.save(group);
	}

	@Override
	public List<Group> getallGroup() {
		// TODO Auto-generated method stub
		return grouprepo.findAll();
	}

	@Override
	public Group getbyGroupid(Long id) {
		// TODO Auto-generated method stub
		return grouprepo.findById(id).orElseThrow(()->
		new RuntimeException("Group not found"));
	}

	@Override
	public void addmember(Long Groupid, Long userid) {
		
		Group group=getbyGroupid(Groupid);
		
		User user=userrepo.findById(userid).orElseThrow(()-> new 
				RuntimeException("user not found "));
		// TODO Auto-generated method stub
		group.getMembers().add(user);
		grouprepo.save(group);
		
	}


}

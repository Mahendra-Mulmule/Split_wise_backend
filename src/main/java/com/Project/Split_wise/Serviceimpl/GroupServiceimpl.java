package com.Project.Split_wise.Serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Project.Split_wise.Entity.Group;
import com.Project.Split_wise.Entity.User;
import com.Project.Split_wise.Repository.GroupRepository;
import com.Project.Split_wise.Repository.UserRepository;
import com.Project.Split_wise.Service.GroupService;

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
	public Group createGroup(Group group) {
		// TODO Auto-generated method stub
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

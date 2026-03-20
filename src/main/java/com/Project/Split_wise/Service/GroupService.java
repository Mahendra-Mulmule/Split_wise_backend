package com.Project.Split_wise.Service;

import java.util.List;

import com.Project.Split_wise.Entity.Group;

public interface GroupService {
	 Group createGroup(Group group);
	 List<Group>getallGroup();
	 Group getbyGroupid(Long id );
	 void addmember(Long Groupid,Long userid);

}

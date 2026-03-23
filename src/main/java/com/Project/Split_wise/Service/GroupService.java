package com.Project.Split_wise.Service;

import java.util.List;

import com.Project.Split_wise.Entity.Group;
import com.Project.Splt_wise.Dto.GroupDto;

public interface GroupService {

	 List<Group>getallGroup();
	 Group getbyGroupid(Long id );
	 void addmember(Long Groupid,Long userid);
	Group createGroup(GroupDto dto);

}

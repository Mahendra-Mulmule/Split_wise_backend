package com.Project.Splt_wise.Dto;

import java.util.List;

public class GroupDto {
	
	 private Long id;
	    private String name;
	    private List<Long> memberIds;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public List<Long> getMemberIds() {
			return memberIds;
		}
		public void setMemberIds(List<Long> memberIds) {
			this.memberIds = memberIds;
		}
	    
	    
}

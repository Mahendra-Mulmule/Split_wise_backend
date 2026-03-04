package com.Project.Split_wise.Entity;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Group {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String name;

	@ManyToOne
@JoinColumn(name="created_by")
	private User createdby;

	@ManyToMany
	@JoinTable(
			name="group_members", 
	joinColumns =@JoinColumn(name="group_id"),
	inverseJoinColumns=@JoinColumn
	(name="user_id"))
	private List<User> members;
	
	@OneToMany(mappedBy ="group" ,cascade=CascadeType.ALL)
	private List<Expence> expences;
	

    @CreationTimestamp
    @Column(updatable = false)
	private LocalDateTime createdAt;
    
    public Group() {
    	
    }

	public Group(int id, String name, User createdby, List<User> members, List<Expence> expences,
			LocalDateTime createdAt) {
		super();
		this.id = id;
		this.name = name;
		this.createdby = createdby;
		this.members = members;
		this.expences = expences;
		this.createdAt = createdAt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getCreatedby() {
		return createdby;
	}

	public void setCreatedby(User createdby) {
		this.createdby = createdby;
	}

	public List<User> getMembers() {
		return members;
	}

	public void setMembers(List<User> members) {
		this.members = members;
	}

	public List<Expence> getExpences() {
		return expences;
	}

	public void setExpences(List<Expence> expences) {
		this.expences = expences;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
    
}

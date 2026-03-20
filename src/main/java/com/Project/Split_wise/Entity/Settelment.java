package com.Project.Split_wise.Entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="settelments")
public class Settelment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name="from_user_id")
	private User fromUser;

	@ManyToOne
	@JoinColumn(name="to_use_id")
	private User toUser;

	private Double amount;

	@ManyToOne
	@JoinColumn(name="group_id")
	private Group group;

	@CreationTimestamp
	private LocalDateTime settledAt;
	
	public Settelment() {
		
	}

	public Settelment(int id, User fromUser, User toUser, Double amount, Group group, LocalDateTime settledAt) {
		super();
		this.id = id;
		this.fromUser = fromUser;
		this.toUser = toUser;
		this.amount = amount;
		this.group = group;
		this.settledAt = settledAt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getFromUser() {
		return fromUser;
	}

	public void setFromUser(User fromUser) {
		this.fromUser = fromUser;
	}

	public User getToUser() {
		return toUser;
	}

	public void setToUser(User toUser) {
		this.toUser = toUser;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public LocalDateTime getSettledAt() {
		return settledAt;
	}

	public void setSettledAt(LocalDateTime settledAt) {
		this.settledAt = settledAt;
	}
	

	
}

package com.Project.Splt_wise.Dto;

import java.util.Map;

import com.Project.Split_wise.Entity.SplitType;

public class ExpenseRequestDto {
	

    private String description;
    private double totalAmount;
    private Long paidByUserId;
    private Long groupId;
    private SplitType splitType;

    // userId → percentage or exact amount
    private Map<Long, Double> splitDetails;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Long getPaidByUserId() {
		return paidByUserId;
	}

	public void setPaidByUserId(Long paidByUserId) {
		this.paidByUserId = paidByUserId;
	}

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	public SplitType getSplitType() {
		return splitType;
	}

	public void setSplitType(SplitType splitType) {
		this.splitType = splitType;
	}

	public Map<Long, Double> getSplitDetails() {
		return splitDetails;
	}

	public void setSplitDetails(Map<Long, Double> splitDetails) {
		this.splitDetails = splitDetails;
	}
    
    

}

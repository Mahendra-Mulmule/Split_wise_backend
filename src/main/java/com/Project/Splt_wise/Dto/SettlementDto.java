package com.Project.Splt_wise.Dto;

public class SettlementDto {

	private Long payerId;
	private Long receiverId;
	private double amount;

	public Long getPayerId() {
		return payerId;
	}

	public void setPayerId(Long payerId) {
		this.payerId = payerId;
	}

	public Long getReceiverId() {
		return receiverId;
	}

	public void setReceiverId(Long receiverId) {
		this.receiverId = receiverId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

}

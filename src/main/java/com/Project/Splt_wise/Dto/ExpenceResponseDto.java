package com.Project.Splt_wise.Dto;

import java.util.List;

public class ExpenceResponseDto {

	  private Long id;
	    private String description;
	    private double totalAmount;
	    private String paidBy;

	    private List<ExpenseSplitDto> splits;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

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

		public String getPaidBy() {
			return paidBy;
		}

		public void setPaidBy(String paidBy) {
			this.paidBy = paidBy;
		}

		public List<ExpenseSplitDto> getSplits() {
			return splits;
		}

		public void setSplits(List<ExpenseSplitDto> splits) {
			this.splits = splits;
		}
	    
	    
}

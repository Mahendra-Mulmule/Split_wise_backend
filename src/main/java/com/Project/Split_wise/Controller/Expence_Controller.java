package com.Project.Split_wise.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Project.Split_wise.Entity.Expence;
import com.Project.Split_wise.Service.ExpenceService;
import com.Project.Splt_wise.Dto.ExpenseRequestDto;

@RestController
@RequestMapping("/api/expenses")
public class Expence_Controller {

	@Autowired
	private ExpenceService Expenceservice;

	@PostMapping
	public String addexpence(@RequestBody ExpenseRequestDto request) {
		Expenceservice.addExpense(request);
		return "Expence added bro";
	}

	@GetMapping
	public List<Expence> getallexpenses() {
		return Expenceservice.getAllExpenses();

	}

	@GetMapping("/group/{groupId}")

	public List<Expence> getGroupExpenses(@PathVariable Long GroupId) {
		return Expenceservice.getGroupExpenses(GroupId);
	}

}

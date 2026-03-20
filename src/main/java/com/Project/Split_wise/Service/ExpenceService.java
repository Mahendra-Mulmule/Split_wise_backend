package com.Project.Split_wise.Service;

import java.util.List;



import com.Project.Split_wise.Entity.Expence;
import com.Project.Splt_wise.Dto.ExpenseRequestDto;

public interface ExpenceService {
	

    void addExpense(ExpenseRequestDto  request);

    List<Expence> getAllExpenses();

    List<Expence> getGroupExpenses(Long groupId);
}

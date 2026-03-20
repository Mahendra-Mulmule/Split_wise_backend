package com.Project.Split_wise.Serviceimpl;

import java.util.ArrayList;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Project.Split_wise.Entity.Expence;
import com.Project.Split_wise.Entity.ExpenceSplit;
import com.Project.Split_wise.Entity.User;
import com.Project.Split_wise.Repository.ExpenceRepository;
import com.Project.Split_wise.Repository.UserRepository;
import com.Project.Split_wise.Service.ExpenceService;
import com.Project.Splt_wise.Dto.ExpenseRequestDto;

@Service
public class ExpenceServiceimpl implements ExpenceService {

    @Autowired
    private ExpenceRepository Expencerepo;

    @Autowired
    private UserRepository userRepository;

    public ExpenceServiceimpl(ExpenceRepository Expencerepo) {
        this.Expencerepo = Expencerepo;
    }

    @Override
    public List<Expence> getAllExpenses() {
        return Expencerepo.findAll();
    }

    @Override
    public List<Expence> getGroupExpenses(Long groupId) {
        return Expencerepo.findByGroup_Id(groupId); // fixed method name
    }

    @Override
    public void addExpense(ExpenseRequestDto request) {

        // 1. Get Paid User
        User paidBy = userRepository.findById(request.getPaidByUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        // 2. Create Expense
        Expence expense = new Expence();
        expense.setDescription(request.getDescription());
        expense.setAmount(request.getTotalAmount());
        expense.setPaidBy(paidBy);
        expense.setSplitType(request.getSplitType());

        List<ExpenceSplit> splitList = new ArrayList<>();

        Map<Long, Double> splitDetails = request.getSplitDetails();

        switch (request.getSplitType()) {

            case EQUAL:
                double equalAmount = request.getTotalAmount() / splitDetails.size();

                for (Long userId : splitDetails.keySet()) {

                    User user = userRepository.findById(userId)
                            .orElseThrow(() -> new RuntimeException("User not found"));

                    ExpenceSplit split = new ExpenceSplit();
                    split.setUser(user);
                    split.setExpense(expense);
                    split.setAmount(equalAmount);

                    splitList.add(split);
                }
                break;

            case PERCENTAGE:
                for (Map.Entry<Long, Double> entry : splitDetails.entrySet()) {

                    User user = userRepository.findById(entry.getKey())
                            .orElseThrow(() -> new RuntimeException("User not found"));

                    double amount = request.getTotalAmount() * entry.getValue() / 100;

                    ExpenceSplit split = new ExpenceSplit();
                    split.setUser(user);
                    split.setExpense(expense);
                    split.setAmount(amount);

                    splitList.add(split);
                }
                break;

            case EXACT:
                for (Map.Entry<Long, Double> entry : splitDetails.entrySet()) {

                    User user = userRepository.findById(entry.getKey())
                            .orElseThrow(() -> new RuntimeException("User not found"));

                    ExpenceSplit split = new ExpenceSplit();
                    split.setUser(user);
                    split.setExpense(expense);
                    split.setAmount(entry.getValue());

                    splitList.add(split);
                }
                break;
        }

        // 3. Set splits
        expense.setSplits(splitList);

        // 4. Save
        Expencerepo.save(expense);
    }


}
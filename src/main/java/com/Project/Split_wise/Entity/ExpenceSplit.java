package com.Project.Split_wise.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="expencesplits")
public class ExpenceSplit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "expense_id")
    private Expence expense;   // ✅ keep this name

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private Double amount;

    private Boolean settled = false;

    public ExpenceSplit() {
    }

    public ExpenceSplit(Long id, Expence expense, User user, Double amount, Boolean settled) {
        this.id = id;
        this.expense = expense;
        this.user = user;
        this.amount = amount;
        this.settled = settled;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Expence getExpense() {
        return expense;
    }

    public void setExpense(Expence expense) {
        this.expense = expense;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Boolean getSettled() {
        return settled;
    }

    public void setSettled(Boolean settled) {
        this.settled = settled;
    }
}
package com.Project.Split_wise.Entity;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="expences")
public class Expence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Double amount;

    // Who paid
    @ManyToOne
    @JoinColumn(name = "paid_by")
    private User paidBy;

    // Expense belongs to ONE group ✅
    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    // Splits
    @OneToMany(mappedBy = "expense", cascade = CascadeType.ALL)
    private List<ExpenceSplit> splits;

    // Split type (EQUAL / EXACT / PERCENTAGE)
    @Enumerated(EnumType.STRING)
    private SplitType splitType;

    // Default Constructor
    public Expence() {
    }

    // Getters and Setters

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

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public User getPaidBy() {
        return paidBy;
    }

    public void setPaidBy(User paidBy) {
        this.paidBy = paidBy;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public List<ExpenceSplit> getSplits() {
        return splits;
    }

    public void setSplits(List<ExpenceSplit> splits) {
        this.splits = splits;
    }

    public SplitType getSplitType() {
        return splitType;
    }

    public void setSplitType(SplitType splitType) {
        this.splitType = splitType;
    }
}
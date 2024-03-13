package com.predana.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

import org.hibernate.annotations.SQLDelete;

@Entity
@Table(name = "p_budget_plan")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SQLDelete(sql = "WHERE p_budget_plan SET deleted = true WHERE budget_id = ?")
public class BudgetPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "budget_id", nullable = false)
    private String id;

    @Column(name = "category_id", nullable = false)
    private String categoryId;

    @Column(name = "user_id", nullable = false)
    private String userId;

    @Column(name = "limit_amount", nullable = false)
    private Double limitAmount;

    @Column(name = "date_created", nullable = false)
    private Date dateCreated;

    private boolean deleted = Boolean.FALSE;
}

package com.predana.model;

import java.util.ArrayList;
import java.util.Date;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import java.util.List;

@Entity
@Table(name = "p_user")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SQLDelete(sql = "UPDATE p_user SET deleted = true WHERE user_id = ?")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "user_id", nullable = false)
    private String id;
   
    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(name = "date_created", nullable = false)
    private Date DateCreated;

    private boolean deleted = Boolean.FALSE;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    List<Category> categories = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    List<Transaction> transactions = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    List<BudgetPlan> budgetPlans = new ArrayList<>();
}

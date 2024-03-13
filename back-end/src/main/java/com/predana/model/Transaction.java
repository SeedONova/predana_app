package com.predana.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

import org.hibernate.annotations.SQLDelete;

@Entity
@Table(name = "p_transaction")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SQLDelete(sql = "UPDATE p_transaction SET deleted = true WHERE transaction_id = ?")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "transaction_id", nullable = false)
    private String id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "category_id")
    private String categoryId;

    @Column(name = "transaction_amount")
    private Double amount;

    @Column(name = "transaction_date")
    private Date date;

    private String description;

    private boolean deleted = Boolean.FALSE;
}

package com.predana.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;

@Entity
@Table (name = "p_category")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SQLDelete(sql = "UPDATE p_category SET delete = true WHERE category_id = ?")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "category_id", nullable = false)
    private String id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "category_name", nullable = false)
    private String categoryName;

    @Column(name = "category_type", nullable = false)
    private String categoryType;

    @Column(name = "category_icon", nullable = false)
    private String categoryIcon;
    
    private boolean deleted = Boolean.FALSE;
}

package com.fpoly.assignmentjava6.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "directories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "categoryCode")
    private String categoryCode;
    @Column(name = "categoryName")
    private String categoryName;
    @Column(name = "categoryStatus")
    private Boolean status;
    @OneToMany(mappedBy = "category")
    private Set<Product> products;
}

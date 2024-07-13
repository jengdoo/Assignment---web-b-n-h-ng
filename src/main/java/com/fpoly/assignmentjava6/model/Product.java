package com.fpoly.assignmentjava6.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "productCode")
    private String productCode;
    @Column(name = "productName")
    private String productName;
    @Column(name = "price")
    private String price;
    @Column(name = "productImage")
    private String productImage;
    @Column(name = "decription")
    private String decription;
    @ManyToOne
    @JoinColumn(name = "category_id",referencedColumnName = "id")
    private Category category;
}

package com.webtechlabs.gestionstock.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product extends AbstractIdentifier {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "price")
    private Double price;

    @Column(name = "quantity", nullable = false)
    private int stockQuantity;

    @Column(name = "alert_threshold", nullable = false)
    private int alertThreshold;

    @Column(name = "image_url")
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "category_uuid", nullable = false)
    private Category category;

    @ManyToOne
    @JoinColumn(name = "company_uuid", nullable = false)
    private Company company;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<StockMovement> stockMovements;

    @ManyToOne
    @JoinColumn(name = "supplier_uuid", nullable = false)
    private Supplier supplier;
}
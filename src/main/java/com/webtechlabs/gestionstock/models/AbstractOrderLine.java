package com.webtechlabs.gestionstock.models;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class AbstractOrderLine extends AbstractIdentifier {

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "unit_price", nullable = false)
    private Double unitPrice;

    @Column(name = "sub_total", nullable = false)
    private Double subTotal;

    @OneToOne
    @JoinColumn(name = "product_uuid", nullable = false)
    private Product product;
}

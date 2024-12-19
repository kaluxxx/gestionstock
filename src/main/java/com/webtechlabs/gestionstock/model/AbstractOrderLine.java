package com.webtechlabs.gestionstock.model;

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
    protected Integer quantity;

    @Column(name = "unit_price", nullable = false)
    protected Double unitPrice;

    @Column(name = "sub_total", nullable = false)
    protected Double subTotal;

    @OneToOne
    @JoinColumn(name = "product_id", nullable = false)
    protected Product product;
}

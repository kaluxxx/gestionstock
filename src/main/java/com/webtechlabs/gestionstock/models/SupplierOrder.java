package com.webtechlabs.gestionstock.models;

import com.webtechlabs.gestionstock.enums.ESupplierOrderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "supplier_orders")
public class SupplierOrder extends AbstractOrder {

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private ESupplierOrderStatus status;

    @Column(name = "reception_date")
    private String receptionDate;
}
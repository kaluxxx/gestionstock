package com.webtechlabs.gestionstock.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "supplier_orders_line")
public class SupplierOrderLine extends AbstractOrderLine {

    @ManyToOne
    @JoinColumn(name = "supplier_order_uuid")
    private SupplierOrder supplierOrder;
}
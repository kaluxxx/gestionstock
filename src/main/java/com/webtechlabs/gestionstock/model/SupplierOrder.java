package com.webtechlabs.gestionstock.model;

import com.webtechlabs.gestionstock.enums.ESupplierOrderStatus;
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
@Table(name = "supplier_orders")
public class SupplierOrder extends AbstractOrder {

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private ESupplierOrderStatus status;

    @Column(name = "reception_date")
    private String receptionDate;

    @OneToMany(mappedBy = "supplierOrder", cascade = CascadeType.ALL)
    private List<SupplierOrderLine> supplierOrderLines;

    @ManyToOne
    @JoinColumn(name = "supplier_uuid")
    private Supplier supplier;
}
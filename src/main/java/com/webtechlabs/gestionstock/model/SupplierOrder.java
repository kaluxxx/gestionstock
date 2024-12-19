package com.webtechlabs.gestionstock.model;

import com.webtechlabs.gestionstock.enums.ESupplierOrderStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
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
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;
}
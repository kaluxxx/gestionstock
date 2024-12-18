package com.webtechlabs.gestionstock.model;

import com.webtechlabs.gestionstock.enums.EOrderStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "orders")
public class Order extends AbstractOrder {

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private EOrderStatus status;

    @Column(name = "delivery_date")
    private Instant deliveryDate;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderLine> orderLines;

    @ManyToOne
    @JoinColumn(name = "customer_uuid")
    private Customer customer;
}
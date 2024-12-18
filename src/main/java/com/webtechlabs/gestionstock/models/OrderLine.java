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
@Table(name = "orders_line")
public class OrderLine extends AbstractOrderLine {

    @ManyToOne
    @JoinColumn(name = "order_uuid")
    private Order order;
}
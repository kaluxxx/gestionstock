package com.webtechlabs.gestionstock.models;

import com.webtechlabs.gestionstock.enums.EStockMovementType;
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
@Table(name = "stock_movements")
public class StockMovement extends AbstractIdentifier {

    @Enumerated(EnumType.STRING)
    @Column(name = "movement_type", nullable = false)
    private EStockMovementType movementType;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "occurred_at", nullable = false)
    private String occurredAt;
}
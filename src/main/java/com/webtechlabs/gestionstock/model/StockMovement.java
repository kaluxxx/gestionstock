package com.webtechlabs.gestionstock.model;

import com.webtechlabs.gestionstock.enums.EStockMovementReason;
import com.webtechlabs.gestionstock.enums.EStockMovementType;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "stock_movements")
public class StockMovement extends AbstractIdentifier {

    @Enumerated(EnumType.STRING)
    @Column(name = "movement_type", nullable = false)
    private EStockMovementType movementType;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "occurred_at", nullable = false)
    private Instant occurredAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "reason", nullable = false)
    private EStockMovementReason reason;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
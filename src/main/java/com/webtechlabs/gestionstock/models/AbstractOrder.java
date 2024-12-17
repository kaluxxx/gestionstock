package com.webtechlabs.gestionstock.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.webtechlabs.gestionstock.enums.EOrderStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AbstractOrder extends AbstractIdentifier {

    @CreatedDate
    @JsonIgnore
    @Column(name = "order_date", nullable = false)
    private Instant orderDate;

    @Column(name = "order_number", nullable = false)
    private String orderNumber;

    @Column(name = "total_amount", nullable = false)
    private Double totalAmount;

    @Column(name = "shipping_date")
    private Instant shippingDate;

    @Column(name = "cancel_date")
    private Instant cancelDate;
}

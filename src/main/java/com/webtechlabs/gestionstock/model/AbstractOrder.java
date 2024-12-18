package com.webtechlabs.gestionstock.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    protected Instant orderDate;

    @Column(name = "order_number", nullable = false)
    protected String orderNumber;

    @Column(name = "total_amount", nullable = false)
    protected Double totalAmount;

    @Column(name = "shipping_date")
    protected Instant shippingDate;

    @Column(name = "cancel_date")
    protected Instant cancelDate;

    @OneToOne
    @JoinColumn(name = "payment_uuid")
    protected Payment payment;
}

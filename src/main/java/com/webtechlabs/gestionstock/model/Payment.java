package com.webtechlabs.gestionstock.model;

import com.webtechlabs.gestionstock.enums.EPaymentMethod;
import com.webtechlabs.gestionstock.enums.EPaymentStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "payments")
public class Payment extends AbstractIdentifier {

    @Column(name = "amount", nullable = false)
    private Double amount;

    @Column(name = "date", nullable = false)
    private Instant date;

    @Enumerated(EnumType.STRING)
    @Column(name = "method", nullable = false)
    private EPaymentMethod method;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private EPaymentStatus status;
}
package com.webtechlabs.gestionstock.model;

import com.webtechlabs.gestionstock.enums.EInvoiceStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "invoices")
public class Invoice extends AbstractIdentifier {

    @Column(name = "invoice_number", nullable = false)
    private String invoiceNumber;

    @Column(name = "amount", nullable = false)
    private Double amount;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private EInvoiceStatus status;

    @Column(name = "issued_date", nullable = false)
    private Instant issuedDate;

    @Column(name = "due_date", nullable = false)
    private Instant dueDate;
}
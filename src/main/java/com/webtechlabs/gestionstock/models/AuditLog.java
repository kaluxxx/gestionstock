package com.webtechlabs.gestionstock.models;

import com.webtechlabs.gestionstock.enums.EAuditActionType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "audit_logs")
public class AuditLog extends AbstractIdentifier {

    @Enumerated(EnumType.STRING)
    @Column(name = "action_type", updatable = false, nullable = false)
    private EAuditActionType actionType;

    @Column(name = "entity_name", updatable = false, nullable = false)
    private String entityName;

    @Column(name = "entity_uuid", updatable = false, nullable = false)
    private String entityUuid;

    @ManyToOne
    @JoinColumn(name = "user_uuid", updatable = false, nullable = false)
    private User user;

    @Column(name = "occurred_at", updatable = false, nullable = false)
    private Instant occurredAt;
}
package com.webtechlabs.gestionstock.model;

import com.webtechlabs.gestionstock.enums.EAuditActionType;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Getter
@Setter
@RequiredArgsConstructor
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
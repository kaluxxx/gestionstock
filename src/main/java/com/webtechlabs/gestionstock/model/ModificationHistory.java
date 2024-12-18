package com.webtechlabs.gestionstock.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "modifications_history")
public class ModificationHistory extends AbstractIdentifier {

    @Column(name = "entity_name", updatable = false, nullable = false)
    private String entityName;

    @Column(name = "entity_uuid", updatable = false, nullable = false)
    private String entityUuid;

    @Column(name = "field_name", updatable = false, nullable = false)
    private String fieldName;

    @Column(name = "old_value", columnDefinition = "TEXT")
    private String oldValue;

    @Column(name = "new_value", columnDefinition = "TEXT")
    private String newValue;

    @Column(name = "modified_at", updatable = false, nullable = false)
    private Instant modifiedAt;

    @ManyToOne
    @JoinColumn(name = "modified_by", updatable = false, nullable = false)
    private User modifiedBy;
}

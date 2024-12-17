package com.webtechlabs.gestionstock.models;

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

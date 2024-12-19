package com.webtechlabs.gestionstock.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;


@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractIdentifier implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, updatable = false, unique = true)
    @Setter(AccessLevel.NONE)
    private UUID uuid = UUID.randomUUID();

    @CreatedDate
    @JsonIgnore
    @Column(name = "created_at", updatable = false, nullable = false)
    protected Instant createdAt;

    @LastModifiedDate
    @JsonIgnore
    @Column(name = "updated_at")
    protected Instant updatedAt;
}

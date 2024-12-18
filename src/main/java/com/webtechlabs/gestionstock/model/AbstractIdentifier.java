package com.webtechlabs.gestionstock.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.Instant;


@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractIdentifier implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "uuid", updatable = false, nullable = false)
    protected String uuid;

    @CreatedDate
    @JsonIgnore
    @Column(name = "created_at", updatable = false, nullable = false)
    protected Instant createdAt;

    @LastModifiedDate
    @JsonIgnore
    @Column(name = "updated_at")
    protected Instant updatedAt;
}

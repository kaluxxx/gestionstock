package com.webtechlabs.gestionstock.models;

import com.webtechlabs.gestionstock.enums.ENotificationType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "notifications")
public class Notification extends AbstractIdentifier {

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private ENotificationType type;

    @Column(name = "message", nullable = false)
    private String message;

    @Column(name = "read", nullable = false)
    private Boolean read = false;

    @ManyToOne
    @JoinColumn(name = "user_uuid", updatable = false, nullable = false)
    private User user;
}

package com.silverfoxmedia.order.domain.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "payments")
public class Payment extends AuditModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private String description;

    @Column(name = "user_id")
    private Long userId;

    @NotNull
    private Double total;

    @Transient
    private User user;

}

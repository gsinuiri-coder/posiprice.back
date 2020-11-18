package com.silverfoxmedia.order.domain.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

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

    public Long getId() {
        return id;
    }

    public Payment setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Payment setDescription(String description) {
        this.description = description;
        return this;
    }

    public Long getUserId() {
        return userId;
    }

    public Payment setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public Double getTotal() {
        return total;
    }

    public Payment setTotal(Double total) {
        this.total = total;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Payment setUser(User user) {
        this.user = user;
        return this;
    }
}

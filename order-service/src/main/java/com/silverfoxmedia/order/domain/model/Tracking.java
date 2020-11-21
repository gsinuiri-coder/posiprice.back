package com.silverfoxmedia.order.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "trackings")
public class Tracking extends AuditModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String place;

    private String status;

    @NotNull
    @Lob
    private String description;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "payment_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Payment payment;

    public Long getId() {
        return id;
    }

    public Tracking setId(Long id) {
        this.id = id;
        return this;
    }

    public String getPlace() {
        return place;
    }

    public Tracking setPlace(String place) {
        this.place = place;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public Tracking setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Tracking setDescription(String description) {
        this.description = description;
        return this;
    }

    public Payment getPayment() {
        return payment;
    }

    public Tracking setPayment(Payment payment) {
        this.payment = payment;
        return this;
    }
}

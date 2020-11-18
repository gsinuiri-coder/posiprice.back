package com.silverfoxmedia.order.resource;

import com.silverfoxmedia.order.domain.model.User;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Lob;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

public class SavePaymentResource {

    @Lob
    private String description;

    @Column(name = "user_id")
    private Long userId;

    @NotNull
    private Double total;

    public String getDescription() {
        return description;
    }

    public SavePaymentResource setDescription(String description) {
        this.description = description;
        return this;
    }

    public Long getUserId() {
        return userId;
    }

    public SavePaymentResource setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public Double getTotal() {
        return total;
    }

    public SavePaymentResource setTotal(Double total) {
        this.total = total;
        return this;
    }

//    @Transient
//    private User user;
}

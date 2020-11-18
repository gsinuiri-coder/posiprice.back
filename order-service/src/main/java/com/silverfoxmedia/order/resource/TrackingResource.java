package com.silverfoxmedia.order.resource;

import com.silverfoxmedia.order.domain.model.AuditModel;

public class TrackingResource extends AuditModel {

    private Long id;
    private String place;
    private String status;
    private String description;

    public Long getId() {
        return id;
    }

    public TrackingResource setId(Long id) {
        this.id = id;
        return this;
    }

    public String getPlace() {
        return place;
    }

    public TrackingResource setPlace(String place) {
        this.place = place;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public TrackingResource setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public TrackingResource setDescription(String description) {
        this.description = description;
        return this;
    }
}

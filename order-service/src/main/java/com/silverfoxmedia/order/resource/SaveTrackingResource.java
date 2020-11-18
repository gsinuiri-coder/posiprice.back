package com.silverfoxmedia.order.resource;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.NotNull;

public class SaveTrackingResource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String place;

    private String status;

    @NotNull
    @Lob
    private String description;

    public Long getId() {
        return id;
    }

    public SaveTrackingResource setId(Long id) {
        this.id = id;
        return this;
    }

    public String getPlace() {
        return place;
    }

    public SaveTrackingResource setPlace(String place) {
        this.place = place;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public SaveTrackingResource setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public SaveTrackingResource setDescription(String description) {
        this.description = description;
        return this;
    }
}

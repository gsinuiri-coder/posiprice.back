package com.silverfoxmedia.customersupport.resource;

import com.silverfoxmedia.customersupport.domain.model.AuditModel;


public class ComplainResource extends AuditModel {

    private Long id;
    private String content;

    public Long getId() {
        return id;
    }

    public ComplainResource setId(Long id) {
        this.id = id;
        return this;
    }

    public String getContent() {
        return content;
    }

    public ComplainResource setContent(String content) {
        this.content = content;
        return this;
    }
}

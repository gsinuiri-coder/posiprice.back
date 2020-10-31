package com.silverfoxmedia.customersupport.resource;

import javax.persistence.Lob;
import javax.validation.constraints.NotNull;

public class SaveComplainResource {

    @NotNull
    @Lob
    private String content;

    public String getContent() {
        return content;
    }

    public SaveComplainResource setContent(String content) {
        this.content = content;
        return this;
    }
}

package com.silverfoxmedia.customersupport.resource;

import com.silverfoxmedia.customersupport.domain.model.AuditModel;

public class UserResource extends AuditModel {

    private Long id;
    private String name;
    private String lastName;
    private String typeUser;

    public Long getId() {
        return id;
    }

    public UserResource setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public UserResource setName(String name) {
        this.name = name;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserResource setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getTypeUser() {
        return typeUser;
    }

    public UserResource setTypeUser(String typeUser) {
        this.typeUser = typeUser;
        return this;
    }
}

package com.silverfoxmedia.customersupport.resource;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SaveUserResource {

    @NotNull
    @Size(max = 100)
    private String name;

    @NotNull
    @Size(max = 100)
    private String lastName;

    @NotNull
    @Size(max = 100)
    private String typeUser;

    public String getName() {
        return name;
    }

    public SaveUserResource setName(String name) {
        this.name = name;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public SaveUserResource setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getTypeUser() {
        return typeUser;
    }

    public SaveUserResource setTypeUser(String typeUser) {
        this.typeUser = typeUser;
        return this;
    }
}

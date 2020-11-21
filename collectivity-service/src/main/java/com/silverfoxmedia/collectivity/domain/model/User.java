package com.silverfoxmedia.collectivity.domain.model;

public class User {
    private Long id;
    private String name;
    private String lastName;
    private String typeUser;

    public Long getId() {
        return id;
    }

    public User setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getTypeUser() {
        return typeUser;
    }

    public User setTypeUser(String typeUser) {
        this.typeUser = typeUser;
        return this;
    }
}

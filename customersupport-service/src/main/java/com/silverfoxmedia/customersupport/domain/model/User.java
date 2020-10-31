package com.silverfoxmedia.customersupport.domain.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 100)
    private String name;

    @NotNull
    @Size(max = 100)
    private String lastName;

    @NotNull
    @Size(max = 100)
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

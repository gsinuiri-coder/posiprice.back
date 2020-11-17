package com.silverfoxmedia.order.domain.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    private Long id;
    private String name;
    private String lastName;
    private String typeUser;
}

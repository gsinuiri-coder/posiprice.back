package com.silverfoxmedia.order.client;

import com.silverfoxmedia.order.domain.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class UserHystrixFallbackFactory implements UserClient{

    @Override
    public ResponseEntity<User> getUser(long id) {
        User user = User.builder()
            .name("none")
            .lastName("none")
            .typeUser("none")
            .build();
        return ResponseEntity.ok(user);
    }
}

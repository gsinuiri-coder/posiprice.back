package com.silverfoxmedia.collectivity.client;

import com.silverfoxmedia.collectivity.domain.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class UserHystrixFallbackFactory implements UserClient {

    @Override
    public ResponseEntity<User> getUser(long id) {
        User user = new User();
        user.setName("none");
        user.setLastName("none");
        user.setTypeUser("none");
        return ResponseEntity.ok(user);
    }
}

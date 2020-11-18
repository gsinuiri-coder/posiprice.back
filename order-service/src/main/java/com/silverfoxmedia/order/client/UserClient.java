package com.silverfoxmedia.order.client;

import com.silverfoxmedia.order.domain.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "customersupport-service", fallback = UserHystrixFallbackFactory.class)
//@RequestMapping("/api")
public interface UserClient  {

    @GetMapping("/api/users/{id}")
    public ResponseEntity<User> getUser(@PathVariable(value = "id") long id);
}

package com.silverfoxmedia.customersupport.domain.repository;

import com.silverfoxmedia.customersupport.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

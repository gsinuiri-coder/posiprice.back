package com.silverfoxmedia.customersupport.domain.repository;

import com.silverfoxmedia.customersupport.domain.model.Complain;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface ComplainRepository extends JpaRepository<Complain, Long> {
        Page<Complain> findByUserId(Long userId, Pageable pageable);
        Optional<Complain> findByIdAndUserId(Long id, Long userId);
        }

package com.silverfoxmedia.order.domain.repository;

import com.silverfoxmedia.order.domain.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long > {
    public List<Payment> findByUserId(Long userId );
}

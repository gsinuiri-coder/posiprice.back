package com.silverfoxmedia.order.domain.repository;

import com.silverfoxmedia.order.domain.model.Tracking;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TrackingRespository extends JpaRepository<Tracking, Long> {

    Page<Tracking> findByPaymentId(Long paymentId, Pageable pageable);
    Optional<Tracking> findByIdAndPaymentId(Long id, Long paymentId);
}

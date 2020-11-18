package com.silverfoxmedia.order.domain.service;

import com.silverfoxmedia.order.domain.model.Tracking;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface TrackingService {

    Page<Tracking> getAllTrackingsByPaymentId(Long paymentId, Pageable pageable);
    Tracking getTrackingByIdAndPaymentId(Long paymentId, Long trackingId);
    Tracking createTracking(Long paymentId, Tracking tracking);
    Tracking updateTracking(Long paymentId, Long trackingId, Tracking trackingDetails);
    ResponseEntity<?> deleteTracking(Long paymentId, Long trackingId);
}

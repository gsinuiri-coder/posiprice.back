package com.silverfoxmedia.order.service;

import com.silverfoxmedia.order.domain.model.Tracking;
import com.silverfoxmedia.order.domain.repository.PaymentRepository;
import com.silverfoxmedia.order.domain.repository.TrackingRespository;
import com.silverfoxmedia.order.domain.service.TrackingService;
import com.silverfoxmedia.order.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TrackingServiceImpl implements TrackingService {

    @Autowired
    private TrackingRespository trackingRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public Page<Tracking> getAllTrackingsByPaymentId(Long paymentId, Pageable pageable) {
        return trackingRepository.findByPaymentId(paymentId, pageable);
    }

    @Override
    public Tracking getTrackingByIdAndPaymentId(Long paymentId, Long trackingId) {
        return trackingRepository.findByIdAndPaymentId(trackingId, paymentId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Tracking not found with Id " + trackingId +
                                " and PaymentId " + paymentId));
    }

    @Override
    public Tracking createTracking(Long paymentId, Tracking tracking) {
        return paymentRepository.findById(paymentId).map(payment -> {
            tracking.setPayment(payment);
            return trackingRepository.save(tracking);
        }).orElseThrow(() -> new ResourceNotFoundException(
                "Payment", "Id", paymentId));
    }

    @Override
    public Tracking updateTracking(Long paymentId, Long trackingId, Tracking trackingDetails) {
        if(!paymentRepository.existsById(paymentId))
            throw new ResourceNotFoundException("Payment", "Id", paymentId);

        return trackingRepository.findById(trackingId).map(tracking -> {
            tracking.setPlace(trackingDetails.getPlace());
            return trackingRepository.save(tracking);
        }).orElseThrow(() -> new ResourceNotFoundException("Tracking", "Id", trackingId));
    }

    @Override
    public ResponseEntity<?> deleteTracking(Long paymentId, Long trackingId) {
        return trackingRepository.findByIdAndPaymentId(trackingId, paymentId).map(tracking -> {
            trackingRepository.delete(tracking);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(
                "Tracking not found with Id " + trackingId + " and PaymentId " + paymentId));
    }
}

package com.silverfoxmedia.order.domain.service;

import com.silverfoxmedia.order.domain.model.Payment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface PaymentService {

    Page<Payment> getAllPayments(Pageable pageable);
    Payment getPaymentById(Long paymentId);
    Payment createPayment(Payment payment);
    Payment updatePayment(Long paymentId, Payment paymentRequest);
    ResponseEntity<?> deletePayment(Long paymentId);
}

package com.silverfoxmedia.order.service;

import com.silverfoxmedia.order.client.ProductCatalogClient;
import com.silverfoxmedia.order.client.UserClient;
import com.silverfoxmedia.order.domain.model.Payment;
import com.silverfoxmedia.order.domain.model.ProductCatalog;
import com.silverfoxmedia.order.domain.model.User;
import com.silverfoxmedia.order.domain.repository.PaymentRepository;
import com.silverfoxmedia.order.domain.service.PaymentService;
import com.silverfoxmedia.order.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    UserClient userClient;

    @Autowired
    ProductCatalogClient productCatalogClient;

    @Override
    public Page<Payment> getAllPayments(Pageable pageable) {
        return paymentRepository.findAll(pageable);
    }

    @Override
    public Payment getPaymentById(Long paymentId) {

        Payment payment = paymentRepository.findById(paymentId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Payment", "Id", paymentId));

        User user = userClient.getUser(payment.getUserId()).getBody();
        ProductCatalog productCatalog = productCatalogClient.getProductCatalog(payment.getProductCatalogId()).getBody();

        payment.setUser(user);
        payment.setProductCatalog(productCatalog);

        return payment;
    }

    @Override
    public Payment createPayment(Payment payment) {

        User user = userClient.getUser(payment.getUserId()).getBody();
        ProductCatalog productCatalog = productCatalogClient.getProductCatalog(payment.getProductCatalogId()).getBody();

        if (user.getId() != null && productCatalog.getId() != null){
            payment.setUser(user);
            payment.setProductCatalog(productCatalog);
            return paymentRepository.save(payment);
        }

        return null;
    }

    @Override
    public Payment updatePayment(Long paymentId, Payment paymentRequest) {
        Payment payment = paymentRepository.findById(paymentId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Payment", "Id", paymentId));

        payment.setDescription(paymentRequest.getDescription());
//        return paymentRepository.save(
//                payment.setDescription(paymentRequest.getDescription())
//                        .setTotal(paymentRequest.getTotal()));

        return paymentRepository.save(payment);
    }

    @Override
    public ResponseEntity<?> deletePayment(Long paymentId) {
        Payment payment = paymentRepository.findById(paymentId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Payment", "Id", paymentId));
        paymentRepository.delete(payment);
        return ResponseEntity.ok().build();
    }
}

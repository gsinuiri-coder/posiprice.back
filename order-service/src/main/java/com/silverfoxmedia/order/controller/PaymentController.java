package com.silverfoxmedia.order.controller;

import com.silverfoxmedia.order.domain.model.Payment;
import com.silverfoxmedia.order.domain.service.PaymentService;
import com.silverfoxmedia.order.resource.PaymentResource;
import com.silverfoxmedia.order.resource.SavePaymentResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "Payments", description = "Payments API")
@RestController
@RequestMapping("/api")
public class PaymentController {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private PaymentService paymentService;

    @Operation(summary = "Get All Payments", description = "Get All available Payments", responses = {
            @ApiResponse(
                    description = "All Payments",
                    responseCode = "200",
                    content = @Content(mediaType = "application/json"))
    })
    @GetMapping("/payments")
    public Page<PaymentResource> getAllPayments(Pageable pageable) {

        Page<Payment> paymentsPage = paymentService.getAllPayments(pageable);
        List<PaymentResource> resources = paymentsPage.getContent()
                .stream().map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @GetMapping("/payments/{paymentId}")
    public PaymentResource getPaymentById(@PathVariable(value = "paymentId") Long paymentId) {
        return convertToResource(paymentService.getPaymentById(paymentId));
    }

    @PostMapping("/payments")
    public PaymentResource createPayment(
            @Valid @RequestBody SavePaymentResource resource) {
        Payment payment = convertToEntity(resource);
        return convertToResource(paymentService.createPayment(payment));

    }

    @PutMapping("/payments/{paymentId}")
    public PaymentResource updatePayment(@PathVariable Long paymentId,
                                   @Valid @RequestBody SavePaymentResource resource) {
        Payment payment = convertToEntity(resource);
        return convertToResource(
                paymentService.updatePayment(paymentId, payment));
    }

    @DeleteMapping("/payments/{paymentId}")
    public ResponseEntity<?> deletePayment(@PathVariable Long paymentId) {
        return paymentService.deletePayment(paymentId);
    }


    private Payment convertToEntity(SavePaymentResource resource) {
        return mapper.map(resource, Payment.class);
    }

    private PaymentResource convertToResource(Payment entity) {
        return mapper.map(entity, PaymentResource.class);
    }

}

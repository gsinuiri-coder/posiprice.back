package com.silverfoxmedia.order.controller;

import com.silverfoxmedia.order.domain.model.Tracking;
import com.silverfoxmedia.order.domain.service.TrackingService;
import com.silverfoxmedia.order.resource.SaveTrackingResource;
import com.silverfoxmedia.order.resource.TrackingResource;
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

@Tag(name = "Trackings", description = "Trackings API")
@RestController
@RequestMapping("/api")
public class TrackingController {

    @Autowired
    private TrackingService trackingService;

    @Autowired
    private ModelMapper mapper;

    @GetMapping("/payments/{paymentId}/trackings")
    public Page<TrackingResource> getAllTrackingsByPaymentId(
            @PathVariable(value = "paymentId") Long paymentId,
            Pageable pageable) {
        Page<Tracking> trackingPage = trackingService.getAllTrackingsByPaymentId(paymentId, pageable);
        List<TrackingResource> resources = trackingPage.getContent().stream()
                .map(this::convertToResource).collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @GetMapping("/payments/{paymentId}/trackings/{trackingId}")
    public TrackingResource getTrackingByIdAndPaymentId(
            @PathVariable(name = "paymentId") Long paymentId,
            @PathVariable(name = "trackingId") Long trackingId) {
        return convertToResource(trackingService.getTrackingByIdAndPaymentId(paymentId, trackingId));
    }

    @PostMapping("/payments/{paymentId}/trackings")
    public TrackingResource createTracking(
            @PathVariable(value = "paymentId") Long paymentId,
            @Valid @RequestBody SaveTrackingResource resource) {
        return convertToResource(trackingService.createTracking(paymentId,
                convertToEntity(resource)));
    }

    @PutMapping("/payments/{paymentId}/trackings/{trackingId}")
    public TrackingResource updateTracking(
            @PathVariable (value = "paymentId") Long paymentId,
            @PathVariable (value = "trackingId") Long trackingId,
            @Valid @RequestBody SaveTrackingResource resource) {
        return convertToResource(trackingService.updateTracking(paymentId, trackingId,
                convertToEntity(resource)));
    }

    @DeleteMapping("/payments/{paymentId}/trackings/{trackingId}")
    public ResponseEntity<?> deleteTracking(
            @PathVariable (value = "paymentId") Long paymentId,
            @PathVariable (value = "trackingId") Long trackingId) {
        return trackingService.deleteTracking(paymentId, trackingId);
    }

    private Tracking convertToEntity(SaveTrackingResource resource) {
        return mapper.map(resource, Tracking.class);
    }

    private TrackingResource convertToResource(Tracking entity) {
        return mapper.map(entity, TrackingResource.class);
    }
}

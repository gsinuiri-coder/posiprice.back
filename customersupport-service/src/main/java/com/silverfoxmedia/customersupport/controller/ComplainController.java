package com.silverfoxmedia.customersupport.controller;

import com.silverfoxmedia.customersupport.domain.model.Complain;
import com.silverfoxmedia.customersupport.domain.service.ComplainService;
import com.silverfoxmedia.customersupport.resource.ComplainResource;
import com.silverfoxmedia.customersupport.resource.SaveComplainResource;
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

@Tag(name = "Complains", description = "Complains API")
@RestController
@RequestMapping("/api")
public class ComplainController {

    @Autowired
    private ComplainService complainService;

    @Autowired
    private ModelMapper mapper;

    @GetMapping("/users/{userId}/complains")
    public Page<ComplainResource> getAllComplainsByUserId(
            @PathVariable(value = "userId") Long userId,
            Pageable pageable) {
        Page<Complain> complainPage = complainService.getAllComplainsByUserId(userId, pageable);
        List<ComplainResource> resources = complainPage.getContent().stream()
                .map(this::convertToResource).collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @GetMapping("/users/{userId}/complains/{complainId}")
    public ComplainResource getComplainByIdAndUserId(
            @PathVariable(name = "userId") Long userId,
            @PathVariable(name = "complainId") Long complainId) {
        return convertToResource(complainService.getComplainByIdAndUserId(userId, complainId));
    }

    @PostMapping("/users/{userId}/complains")
    public ComplainResource createComplain(
            @PathVariable(value = "userId") Long userId,
            @Valid @RequestBody SaveComplainResource resource) {
        return convertToResource(complainService.createComplain(userId,
                convertToEntity(resource)));
    }

    @PutMapping("/users/{userId}/complains/{complainId}")
    public ComplainResource updateComplain(
            @PathVariable (value = "userId") Long userId,
            @PathVariable (value = "complainId") Long complainId,
            @Valid @RequestBody SaveComplainResource resource) {
        return convertToResource(complainService.updateComplain(userId, complainId,
                convertToEntity(resource)));
    }

    @DeleteMapping("/users/{userId}/complains/{complainId}")
    public ResponseEntity<?> deleteComplain(
            @PathVariable (value = "userId") Long userId,
            @PathVariable (value = "complainId") Long complainId) {
        return complainService.deleteComplain(userId, complainId);
    }

    private Complain convertToEntity(SaveComplainResource resource) {
        return mapper.map(resource, Complain.class);
    }

    private ComplainResource convertToResource(Complain entity) {
        return mapper.map(entity, ComplainResource.class);
    }

}

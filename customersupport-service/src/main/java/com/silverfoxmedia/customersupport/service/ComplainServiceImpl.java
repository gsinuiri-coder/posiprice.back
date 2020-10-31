package com.silverfoxmedia.customersupport.service;

import com.silverfoxmedia.customersupport.domain.model.Complain;
import com.silverfoxmedia.customersupport.domain.repository.ComplainRepository;
import com.silverfoxmedia.customersupport.domain.repository.UserRepository;
import com.silverfoxmedia.customersupport.domain.service.ComplainService;
import com.silverfoxmedia.customersupport.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ComplainServiceImpl implements ComplainService {
    @Autowired
    private ComplainRepository complainRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Page<Complain> getAllComplainsByUserId(Long userId, Pageable pageable) {
        return complainRepository.findByUserId(userId, pageable);
    }

    @Override
    public Complain getComplainByIdAndUserId(Long userId, Long complainId) {
        return complainRepository.findByIdAndUserId(complainId, userId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Complain not found with Id " + complainId +
                                " and UserId " + userId));
    }

    @Override
    public Complain createComplain(Long userId, Complain complain) {
        return userRepository.findById(userId).map(user -> {
            complain.setUser(user);
            return complainRepository.save(complain);
        }).orElseThrow(() -> new ResourceNotFoundException(
                "User", "Id", userId));
    }

    @Override
    public Complain updateComplain(Long userId, Long complainId, Complain complainDetails) {
        if(!userRepository.existsById(userId))
            throw new ResourceNotFoundException("User", "Id", userId);

        return complainRepository.findById(complainId).map(complain -> {
            complain.setContent(complainDetails.getContent());
            return complainRepository.save(complain);
        }).orElseThrow(() -> new ResourceNotFoundException("Complain", "Id", complainId));
    }

    @Override
    public ResponseEntity<?> deleteComplain(Long userId, Long complainId) {
        return complainRepository.findByIdAndUserId(complainId, userId).map(complain -> {
            complainRepository.delete(complain);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(
                "Complain not found with Id " + complainId + " and UserId " + userId));
    }
}

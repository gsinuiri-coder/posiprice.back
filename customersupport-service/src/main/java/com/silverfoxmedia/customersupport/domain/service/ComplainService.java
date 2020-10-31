package com.silverfoxmedia.customersupport.domain.service;

import com.silverfoxmedia.customersupport.domain.model.Complain;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface ComplainService {
    Page<Complain> getAllComplainsByUserId(Long userId, Pageable pageable);
    Complain getComplainByIdAndUserId(Long userId, Long commentId);
    Complain createComplain(Long userId, Complain comment);
    Complain updateComplain(Long userId, Long commentId, Complain commentDetails);
    ResponseEntity<?> deleteComplain(Long userId, Long commentId);
}

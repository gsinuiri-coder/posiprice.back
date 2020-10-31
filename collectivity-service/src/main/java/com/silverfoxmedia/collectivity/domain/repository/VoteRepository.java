package com.silverfoxmedia.collectivity.domain.repository;

import com.silverfoxmedia.collectivity.domain.model.Vote;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VoteRepository extends JpaRepository<Vote, Long> {
    Page<Vote> findByUserId(Long userId, Pageable pageable);
    Optional<Vote> findByIdAndUserId(Long id, Long userId);
}

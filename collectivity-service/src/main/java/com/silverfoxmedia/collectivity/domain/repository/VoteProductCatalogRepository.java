package com.silverfoxmedia.collectivity.domain.repository;

import com.silverfoxmedia.collectivity.domain.model.VoteProductCatalog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteProductCatalogRepository extends JpaRepository<VoteProductCatalog, Long> {
}

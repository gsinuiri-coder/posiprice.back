package com.silverfoxmedia.collectivity.domain.service;

import com.silverfoxmedia.collectivity.domain.model.VoteProductCatalog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface VoteProductCatalogService {

    Page<VoteProductCatalog> getAllVoteProductCatalogs(Pageable pageable);
    VoteProductCatalog getVoteProductCatalogById(Long voteProductCatalogId);
    VoteProductCatalog createVoteProductCatalog(VoteProductCatalog voteProductCatalog);
    VoteProductCatalog updateVoteProductCatalog(Long voteProductCatalogId, VoteProductCatalog voteProductCatalogRequest);
    ResponseEntity<?> deleteVoteProductCatalog(Long voteProductCatalogId);
}

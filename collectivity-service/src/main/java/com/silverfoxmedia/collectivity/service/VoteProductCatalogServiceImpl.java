package com.silverfoxmedia.collectivity.service;

import com.silverfoxmedia.collectivity.client.ProductCatalogClient;
import com.silverfoxmedia.collectivity.domain.model.ProductCatalog;
import com.silverfoxmedia.collectivity.domain.model.VoteProductCatalog;
import com.silverfoxmedia.collectivity.domain.repository.VoteProductCatalogRepository;
import com.silverfoxmedia.collectivity.domain.service.VoteProductCatalogService;
import com.silverfoxmedia.collectivity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class VoteProductCatalogServiceImpl implements VoteProductCatalogService {

    @Autowired
    private VoteProductCatalogRepository voteProductCatalogRepository;

//    @Autowired
//    UserClient userClient;

    @Autowired
    ProductCatalogClient productCatalogClient;

    @Override
    public Page<VoteProductCatalog> getAllVoteProductCatalogs(Pageable pageable) {
        return voteProductCatalogRepository.findAll(pageable);
    }

    @Override
    public VoteProductCatalog getVoteProductCatalogById(Long voteProductCatalogId) {

        VoteProductCatalog voteProductCatalog = voteProductCatalogRepository.findById(voteProductCatalogId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "VoteProductCatalog", "Id", voteProductCatalogId));

//        User user = userClient.getUser(voteProductCatalog.getUserId()).getBody();
        ProductCatalog productCatalog = productCatalogClient.getProductCatalog(voteProductCatalog.getProductCatalogId()).getBody();

//        voteProductCatalog.setUser(user);
        voteProductCatalog.setProductCatalog(productCatalog);

        return voteProductCatalog;
    }

    @Override
    public VoteProductCatalog createVoteProductCatalog(VoteProductCatalog voteProductCatalog) {

//        User user = userClient.getUser(voteProductCatalog.getUserId()).getBody();
        ProductCatalog productCatalog = productCatalogClient.getProductCatalog(voteProductCatalog.getProductCatalogId()).getBody();

        if (productCatalog.getId() != null){
//            voteProductCatalog.setUser(user);
            voteProductCatalog.setProductCatalog(productCatalog);
            return voteProductCatalogRepository.save(voteProductCatalog);
        }

        return null;
    }

    @Override
    public VoteProductCatalog updateVoteProductCatalog(Long voteProductCatalogId, VoteProductCatalog voteProductCatalogRequest) {
        VoteProductCatalog voteProductCatalog = voteProductCatalogRepository.findById(voteProductCatalogId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "VoteProductCatalog", "Id", voteProductCatalogId));

        voteProductCatalog.setMinimumVotes(voteProductCatalogRequest.getMinimumVotes());
//        return voteProductCatalogRepository.save(
//                voteProductCatalog.setDescription(voteProductCatalogRequest.getDescription())
//                        .setTotal(voteProductCatalogRequest.getTotal()));

        return voteProductCatalogRepository.save(voteProductCatalog);
    }

    @Override
    public ResponseEntity<?> deleteVoteProductCatalog(Long voteProductCatalogId) {
        VoteProductCatalog voteProductCatalog = voteProductCatalogRepository.findById(voteProductCatalogId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "VoteProductCatalog", "Id", voteProductCatalogId));
        voteProductCatalogRepository.delete(voteProductCatalog);
        return ResponseEntity.ok().build();
    }
}

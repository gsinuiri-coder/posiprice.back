package com.silverfoxmedia.collectivity.controller;

import com.silverfoxmedia.collectivity.domain.model.VoteProductCatalog;
import com.silverfoxmedia.collectivity.domain.service.VoteProductCatalogService;
import com.silverfoxmedia.collectivity.resource.SaveVoteProductCatalogResource;
import com.silverfoxmedia.collectivity.resource.VoteProductCatalogResource;
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

@Tag(name = "Vote Product Catalogs", description = "Vote Produc tCatalogs API")
@RestController
@RequestMapping("/api")
public class VoteProductCatalogController {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private VoteProductCatalogService voteProductCatalogService;

    @Operation(summary = "Get All VoteProductCatalogs", description = "Get All available VoteProductCatalogs", responses = {
            @ApiResponse(
                    description = "All VoteProductCatalogs",
                    responseCode = "200",
                    content = @Content(mediaType = "application/json"))
    })
    @GetMapping("/voteProductCatalogs")
    public Page<VoteProductCatalogResource> getAllVoteProductCatalogs(Pageable pageable) {

        Page<VoteProductCatalog> voteProductCatalogsPage = voteProductCatalogService.getAllVoteProductCatalogs(pageable);
        List<VoteProductCatalogResource> resources = voteProductCatalogsPage.getContent()
                .stream().map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @GetMapping("/voteProductCatalogs/{voteProductCatalogId}")
    public VoteProductCatalogResource getVoteProductCatalogById(@PathVariable(value = "voteProductCatalogId") Long voteProductCatalogId) {
        return convertToResource(voteProductCatalogService.getVoteProductCatalogById(voteProductCatalogId));
    }

    @PostMapping("/voteProductCatalogs")
    public VoteProductCatalogResource createVoteProductCatalog(
            @Valid @RequestBody SaveVoteProductCatalogResource resource) {
        VoteProductCatalog voteProductCatalog = convertToEntity(resource);
        return convertToResource(voteProductCatalogService.createVoteProductCatalog(voteProductCatalog));
    }

    @PutMapping("/voteProductCatalogs/{voteProductCatalogId}")
    public VoteProductCatalogResource updateVoteProductCatalog(@PathVariable Long voteProductCatalogId,
                                         @Valid @RequestBody SaveVoteProductCatalogResource resource) {
        VoteProductCatalog voteProductCatalog = convertToEntity(resource);
        return convertToResource(
                voteProductCatalogService.updateVoteProductCatalog(voteProductCatalogId, voteProductCatalog));
    }

    @DeleteMapping("/voteProductCatalogs/{voteProductCatalogId}")
    public ResponseEntity<?> deleteVoteProductCatalog(@PathVariable Long voteProductCatalogId) {
        return voteProductCatalogService.deleteVoteProductCatalog(voteProductCatalogId);
    }


    private VoteProductCatalog convertToEntity(SaveVoteProductCatalogResource resource) {
        return mapper.map(resource, VoteProductCatalog.class);
    }

    private VoteProductCatalogResource convertToResource(VoteProductCatalog entity) {
        return mapper.map(entity, VoteProductCatalogResource.class);
    }
}

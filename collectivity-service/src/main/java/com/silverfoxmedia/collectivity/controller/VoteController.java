package com.silverfoxmedia.collectivity.controller;


import com.silverfoxmedia.collectivity.domain.model.Vote;
import com.silverfoxmedia.collectivity.domain.service.VoteService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Tag(name = "Votes", description = "Votes API")
@RestController
@RequestMapping("/api")
public class VoteController {

    @Autowired
    VoteService voteService;
    
    // -------------------Retrieve All Votes--------------------------------------------
    @GetMapping
    public ResponseEntity<List<Vote>> listAllVotes() {
        List<Vote> votes = voteService.findVoteAll();
        if (votes.isEmpty()) {
            return  ResponseEntity.noContent().build();
        }
        return  ResponseEntity.ok(votes);
    }


    // -------------------Create a Vote-------------------------------------------
    @PostMapping
    public ResponseEntity<Vote> createVote(@Valid @RequestBody Vote vote, BindingResult result) {
//        log.info("Creating Vote : {}", vote);
//        if (result.hasErrors()){
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, this.formatMessage(result));
//        }
        Vote voteDB = voteService.createVote (vote);

        return  ResponseEntity.status( HttpStatus.CREATED).body(voteDB);
    }
}

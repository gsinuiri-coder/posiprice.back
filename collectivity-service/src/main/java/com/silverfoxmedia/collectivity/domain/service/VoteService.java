package com.silverfoxmedia.collectivity.domain.service;

import com.silverfoxmedia.collectivity.domain.model.Vote;

import java.util.List;

public interface VoteService {
//    Page<Vote> getAllVotesByUserId(Long userId, Pageable pageable);
//    Vote getVoteByIdAndUserId(Long userId, Long voteId);
//    Vote createVote(Long userId, Vote vote);
//    Vote updateVote(Long userId, Long voteId, Vote voteDetails);
//    ResponseEntity<?> deleteVote(Long userId, Long voteId);

    public List<Vote> findVoteAll();

    public Vote createVote(Vote vote);
}

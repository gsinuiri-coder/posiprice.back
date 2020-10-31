package com.silverfoxmedia.collectivity.service;

import com.silverfoxmedia.collectivity.client.UserClient;
import com.silverfoxmedia.collectivity.domain.model.User;
import com.silverfoxmedia.collectivity.domain.model.Vote;
import com.silverfoxmedia.collectivity.domain.repository.VoteRepository;
import com.silverfoxmedia.collectivity.domain.service.VoteService;
import com.silverfoxmedia.collectivity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class VoteServiceImpl implements VoteService {


    @Autowired
    private VoteRepository voteRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    UserClient userClient;

    @Override
    public Page<Vote> getAllVotesByUserId(Long userId, Pageable pageable) {
        return voteRepository.findByUserId(userId, pageable);
    }

    @Override
    public Vote getVoteByIdAndUserId(Long userId, Long voteId) {
        return voteRepository.findByIdAndUserId(voteId, userId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Vote not found with Id " + voteId +
                                " and UserId " + userId));
    }
    @Override
    public Vote createVote(Long userId, Vote vote) {

        return userClient.getUser(userId).map(user -> {
            vote.setUser(user);
            return voteRepository.save(vote);
        }).orElseThrow(() -> new ResourceNotFoundException(
                "User", "Id", userId));

    }

    @Override
    public Vote updateVote(Long userId, Long voteId, Vote voteDetails) {
        if(!userRepository.existsById(userId))
            throw new ResourceNotFoundException("User", "Id", userId);

        return voteRepository.findById(voteId).map(vote -> {
            vote.setVoteMinimun(voteDetails.getVoteMinimun());
            return voteRepository.save(vote);
        }).orElseThrow(() -> new ResourceNotFoundException("Vote", "Id", voteId));
    }

    @Override
    public ResponseEntity<?> deleteVote(Long userId, Long voteId) {
        return voteRepository.findByIdAndUserId(voteId, userId).map(vote -> {
            voteRepository.delete(vote);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(
                "Vote not found with Id " + voteId + " and UserId " + userId));
    }
}

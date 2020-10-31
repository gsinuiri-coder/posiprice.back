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

import java.util.List;

@Service
public class VoteServiceImpl implements VoteService {

    @Autowired
    VoteRepository voteRepository;

    @Autowired
    UserClient userClient;

    @Override
    public List<Vote> findVoteAll() {
        return  voteRepository.findAll();
    }


    @Override
    public Vote createVote(Vote vote) {
        Vote voteDB = new Vote();

        voteDB = voteRepository.save(vote);

        return voteDB;
    }

}

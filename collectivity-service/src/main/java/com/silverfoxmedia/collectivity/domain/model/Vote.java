package com.silverfoxmedia.collectivity.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

public class Vote extends AuditModel {

    @NotNull
    private Short voteMinimun;

    @Column(name = "user_id")
    private Long userId;

//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "user_id", nullable = false)
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    @JsonIgnore
//    private User user;

    public Short getVoteMinimun() {
        return voteMinimun;
    }

    public Vote setVoteMinimun(Short voteMinimun) {
        this.voteMinimun = voteMinimun;
        return this;
    }


    public Long getUserId() {
        return userId;
    }

    public Vote setUserId(Long userId) {
        this.userId = userId;
        return this;
    }
}

package com.silverfoxmedia.collectivity.domain.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "votes")
public class Vote extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    public Long getId() {
        return id;
    }

    public Vote setId(Long id) {
        this.id = id;
        return this;
    }
}

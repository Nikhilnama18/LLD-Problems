package org.nikhil.models;

import org.nikhil.enums.VoteType;

public class Vote {
    private VoteType vote;
    private User voter;

    public Vote( User voter, VoteType vote) {
        this.vote = vote;
        this.voter = voter;
    }

    public User getVoter() {
        return voter;
    }

    public VoteType getVote() {
        return vote;
    }
}

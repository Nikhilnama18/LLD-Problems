package org.nikhil.models;

import org.nikhil.enums.VoteType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Answer {
    private Integer id;
    private User author;
    private String answer;
    private Map<Integer,Vote> votes;
    private List<Comment> comments;

    private static Integer idGenerator = 1;

    public Answer(String answer, User author) {
        this.id = idGenerator++;
        this.answer = answer;
        this.author = author;
        this.comments = new ArrayList<>();
        this.votes = new HashMap<>();
    }

    public void addVote(VoteType voteType, User voter) {
        if (voter.getId() == author.getId()) {
            throw new IllegalArgumentException("Cannot vote on your own question");
        }
        if (votes.containsKey(voter.getId())) {
            throw new IllegalArgumentException("Already voted on this question");
        }
        votes.put(voter.getId(), new Vote(voter, voteType));
    }

    public void addComment(Comment cmt){
        this.comments.add(cmt);
    }
}

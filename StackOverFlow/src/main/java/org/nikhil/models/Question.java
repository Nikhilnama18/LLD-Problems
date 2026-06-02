package org.nikhil.models;

import org.nikhil.enums.VoteType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Question {
    private Integer id;
    private String title;
    private String description;
    private User author;
    private List<Tag> tags;
    private Map<Integer, Vote> votes;
    private List<Comment> comments;
    private List<Answer> answers;

    private static Integer idGenerator = 1;

    public Integer getId() {
        return id;
    }

    public Question(String title, String description, User author, List<Tag> tags) {
        this.id= idGenerator++;
        this.title = title;
        this.description = description;
        this.author = author;
        this.tags = tags;

        this.comments = new ArrayList<>();
        this.votes = new HashMap<>();
        this.answers = new ArrayList<>();
    }

    public Answer addAnswer(String answer,User author){
        Answer ans = new Answer(answer, author);
        answers.add(ans);
        return ans;
    }

    public void addComment(Comment comment){
        this.comments.add(comment);
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

    public User getAuthor() {
        return author;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }
}


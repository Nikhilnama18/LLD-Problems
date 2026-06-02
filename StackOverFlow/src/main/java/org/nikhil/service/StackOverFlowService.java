package org.nikhil.service;

import org.nikhil.enums.VoteType;
import org.nikhil.models.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StackOverFlowService {
    private Map<Integer, User> users;
    private Map<Integer, Question> questions;

    public StackOverFlowService() {
        this.users = new HashMap<>();
        this.questions = new HashMap<>();
    }

    public User createUser(String name, String email){
        User user = new User(name, email);
        users.put(user.getId(), user);
        return  user;
    }

    public Question createQuestion(User author, String title, String description, List<String> tagNames){

        List<Tag> tags = tagNames.stream()
                .map(Tag::new).collect(Collectors.toList());
        Question qu = new Question(title,description, author , tags);
        questions.put(qu.getId(), qu);
        author.addQuestion(qu);
        return qu;
    }

    public Answer createAnswer(Question question, User author, String answer){
        Answer ans = question.addAnswer(answer, author);
        author.addAnswer(ans);
        return ans;
    }


    public Comment addCommentToQuestion(Question question, User author, String comment){
        Comment cmt =new Comment(comment, author);
        question.addComment(cmt);
        return cmt;
    }

    public Comment addCommentToAnswer(Answer answer, User author, String body){
        Comment cmt = new Comment(body, author);
        answer.addComment(cmt);
        return cmt;
    }

    public void voteQuestion(Question question, User author, VoteType type){
        question.addVote(type, author);
    }

    public void voteAnswer(Answer answer, User voter, VoteType voteType){
        answer.addVote(voteType, voter);
    }

 }

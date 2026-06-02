package org.nikhil.models;

import java.util.ArrayList;
import java.util.List;

public class User {
    private Integer id;
    private String name;
    private String email;
    private List<Question> questions;
    private List<Answer> answers;

    private static Integer idGenerator = 1;

    public Integer getId() {
        return id;
    }

    public User(String name, String email) {
        this.id = idGenerator++;
        this.name = name;
        this.email = email;
        this.questions = new ArrayList<>();
        this.answers = new ArrayList<>();
    }

    public void addQuestion(Question question){
        this.questions.add(question);
    }

    public void addAnswer(Answer answer){
        this.answers.add(answer);
    }
}

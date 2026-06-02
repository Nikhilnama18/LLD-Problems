package org.nikhil.models;

public class Comment {
    private Integer id;
    private String comment;
    private User author;

    private static Integer idCounter = 1;

    public Comment(String comment, User author) {
        this.id = idCounter++;
        this.comment = comment;
        this.author = author;
    }

    public Integer getId() {
        return id;
    }

    public String getComment() {
        return comment;
    }
}

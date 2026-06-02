package org.nikhil.entities;

public class Player {
    private Integer id;
    private String name;
    private Integer position;

    private static Integer autoId =1;

    public Player(String name){
        this.id = autoId;
        this.name = name;
        this.position = 0;
        autoId++;
    }

    public String getName() {
        return name;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }
}

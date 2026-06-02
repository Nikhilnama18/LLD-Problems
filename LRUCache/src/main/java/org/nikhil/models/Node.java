package org.nikhil.models;

public class Node{
    private String key;
    private String value;

    Node prev;
    Node next;

    public void setValue(String value) {
        this.value = value;
    }

    public Node(String key, String value) {
        this.key = key;
        this.value = value;
        this.prev = null;
        this.next = null;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public Node getPrev() {
        return prev;
    }

    public Node getNext() {
        return next;
    }
}

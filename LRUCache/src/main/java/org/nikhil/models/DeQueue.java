package org.nikhil.models;

public class DeQueue {
    private Node head;
    private Node tail;


    public DeQueue(){
        this.head = null;
        this.tail = null;
    }

    public Node addFront(String key, String value){
        Node node = new Node(key, value);

        if(head == null){
            head = node;
            tail = node;
            return node;
        }

        node.next = head;
        head.prev = node;
        head = node;
        return node;
    }

    public Node removeLast(){
        if(tail == null){
            throw new IllegalArgumentException("Cache is empty");
        }

        if(head == tail){
            Node node = head;
            head = null;
            tail = null;
            return node;
        }

        Node node = tail;
        tail = tail.prev;
        tail.next = null;
        return  node;
    }

    public void moveToFront(Node node) {
        if (node == head) {
            return;
        }

        if (node == tail) {
            tail = node.prev;
        }

        node.prev.next = node.next;

        if (node.next != null) {
            node.next.prev = node.prev;
        }

        node.prev = null;
        node.next = head;
        head.prev = node;
        head = node;
    }
}

package org.nikhil.models;

import java.util.*;

public class Cache {
    private Integer capacity;
    private Map<String, Node> cache;
    private DeQueue deQueue;

    public Cache(Integer capacity) {

        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than 0");
        }

        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.deQueue = new DeQueue();
    }

    public void add(String key, String value){

        if(cache.containsKey(key)){
          Node node = cache.get(key);
          node.setValue(value);
          deQueue.moveToFront(node);
          return ;
        } else if(cache.size() == capacity){
            Node removedNode = deQueue.removeLast();
            cache.remove(removedNode.getKey());
        }

        Node node = deQueue.addFront(key, value);
        cache.put(key, node);
    }

    public String getValueForKey(String key){
        if(!cache.containsKey(key)){
            throw new IllegalArgumentException("Key doesn't exists");
        }

        Node node = cache.get(key);
        deQueue.moveToFront(node);

        return node.getValue();
    }
}

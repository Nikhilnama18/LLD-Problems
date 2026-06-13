package org.nikhil.entities;

import java.util.UUID;

public class Product {
    private String  id;
    private final String name;
    private int price;

    public Product(String name, int price) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}

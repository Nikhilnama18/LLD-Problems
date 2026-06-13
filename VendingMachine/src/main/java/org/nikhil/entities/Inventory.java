package org.nikhil.entities;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Inventory {
    private Map<String, Integer> stock; // product name to quantity mapping
    private Map<String, Product> products; // product name to product mapping

    public Inventory() {
        this.stock = new ConcurrentHashMap<>();
        this.products = new ConcurrentHashMap<>();
    }

    public void reStockProduct(String productName, Integer quantity) {
        if(!stock.containsKey(productName)){
            throw new IllegalArgumentException("Product doesn't exist");
        }
        stock.compute(productName, (k, curStock) -> curStock + quantity);
    }

    public void addNewProduct(Product product, Integer initialQuantity){
        if(products.containsKey(product.getName())){
            throw new IllegalArgumentException("Product already exists");
        }

        stock.put(product.getName(), initialQuantity);
        products.put(product.getName(), product);
    }

    public boolean isAvailable(String productName){
        if(!stock.containsKey(productName)){
            throw new IllegalArgumentException("Product doesn't exist");
        }
        return stock.get(productName) != 0;
    }

    public Product getProduct(String productName){
        if(!products.containsKey(productName)){
            throw new IllegalArgumentException("Product doesn't exist");
        }

        return products.get(productName);
    }

    public void displayProducts() {
        for(Product product : products.values()){
            System.out.println(
                            product.getName() + " - ₹" +
                            product.getPrice() + " - Qty: " +
                            stock.get(product.getName())
            );
        }
    }

    public void reduceQuantity(String productName){
        stock.compute(productName, (key,oldQty)-> oldQty - 1);
    }
}

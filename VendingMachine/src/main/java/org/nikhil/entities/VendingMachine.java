package org.nikhil.entities;

import org.nikhil.state.IdleState;
import org.nikhil.state.VendingMachineState;

public class VendingMachine {
    private static volatile VendingMachine instance;
    private VendingMachineState currentState;
    private Inventory inventory;
    private Product selectedProduct;
    private Integer totalAmount;
    private Integer balance;

    private VendingMachine() {
        this.inventory = new Inventory();
        this.currentState = new IdleState();
    }

    public static VendingMachine getInstance() {
        if (instance == null) {
            synchronized (VendingMachine.class) {
                if (instance == null) {
                    instance = new VendingMachine();
                }
            }
        }

        return instance;
    }


    public void addNewProduct(String name, int price, Integer quantity){
        Product newProduct = new Product(name, price);
        inventory.addNewProduct(newProduct, quantity);
    }

    public void restockProduct(Product product, Integer quantity){
        inventory.reStockProduct(product.getName(), quantity);
    }

    public void selectProduct(String productCode) {
        currentState.selectProduct(this, productCode);
    }

    public void insertMoney(int amount) {
        currentState.insertMoney(this, amount);
    }

    public void dispenseProduct() {
        currentState.dispenseProduct(this);
    }

    public void displayProducts() {
        inventory.displayProducts();
    }

    public void cancel() {
        currentState.cancel(this);
    }

    public void setState(VendingMachineState vendingMachineState){
        this.currentState = vendingMachineState;
    }

    public void setSelectedProduct(Product product){
        this.selectedProduct =product;
    }

    public void resetMachine(){
        this.selectedProduct = null;
        this.balance = 0;
    }

    public Product getSelectedProduct(){
        return this.selectedProduct;
    }

    public void insertAmount(Integer amount){
        this.balance+=amount;
    }

    public Inventory getInventory(){
        return inventory;
    }

    public Integer getInsertedAmount(){
        return balance;
    }
}

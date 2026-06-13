package org.nikhil.state;

import org.nikhil.entities.Product;
import org.nikhil.entities.VendingMachine;

public class IdleState implements VendingMachineState{

    @Override
    public void selectProduct(VendingMachine machine, String productName) {
        if(!machine.getInventory().isAvailable(productName)){
            throw new IllegalStateException("Product out of stock");
        }
        Product product = machine.getInventory().getProduct(productName);
        machine.setSelectedProduct(product);
        machine.setState(new ProductSelectedState());
        System.out.println("Selected Product is " + productName);
        return ;
    }

    @Override
    public void insertMoney(VendingMachine machine, int amount) {
        System.out.println("Please select the product first");
    }

    @Override
    public void dispenseProduct(VendingMachine machine) {
        System.out.println("Please select the product first");
    }

    @Override
    public void cancel(VendingMachine machine) {
        System.out.println("No active transaction to cancel");
    }
}

package org.nikhil.state;

import org.nikhil.entities.Product;
import org.nikhil.entities.VendingMachine;

public class PaymentState implements VendingMachineState{
    @Override
    public void selectProduct(VendingMachine machine, String productName) {
        throw new IllegalStateException("Product already selected, cancel this transaction to start from beginning");
    }

    @Override
    public void insertMoney(VendingMachine machine, int amount) {
        if(amount<=0){
            throw new IllegalStateException("Amount must be greater than 0");
        }

        machine.insertAmount(amount);
        System.out.println("Inserted amount " + amount);
    }

    @Override
    public void dispenseProduct(VendingMachine machine) {
        Product product = machine.getSelectedProduct();

        if(product.getPrice() < machine.getInsertedAmount()){
            double remaining = machine.getInsertedAmount() -product.getPrice();
            throw new IllegalStateException("Insufficient funds, Insert " + remaining + " more");
        }
        machine.setState(new DispenseState());
        machine.dispenseProduct();
    }

    @Override
    public void cancel(VendingMachine machine) {
        int refundAmount = machine.getInsertedAmount();

        machine.resetMachine();
        machine.setState(new IdleState());

        System.out.println("Transaction cancelled, Refunded " + refundAmount);
    }
}

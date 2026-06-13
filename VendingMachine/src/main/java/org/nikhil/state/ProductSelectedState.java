package org.nikhil.state;

import org.nikhil.entities.VendingMachine;

public class ProductSelectedState implements VendingMachineState{
    @Override
    public void selectProduct(VendingMachine machine, String productName) {
        throw new IllegalStateException("Product already selected");
    }

    @Override
    public void insertMoney(VendingMachine machine, int amount) {
        if(amount<=0){
            throw new IllegalStateException("Amount must be greater than 0");
        }

        machine.insertAmount(amount);
        machine.setState(new PaymentState());
        System.out.println("Inserted amount " + amount);
    }

    @Override
    public void dispenseProduct(VendingMachine machine) {
        System.out.println("Insert amount first");
    }

    @Override
    public void cancel(VendingMachine machine) {
        machine.resetMachine();
        machine.setState(new IdleState());
        System.out.println("Transaction cancelled");
    }
}

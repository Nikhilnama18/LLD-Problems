package org.nikhil.state;

import org.nikhil.entities.Product;
import org.nikhil.entities.VendingMachine;

public class DispenseState implements VendingMachineState{
    @Override
    public void selectProduct(VendingMachine machine, String productName) {
        throw new IllegalStateException("Machine is dispensing product");
    }

    @Override
    public void insertMoney(VendingMachine machine, int amount) {
        throw new IllegalStateException("Machine is dispensing product");
    }

    @Override
    public void dispenseProduct(VendingMachine machine) {
        Product product = machine.getSelectedProduct();

        machine.getInventory().reduceQuantity(product.getName());
        int reamining = machine.getInsertedAmount() - product.getPrice();

        System.out.println("Dispensed product: " + product.getName());

        if (reamining > 0) {
            System.out.println("Returned change: ₹" + reamining);
        }

        machine.resetMachine();
        machine.setState(new IdleState());
    }

    @Override
    public void cancel(VendingMachine machine) {
        throw new IllegalStateException("Cannot cancel while dispensing");
    }
}

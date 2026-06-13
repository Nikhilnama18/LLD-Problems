package org.nikhil.state;

import org.nikhil.entities.VendingMachine;

public interface VendingMachineState {
    public void selectProduct(VendingMachine machine, String productName);
    public void insertMoney(VendingMachine machine, int amount);
    public void dispenseProduct(VendingMachine machine);
    public void cancel(VendingMachine machine);
}

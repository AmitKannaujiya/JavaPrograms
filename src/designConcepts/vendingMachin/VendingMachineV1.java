package designConcepts.vendingMachin;

import java.util.HashMap;
import java.util.Set;

public class VendingMachineV1 {
    private HashMap<String, Double> productPricing ;
    private HashMap<String, Set<String>> productCodeItem;
    private State state;

    private double totalCost;

    public VendingMachineV1(State state) {
        this.totalCost = 0;
        this.state = state;
    }

    public void  collectCash(double cash) {
        switch (state) {
            case READY:
                handleCollectCash(cash);
                break;
            case CASH_DESPENSE:
                System.out.println("Can't despense cash");
                break;
            case TRANSACTION_CANCEL:
                System.out.println("Can't cancel transaction");
                break;
            case ITEM_DESPENSE:
                System.out.println("Can't cancel transaction");
                break;
            default:
                System.out.println("No option");
        }
    }

    public void despsenseItem(String productCode) {
        switch (state) {
            case READY:
                throw new RuntimeException("Unable to dispense Item. Cash not collected");
            case CASH_DESPENSE:
                handleDispenseChange(productCode);
                break;
            case ITEM_DESPENSE:
                handleDispenseItem(productCode);
                break;
            case TRANSACTION_CANCEL:
                throw new RuntimeException("Transaction cancelled. Unable to dispense Item");

        }
    }


    private void handleCollectCash(double cash) {
        this.totalCost += cash;
    }

    private void handleDispenseItem(String productCode) {
        // logic to dispense item
    }

    private void handleDispenseChange(String productCode) {
        // logic to dispense Change
    }

}

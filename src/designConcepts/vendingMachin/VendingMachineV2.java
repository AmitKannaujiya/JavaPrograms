package designConcepts.vendingMachin;

import java.util.HashMap;
import java.util.Set;

public class VendingMachineV2 {
    private double collectCash;
    private State state;
    private HashMap<String, Set<String>> productCodeItemMap;
    private HashMap<String, Double> productCodePriceMap;

    private IStateChange stateChange;
    private double totalCash;

    public VendingMachineV2 setProductCodeItem(HashMap<String,Set<String>> map) {
        this.productCodeItemMap = map;
        return this;
    }

    public VendingMachineV2 setProductCodePriceMap(HashMap<String, Double> map) {
        this.productCodePriceMap = map;
        return this;
    }

    public void addCollectedCash(double collectedCash) {
        this.collectCash += collectedCash;
        this.totalCash += collectedCash;
    }

    public VendingMachineV2 setCollectedCash(double collectedCash) {
        this.collectCash = collectedCash;
        this.totalCash += collectedCash;
        return this;
    }

    public State getState() {
        return state;
    }

    public IStateChange getCurrentState() {
        return stateChange;
    }


    public VendingMachineV2 setState(State state) {
        this.state = state;
        return this;
    }
    public VendingMachineV2 setCurrentState(IStateChange stateChange) {
        this.stateChange = stateChange;
        return this;
    }

    public boolean removeProduct(String productCode) {
        boolean response = false;
        if(productCodeItemMap.containsKey(productCode)) {
             response = productCodeItemMap.remove(productCode) != null ? true : false;
        }
        if(productCodePriceMap.containsKey(productCode)) {
            response &= productCodePriceMap.remove(productCode) != null ? true : false;
        }
        return response;
    }

    public void dispenseChange(String productCode) {
        this.stateChange.dispenseChange(productCode);
    }

    public void cancelTransaction() {
        this.stateChange.cancelTransaction();
    }

    public double calculateChange(String productCode) {
        this.totalCash -= productCodePriceMap.get(productCode);
        return collectCash - productCodePriceMap.get(productCode);
    }

    public void dispenseItem(String productCode) {
        this.stateChange.dispenseItem(productCode);
    }

    public double getCollectedCash() {
        return collectCash;
    }
}

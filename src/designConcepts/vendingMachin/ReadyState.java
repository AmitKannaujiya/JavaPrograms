package designConcepts.vendingMachin;

public class ReadyState implements IStateChange {
    private VendingMachineV2 vendingMachineV2;
    ReadyState(VendingMachineV2 vendingMachineV2) {
        this.vendingMachineV2 = vendingMachineV2;
    }
    @Override
    public void collectCash(double cash) {
        System.out.println("Collected cash : " + cash);
        this.vendingMachineV2.addCollectedCash(cash);
    }

    @Override
    public void dispenseChange(String productCode) {
        this.vendingMachineV2.setCurrentState(new DespenseChange(this.vendingMachineV2));
        this.vendingMachineV2.dispenseChange(productCode);
    }

    @Override
    public void dispenseItem(String productCode) {

    }

    @Override
    public void cancelTransaction() {
        this.vendingMachineV2.setCurrentState(new TransactionCancel(vendingMachineV2));
        this.vendingMachineV2.cancelTransaction();
    }
}

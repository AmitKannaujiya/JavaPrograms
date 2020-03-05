package designConcepts.vendingMachin;

public class TransactionCancel implements IStateChange {
    private VendingMachineV2 vendingMachineV2;
    TransactionCancel(VendingMachineV2 vendingMachineV2) {
        this.vendingMachineV2 = vendingMachineV2;
    }
    @Override
    public void collectCash(double cash) {
        throw new RuntimeException("Can't Collect cash Now");
    }

    @Override
    public void dispenseChange(String productCode) {
        throw new RuntimeException("Can't dispanse cash Now");
    }

    @Override
    public void dispenseItem(String productCode) {
        throw new RuntimeException("Can't dispance Item now");
    }

    @Override
    public void cancelTransaction() {
        System.out.println("Returned collected :" + vendingMachineV2.getCollectedCash() + " ");
        this.vendingMachineV2.setCollectedCash(0);
        this.vendingMachineV2.setCurrentState(new ReadyState(vendingMachineV2));
    }
}

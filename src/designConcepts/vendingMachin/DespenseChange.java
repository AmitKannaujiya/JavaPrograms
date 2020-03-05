package designConcepts.vendingMachin;

public class DespenseChange implements IStateChange {
    private VendingMachineV2 vendingMachineV2;
    public DespenseChange(VendingMachineV2 vendingMachineV2) {
        this.vendingMachineV2 = vendingMachineV2;
    }

    @Override
    public void collectCash(double cash) {
        throw new RuntimeException("Can't collect cash");
    }

    @Override
    public void dispenseChange(String productCode) {
        double change = this.vendingMachineV2.calculateChange(productCode);
        System.out.println("Change is : " + change);
        this.vendingMachineV2.dispenseItem(productCode);
        this.vendingMachineV2.setCurrentState(new DespenseItem(vendingMachineV2));
    }

    @Override
    public void dispenseItem(String productCode) {
        throw new RuntimeException("Can't dispense Item");
    }

    @Override
    public void cancelTransaction() {
        throw new RuntimeException("Can't cancel Transaction");
    }
}

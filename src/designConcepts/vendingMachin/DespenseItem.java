package designConcepts.vendingMachin;

public class DespenseItem implements IStateChange {
    private VendingMachineV2 vendingMachineV2;
    public DespenseItem(VendingMachineV2 vendingMachineV2) {
        this.vendingMachineV2 = vendingMachineV2;
    }

    @Override
    public void collectCash(double cash) {
        throw new RuntimeException("Can't collect cash");
    }

    @Override
    public void dispenseChange(String productCode) {
        throw new RuntimeException("Can't despense  change");
    }

    @Override
    public void dispenseItem(String productCode) {
        this.vendingMachineV2.removeProduct(productCode);
        System.out.println("Product removed : " + productCode);
        this.vendingMachineV2.setCurrentState(new ReadyState(this.vendingMachineV2));

    }

    @Override
    public void cancelTransaction() {
        throw new RuntimeException("Can't cancel transaction");
    }
}

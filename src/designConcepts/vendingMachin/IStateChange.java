package designConcepts.vendingMachin;

public interface IStateChange {
    public void collectCash(double cash);
    public void dispenseChange(String productCode);
    public void dispenseItem(String productCode);
    public void cancelTransaction();
}

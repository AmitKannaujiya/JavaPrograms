package designConcepts.payment;

public interface ICardPayment {
    void saveCardDetails(String name, String cardNo, CardType type, String expiry, int cvv);
}

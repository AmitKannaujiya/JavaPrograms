package designConcepts.payment;

public class Booking {
    private BasePayment basePayment;
    private double payment;

    public Booking(BasePayment basePayment, double payment) {
        this.basePayment = basePayment;
        this.payment = payment;
    }
    public void makePayment(double amount) {
        basePayment.makePayment(amount);
    }
}

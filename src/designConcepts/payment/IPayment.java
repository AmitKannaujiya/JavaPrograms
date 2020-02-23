package designConcepts.payment;

public interface IPayment {
    void setPaymentDetails(PaymentStatus status, double dueAmount);
    void makePayment(double amount);
}

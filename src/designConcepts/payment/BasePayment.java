package designConcepts.payment;

abstract public class BasePayment implements IPayment {
    private Order order;
    private double paymentRecived;
    private double duePayment;
    private PaymentStatus status;

    @Override
    public String toString() {
        return "BasePayment{" +
                "order=" + order +
                ", paymentRecived=" + paymentRecived +
                ", duePayment=" + duePayment +
                ", status=" + status +
                '}';
    }
    @Override
    public void setPaymentDetails(PaymentStatus status, double duePayment) {
        setStatus(status);
        setDuePayment(duePayment);
        setPaymentRecived(order.getPrice() - duePayment);
        System.out.println(toString());
    }

    @Override
    public void makePayment(double amount) {
        double price = order.getPrice();
        if(amount == 0) {
            setPaymentDetails(PaymentStatus.PAYMENT_PENDING, price);
        } else if(amount == price) {
            setPaymentDetails(PaymentStatus.PAYMENT_DONE, 0);
        }else {
            setPaymentDetails(PaymentStatus.PAYMENT_DELAYED, price - amount);
        }
    }

    public void setPaymentRecived(double paymentRecived) {
        this.paymentRecived = paymentRecived;
    }

    public void setDuePayment(double duePayment) {
        this.duePayment = duePayment;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }
}

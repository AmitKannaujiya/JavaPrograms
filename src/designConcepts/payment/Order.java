package designConcepts.payment;

import java.util.Arrays;

public class Order {
    private int id;
    private User user;
    private Product[] products;

    public Order(int id, User user, Product[] products) {
        this.id = id;
        this.user = user;
        this.products = products;
        this.calculatePrice();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product[] getProducts() {
        return products;
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }

    private double price;
    public void calculatePrice() {
        double price = 0;
        for (Product product : getProducts()) {
            price += product.getPrice();
        }
        setPrice(price);
    }

    public double getPrice() {
        return price;
    }

    private void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", user=" + user +
                ", products=" + Arrays.toString(products) +
                ", price=" + price +
                '}';
    }
}

package designConcepts.payment;

public class Product {
    private String itemName;
    private int price;
    private String description;

    public Product(String itemName, int price, String description) {
        this.itemName = itemName;
        this.price = price;
        this.description = description;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "itemName='" + itemName + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}

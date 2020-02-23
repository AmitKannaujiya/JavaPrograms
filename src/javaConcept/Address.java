package javaConcept;

import java.io.Serializable;

/*
  Employee Address Class,
  Every serlizable having reference class, must implement serilizable interface
 */
public class Address implements Serializable {
    public static final long serialVersionUID = 1l;
    String street;
    String city;

    public Address(String street, String city) {
        this.street = street;
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}

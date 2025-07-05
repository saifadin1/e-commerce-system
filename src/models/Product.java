package models;

import behaviours.interfaces.ExpirationBehavior;
import behaviours.interfaces.ShippingBehavior;

public class Product {
    private String name;
    private double price;
    private int quantity;
    private ExpirationBehavior expirationBehavior;
    private ShippingBehavior shippingBehavior;


    public Product(String name, double price, int quantity, ExpirationBehavior expirationBehavior, ShippingBehavior shippingBehavior) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.expirationBehavior = expirationBehavior;
        this.shippingBehavior = shippingBehavior;
    }

    public void reduceQuantity(int quantity) {
        this.quantity -= quantity;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }
}

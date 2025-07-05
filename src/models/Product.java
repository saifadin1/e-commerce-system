package models;

import behaviours.interfaces.ExpirationBehavior;
import behaviours.interfaces.ShippingBehavior;
import interfaces.ShippedItem;

public class Product implements ShippedItem {
    private String name;
    private double price;
    private int quantity;
    private double weight;
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

    @Override
    public double getWeight() {
        return 0;
    }

    public int getQuantity() {
        return quantity;
    }

    public ExpirationBehavior getExpirationBehavior() {
        return expirationBehavior;
    }

    public ShippingBehavior getShippingBehavior() {
        return shippingBehavior;
    }
}

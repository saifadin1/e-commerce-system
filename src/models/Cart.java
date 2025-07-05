package models;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> items = new ArrayList<CartItem>();

    public void addItem(Product product, int quantity) {
        if (product.getQuantity() < quantity) {
            throw new IllegalArgumentException("Quantity exceeds stock");
        }
        CartItem item = new CartItem(product, quantity);
        items.add(item);
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public double getSubTotal() {
        double subTotal = 0;
        for (CartItem item : items) {
            subTotal += item.getTotal();
        }
        return subTotal;
    }

    public List<CartItem> getItems() {
        return items;
    }
}

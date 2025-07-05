package models;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> items = new ArrayList<CartItem>();

    public void addItem(Product product, int quantity) {
        CartItem item = new CartItem(product, quantity);
        items.add(item);
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public List<CartItem> getItems() {
        return items;
    }
}

package models;

public class CartItem {
    private Product product;
    private int quantity;

    public CartItem(Product product, int quantity) {
        this.product = product;
    }

    public double getTotal() {
        return product.getPrice() * quantity;
    }
}

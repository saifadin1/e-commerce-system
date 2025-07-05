package services;

import interfaces.ShippedItem;

import java.util.List;

public class ShippingService {
    public void ship(List<ShippedItem> shippedProducts) {
        if (shippedProducts == null || shippedProducts.isEmpty()) {
            System.out.println("No products to ship.");
            return;
        }

        System.out.println("Shipping the following products:");

        for (ShippedItem product : shippedProducts) {
            String name = product.getName();
            double weight = product.getWeight();
            System.out.printf("• %s - %.2f kg%n", name, weight);
        }

        System.out.println("Shipping complete.");
    }
}

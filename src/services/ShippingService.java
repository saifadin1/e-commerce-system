package services;

import models.Product;

import java.util.List;

public class ShippingService {
    public void ship(List<Product> shippedProducts) {
        if (shippedProducts == null || shippedProducts.isEmpty()) {
            System.out.println("No products to ship.");
            return;
        }

        System.out.println("Shipping the following products:");

        for (Product product : shippedProducts) {
            String name = product.getName();
            double weight = product.getShippingBehavior().getWeight();
            System.out.printf("• %s - %.2f kg%n", name, weight);
        }

        System.out.println("Shipping complete.");
    }
}

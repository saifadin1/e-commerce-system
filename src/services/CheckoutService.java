package services;

import interfaces.ShippedItem;
import models.Cart;
import models.CartItem;
import models.Customer;

import java.util.ArrayList;
import java.util.List;

public class CheckoutService {
    ShippingService shippingService = new ShippingService();
    public void checkout(Customer customer, Cart cart) {
        if (cart.isEmpty()) {
            System.out.println("Cart is empty");
            return;
        }

        List<CartItem> cartItems = cart.getItems();
        List<ShippedItem> tobeShippedProducts = new ArrayList<>();
        double shippingFees = 0.0;
        double totalWeight = 0.0;
        double subtotal = 0.0;

        for (CartItem item : cart.getItems()) {
            // check if the item is expired or not
            if (item.getProduct()
                    .getExpirationBehavior()
                    .isExpired()) {
                System.out.printf("Product %s is expired\n", item.getProduct().getName());
                return;
            }

            // check if the quantity is in stock
            if (item.getQuantity() > item.getProduct().getQuantity()) {
                System.out.printf("Product %s is out of stock \n", item.getProduct().getName());
                return;
            }

            double price = item.getProduct().getPrice();
            int quantity = item.getQuantity();
            double itemTotal = price * quantity;
            double weight = item.getProduct().getShippingBehavior().getWeight();

            subtotal += itemTotal;
            totalWeight += weight * quantity;
            shippingFees += weight * quantity * 10; // i assumed that $10 per kg for now

            if (item.getProduct().getShippingBehavior().requiresShipping()) {
                tobeShippedProducts.add(item.getProduct());
            }
        }

        double paidAmount = subtotal + shippingFees;

        // check if the customer's balance is sufficient
        if (paidAmount > customer.getBalance()) {
            System.out.println("Insufficient balance to complete the purchase.");
            return;
        }

        customer.pay(paidAmount);
        for (CartItem item : cartItems) {
            item.getProduct().reduceQuantity(item.getQuantity());
        }

        double newBalance = customer.getBalance();

        printReceipt(cartItems, subtotal, shippingFees, totalWeight,  newBalance);
        shippingService.ship(tobeShippedProducts);
    }

    private void printReceipt(List<CartItem> cartItems, double subtotal, double shippingFees, double totalWeight, double newBalance) {
        StringBuilder shipmentNotice = new StringBuilder("** Shipment notice **\n");
        StringBuilder receipt = new StringBuilder("** Checkout receipt **\n");

        for (CartItem item : cartItems) {
            int quantity = item.getQuantity();
            String name = item.getProduct().getName();
            double price = item.getProduct().getPrice();
            double weight = item.getProduct().getShippingBehavior().getWeight();

            if (item.getProduct().getShippingBehavior().requiresShipping()) {
                shipmentNotice.append(String.format("%-4dx %-15s %6.0fg%n", quantity, name, weight * 1000));
            }

            receipt.append(String.format("%-4dx %-15s %8.2f%n", quantity, name, price * quantity));
        }

        double total = subtotal + shippingFees;

        System.out.print(shipmentNotice);
        System.out.printf("Total package weight %.1fkg%n%n", totalWeight);

        System.out.print(receipt);
        System.out.println("----------------------");
        System.out.printf("%-20s %8.2f%n", "Subtotal", subtotal);
        System.out.printf("%-20s %8.2f%n", "Shipping", shippingFees);
        System.out.printf("%-20s %8.2f%n", "Amount", total);
        System.out.printf("%-20s %8.2f%n", "Remaining Balance", newBalance);
    }



}

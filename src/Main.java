import behaviours.Expirable;
import behaviours.NonExpirable;
import behaviours.Shippable;
import models.Cart;
import models.Customer;
import models.Product;
import services.CheckoutService;

import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Product tv = new Product(
                "tv", 200, 3,
                new NonExpirable(),
                new Shippable(10)
        );

        Product cheese = new Product(
                "cheese", 100, 1,
                new Expirable(LocalDate.now().plusDays(3)),
                new Shippable(0.5)
        );

        CheckoutService checkoutService = new CheckoutService();


        Customer customer = new Customer("seif", 1000);
        Cart cart = new Cart();
        cart.addItem(cheese, 1);
        cart.addItem(tv, 1);

        checkoutService.checkout(customer, cart);

    }
}
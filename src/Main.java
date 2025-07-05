import behaviours.Expirable;
import behaviours.NonExpirable;
import behaviours.NonShippable;
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
                "tv", 500, 3,
                new NonExpirable(),
                new Shippable(0)
        );

        Product cheese = new Product(
                "cheese", 100, 1,
                new Expirable(LocalDate.now().plusDays(3)),
                new Shippable(0.5)
        );

        Product scratchCard = new Product(
                "scratchCard", 50, 1,
                new NonExpirable(),
                new NonShippable()
        );

        CheckoutService checkoutService = new CheckoutService();


        Customer customer = new Customer("seif", 1000.5);
        Cart cart = new Cart();
//        cart.addItem(cheese, 1);
        cart.addItem(tv, 2);
//        cart.addItem(scratchCard, 1);

        checkoutService.checkout(customer, cart);

    }
}
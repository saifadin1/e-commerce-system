package models;

public class Customer {
    private String name;
    private double balance;
    private Cart cart =  new Cart();

    public Customer(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }


    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public Cart getCart() {
        return cart;
    }

    public void pay(double amount) {
        if (amount  > balance) {
            throw new IllegalArgumentException("Customer's balance is insufficient");
        }
        balance -= amount;
    }
}

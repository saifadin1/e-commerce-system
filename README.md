# Full Stack Development Internship Challenge
I've used composition over inheritance principle to avoid class explosion using strategy pattern.
for example: I've created an interface `ExpiryBehavior` and there are two behaviours implement this interface: `Expirable`, `NonExpirable`.

Product objects are composed of these behaviors.

## Why this approach is good ?
### 1. **Avoids Class Explosion**  
   There's no need to create a subclass for every product combination (e.g., `ShippableExpirableProduct`).

### 2. **extendable**
   If we would to add a new behaviour like `returnable` or `taxable` we just add these new behaviours class and compose it
   with the relevant products.  This avoids the need to create a separate subclass for every possible combination (e.g., ShippableAndReturnableProduct), keeping the system clean and scalable.



### 3. **Open/Closed Principle**  
   The design allows the code to be open for extension but closed for modification, promoting flexibility and maintainability.

### 4. **Easy to Test**
   we can test each behaviour independently.


## Code Examples

```java
cart.addItem(cheese, 1);
cart.addItem(tv, 1);
cart.addItem(scratchCard, 1);
checkoutService.checkout(customer, cart);
```

## Console output 

    ** Shipment notice **
    1x cheese            500g
    1x tv              10000g
    Total package weight 10.5kg
    
    ** Checkout receipt **
    1x cheese            100
    1x tv                200
    1x scratchCard        50
    ----------------------
    Subtotal               350
    Shipping               105
    Amount                 455
    Remaining Balance      545
    Shipping the following products:
    • cheese - 0.50 kg
    • tv - 10.00 kg
    Shipping complete.

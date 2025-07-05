package behaviours;

import behaviours.interfaces.ShippingBehavior;

public class NonShippable implements ShippingBehavior {
    @Override
    public boolean requiresShipping() {
        return false;
    }

    @Override
    public double getWeight() {
        return 0;
    }
}

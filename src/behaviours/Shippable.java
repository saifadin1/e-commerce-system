package behaviours;

import behaviours.interfaces.ShippingBehavior;

public class Shippable implements ShippingBehavior {
    private double weight;

    public Shippable(double weight) {
        this.weight = weight;
    }

    @Override
    public boolean requiresShipping() {
        return true;
    }

    @Override
    public double getWeight() {
        return weight;
    }


}

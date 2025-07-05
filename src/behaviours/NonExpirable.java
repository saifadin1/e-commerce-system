package behaviours;

import behaviours.interfaces.ExpirationBehavior;

public class NonExpirable implements ExpirationBehavior {
    @Override
    public boolean isExpired() {
        return false;
    }
}

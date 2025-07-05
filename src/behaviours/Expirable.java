package behaviours;

import behaviours.interfaces.ExpirationBehavior;

import java.time.LocalDate;

public class Expirable implements ExpirationBehavior {
    private LocalDate expiryDate;

    public Expirable(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Override
    public boolean isExpired() {
        return expiryDate.isBefore(LocalDate.now());
    }

}

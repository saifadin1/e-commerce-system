package behaviours;

import behaviours.interfaces.ExpirationBehavior;

import java.time.LocalDate;

public class Expirable implements ExpirationBehavior {
    private LocalDate expiryDate;


    @Override
    public boolean isExpired() {
        return expiryDate.isBefore(LocalDate.now());
    }

}

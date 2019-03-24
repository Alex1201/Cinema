package Domain;

import java.security.PublicKey;

public class BookingValidator implements IValidator<Booking> {
    public void validate(Booking booking){
        if (booking.getNumberOfItems() <= 0){
            throw new RuntimeException("The number of items must be grater than 0.");
        }
    }
}

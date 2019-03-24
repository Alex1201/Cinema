package Service;
import Domain.Booking;
import Domain.Film;
import Repository.*;

import java.util.List;

public class BookingService {
    private IRepository<Booking> bookingIRepository;
    private IRepository<Film> filmIRepository;

    public BookingService(IRepository<Booking> bookingIRepository){
        this.bookingIRepository = bookingIRepository;
        this.filmIRepository = filmIRepository;
    }

    public Booking addOrUpdate (int id, int filmId, int cardId, String date, String time, int numberOfItems) {
        Booking existing = bookingIRepository.findById(id);
        if (existing != null) {
            if (filmId == 0) {
                filmId = existing.getFilmId();
            }
            if (cardId == 0) {
                cardId = existing.getCardId();
            }
            if (numberOfItems == 0) {
                numberOfItems = existing.getNumberOfItems();
            }
            if (date.isEmpty()) {
                date = existing.getDate();
            }
            if (time.isEmpty()) {
                time = existing.getTime();
            }
        }

        Film filmSold = filmIRepository.findById(filmId);
        if (filmSold == null){
                throw new RuntimeException("There is no film with given name.");
        }
        double basePrice = filmSold.getPrice();
        double discount = 0;
        if (cardId != 0 && numberOfItems > 3){
            discount = 0.1; //10% discount
        }

        Booking booking = new Booking(id, filmId, cardId, date, time, numberOfItems, basePrice, discount);
        bookingIRepository.upsert(booking);
        return booking;
    }

    public void remove(int id) {
        bookingIRepository.remove(id);
    }
    public List<Booking> getAll(){
        return bookingIRepository.getAll();
    }
}

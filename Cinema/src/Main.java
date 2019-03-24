import Domain.*;
import Repository.IRepository;
import Repository.InMemoryRepository;
import Service.FilmService;
import Service.ClientCardService;
import Service.BookingService;
import UI.Console;

public class Main {

    public static void main(String[] args){

        IValidator<Film> filmIValidator = new FilmValidator();
        IValidator<ClientCard> clientCardIValidator = new ClientCardValidator();
        IValidator<Booking> bookingIValidator = new BookingValidator();

        IRepository<Film> filmIRepository = new InMemoryRepository<>(filmIValidator);
        IRepository<ClientCard> clientCardIRepository = new InMemoryRepository<>(clientCardIValidator);
        IRepository<Booking> bookingIRepository = new InMemoryRepository<>(bookingIValidator);

        FilmService filmService = new FilmService(filmIRepository);
        ClientCardService clientCardService = new ClientCardService(clientCardIRepository);
        BookingService bookingService = new BookingService(bookingIRepository);

        Console console = new Console(filmService, clientCardService, bookingService);
        console.run();
    }
}

package UI;
import Domain.Film;
import Domain.ClientCard;
import Domain.Booking;
import Service.BookingService;
import Service.FilmService;
import Service.ClientCardService;
import java.util.*;

public class Console {

    private FilmService filmService;
    private ClientCardService clientCardService;
    private BookingService bookingService;

    private Scanner scanner;

    public Console(FilmService filmService, ClientCardService clientCardService, BookingService bookingService){
        this.filmService = filmService;
        this.clientCardService = clientCardService;
        this.bookingService = bookingService;

        this.scanner = new Scanner(System.in);
    }

    private void showMenu(){
        System.out.println("1. Film CRUD");
        System.out.println("2. Client card CRUD");
        System.out.println("3. Booking CRUD");
        System.out.println("4. Search Client");
        System.out.println("x. Exit");
    }

    public void run() {
        while (true) {
            showMenu();

            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    runFilmCrud();
                    break;
                case "2":
                    runClientCardCrud();
                    break;
                case "3":
                    runBookingCrud();
                    break;
                case "4":
                    runClientCardSearch();
                    break;
                case "x":
                    return;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }
    }

    private void runClientCardSearch() {
        System.out.println("Enter the values to search: ");
        String text = scanner.nextLine();
        System.out.println("The searching results are:");
        for (ClientCard c : clientCardService.textSearch(text)) {
            System.out.println(c);
        }
    }

    private void runBookingCrud(){
        while(true){
            System.out.println("1. Add or update a booking");
            System.out.println("2. Remove a booking.");
            System.out.println("3. View all bookings.");
            System.out.println("4. Back");

            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    handleAddUpdateBooking();
                    break;
                case "2":
                    handleRemoveBooking();
                    break;
                case "3":
                    handleViewBooking();
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }
    }

    private void handleViewBooking() {
        for (Booking booking : bookingService.getAll()) {
            System.out.println(booking);
        }
    }

    private void handleRemoveBooking() {
        try {
            System.out.print("Enter the id to remove:");
            int id = scanner.nextInt();
            bookingService.remove(id);

            System.out.println("Booking removed!");
        } catch (Exception ex) {
            System.out.println("Errors:\n" + ex.getMessage());
        }
        // TODO: catch (InMemoryRepositoryException ...)
    }

    private void handleAddUpdateBooking() {
        try {
            System.out.print("Enter id: ");
            int id = scanner.nextInt();
            System.out.print("Enter film id (empty to not change for update): ");
            int filmId = scanner.nextInt();
            System.out.print("Enter client card (empty to not change for update): ");
            int idClientCard = scanner.nextInt();
            System.out.print("Enter number of items (0 to not change for update): ");
            int numberOfItems = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter date (empty to not change for update): ");
            String date = scanner.nextLine();
            System.out.print("Enter time (empty to not change for update): ");
            String time = scanner.nextLine();

            Booking booking = bookingService.addOrUpdate(id, filmId, idClientCard, date, time, numberOfItems);
            System.out.println(String.format("Added transaction id=%s, paid price=%f, discount=%f%%", booking.getId(), booking.getDiscountedPrice(), booking.getDiscount()));
        } catch (Exception ex) {
            System.out.println("Errors:\n" + ex.getMessage());
        }
    }

    private void runClientCardCrud() {
        while (true) {
            System.out.println("1. Add or update a client card");
            System.out.println("2. Remove a client card");
            System.out.println("3. View all client cards");
            System.out.println("4. Back");

            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    handleAddUpdateClientCard();
                    break;
                case "2":
                    handleRemoveClientCards();
                    break;
                case "3":
                    handleViewClientCards();
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }
    }

    private void handleViewClientCards() {
        for (ClientCard client : clientCardService.getAll()) {
            System.out.println(client);
        }
    }

    private void handleRemoveClientCards() {
        try {
            System.out.print("Enter the id to remove:");
            int id = scanner.nextInt();
            clientCardService.remove(id);

            System.out.println("Client card removed!");
        } catch (Exception ex) {
            System.out.println("Errors:\n" + ex.getMessage());
        }
    }

    private void handleAddUpdateClientCard() {
        try {
            System.out.print("Enter id: ");
            int id = scanner.nextInt();
            System.out.print("Enter points (empty to not change for update): ");
            int points = scanner.nextInt();
            System.out.print("Enter first name (empty to not change for update): ");
            String firstName = scanner.nextLine();
            System.out.print("Enter first name (empty to not change for update): ");
            String lastName = scanner.nextLine();
            System.out.print("Enter CNP (empty to not change for update): ");
            String CNP = scanner.nextLine();
            System.out.print("Enter date of birth (empty to not change for update): ");
            String DOB = scanner.nextLine();
            System.out.print("Enter date of registration (empty to not change for update): ");
            String dateOfRegistration = scanner.nextLine();

            clientCardService.addOrUpdate(id, points, firstName, lastName, CNP, DOB, dateOfRegistration);

            System.out.println("Client added!");
        } catch (Exception ex) {
            System.out.println("Errors:\n" + ex.getMessage());
        }
    }

    private void runFilmCrud() {
        while (true) {
            System.out.println("1. Add or update a cake");
            System.out.println("2. Remove a cake");
            System.out.println("3. View all cakes");
            System.out.println("4. Back");

            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    handleAddUpdateFilm();
                    break;
                case "2":
                    handleRemoveFilm();
                    break;
                case "3":
                    handleViewFilm();
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }
    }

    private void handleViewFilm() {
        for (Film cake : filmService.getAll()) {
            System.out.println(cake);
        }
    }

    private void handleRemoveFilm() {
        try {
            System.out.print("Enter the id to remove:");
            int id = scanner.nextInt();
            filmService.remove(id);

            System.out.println("Film removed!");
        } catch (Exception ex) {
            System.out.println("Errors:\n" + ex.getMessage());
        }
    }

    private void handleAddUpdateFilm() {

        try {
            System.out.print("Enter id: ");
            int id = scanner.nextInt();
            System.out.print("Enter name (empty to not change for update): ");
            String title = scanner.nextLine();
            System.out.print("Enter title (empty to not change for update): ");
            String release = scanner.nextLine();
            System.out.print("Enter release date (0 to not change for update): ");
            int price = scanner.nextInt();

            filmService.addOrUpdate(id, title, release, price);

            System.out.println("Cake added!");
        } catch (Exception ex) {
            System.out.println("Errors:\n" + ex.getMessage());
        }
    }
}

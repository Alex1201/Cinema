package Domain;

public class Booking extends Entity{
    private int id, filmId, cardId;
    private String date, time;
    private int numberOfItems;
    private double basePrice;
    private double discount;

    public Booking(int id, int id1, int filmId, String date, String time, int numberOfItems, double basePrice, double discount) {
        super(id);
        this.id = id1;
        this.filmId = filmId;
        this.cardId = cardId;
        this.date = date;
        this.time = time;
        this.numberOfItems = numberOfItems;
        this.basePrice = basePrice;
        this.discount = discount;
    }

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getNumberOfItems() {
        return numberOfItems;
    }

    public void setNumberOfItems(int numberOfItems) {
        this.numberOfItems = numberOfItems;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id='" + getId() + '\'' +
                ", idFilm='" + filmId + '\'' +
                ", idClientCard='" + cardId + '\'' +
                ", numberOfItems='" + numberOfItems + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", basePrice=" + basePrice +
                ", discount=" + discount +
                '}';
    }

    public double getDiscountedPrice(){
        return basePrice * numberOfItems - discount * basePrice*numberOfItems;
    }
}

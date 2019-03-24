package Domain;

public class Film extends Entity {
    private int id, price;
    private String release, title;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRelease() {
        return release;
    }

    public void setRelease(String release) {
        this.release = release;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Film(int id, String title, String release, int price) {
        this.id = id;
        this.release = release;
        this.price = price;
        this.title = title;
    }

    @Override
    public String toString() {
        return "Film{" +
                "id='" + getId() + '\'' +
                ", title='" + title + '\'' +
                ", release='" + release + '\'' +
                ", price=" + price +
                '}';
    }
}

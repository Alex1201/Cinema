package Domain;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.text.*;
import java.util.*;

public class FilmValidator implements IValidator<Film>{
    public void validate(Film film){
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        try {
            format.parse(film.getRelease().toString());
        } catch (ParseException pe) {
            throw new RuntimeException("The release date is not in a correct format!");
        }

        if(film.getPrice() <= 0){
            throw new RuntimeException("The price must be positive.");
        }

    }
}

/*
    public void validate(ClientCard clientCard) {

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        try {
            format.parse(clientCard.getDOB().toString());
        } catch (ParseException pe) {
            throw new RuntimeException("The date of birth is not in a correct format!");
        }

        try {
            format.parse(clientCard.getRegDate().toString());
        } catch (ParseException pe) {
            throw new RuntimeException("The date of birth is not in a correct format!");
        }

    }*/
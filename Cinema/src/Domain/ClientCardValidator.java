package Domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ClientCardValidator implements IValidator<ClientCard> {
    public void validate(ClientCard clientCard){
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        try{
            format.parse(clientCard.getDOB());
        }catch (ParseException pe){
            throw new RuntimeException("The date of birth format is not valid");
        }

        try {
            format.parse((clientCard.getRegDate()));
        }catch (ParseException pe){
            throw new RuntimeException("The registration date is not in valid format.");
        }
    }
}

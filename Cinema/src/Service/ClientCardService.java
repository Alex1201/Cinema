package Service;
import Domain.ClientCard;
import Repository.IRepository;

import java.util.ArrayList;
import java.util.List;

public class ClientCardService {

    private IRepository<ClientCard> repository;

    public ClientCardService(IRepository<ClientCard> repository){
        this.repository = repository;
    }

    public void addOrUpdate(int id, int points,String firstName, String lastName, String CNP, String DOB, String regDate) {
        ClientCard existing = repository.findById(id);
        if (existing != null) {
            // keep unchanged fields as they were
            if (id == 0){
                id = existing.getId();
            }
            if (lastName.isEmpty()) {
                lastName = existing.getLastName();
            }
            if (points == 0){
                points = existing.getPoints();
            }
            if (firstName.isEmpty()) {
                firstName = existing.getFirstName();
            }
            if (CNP.isEmpty()) {
                CNP = existing.getCNP();
            }
            if (DOB.isEmpty()) {
                DOB = existing.getDOB();
            }
            if (regDate.isEmpty()) {
                regDate = existing.getRegDate();
            }
        }
        ClientCard clientCard = new ClientCard(id, CNP, points, firstName, lastName, CNP, regDate);
        repository.upsert(clientCard);
    }

    /**
     * search client after given text
     * @param text rearched for
     * @return results with give text
     */
    public List<ClientCard> textSearch(String text){
        List<ClientCard> result = new ArrayList<>();
        for(ClientCard c: repository.getAll()){
            if (c.toString().contains(text)){
                result.add(c);
            }
        }
        return result;
    }

    public void remove(int id){
        repository.remove(id);
    }

    public List<ClientCard> getAll() {
        return repository.getAll();
    }
}

package Service;

import Domain.Film;
import Repository.IRepository;

import java.util.List;

public class FilmService {
    private IRepository<Film> repository;

    public FilmService(IRepository<Film> repository){
        this.repository = repository;
    }

    public void addOrUpdate(int id, String title, String release, int price){
        Film existing = repository.findById(id);
        if(existing != null){
            if (id == 0){
                id = existing.getId();
            }
            if (title.isEmpty()){
                title = existing.getTitle();
            }
            if (release.isEmpty()){
                release = existing.getRelease();
            }
            if (price == 0){
                price = existing.getPrice();
            }
        }

        Film film = new Film(id, title, release, price);
        repository.upsert(film);
    }

    public void remove(int id){
        repository.remove(id);
    }

    public List<Film> getAll(){
        return repository.getAll();
    }
}

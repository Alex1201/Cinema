package Repository;

import Domain.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryRepository<T extends Entity>
        implements IRepository<T>{

    private Map<Integer, T> storage = new HashMap<>();
    private IValidator<T> validator;

    public InMemoryRepository(IValidator<T> validator) {
        this.validator = validator;
    }
    public T findById(String id){
        return storage.get(id);
    }

    @Override
    public T findById(int id) {
        return null;
    }

    /**
     * add or update entity if already exists
     * @param entity the entity to add or update
     */
    public void upsert(T entity){
        validator.validate(entity);
        storage.put(entity.getId(), entity);
    }

    /**
     * Remove entity with given id
     * @param id
     */
    public void remove(int id){
        if(!storage.containsKey(id)){
            throw new RuntimeException("There is no entity with the given id to remove.");
        }
    }

    @Override
    public List<T> getAll() {
        return new ArrayList<>(storage.values());
    }
}


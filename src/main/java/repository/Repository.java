package repository;

import javax.persistence.EntityManager;
import java.util.List;

public interface Repository<T> {

    public T read(long id);
    public T create(T t);
    public T update(T t);

    public void delete(T t);
}


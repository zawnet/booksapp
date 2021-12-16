package repository;

public interface Repository<T> {

    T read(long id);
    T create(T t);
    T update(T t);

    void delete(T t);
}


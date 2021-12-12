package repository;

import javax.persistence.EntityManager;

public abstract class CrudManagerRepository<T> implements Repository<T>{

    private final EntityManager entityManager;
    private final Class<T> typeParameterClass;

    public CrudManagerRepository(EntityManager entityManager, Class<T> typeParameterClass) {
        this.entityManager = entityManager;
        this.typeParameterClass = typeParameterClass;
    }

    @Override
    public T read(long id) {
        T result = entityManager.find(typeParameterClass, id);
        return result;
    }

    @Override
    public T create(T t) {
        entityManager.getTransaction().begin();
        entityManager.persist(t);
        entityManager.getTransaction().commit();
        return t;
    }

    @Override
    public T update(T t) {
        entityManager.getTransaction().begin();
        entityManager.persist(t);
        entityManager.getTransaction().commit();
        return t;
    }

    @Override
    public void delete(T t) {
        entityManager.getTransaction().begin();
        entityManager.remove(t);
        entityManager.getTransaction().commit();
    }
}

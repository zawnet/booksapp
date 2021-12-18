package repository;

import entity.AuthorEntity;
import entity.BookEntity;
import repository.exeption.NoAuthorFoundException;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.NoSuchElementException;

public class AuthorManagerRepository extends CrudManagerRepository<AuthorEntity> implements AuthorRepository {

    private final EntityManager entityManager;

    public AuthorManagerRepository(EntityManager entityManager) {
        super(entityManager, AuthorEntity.class);
        this.entityManager = entityManager;
    }

    @Override
    public List<AuthorEntity> findAuthorByName(String name) {
        throw new NoSuchElementException("Method is not implemented yet");
    }

    @Override
    public AuthorEntity findAuthorByKey(String key) throws NoSuchElementException {
        Query query = entityManager.createQuery("FROM AuthorEntity WHERE olKey like :key");
        query.setParameter("key", "%"+key+"%");
        if(!query.getResultList().isEmpty()) {
            return (AuthorEntity) query.getResultList().get(0);
        }
        else {
            throw new NoAuthorFoundException("No authors found in local database");
        }
    }
}

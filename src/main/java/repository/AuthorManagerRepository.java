package repository;

import entity.AuthorEntity;

import javax.persistence.EntityManager;
import java.util.List;

public class AuthorManagerRepository extends CrudManagerRepository<AuthorEntity> implements AuthorRepository {

    private final EntityManager entityManager;

    public AuthorManagerRepository(EntityManager entityManager) {
        super(entityManager, AuthorEntity.class);
        this.entityManager = entityManager;
    }

    @Override
    public List<AuthorEntity> findAuthorByName(String name) {
        return null;
    }
}

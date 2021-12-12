package repository;

import entity.AuthorEntity;

import javax.persistence.EntityManager;
import java.util.List;

public class AuthorsManagerRepository extends CrudManagerRepository<AuthorEntity> implements RepositoryForAuthors{

    private final EntityManager entityManager;

    public AuthorsManagerRepository(EntityManager entityManager) {
        super(entityManager, AuthorEntity.class);
        this.entityManager = entityManager;
    }

    @Override
    public List<AuthorEntity> findAuthorByName(String name) {
        return null;
    }
}

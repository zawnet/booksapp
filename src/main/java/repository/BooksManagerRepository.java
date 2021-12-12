package repository;

import entity.BookEntity;

import javax.persistence.EntityManager;
import java.util.List;

public class BooksManagerRepository extends CrudManagerRepository<BookEntity> implements RepositoryForBooks{

    private final EntityManager entityManager;

    public BooksManagerRepository(EntityManager entityManager) {
        super(entityManager, BookEntity.class);
        this.entityManager = entityManager;
    }

    @Override
    public List<BookEntity> findByISBN(String isbn) {
        return null;
    }

    @Override
    public List<BookEntity> findByTitle(String title) {
        return null;
    }
}

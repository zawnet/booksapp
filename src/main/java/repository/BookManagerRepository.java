package repository;

import entity.BookEntity;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class BookManagerRepository extends CrudManagerRepository<BookEntity> implements BookRepository {

    private final EntityManager entityManager;

    public BookManagerRepository(EntityManager entityManager) {
        super(entityManager, BookEntity.class);
        this.entityManager = entityManager;
    }

    @Override
    public List<BookEntity> findByISBN(String isbn) {
        Query query= entityManager.createQuery("from BookEntity where isbn_13=:isbn OR isbn_10=:isbn ");
        query.setParameter("isbn", isbn);
        return  query.getResultList();
    }

    @Override
    public List<BookEntity> findByTitle(String title) {
        Query query= entityManager.createQuery("from BookEntity where title=:title ");
        query.setParameter("title", title);
        return  query.getResultList();
    }
}

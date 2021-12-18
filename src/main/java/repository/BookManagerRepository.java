package repository;

import entity.BookEntity;
import repository.exeption.NoBookFoundException;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.*;

public class BookManagerRepository extends CrudManagerRepository<BookEntity> implements BookRepository {

    private final EntityManager entityManager;

    public BookManagerRepository(EntityManager entityManager) {
        super(entityManager, BookEntity.class);
        this.entityManager = entityManager;
    }

    @Override
    public BookEntity findByISBN(String isbn) {
            Query query = entityManager.createQuery("from BookEntity where isbn_13=:isbn OR isbn_10=:isbn ");
            query.setParameter("isbn", isbn);
           return  (!query.getResultList().isEmpty())?(BookEntity) query.getResultList().get(0) : null;

    }

    @Override
    public List<BookEntity> findByTitle(String title) {
        Query query= entityManager.createQuery("from BookEntity where title like :title ");
        query.setParameter("title", "%"+title+"%");
        return  query.getResultList();
    }

    @Override
    public List<BookEntity> findBooksByAuthorKey(String key) {
        Query query = entityManager.createQuery(
                "SELECT b FROM BookEntity b JOIN b.authors a WHERE a.olKey like :key");
        query.setParameter("key", "%"+key+"%");
        return query.getResultList();
    }

    @Override
    public BookEntity findBookByOlKey(String key) throws NoBookFoundException {
        Query query = entityManager.createQuery("FROM BookEntity WHERE ol_key like :key");
        query.setParameter("key", "%"+key+"%");
        if(!query.getResultList().isEmpty()) {
            return (BookEntity) query.getResultList().get(0);
        }
        else {
            throw new NoBookFoundException("No book found in local database");
        }
    }
}

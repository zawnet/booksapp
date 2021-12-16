package repository;

import entity.BookEntity;
import model.Book;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;
import java.util.NoSuchElementException;

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
}

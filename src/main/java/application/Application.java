package application;

import connector.BookConnector;
import connector.BookService;
import model.Author;
import model.Book;
import repository.BookManagerRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Application implements ApplicationService{

    private static EntityManagerFactory entityManagerFactory
            = Persistence.createEntityManagerFactory(
            "booksPU");

    private static EntityManager entityManager
            = entityManagerFactory.createEntityManager();

    private final BookService bookService;
    private final BookManagerRepository bookManagerRepository;

    public Application() {
        this.bookService = new BookService();
        this.bookManagerRepository = new BookManagerRepository(entityManager);
    }

    @Override
    public Book getByISBN(String isbn) {
        return null;
    }

    @Override
    public List<Book> getByName(String name) {
        return null;
    }

    @Override
    public List<Book> getBooksByAuthor(String authorName) {
        return null;
    }

    @Override
    public Author getAuthorInfo(long id) {
        return null;
    }
}

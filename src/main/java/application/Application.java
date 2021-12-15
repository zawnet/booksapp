package application;

import connector.BookConnector;
import connector.BookService;
import entity.BookEntity;
import mapper.BookToBookEntityMapper;
import model.Author;
import model.Book;
import repository.BookManagerRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
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
        return bookService.getByISBN(isbn);
    }

    @Override
    public List<Book> getByName(String name) {

        List<BookEntity> bookEntities = bookManagerRepository.findByTitle(name);

        if(bookEntities == null || bookEntities.isEmpty()){
            bookService.getByTitle(name).forEach(book -> bookManagerRepository.create(BookToBookEntityMapper.convert(book)));
            bookEntities = bookManagerRepository.findByTitle(name);
        }
       List<Book> bookList = new ArrayList<>();
        bookEntities.forEach(bookEntity -> {
            bookList.add(BookToBookEntityMapper.convert(bookEntity));
        });

        return  bookList;

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

package application;

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
import java.util.NoSuchElementException;

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
        BookEntity bookEntity = bookManagerRepository.findByISBN(isbn);
        Book book = new Book();
        if(bookEntity == null) {
            try {
                book = bookService.getByISBN(isbn);
                bookManagerRepository.create(BookToBookEntityMapper.convert(book));
                bookEntity = bookManagerRepository.findByISBN(isbn);
                if(bookEntity != null) {
                    book = BookToBookEntityMapper.convert(bookEntity);
                }
            } catch (NoSuchElementException ex) {
                System.out.println(ex.getMessage());
            }
        }
        else {
            book = BookToBookEntityMapper.convert(bookEntity);
        }
            return book;
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

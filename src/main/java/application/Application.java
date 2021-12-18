package application;

import connector.AuthorService;
import connector.BookService;
import entity.AuthorEntity;
import entity.BookEntity;
import mapper.AuthorToAuthorEntityMapper;
import mapper.BookToBookEntityMapper;
import model.Author;
import model.Book;
import org.apache.commons.lang3.StringUtils;
import repository.AuthorManagerRepository;
import repository.BookManagerRepository;
import repository.exeption.NoAuthorFoundException;
import repository.exeption.NoBookFoundException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.*;

public class Application implements ApplicationService{

    private static EntityManagerFactory entityManagerFactory
            = Persistence.createEntityManagerFactory(
            "booksPU");

    private static EntityManager entityManager
            = entityManagerFactory.createEntityManager();

    private final BookService bookService;
    private final AuthorService authorService;
    private final BookManagerRepository bookManagerRepository;
    private final AuthorManagerRepository authorManagerRepository;

    public Application() {
        this.bookService = new BookService();
        this.authorService = new AuthorService();
        this.bookManagerRepository = new BookManagerRepository(entityManager);
        this.authorManagerRepository = new AuthorManagerRepository(entityManager);
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
        for (BookEntity bookEntity : bookEntities) {
            bookList.add(BookToBookEntityMapper.convert(bookEntity));
        }

        return  bookList;
    }

    @Override
    public List<Book> getBooksByAuthor(String authorKey) {
        List<BookEntity> bookEntities = new ArrayList<>();
        List<Book> bookList = new ArrayList<>();
        AuthorEntity authorEntity = new AuthorEntity();
        try {
            authorEntity = authorManagerRepository.findAuthorByKey(authorKey);
        }
        catch (NoAuthorFoundException e){
            System.out.println(e.getMessage());
        }


        if(StringUtils.isBlank(authorEntity.getOlKey())){
            Author author = authorService.getAuthorInfo(authorKey);
            authorEntity = authorManagerRepository.create(AuthorToAuthorEntityMapper.convert(author));
        }
            bookEntities = bookManagerRepository.findBooksByAuthorKey(authorKey);

        if (bookEntities.isEmpty() ) {
            bookList = authorService.getAuthorBooks(authorKey);
            if(!bookList.isEmpty()) {
                for (Book book : bookList) {
                    BookEntity bookEntity = new BookEntity();
                    try {
                        bookEntity = bookManagerRepository.findBookByOlKey(book.getKey());
                    }
                    catch (NoBookFoundException e){
                        e.getMessage();
                    }
                    if (StringUtils.isBlank(bookEntity.getOl_key())) {
                        bookEntity = BookToBookEntityMapper.convert(book);
                        bookEntity.addAuthor(authorEntity);
                        bookManagerRepository.create(bookEntity);
                    }

                }

            }
            bookEntities = bookManagerRepository.findBooksByAuthorKey(authorKey);
        }

        bookList = new ArrayList<>();
        for (BookEntity bookEntity : bookEntities) {
            bookList.add(BookToBookEntityMapper.convert(bookEntity));
        }
        return  bookList;
    }

    @Override
    public Author getAuthorInfo(long id) {
        return null;
    }
}

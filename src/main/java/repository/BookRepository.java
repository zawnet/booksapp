package repository;

import entity.BookEntity;
import model.Book;

import java.util.List;

public interface BookRepository extends Repository<BookEntity>{
    BookEntity findByISBN(String isbn);
    List<BookEntity> findByTitle(String title);
    List<BookEntity> findBooksByAuthorKey(String key);
    BookEntity findBookByOlKey(String key);
}

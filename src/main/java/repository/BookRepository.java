package repository;

import entity.BookEntity;
import model.Book;

import java.util.List;

public interface BookRepository extends Repository<BookEntity>{
    BookEntity findByISBN(String isbn);
    List<BookEntity> findByTitle(String title);
}

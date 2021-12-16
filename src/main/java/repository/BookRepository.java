package repository;

import entity.BookEntity;

import java.util.List;

public interface BookRepository extends Repository<BookEntity>{
    List<BookEntity> findByISBN(String isbn);
    List<BookEntity> findByTitle(String title);
}

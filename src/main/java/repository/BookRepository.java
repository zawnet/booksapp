package repository;

import entity.BookEntity;

import java.util.List;

public interface BookRepository extends Repository<BookEntity>{
    public List<BookEntity> findByISBN(String isbn);
    public List<BookEntity> findByTitle(String title);
}

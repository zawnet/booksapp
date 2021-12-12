package repository;

import entity.BookEntity;
import model.Book;

import java.util.List;

public interface RepositoryForBooks extends Repository<BookEntity>{
    public List<BookEntity> findByISBN(String isbn);
    public List<BookEntity> findByTitle(String title);
}

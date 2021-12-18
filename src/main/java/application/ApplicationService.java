package application;

import model.Author;
import model.Book;

import java.util.List;

public interface ApplicationService {

    Book getByISBN(String isbn);
    List<Book> getByName(String name);
    List<Book> getBooksByAuthor(String authorKey);
    Author getAuthorInfo(long id);
}

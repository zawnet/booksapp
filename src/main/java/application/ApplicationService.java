package application;

import model.Author;
import model.Book;

import java.util.List;

public interface ApplicationService {

    Book getByISBN(String isbn);
    List<Book> getByName(String name);
    List<Book> getBooksByAuthor(String authorName);
    Author getAuthorInfo(long id);
}

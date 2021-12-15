package application;

import model.Author;
import model.Book;

import java.util.List;

public interface ApplicationService {

    public Book getByISBN(String isbn);
    public List<Book> getByName(String name);
    public List<Book> getBooksByAuthor(String authorName);
    public Author getAuthorInfo(long id);

}

package connector;

import model.Author;
import model.Book;

import java.util.List;

public interface AuthorConnector {
    List<Book> getAuthorBooks(String key);
    Author getAuthorInfo(String key);
}

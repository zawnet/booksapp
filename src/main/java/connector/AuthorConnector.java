package connector;

import model.Author;
import model.Book;

import java.util.List;

public interface AuthorConnector {
    public List<Book> getAuthorBooks(String key);
    public Author getAuthorInfo(String key);
}

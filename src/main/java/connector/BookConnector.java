package connector;

import model.Book;

import java.util.List;

public interface BookConnector {
    Book getByISBN(String isbn);
    List<Book> getByTitle(String title);
}

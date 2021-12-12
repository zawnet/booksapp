package service;

import model.Book;

import java.util.List;

public interface AppService {

    Book getByISBN(String isbn);
    List<Book> getByName(String name);

}

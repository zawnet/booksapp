package mapper;

import connector.AuthorService;
import model.Author;
import model.Book;
import model.Doc;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class DocToBookMapper {
    public static Book convert(Doc doc){
        Book book = new Book();
        List<Object> isbns = doc.getIsbn();
        if(isbns != null) {
            for (Object o : doc.getIsbn()) {
                if (o.toString().length() <= 10) {
                    book.getIsbn_10().add(o);
                }
                if (o.toString().length() > 10) {
                    book.getIsbn_13().add(o);
                }
            }
        }
        List<Object> authorsKeys = new ArrayList<>();
        try {
            authorsKeys = doc.getSeed().stream().filter(o -> o.toString().contains("/authors/"))
                    .collect(Collectors.toList());
            if (authorsKeys == null || authorsKeys.isEmpty()) {
                throw new NoSuchElementException("No authors found for " + doc.getTitle());
            } else {
                AuthorService authorService = new AuthorService();
                authorsKeys.forEach(o ->
                {
                    Author author = authorService.getAuthorInfo(o.toString().replace("/authors/", ""));
                    book.addAuthor(author);
                });

            }
        }catch (NoSuchElementException e){
            System.out.println(e.getMessage());
        }
        book.setKey(doc.getKey());
        //book.setPublish_date(doc.getPublish_date().toString());
        book.setNumber_of_pages(doc.getNumber_of_pages_median());
        book.setPublishers(doc.getPublisher());
        //book.setPublish_date(String.valueOf(doc.getPu);
        book.setTitle(doc.getTitle());
        return book;
    }
}

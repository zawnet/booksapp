package mapper;

import entity.AuthorEntity;
import entity.BookEntity;
import model.Author;
import model.Book;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import static org.apache.commons.lang3.StringUtils.isBlank;

public class BookToBookEntityMapper {

    public static BookEntity convert(Book book){
        BookEntity bookEntity = new BookEntity();
        bookEntity.setTitle(book.getTitle());
        if(book.getIsbn_10() != null && !book.getIsbn_10().isEmpty()) bookEntity.setIsbn_10(book.getIsbn_10().get(0).toString());
        if(book.getIsbn_13() != null && !book.getIsbn_13().isEmpty()) bookEntity.setIsbn_13(book.getIsbn_13().get(0).toString());
        bookEntity.setPublish_date(book.getPublish_date());
        bookEntity.setOl_key(book.getKey());

        try {


            if (book.getAuthors() == null || book.getAuthors().isEmpty()) {
                throw new NoSuchElementException("No authors for " + book.getTitle());
            }
            for (Author author : book.getAuthors()) {
                AuthorEntity authorEntity = new AuthorEntity();
                authorEntity.setName(author.getName());
                authorEntity.setBirthDate(author.getBirth_date());
                authorEntity.setEnType(author.getEntity_type());
                authorEntity.setOlKey(author.getKey());
                authorEntity.setPersonalName(author.getPersonal_name());
                authorEntity.setWikipedia(author.getWikipedia());
                authorEntity.setTitle(author.getTitle());
                bookEntity.addAuthor(authorEntity);
            }
        }catch (NoSuchElementException e){
            System.out.println(e.getMessage());
        }

        return  bookEntity;
    }

    public static Book convert(BookEntity bookEntity){
        Book book = new Book();
        book.setTitle(bookEntity.getTitle());
        if(!isBlank(bookEntity.getIsbn_10())){
            book.setIsbn_10(List.of(bookEntity.getIsbn_10()));
        }
        if(!isBlank(bookEntity.getIsbn_13())){
            book.setIsbn_13(List.of(bookEntity.getIsbn_13()));
        }

        book.setPublish_date(bookEntity.getPublish_date());
        book.setKey(bookEntity.getOl_key());
        try {

            if (bookEntity.getBookAuthors() == null || bookEntity.getBookAuthors().isEmpty()) {
                throw new NoSuchElementException("No authors for " + book.getTitle());
            }
            for (AuthorEntity authorEntity : bookEntity.getBookAuthors()) {
                Author author = new Author();
                author.setName(authorEntity.getName());
                author.setBirth_date(authorEntity.getBirthDate());
                author.setEntity_type(authorEntity.getEnType());
                author.setKey(authorEntity.getOlKey());
                author.setPersonal_name(authorEntity.getPersonalName());
                author.setWikipedia(authorEntity.getWikipedia());
                author.setTitle(authorEntity.getTitle());
                book.addAuthor(author);
            }
        }catch (NoSuchElementException e){
            System.out.println(e.getMessage());
        }

        return book;
    }
}

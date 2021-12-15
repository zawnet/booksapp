package mapper;

import entity.AuthorEntity;
import entity.BookEntity;
import model.Author;
import model.Book;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

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
        if(bookEntity.getIsbn_10() != null) book.setIsbn_10(List.of(bookEntity.getIsbn_10()));
        if(bookEntity.getIsbn_13() != null) book.setIsbn_13(List.of(bookEntity.getIsbn_13()));
        book.setPublish_date(bookEntity.getPublish_date());
        book.setKey(bookEntity.getOl_key());
        List<Author> authors = new ArrayList<>();
        bookEntity.getBookAuthors().forEach(authorEntity -> authors.add(AuthorToAuthorEntityMapper.convert(authorEntity)));

        if(!authors.isEmpty()) book.setAuthors(authors);
        return book;
    }
}

package mapper;

import entity.AuthorEntity;
import entity.BookEntity;
import model.Author;
import model.Book;

public class BookToBookEntityMapper {

    public static BookEntity convert(Book book){
        BookEntity bookEntity = new BookEntity();
        bookEntity.setTitle(book.getTitle());
        bookEntity.setIsbn_10(book.getIsbn_10().get(0).toString());
        bookEntity.setIsbn_13(book.getIsbn_13().get(0).toString());
        bookEntity.setPublish_date(book.getPublish_date());
        bookEntity.setOl_key(book.getKey());

        for (Author author : book.getAuthors()){
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

        return  bookEntity;
    }
}

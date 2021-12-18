package entity;

import model.Author;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "books")
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column( length = 100000 )
    private String title;
    private String isbn_13;
    private String isbn_10;
    private String publish_date;
    private String ol_key;


    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "book_author",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<AuthorEntity> authors = new HashSet<AuthorEntity>(0);


    public void setTitle(String title) {
        this.title = title;
    }

    public void setIsbn_13(String isbn_13) {
        this.isbn_13 = isbn_13;
    }

    public void setIsbn_10(String isbn_10) {
        this.isbn_10 = isbn_10;
    }

    public void setPublish_date(String publish_date) {
        this.publish_date = publish_date;
    }

    public String getTitle() {
        return title;
    }

    public String getIsbn_13() {
        return isbn_13;
    }

    public String getIsbn_10() {
        return isbn_10;
    }

    public String getPublish_date() {
        return publish_date;
    }

    public String getOl_key() {
        return ol_key;
    }

    public void setOl_key(String ol_key) {
        this.ol_key = ol_key;
    }

    public Set<AuthorEntity> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<AuthorEntity> authors) {
        this.authors = authors;
    }

    public void addAuthor(AuthorEntity authorEntity){
        authors.add(authorEntity);
    }

}

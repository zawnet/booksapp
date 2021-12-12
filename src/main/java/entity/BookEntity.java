package entity;

import model.Author;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "books")
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String isbn13;
    private String isbn10;
    private String publishDate;

    @ManyToMany()
    @JoinTable(
            name = "books_authors",
            joinColumns = { @JoinColumn(name = "book_id") },
            inverseJoinColumns = { @JoinColumn(name = "author_id") }
    )
    private Set<AuthorEntity> bookAuthors = new HashSet<>();

}

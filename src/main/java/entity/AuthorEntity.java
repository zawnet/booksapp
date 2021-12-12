package entity;


import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "authors")
public class AuthorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String title;
    private String personalName;
    private String enType;
    private String wikipedia;
    private String birthDate;
    private String olKey;

    @ManyToMany(mappedBy = "bookAuthors")
    private Set<BookEntity> books = new HashSet<>();;
}

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
    private Set<BookEntity> books = new HashSet<>();

    public void setName(String name) {
        this.name = name;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPersonalName(String personalName) {
        this.personalName = personalName;
    }

    public void setEnType(String enType) {
        this.enType = enType;
    }

    public void setWikipedia(String wikipedia) {
        this.wikipedia = wikipedia;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public void setOlKey(String olKey) {
        this.olKey = olKey;
    }

    public void setBooks(Set<BookEntity> books) {
        this.books = books;
    }


}

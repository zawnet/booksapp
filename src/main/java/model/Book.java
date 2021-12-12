package model;

import java.util.List;

public class Book {

    private List<Object> publishers;
    private int number_of_pages;
    private String physical_format;
    //private List<Object> last_modified;
    private String title;
    private List<Object> isbn_13;
    private List<Object> isbn_10;
    //private String publish_date;
    private String key;
    private int revision;


    public List<Object> getPublishers() {
        return publishers;
    }

    public void setPublishers(List<Object> publishers) {
        this.publishers = publishers;
    }

    public int getNumber_of_pages() {
        return number_of_pages;
    }

    public void setNumber_of_pages(int number_of_pages) {
        this.number_of_pages = number_of_pages;
    }

    public String getPhysical_format() {
        return physical_format;
    }

    public void setPhysical_format(String physical_format) {
        this.physical_format = physical_format;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Object> getIsbn_13() {
        return isbn_13;
    }

    public void setIsbn_13(List<Object> isbn_13) {
        this.isbn_13 = isbn_13;
    }

    public List<Object> getIsbn_10() {
        return isbn_10;
    }

    public void setIsbn_10(List<Object> isbn_10) {
        this.isbn_10 = isbn_10;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getRevision() {
        return revision;
    }

    public void setRevision(int revision) {
        this.revision = revision;
    }

    @Override
    public String toString() {
        return "Book[" +
                "publishers=" + publishers +
                ", number_of_pages=" + number_of_pages +
                ", physical_format='" + physical_format + '\'' +
                ", title='" + title + '\'' +
                ", isbn_13=" + isbn_13 +
                ", isbn_10=" + isbn_10 +
                ", key='" + key + '\'' +
                ", revision=" + revision +
                ']';
    }
}
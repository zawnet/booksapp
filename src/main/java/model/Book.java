package model;

import java.util.List;

public class Book {

    //private List<Object> publishers;
    private String physical_format;
    //private List<Object> last_modified;
    private String title;
    //private List<Object> isbn_13;
    private String isbn_10;
    //private String publish_date;
    private String key;
    private int revision;





    public String getPhysical_format() {
        return physical_format;
    }

    public void setPhysical_format(String physical_format) {
        this.physical_format = physical_format;
    }

//    public List<Object> getPublishers() {
//        return publishers;
//    }
//
//    public void setPublishers(List<Object> publishers) {
//        this.publishers = publishers;
//    }
//
//    public List<Object> getLast_modified() {
//        return last_modified;
//    }
//
//    public void setLast_modified(List<Object> last_modified) {
//        this.last_modified = last_modified;
//    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

//    public List<Object> getIsbn_13() {
//        return isbn_13;
//    }
//
//    public void setIsbn_13(List<Object> isbn_13) {
//        this.isbn_13 = isbn_13;
//    }

    public String getIsbn_10() {
        return isbn_10;
    }

    public void setIsbn_10(String isbn_10) {
        this.isbn_10 = isbn_10;
    }

//    public String getPublish_date() {
//        return publish_date;
//    }
//
//    public void setPublish_date(String publish_date) {
//        this.publish_date = publish_date;
//    }

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
            //    "publishers=" + publishers +
                ", physical_format='" + physical_format + '\'' +
              //  ", last_modified=" + last_modified +
                ", title='" + title + '\'' +
               // ", isbn_13=" + isbn_13 +
                ", isbn_10='" + isbn_10 + '\'' +
               // ", publish_date='" + publish_date + '\'' +
                ", key='" + key + '\'' +
                ", revision=" + revision +
                ']';
    }
}
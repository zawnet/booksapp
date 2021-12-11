package model;

import java.util.List;

public class Doc {

    //@JsonProperty("key")
    private String key;
   // @JsonProperty("type")
    private String type;
    //@JsonProperty("seed")
    private List<Object> seed;
    //@JsonProperty("title")
    private String title;
    //@JsonProperty("title_suggest")
    private String title_suggest;
    //@JsonProperty("has_fulltext")
    private boolean has_fulltext;
    //@JsonProperty("edition_count")
    private int edition_count;
    //@JsonProperty("edition_key")
    private List<Object> edition_key;
    //@JsonProperty("publish_date")
    private List<Object> publish_date;
    //@JsonProperty("publish_year")
    private List<Object> publish_year;
    private int first_publish_year;
    //@JsonProperty("numbers_of_pages_medium")
    private int number_of_pages_median;
    //@JsonProperty("isbn")
    private List<Object> isbn;
    private int last_modified_i;
    private int ebook_count_i;
    private String cover_edition_key;
    private int cover_i;
    private List<Object> publisher;
    private List<Object> language;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Object> getSeed() {
        return seed;
    }

    public void setSeed(List<Object> seed) {
        this.seed = seed;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle_suggest() {
        return title_suggest;
    }

    public void setTitle_suggest(String title_suggest) {
        this.title_suggest = title_suggest;
    }

    public boolean isHas_fulltext() {
        return has_fulltext;
    }

    public void setHas_fulltext(boolean has_fulltext) {
        this.has_fulltext = has_fulltext;
    }

    public int getEdition_count() {
        return edition_count;
    }

    public void setEdition_count(int edition_count) {
        this.edition_count = edition_count;
    }

    public List<Object> getEdition_key() {
        return edition_key;
    }

    public void setEdition_key(List<Object> edition_key) {
        this.edition_key = edition_key;
    }

    public List<Object> getPublish_date() {
        return publish_date;
    }

    public void setPublish_date(List<Object> publish_date) {
        this.publish_date = publish_date;
    }

    public List<Object> getPublish_year() {
        return publish_year;
    }

    public void setPublish_year(List<Object> publish_year) {
        this.publish_year = publish_year;
    }

    public int getFirst_publish_year() {
        return first_publish_year;
    }

    public void setFirst_publish_year(int first_publish_year) {
        this.first_publish_year = first_publish_year;
    }

    public int getNumber_of_pages_median() {
        return number_of_pages_median;
    }

    public void setNumber_of_pages_median(int number_of_pages_median) {
        this.number_of_pages_median = number_of_pages_median;
    }

    public List<Object> getIsbn() {
        return isbn;
    }

    public void setIsbn(List<Object> isbn) {
        this.isbn = isbn;
    }

    public int getLast_modified_i() {
        return last_modified_i;
    }

    public void setLast_modified_i(int last_modified_i) {
        this.last_modified_i = last_modified_i;
    }

    public int getEbook_count_i() {
        return ebook_count_i;
    }

    public void setEbook_count_i(int ebook_count_i) {
        this.ebook_count_i = ebook_count_i;
    }

    public String getCover_edition_key() {
        return cover_edition_key;
    }

    public void setCover_edition_key(String cover_edition_key) {
        this.cover_edition_key = cover_edition_key;
    }

    public int getCover_i() {
        return cover_i;
    }

    public void setCover_i(int cover_i) {
        this.cover_i = cover_i;
    }

    public List<Object> getPublisher() {
        return publisher;
    }

    public void setPublisher(List<Object> publisher) {
        this.publisher = publisher;
    }

    public List<Object> getLanguage() {
        return language;
    }

    public void setLanguage(List<Object> language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "Doc[" +
                "key='" + key + '\'' +
                ", type='" + type + '\'' +
                ", seed=" + seed +
                ", title='" + title + '\'' +
                ", title_suggest='" + title_suggest + '\'' +
                ", has_fulltext=" + has_fulltext +
                ", edition_count=" + edition_count +
                ", edition_key=" + edition_key +
                ", publish_date=" + publish_date +
                ", publish_year=" + publish_year +
                ", first_publish_year=" + first_publish_year +
                ", number_of_pages_median=" + number_of_pages_median +
                ", isbn=" + isbn +
                ", last_modified_i=" + last_modified_i +
                ", ebook_count_i=" + ebook_count_i +
                ", cover_edition_key='" + cover_edition_key + '\'' +
                ", cover_i=" + cover_i +
                ", publisher=" + publisher +
                ", language='" + language + '\'' +
                ']';
    }
}

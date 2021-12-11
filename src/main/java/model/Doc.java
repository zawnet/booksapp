package model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Doc {

    private String key;
    private String type;
    @JsonProperty("seed")
    private List<Object> seed;
    @JsonProperty("title")
    private String title;
    @JsonProperty("title_suggest")
    private String title_suggest;
    private boolean has_fulltext;
    private int edition_count;
    @JsonProperty("edition_key")
    private List<Object> edition_key;
    private List<Object> publish_date;
    @JsonProperty("publish_year")
    private List<Object> publish_year;
    private int first_publish_year;
    private int number_of_pages_median;
    private List<Object> isbn;
    private int last_modified_i;
    private int ebook_count_i;
    private String cover_edition_key;
    private int cover_i;
    private List<Object> publisher;
    private String language;

    @Override
    public String toString() {
        return "Doc{" +
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
                '}';
    }
}

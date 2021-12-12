package model;

import java.util.List;

public class Author {
    private String name;
    private String title;
    private List<Object> source_records;
    private String personal_name;
    private String bio;
    private String entity_type;
    private String wikipedia;
    private List<Object> alternate_names;
    private String birth_date;
    private String key;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Object> getSource_records() {
        return source_records;
    }

    public void setSource_records(List<Object> source_records) {
        this.source_records = source_records;
    }

    public String getPersonal_name() {
        return personal_name;
    }

    public void setPersonal_name(String personal_name) {
        this.personal_name = personal_name;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getEntity_type() {
        return entity_type;
    }

    public void setEntity_type(String entity_type) {
        this.entity_type = entity_type;
    }

    public String getWikipedia() {
        return wikipedia;
    }

    public void setWikipedia(String wikipedia) {
        this.wikipedia = wikipedia;
    }

    public List<Object> getAlternate_names() {
        return alternate_names;
    }

    public void setAlternate_names(List<Object> alternate_names) {
        this.alternate_names = alternate_names;
    }

    public String getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "Author[" +
                "name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", source_records=" + source_records +
                ", personal_name='" + personal_name + '\'' +
                ", bio='" + bio + '\'' +
                ", entity_type='" + entity_type + '\'' +
                ", wikipedia='" + wikipedia + '\'' +
                ", alternate_names=" + alternate_names +
                ", birth_date='" + birth_date + '\'' +
                ", key='" + key + '\'' +
                ']';
    }
}

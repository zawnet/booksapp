package model;

import java.util.List;

public class Author {
    private String name;
    private String title;
    private String personal_name;
   // private String bio;
    private String entity_type;
    private String wikipedia;
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

    public String getPersonal_name() {
        return personal_name;
    }

    public void setPersonal_name(String personal_name) {
        this.personal_name = personal_name;
    }

//    public String getBio() {
//        return bio;
//    }
//
//    public void setBio(String bio) {
//        this.bio = bio;
//    }

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
                ", personal_name='" + personal_name + '\'' +
              //  ", bio='" + bio + '\'' +
                ", entity_type='" + entity_type + '\'' +
                ", wikipedia='" + wikipedia + '\'' +
                ", birth_date='" + birth_date + '\'' +
                ", key='" + key + '\'' +
                ']';
    }
}

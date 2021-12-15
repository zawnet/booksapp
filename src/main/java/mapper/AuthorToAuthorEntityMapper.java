package mapper;

import entity.AuthorEntity;
import model.Author;

public class AuthorToAuthorEntityMapper {

    public static AuthorEntity convert(Author author){
        AuthorEntity authorEntity = new AuthorEntity();
        authorEntity.setName(author.getName());
        authorEntity.setBirthDate(author.getBirth_date());
        authorEntity.setEnType(author.getEntity_type());
        authorEntity.setOlKey(author.getKey());
        authorEntity.setPersonalName(author.getPersonal_name());
        authorEntity.setWikipedia(author.getWikipedia());
        authorEntity.setTitle(author.getTitle());
        return authorEntity;
    }

    public static Author convert(AuthorEntity authorEntity){
        Author author = new Author();
        author.setName(authorEntity.getName());
        author.setBirth_date(authorEntity.getBirthDate());
        author.setEntity_type(authorEntity.getEnType());
        author.setKey(authorEntity.getOlKey());
        author.setPersonal_name(authorEntity.getPersonalName());
        author.setWikipedia(authorEntity.getWikipedia());
        author.setTitle(author.getTitle());
        return  author;
    }
}

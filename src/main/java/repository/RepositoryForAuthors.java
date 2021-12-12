package repository;

import entity.AuthorEntity;
import model.Author;

import java.util.List;

public interface RepositoryForAuthors extends Repository<AuthorEntity>{

    List<AuthorEntity> findAuthorByName(String name);

}

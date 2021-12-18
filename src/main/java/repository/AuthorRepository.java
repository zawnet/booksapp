package repository;

import entity.AuthorEntity;

import java.util.List;

public interface AuthorRepository extends Repository<AuthorEntity>{

    List<AuthorEntity> findAuthorByName(String name);
    AuthorEntity findAuthorByKey(String key);


}

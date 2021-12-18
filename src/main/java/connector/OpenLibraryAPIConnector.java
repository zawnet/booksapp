package connector;

import org.codehaus.httpcache4j.uri.URIBuilder;

import java.net.URI;
import java.util.NoSuchElementException;
import java.util.Optional;

public class OpenlibraryAPIConnector {

    private static final String SEARCH_BOOK_ENDPOINT        = "https://openlibrary.org/search.json";
    private static final String GET_AUTHOR_ENDPOINT         = "https://openlibrary.org/authors/";
    private static final String GET_BOOK_BY_ISBN_ENDPOINT   = "https://openlibrary.org/isbn/";
    private static final String GET_BOOK_BY_KEY_ENDPOINT    = "https://openlibrary.org/books/";
    private static final String GET_AUTHOR_BOOKS_ENDPOINT   = "https://openlibrary.org/authors/";

    public static URI getGetAuthorEndpoint(String authorKey) {
        try {
            return getUrl(GET_AUTHOR_ENDPOINT+authorKey+".json");
        }
        catch (NoSuchElementException e){
            throw new NoSuchElementException(e.getMessage());
        }
    }

    public static URI getGetBookByIsbnEndpoint(String isbn) {
        try {
            return getUrl(GET_BOOK_BY_ISBN_ENDPOINT+isbn+".json");
        }
        catch (NoSuchElementException e){
            throw new NoSuchElementException(e.getMessage());
        }
    }

    public static URI getSearchBookEndpoint(String title) {
        try {
            return getUrl(SEARCH_BOOK_ENDPOINT, "title", title);
        }
        catch (NoSuchElementException e){
            throw new NoSuchElementException(e.getMessage());
        }

    }

    public static URI getBookByKeyEndpoint(String key) {
        try {
            return getUrl(GET_BOOK_BY_KEY_ENDPOINT + key + ".json");
        }
        catch (NoSuchElementException e){
            throw new NoSuchElementException(e.getMessage());
        }
    }

    public static URI getGetAuthorBooksEndpoint(String key) {
        try {
            return getUrl(GET_AUTHOR_BOOKS_ENDPOINT + key + "/works.json");
        }
        catch (NoSuchElementException e){
            throw new NoSuchElementException(e.getMessage());
        }
    }


    private static URI getUrl(String path, String param, String value){
        try {
            URI uri = URIBuilder.fromString(path)
                    .addParameter(param, value)
                    .toURI();
            return uri;
        }
        catch (IllegalArgumentException e){
            throw new NoSuchElementException("Error while url build!");
        }

    }

    private static URI getUrl(String path){
        try {
            URI uri = URIBuilder.fromString(path)
                    .toURI();
            return uri;
        }
        catch (IllegalArgumentException e){
            throw new NoSuchElementException("Error while url build!");
        }
    }


}

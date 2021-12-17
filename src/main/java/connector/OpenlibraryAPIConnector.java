package connector;

import org.codehaus.httpcache4j.uri.URIBuilder;

import java.net.URI;
import java.util.Optional;

public class OpenlibraryAPIConnector {

    private static final String SEARCH_BOOK_ENDPOINT        = "https://openlibrary.org/search.json";
    private static final String GET_AUTHOR_ENDPOINT         = "https://openlibrary.org/authors/";
    private static final String GET_BOOK_BY_ISBN_ENDPOINT   = "https://openlibrary.org/isbn/";
    private static final String GET_BOOK_BY_KEY_ENDPOINT    = "https://openlibrary.org/books/";

    public static URI getGetAuthorEndpoint(String authorKey) {
        return getUrl(GET_AUTHOR_ENDPOINT+authorKey+".json");
    }

    public static URI getGetBookByIsbnEndpoint(String isbn) {
        return getUrl(GET_BOOK_BY_ISBN_ENDPOINT+isbn+".json");
    }

    public static URI getSearchBookEndpoint(String title) {
        return getUrl(SEARCH_BOOK_ENDPOINT, "title", title);
    }

    public static URI getBookByKeyEndpoint(String key) {
        return getUrl(GET_BOOK_BY_KEY_ENDPOINT+key+".json");
    }


    private static URI getUrl(String path, String param, String value){

        URI uri = URIBuilder.fromString(path)
                .addParameter(param,value)
                .toURI();

        return uri;
    }
    private static URI getUrl(String path){

        URI uri = URIBuilder.fromString(path)
                .toURI();

        return uri;
    }
}

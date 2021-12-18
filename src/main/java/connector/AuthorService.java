package connector;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import connector.exception.HttpServiceException;
import model.Author;
import model.Book;

import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class AuthorService implements  AuthorConnector{

    private HttpService httpService;

    public AuthorService() {
        this.httpService = new HttpService();
    }

    public List<Book> getAuthorBooks(String key){

        List<Book> bookList = new ArrayList<>();

        try {
            HttpResponse<String> httpResponse = httpService.callService(OpenlibraryAPIConnector.getGetAuthorBooksEndpoint(key));

            if(httpResponse.body().isEmpty()){
                throw new IllegalArgumentException("Empty response body content ");
            }

            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            objectMapper.configure(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS, true);

            JsonNode rootNode = null;

            rootNode = objectMapper.readTree(httpResponse.body());
            JsonNode bookNode = rootNode.path("entries");
            bookList   = objectMapper.readValue(bookNode.toString(),new TypeReference<List<Book>>(){});

        } catch (JsonProcessingException e) {
            System.out.println("Error while json processing.");
            System.out.println(e.getMessage());;
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

        catch (HttpServiceException e){
            System.out.println(e.getMessage());
        }
        catch (NoSuchElementException e){
            System.out.println(e.getMessage());
        }
        return bookList;
    }

    public Author getAuthorInfo(String key){
        Author author = new Author();
        try {
            HttpResponse<String> httpResponse = httpService.callService(OpenlibraryAPIConnector.getGetAuthorEndpoint(key));

            if(httpResponse.body().isEmpty()){
                throw new IllegalArgumentException("Empty response content ");
            }
            else {
                System.out.println(httpResponse);
            }

            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            objectMapper.configure(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS, true);
            author = objectMapper.readValue(httpResponse.body(),Author.class);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        catch (NoSuchElementException e){
            System.out.println(e.getMessage());
        }

        return author;
    }

}

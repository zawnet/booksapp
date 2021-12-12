package connector;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import connector.HttpService;
import connector.OpenlibraryAPIConnector;
import model.Book;

import java.net.URISyntaxException;
import java.net.http.HttpResponse;
import java.util.List;

public class BookService implements BookConnector{

    private HttpService httpService;


    public BookService() {
        this.httpService = new HttpService(new OpenlibraryAPIConnector());
    }

    public Book getBookByKey(String key){

        Book book = new Book();
        httpService.getOpenlibraryAPIConnector().setEndpoint("/books/"+key+".json");
        try {
            HttpResponse<String> httpResponse = httpService.getHttpRequest();


            if(httpResponse.body().isEmpty()){
                throw new IllegalArgumentException("Empty response content ");
            }
            else {
                System.out.println(httpResponse);
            }

            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            objectMapper.configure(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS, true);
            book = objectMapper.readValue(httpResponse.body(),Book.class);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

        return book;

    }

    @Override
    public Book getByISBN(String isbn) {
        return null;
    }

    @Override
    public List<Book> getByTitle(String title) {
        return null;
    }
}

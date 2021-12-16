package connector;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import model.Book;
import model.Doc;
import org.apache.commons.lang3.StringUtils;

import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import static mapper.DocToBookMapper.convert;
import static org.apache.commons.lang3.StringUtils.*;

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


            if(isBlank(httpResponse.body())){
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
        Book book = new Book();

        httpService.getOpenlibraryAPIConnector().setEndpoint("/isbn/"+isbn+".json");

        try {
            HttpResponse<String> httpResponse = httpService.getHttpRequest();


            if(isBlank(httpResponse.body())){
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
    public List<Book> getByTitle(String title) {
        List<Book> bookList = new ArrayList<>();
       DocService docService = new DocService();
       List<Doc> docList = docService.getDocsByTitle(title);
       if(docList.isEmpty()){

       }
       else {
           for (Doc doc : docList){
               bookList.add(convert(doc));
           }
       }
       return bookList;
    }
}

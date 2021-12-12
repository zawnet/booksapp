package service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import connector.HttpService;
import connector.OpenlibraryAPIConnector;
import model.Book;

import java.net.http.HttpResponse;

public class BookService {

    private HttpService httpService;


    public BookService() {
        this.httpService = new HttpService(new OpenlibraryAPIConnector());
    }

    public Book getBookByKey(String key){

        Book book = new Book();
        httpService.getOpenlibraryAPIConnector().setEndpoint("/books/"+key+".json");
        HttpResponse<String> httpResponse = httpService.getHttpRequest();
        if(httpResponse.body().isEmpty()){
            throw new IllegalArgumentException("Empty response body content ");
        }
        else {
            System.out.println(httpResponse);
        }

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS, true);

        try {
            book = objectMapper.readValue(httpResponse.body(),Book.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return book;

    }

}

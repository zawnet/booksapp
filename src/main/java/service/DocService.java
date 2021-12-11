package service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import connector.HttpService;
import connector.OpenlibraryAPIConnector;
import model.Doc;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class DocService {

    private HttpService httpService;

    public DocService() {
        this.httpService = new HttpService(new OpenlibraryAPIConnector());
    }

    public List<Doc> getDocsByTitle(String title){
        List<Doc> docList = new ArrayList<>();
        httpService.getOpenlibraryAPIConnector().setEndpoint("/search.json");
        httpService.getOpenlibraryAPIConnector().setParam("title");
        httpService.getOpenlibraryAPIConnector().setValue(title);
        HttpResponse<String> httpResponse = httpService.getHttpRequest();

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS, true);

        JsonNode rootNode = null;
        try {
            rootNode = objectMapper.readTree(httpResponse.body());
            JsonNode docsNode = rootNode.path("docs");
            docList   = objectMapper.readValue(docsNode.toString(),new TypeReference<List<Doc>>(){});

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

       docList.forEach(System.out::println);
        return docList;
    }

}

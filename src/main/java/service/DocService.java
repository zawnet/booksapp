package service;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import connector.HttpService;
import connector.OpenlibraryAPIConnector;
import model.Doc;
import org.json.JSONObject;

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

        JSONObject jsonObject = new JSONObject(httpResponse.body());

        jsonObject.getJSONArray("docs").forEach(s -> {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            objectMapper.configure(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS, true);

            try {
                Doc doc = objectMapper.readValue(s.toString(),Doc.class);
                docList.add(doc);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        });

       docList.forEach(System.out::println);
        return docList;
    }

}

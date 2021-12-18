package connector;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.cj.util.StringUtils;
import connector.HttpService;
import connector.OpenlibraryAPIConnector;
import connector.exception.HttpServiceException;
import model.Doc;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class DocService {

    private HttpService httpService;

    public DocService() {
        this.httpService = new HttpService();
    }

    public List<Doc> getDocsByTitle(String title){
        List<Doc> docList = new ArrayList<>();


        try {

            HttpResponse<String> httpResponse = httpService.callService(OpenlibraryAPIConnector.getSearchBookEndpoint(title));
            if( httpResponse.body().isBlank()){
                throw new IllegalArgumentException("Empty response body content ");
            }

            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            objectMapper.configure(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS, true);

            JsonNode rootNode = null;

            rootNode = objectMapper.readTree(httpResponse.body());
            JsonNode docsNode = rootNode.path("docs");
            docList   = objectMapper.readValue(docsNode.toString(),new TypeReference<List<Doc>>(){});

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

        return docList;
    }

}

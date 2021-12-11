package connector;

import connector.OpenlibraryAPIConnector;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.NoSuchElementException;

public class HttpService {

    private OpenlibraryAPIConnector openlibraryAPIConnector;

    public HttpService(OpenlibraryAPIConnector openlibraryAPIConnector) {
        this.openlibraryAPIConnector = openlibraryAPIConnector;
    }


    private HttpResponse<String> getHttpRequest() {

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(openlibraryAPIConnector.getUrl()))
                    .GET()
                    .build();

            HttpResponse<String> httpResponse = HttpClient.newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());

            return httpResponse;

        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        throw new NoSuchElementException("");
    }
}

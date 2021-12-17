package connector;

import connector.OpenlibraryAPIConnector;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.NoSuchElementException;

public class HttpService {

    private OpenlibraryAPIConnector openlibraryAPIConnector;

    public HttpService(OpenlibraryAPIConnector openlibraryAPIConnector) {
        this.openlibraryAPIConnector = openlibraryAPIConnector;
    }


    public HttpResponse<String> getHttpRequest(URI uri) {

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .GET()
                    .build();

            HttpResponse<String> httpResponse = HttpClient.newBuilder()
                    .followRedirects(HttpClient.Redirect.NORMAL) // follow redirects
                    .build()
                    .send(request, HttpResponse.BodyHandlers.ofString());


            return httpResponse;

        } catch (IOException e) {

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        throw new NoSuchElementException("");
    }


    public OpenlibraryAPIConnector getOpenlibraryAPIConnector() {
        return openlibraryAPIConnector;
    }
}

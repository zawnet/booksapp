package connector;

import connector.OpenlibraryAPIConnector;
import connector.exception.HttpServiceException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.NoSuchElementException;

public class HttpService {


    public HttpResponse<String> callService(URI uri) {

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
            e.printStackTrace();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (NoSuchElementException e){
            e.getMessage();
        }

        throw new HttpServiceException("Error while callService method");

    }

}

package connector;

import org.codehaus.httpcache4j.uri.URIBuilder;

import java.net.URI;
import java.util.Optional;

public class OpenlibraryAPIConnector {

    private String host = "https://openlibrary.org";
    private String endpoint = "/search.json";
    private String param;
    private String value;



    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public URI getUrl(){

        URI uri = URIBuilder.fromString(host+endpoint)
                .addParameter(param,value)
                .toURI();

        return uri;
    }



}

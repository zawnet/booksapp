package connector.exception;

public class HttpServiceException extends RuntimeException{
    public HttpServiceException(String message) {
        super(message);
    }
}

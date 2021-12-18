package repository.exeption;

public class NoBookFoundException extends RuntimeException {
    public NoBookFoundException(String message) {
        super(message);
    }
}

package repository.exeption;

import java.util.NoSuchElementException;

public class NoAuthorFoundException  extends RuntimeException {
    public NoAuthorFoundException(String s) {
        super(s);
    }
}

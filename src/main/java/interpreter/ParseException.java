package interpreter;

public class ParseException extends RuntimeException{
    public ParseException() {
    }

    public ParseException(String message) {
        super(message);
    }
}

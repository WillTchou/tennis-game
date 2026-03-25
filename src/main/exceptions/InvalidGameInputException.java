package main.exceptions;

public class InvalidGameInputException extends IllegalArgumentException {
    public InvalidGameInputException(String message) {
        super(message);
    }
}

package br.com.alura.screenmatch.exceptions;

public class TitleNotFoundException extends RuntimeException {

    private final String message;
    public TitleNotFoundException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

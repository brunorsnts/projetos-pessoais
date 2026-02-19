package br.com.alura.screenmatch.exceptions;

public class ApiException extends RuntimeException {
    private int statusCode;
    private String message;

    public ApiException(int statusCode, String message) {
        this.message = message;
        this.statusCode = statusCode;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public int getStatusCode() {
        return statusCode;
    }
}

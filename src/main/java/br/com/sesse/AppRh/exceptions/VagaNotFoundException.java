package br.com.sesse.AppRh.exceptions;

public class VagaNotFoundException extends RuntimeException {
    public VagaNotFoundException(String message) {
        super(message);
    }
}

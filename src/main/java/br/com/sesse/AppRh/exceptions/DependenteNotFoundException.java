package br.com.sesse.AppRh.exceptions;

public class DependenteNotFoundException extends RuntimeException {
    public DependenteNotFoundException(String message) {
        super(message);
    }
}

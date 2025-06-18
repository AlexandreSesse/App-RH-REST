package br.com.sesse.AppRh.exceptions;


public class CandidatoNotFoundException extends RuntimeException {
    public CandidatoNotFoundException(String message) {
        super(message);
    }
}

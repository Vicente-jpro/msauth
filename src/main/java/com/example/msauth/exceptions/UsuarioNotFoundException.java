package com.example.msauth.exceptions;

public class UsuarioNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public UsuarioNotFoundException(String errorMessage) {
        super(errorMessage);
    }

}

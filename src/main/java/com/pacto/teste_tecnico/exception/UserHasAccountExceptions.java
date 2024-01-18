package com.pacto.teste_tecnico.exception;

public class UserHasAccountExceptions extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public UserHasAccountExceptions(String msg) {
        super(msg);
    }

    public UserHasAccountExceptions(String msg, Throwable cause) {
        super(msg, cause);
    }
}

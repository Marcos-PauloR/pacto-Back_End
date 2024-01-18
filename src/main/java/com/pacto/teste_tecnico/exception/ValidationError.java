package com.pacto.teste_tecnico.exception;

import java.util.ArrayList;
import java.util.List;

import com.pacto.teste_tecnico.handler.FieldMessage;
import com.pacto.teste_tecnico.handler.StandardError;

public class ValidationError extends StandardError {

    private List<FieldMessage> errors = new ArrayList<>();

    public ValidationError(Long timeStamp, Integer status, String error, String message, String path) {
        super(timeStamp, status, error, message, path);
    }

    public List<FieldMessage> getErrors() {
        return errors;
    }

    public void addError(String fieldName, String message) {
        errors.add(new FieldMessage(fieldName, message));
    }

}

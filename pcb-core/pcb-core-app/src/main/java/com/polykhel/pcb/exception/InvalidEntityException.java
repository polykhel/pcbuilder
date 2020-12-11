package com.polykhel.pcb.exception;

public class InvalidEntityException extends RuntimeException {

    public InvalidEntityException(String entity) {
        super("Invalid entity: " + entity);
    }
}

package com.polykhel.pcb.exception;

public class UnknownEntityException extends RuntimeException {
    public UnknownEntityException(String type, Long id) {
        super("No " + type + " found with id " + id);
    }
}

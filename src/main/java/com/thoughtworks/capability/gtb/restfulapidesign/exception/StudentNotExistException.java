package com.thoughtworks.capability.gtb.restfulapidesign.exception;

public class StudentNotExistException extends RuntimeException {
    public StudentNotExistException(String message) {
        super(message);
    }
}

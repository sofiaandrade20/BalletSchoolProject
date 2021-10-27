package com.bootcamp.balletschool.exception;

public class ClassTypeNotFound extends RuntimeException{
    public ClassTypeNotFound(String message) {
        super(message);
    }
}

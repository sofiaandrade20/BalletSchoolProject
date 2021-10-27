package com.bootcamp.balletschool.exception;

public class DancerNotFound extends RuntimeException{
    public DancerNotFound(String message) {
        super(message);
    }
}

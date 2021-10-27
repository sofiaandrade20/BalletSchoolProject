package com.bootcamp.balletschool.exception;

public class TeacherNotFound extends RuntimeException{
    public TeacherNotFound(String message) {
        super(message);
    }
}

package com.cydeo.exceptions;

public class RecordNotFoundException extends RuntimeException{

    public RecordNotFoundException(String s) {
        super(s);
    }
}
package com.cydeo.exceptions;

public class BalanceNotSufficientException extends RuntimeException {
    public BalanceNotSufficientException(String s) {
        super(s);
    }
}
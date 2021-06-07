package com.tuana9a.oop;

public class CustomException extends Exception {
    public String errorMessage;
    public CustomException(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}

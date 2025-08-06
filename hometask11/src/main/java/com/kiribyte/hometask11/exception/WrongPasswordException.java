package com.kiribyte.hometask11.exception;

public class WrongPasswordException extends Exception {
    public WrongPasswordException(String message) {
        super(message);
    }

    public WrongPasswordException() {
    }
}

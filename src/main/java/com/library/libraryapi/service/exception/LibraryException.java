package com.library.libraryapi.service.exception;

public class LibraryException extends RuntimeException {

    public LibraryException() {
        super("No data found!");
    }

    public LibraryException(String message) {
        super(message);
    }
}

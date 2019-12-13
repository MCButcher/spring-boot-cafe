package de.cegeka.springbootcafe.exceptions;

public class UnknownCategoryException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public UnknownCategoryException(String message) {
        super(message);
    }
}
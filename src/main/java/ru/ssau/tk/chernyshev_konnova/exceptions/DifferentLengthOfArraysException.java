package ru.ssau.tk.chernyshev_konnova.exceptions;

public class DifferentLengthOfArraysException extends RuntimeException {

    private static final long serialVersionUID = -1438108215923293847L;

    public DifferentLengthOfArraysException() {
    }

    public DifferentLengthOfArraysException(String message) {
        super(message);
    }
}

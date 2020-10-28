package ru.ssau.tk.chernyshev_konnova.exceptions;

public class ArrayIsNotSortedException extends RuntimeException {

    private static final long serialVersionUID = 4189626007652748633L;

    public ArrayIsNotSortedException() {
    }

    public ArrayIsNotSortedException(String message) {
        super(message);
    }
}

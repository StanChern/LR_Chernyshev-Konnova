package ru.ssau.tk.chernyshev_konnova.exceptions;

public class InterpolationException extends RuntimeException {

    private static final long serialVersionUID = 1653404027659043082L;

    public InterpolationException() {
    }

    public InterpolationException(String message) {
        super(message);
    }
}

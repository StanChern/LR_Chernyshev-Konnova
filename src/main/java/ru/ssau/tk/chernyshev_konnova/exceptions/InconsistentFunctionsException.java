package ru.ssau.tk.chernyshev_konnova.exceptions;

public class InconsistentFunctionsException extends RuntimeException{

    private static final long serialVersionUID = -4756370091825992135L;

    public InconsistentFunctionsException() {
    }

    public InconsistentFunctionsException(String message) {
        super(message);
    }
}

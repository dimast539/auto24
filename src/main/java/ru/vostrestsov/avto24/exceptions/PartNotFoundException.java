package ru.vostrestsov.avto24.exceptions;

public class PartNotFoundException extends RuntimeException{
    public PartNotFoundException(String message) {
        super(message);
    }
}

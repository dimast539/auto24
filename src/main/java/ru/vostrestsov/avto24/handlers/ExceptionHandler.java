package ru.vostrestsov.avto24.handlers;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.vostrestsov.avto24.exceptions.PartNotFoundException;

@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(PartNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String PartsNotFoundException(PartNotFoundException partNotFoundException){
        return partNotFoundException.getMessage();
    }
}


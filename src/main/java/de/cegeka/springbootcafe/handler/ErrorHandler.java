package de.cegeka.springbootcafe.handler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import de.cegeka.springbootcafe.models.ApiError;
import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class ErrorHandler {

    @ExceptionHandler(NumberFormatException.class)
    public ResponseEntity<ApiError> handleNumberFormatException(NumberFormatException exception) {
        log.error(exception.getMessage(), exception);
        return new ResponseEntity<ApiError>(new ApiError(HttpStatus.NOT_ACCEPTABLE, LocalDateTime.now(), exception.getMessage()), HttpStatus.NOT_ACCEPTABLE);
    }
}
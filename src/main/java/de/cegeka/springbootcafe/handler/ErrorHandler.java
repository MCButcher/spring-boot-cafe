package de.cegeka.springbootcafe.handler;

import java.time.LocalDateTime;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import de.cegeka.springbootcafe.exceptions.UnknownCategoryException;
import de.cegeka.springbootcafe.models.ApiError;
import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class ErrorHandler {

  @ExceptionHandler(NumberFormatException.class)
  public ResponseEntity<ApiError> handleNumberFormatException(NumberFormatException exception) {
    log.error(exception.getMessage(), exception);
    return new ResponseEntity<ApiError>(
        new ApiError(HttpStatus.NOT_ACCEPTABLE, LocalDateTime.now(), exception.getMessage()),
        HttpStatus.NOT_ACCEPTABLE);
  }

  @ExceptionHandler(UnknownCategoryException.class)
  public ResponseEntity<ApiError> handleUnknownCategoryException(UnknownCategoryException exception) {
    log.error(exception.getMessage(), exception);
    return new ResponseEntity<ApiError>(
        new ApiError(HttpStatus.UNPROCESSABLE_ENTITY, LocalDateTime.now(), exception.getMessage()),
        HttpStatus.UNPROCESSABLE_ENTITY);
  }

  @ExceptionHandler(ConstraintViolationException.class)
  public ResponseEntity<ApiError> handleConstraintViolationException(ConstraintViolationException exception) {
    log.error(exception.getMessage(), exception);
    StringBuffer messages = new StringBuffer();
    exception.getConstraintViolations()
        .forEach(violation -> messages.append(violation.getPropertyPath()).append(" ").append(violation.getMessage()));
    return new ResponseEntity<ApiError>(
        new ApiError(HttpStatus.NOT_ACCEPTABLE, LocalDateTime.now(), messages.toString()), HttpStatus.NOT_ACCEPTABLE);
  }
}
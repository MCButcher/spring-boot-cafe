package de.cegeka.springbootcafe.handler;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import de.cegeka.springbootcafe.models.ApiError;

public class ErrorHandlerTest {
  ErrorHandler classUnderTest = new ErrorHandler();

  @Test
  void testNumberFormatException() {
    ResponseEntity<ApiError> response = classUnderTest
        .handleNumberFormatException(new NumberFormatException("no number"));

    assertAll("apiError", () -> assertThat(response.getStatusCode()).isNotNull().isEqualTo(HttpStatus.NOT_ACCEPTABLE),
        () -> assertThat(response.getBody()).extracting("status", "message").containsExactly(HttpStatus.NOT_ACCEPTABLE,
            "no number"),
        () -> assertThat(response.getBody()).hasFieldOrProperty("timestamp").isNotNull());
  }

}
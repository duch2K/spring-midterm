package iitu.midterm.demo.exception.handlers;

import iitu.midterm.demo.models.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLException;

@ControllerAdvice
@Component
public class SpringExceptionHandler {

    @ExceptionHandler(value = SQLException.class)
    public ResponseEntity<ErrorResponse> handleSQLException(SQLException e) {
        ErrorResponse errorResponse = new ErrorResponse("SQLException", e.getMessage());

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = NullPointerException.class)
    public ResponseEntity<ErrorResponse> handleNullPointerException(NullPointerException e) {
        ErrorResponse errorResponse = new ErrorResponse("NullPointerException", e.getMessage());

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ErrorResponse> handleAnyException(Exception e) {
        ErrorResponse errorResponse = new ErrorResponse("INTERNAL_SERVER_ERROR",
                  "System error! Try again later!");

        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

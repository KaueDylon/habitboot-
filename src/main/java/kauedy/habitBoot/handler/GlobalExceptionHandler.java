package kauedy.habitBoot.handler;

import kauedy.habitBoot.exception.*;
import kauedy.habitBoot.exception.IllegalStateException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.lang.IllegalArgumentException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(kauedy.habitBoot.exception.NotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFoundException(NotFoundException e){
        var response = new ErrorResponse(e.getMessage(), HttpStatus.NOT_FOUND.value(), null);
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(response);
    }

    @ExceptionHandler(kauedy.habitBoot.exception.IllegalStateException.class)
    public ResponseEntity<ErrorResponse> handleIllegalStateException(IllegalStateException e){
        var response = new ErrorResponse(e.getMessage(), HttpStatus.CONFLICT.value(), null);
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(response);
    }


    @ExceptionHandler(kauedy.habitBoot.exception.IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleIllegalStateException(IllegalArgumentException e){
        var response = new ErrorResponse(e.getMessage(), HttpStatus.BAD_REQUEST.value(), null);
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(response);
    }

    @ExceptionHandler(kauedy.habitBoot.exception.DateTimeParseException.class)
    public ResponseEntity<ErrorResponse> handleIllegalStateException(DateTimeParseException e){
        var response = new ErrorResponse(e.getMessage(), HttpStatus.BAD_REQUEST.value(), null);
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(response);
    }

    @ExceptionHandler(org.springframework.http.converter.HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponse> handleHttpMessageNotReadableException(
            org.springframework.http.converter.HttpMessageNotReadableException e) {

        String mensagem = "Erro ao interpretar JSON. Verifique os tipos inseridos nos campos.";

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse(e.getMessage(), HttpStatus.BAD_REQUEST.value(), mensagem));
    }
}

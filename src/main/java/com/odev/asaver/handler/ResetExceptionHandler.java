package com.odev.asaver.handler;

import com.odev.asaver.exception.ASaverException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ResetExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ASaverException.class)
    public ResponseEntity<ErrorDto> handleException(ASaverException exception) {

        final HttpStatus notAcceptable = HttpStatus.NOT_ACCEPTABLE;
        final ErrorDto errorDto = ErrorDto.builder()
                .httpCode(notAcceptable.value())
                .message(exception.getMessage())
                .build();

        return new ResponseEntity<>(errorDto, notAcceptable);
    }
}

package com.axyya.newapplication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ServerNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleException(ServerNotFoundException bookingNotFoundException, WebRequest webRequest)
    {
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setMessage("Server not found : (type=Not Found,status=404)");
        ResponseEntity<ExceptionResponse> entity = new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
        return entity;
    }
}

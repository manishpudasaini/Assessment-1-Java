package com.example.assessment1.exception;

import com.example.assessment1.model.Book;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiEceptionHandler {

    @ExceptionHandler(value = {ApiRequestException.class})
    public ResponseEntity<Object> apiHandelException(ApiRequestException apiRequestException){
      ApiException apiException=  new ApiException(
                apiRequestException.getMessage(),
                HttpStatus.BAD_REQUEST
                );

      return new ResponseEntity<>(apiException,HttpStatus.BAD_REQUEST);
    }
}

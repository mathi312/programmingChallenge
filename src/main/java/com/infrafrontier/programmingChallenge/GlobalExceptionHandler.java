package com.infrafrontier.programmingChallenge;

import com.infrafrontier.programmingChallenge.exceptions.EntityAlreadyExistsException;
import com.infrafrontier.programmingChallenge.exceptions.NoSuchElementFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(NoSuchElementFoundException.class)
    public ResponseEntity<ErrorInfo> handleNoSuchElementFound(NoSuchElementFoundException exception, final HttpServletRequest httpServletRequest){
        ErrorInfo error = new ErrorInfo(HttpStatus.NOT_FOUND.value(), exception.getMessage(), LocalDateTime.now(), httpServletRequest.getRequestURI());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ResponseBody
    @ExceptionHandler(EntityAlreadyExistsException.class)
    public ResponseEntity<ErrorInfo> handleEntityAlreadyExists(EntityAlreadyExistsException exception, final HttpServletRequest httpServletRequest){
        ErrorInfo error = new ErrorInfo(HttpStatus.CONFLICT.value(), exception.getMessage(), LocalDateTime.now(), httpServletRequest.getRequestURI());
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }

    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorInfo> handleMethodArgumentNotValid(MethodArgumentNotValidException exception, final HttpServletRequest httpServletRequest){
        Map<String, String> errors = new HashMap<>();

        for(FieldError error : exception.getBindingResult().getFieldErrors()) {
            errors.put(error.getField(), error.getDefaultMessage());
        }

        ErrorInfo error = new ErrorInfo(HttpStatus.BAD_REQUEST.value(), "Validation failed", LocalDateTime.now(), httpServletRequest.getRequestURI(), errors);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}

package com.devsuperior.dscatolog.resources.exceptions;

import com.devsuperior.dscatolog.services.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> entityNotFound(ResourceNotFoundException e, HttpServletRequest request) {

        StandardError err = new StandardError();
        err.setError("Resource Not Found");
        err.setTimestamp(Instant.now());
        err.setStatus(HttpStatus.NOT_FOUND.value());
        err.setPath(request.getRequestURI());
        err.setMessage(e.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);

    }
}

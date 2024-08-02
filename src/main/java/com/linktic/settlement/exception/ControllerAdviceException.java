package com.linktic.settlement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ControllerAdviceException {

    @ExceptionHandler(ExcepcionSettlement.class)
    public ResponseEntity<String> manejarMiExcepcionPersonalizada(ExcepcionSettlement ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}

package com.stackroute.musicplayer.config;

import com.stackroute.musicplayer.exceptions.TrackAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice("com.stackroute")
public class AdviceController {
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<String> exceptionHandler(Exception ex) {
        return new ResponseEntity<>("Exception Handled Globally" + ex.getMessage(), HttpStatus.CONFLICT);

    }

    @ExceptionHandler(value = TrackAlreadyExistsException.class)
    public ResponseEntity<String> exceptionHandler(TrackAlreadyExistsException ex) {
        return new ResponseEntity<>("Track Already exists" + ex.getMessage(), HttpStatus.CONFLICT);
    }
}

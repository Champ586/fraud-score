package com.champ586.fraudscore.handler;

import com.champ586.fraudscore.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(HttpServletRequest request, Exception ex) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorResponse(ex.getMessage()));
    }
//
//    @ExceptionHandler(NoHandlerFoundException.class)
//    public ResponseEntity<ErrorResponse> handleError404(HttpServletRequest request, NoHandlerFoundException ex)   {
//        return ResponseEntity
//                .status(HttpStatus.NOT_FOUND)
//                .body(new ErrorResponse(ex.getMessage()));
//    }

//    @Override
//    protected ResponseEntity<Object> handleNoHandlerFoundException(
//            NoHandlerFoundException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
//
//        return ResponseEntity
//                .status(HttpStatus.NOT_FOUND)
//                .body(new ErrorResponse(ex.getMessage()));
//    }
}

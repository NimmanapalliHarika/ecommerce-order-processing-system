package com.e_comm.authservice.exception;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleUserNotFoundException(UserNotFoundException ue,HttpServletRequest request){
		
		ErrorResponse errorResponse =new ErrorResponse();
		errorResponse.setTimestamp(LocalDateTime.now());
	    errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
	    errorResponse.setError(HttpStatus.NOT_FOUND.getReasonPhrase());
	    errorResponse.setMessage(ue.getMessage());
	    errorResponse.setPath(request.getRequestURI());

	    return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
		
	}
@ExceptionHandler(UserAlreadyExistsException.class)
public ResponseEntity<ErrorResponse> handleUserAlreadyExistsException(UserAlreadyExistsException ue,HttpServletRequest request){
		
		ErrorResponse errorResponse =new ErrorResponse();
		errorResponse.setTimestamp(LocalDateTime.now());
	    errorResponse.setStatus(HttpStatus.CONFLICT.value());
	    errorResponse.setError(HttpStatus.CONFLICT.getReasonPhrase());
	    errorResponse.setMessage(ue.getMessage());
	    errorResponse.setPath(request.getRequestURI());

	    return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
		
	}
@ExceptionHandler(InvalidCredentialsException.class)
public ResponseEntity<ErrorResponse> handleInvalidCredentials(InvalidCredentialsException ue,HttpServletRequest request){
	
	ErrorResponse errorResponse =new ErrorResponse();
	errorResponse.setTimestamp(LocalDateTime.now());
    errorResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
    errorResponse.setError(HttpStatus.UNAUTHORIZED.getReasonPhrase());
    errorResponse.setMessage(ue.getMessage());
    errorResponse.setPath(request.getRequestURI());

    return new ResponseEntity<>(errorResponse, HttpStatus.UNAUTHORIZED);
	
}
@ExceptionHandler(MethodArgumentNotValidException.class)
public ResponseEntity<ErrorResponse> handleValidationException(
        MethodArgumentNotValidException ex,
        HttpServletRequest request) {

    String message = ex.getBindingResult()
                       .getFieldError()
                       .getDefaultMessage();

    ErrorResponse errorResponse = new ErrorResponse();

    errorResponse.setTimestamp(LocalDateTime.now());
    errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
    errorResponse.setError(HttpStatus.BAD_REQUEST.getReasonPhrase());
    errorResponse.setMessage(message);
    errorResponse.setPath(request.getRequestURI());

    return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
}


}

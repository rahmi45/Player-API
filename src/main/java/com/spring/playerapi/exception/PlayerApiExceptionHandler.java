package com.spring.playerapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PlayerApiExceptionHandler {
	
	// Add an exception for the players who are not found
    @ExceptionHandler
    public ResponseEntity<PlayerErrorResponse> handleException(PlayerNotFoundException exc){
    	
        // create PlayerErrorResponse
    	PlayerErrorResponse playerErrorResponse = new PlayerErrorResponse();

    	playerErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
    	playerErrorResponse.setMessage(exc.getMessage());
    	playerErrorResponse.setTimeStamp(System.currentTimeMillis());

        ResponseEntity<PlayerErrorResponse> responseEntity = new ResponseEntity<>(playerErrorResponse, HttpStatus.NOT_FOUND);

        return responseEntity;
    }


    // Add an exception for other types of faulty entries
    @ExceptionHandler
    public ResponseEntity<PlayerErrorResponse> handleBadRequestException(Exception exc){
        // create CustomerErrorResponse
    	PlayerErrorResponse playerErrorResponse = new PlayerErrorResponse();

    	playerErrorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
    	playerErrorResponse.setMessage(exc.getMessage());
    	playerErrorResponse.setTimeStamp(System.currentTimeMillis());

        ResponseEntity<PlayerErrorResponse> responseEntity = new ResponseEntity<>(playerErrorResponse, HttpStatus.BAD_REQUEST);


        return responseEntity;
    }

}

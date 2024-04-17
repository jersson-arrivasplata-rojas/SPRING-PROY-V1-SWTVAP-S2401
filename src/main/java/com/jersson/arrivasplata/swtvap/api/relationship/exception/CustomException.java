package com.jersson.arrivasplata.swtvap.api.relationship.exception;

public class CustomException extends RuntimeException{

    public CustomException(String message){
        super(message);
    }

    public CustomException(String message, Throwable cause) {
        super(message, cause);
    }

}

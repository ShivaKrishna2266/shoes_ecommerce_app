package com.shoes_ecommerce_app.execption;

public class ApplicationBusinessException extends RuntimeException{

    public ApplicationBusinessException(String message){
    super(message);
    }
    public ApplicationBusinessException(String message, Throwable cause){
        super(message, cause);
    }
}

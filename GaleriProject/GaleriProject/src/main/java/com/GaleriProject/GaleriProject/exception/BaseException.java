package com.GaleriProject.GaleriProject.exception;

public class BaseException extends RuntimeException{

    public BaseException(ErrorMessage message){
        super(message.prepareErrorMessage());
        // hatayı bile benim istediğim gibi vericeksin dedik

    }
}

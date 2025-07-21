package com.example.exception_handling.exception;

import com.fasterxml.jackson.databind.ser.Serializers;

public class BaseException extends RuntimeException{

    public BaseException(){}

    public BaseException(ErrorMessage errorMessage) {
        super(errorMessage.prepareErrorMessage());
    }
}

package com.example.exception_handling.exception.handler;


import lombok.Data;
import lombok.Getter;

@Data
public class ApiError<T> {

    private int status;

    private Exception <T> exception;
}

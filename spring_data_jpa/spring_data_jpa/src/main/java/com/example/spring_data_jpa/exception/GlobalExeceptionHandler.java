package com.example.spring_data_jpa.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.*;

@ControllerAdvice // bu sınıf valid hatalarını yakalayacak
public class GlobalExeceptionHandler {
    //validation kaynaklı hatanın tipi
    // methodArgumentNotValidException

    private List<String> addMapValue(List<String> list,String newError){
        list.add(newError);
        return list;
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        Map<String,List<String>> errorMap = new HashMap<>();
        for (ObjectError objError : exception.getBindingResult().getAllErrors()) {
            String fieldName = ((FieldError)objError).getField();
            if(errorMap.containsKey(fieldName)) {
                List<String> errorList = errorMap.get(fieldName);
                List<String> newErrorList = addMapValue(errorList,objError.getDefaultMessage());
                errorMap.put(fieldName, newErrorList);
            } else {
                List<String> newErrorList = addMapValue(new ArrayList<>(), objError.getDefaultMessage());
                errorMap.put(fieldName, newErrorList);
            }
        }

        return ResponseEntity.badRequest().body(
                createApiError(errorMap)
        );
    }

    private <T> ApiError<T> createApiError(T errorMap ){
        ApiError<T> apiError = new ApiError<T>();
        apiError.setId(UUID.randomUUID().hashCode());
        apiError.setTimestamp(new Date());
        apiError.setErrorList(errorMap);
        return apiError;
    }
}

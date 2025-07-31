package com.GaleriProject.GaleriProject.handler;

import com.GaleriProject.GaleriProject.exception.BaseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.*;

// hata yakalama kodu controller advice
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {BaseException.class})
   // public ResponseEntity<ApiError<String>> HandleBaseException(BaseException exception, WebRequest request) throws UnknownHostException {
    // burda api errror string döndü ama mesela validation map dönebilir ondan ?
    public ResponseEntity<ApiError<?>> HandleBaseException(BaseException exception, WebRequest request) throws UnknownHostException {
       return  ResponseEntity.badRequest().body(createApiError(exception.getMessage(),request));
    }


    private String getHostName() throws UnknownHostException {
        return Inet4Address.getLocalHost().getHostName();
    }

    public <T> ApiError<T> createApiError(T message, WebRequest request) throws UnknownHostException {
        ApiError<T> apiError = new ApiError<>();
        apiError.setStatus(HttpStatus.BAD_REQUEST.value());
        Exception<T> exception = new Exception<>();
        exception.setMessage(message);
        exception.setCreateDate(new Date());
        // aşağıdaki satır url veriyor
        exception.setPath(request.getDescription(false).substring(4));
        exception.setHostName(getHostName());
        apiError.setException(exception);
        return apiError;
    }

    // şimdi geldik validation ile ilgili hatalara
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError<Map<String, List<String>>>> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception, WebRequest request) throws BaseException, UnknownHostException {
        Map<String, List<String>> errorMap = new HashMap<>();
        for (ObjectError objError : exception.getBindingResult().getAllErrors()){
            String fieldName = ((FieldError) objError).getField();
            if(errorMap.containsKey(fieldName)){
                // varsa ekle
                List<String> oldErrorList = errorMap.get(fieldName);
                oldErrorList.add(objError.getDefaultMessage());
                errorMap.put(fieldName, oldErrorList);
            }else{
                // yoksa oluştur
                List<String> errorList = new ArrayList<>();
                errorList.add(objError.getDefaultMessage());
                errorMap.put(fieldName, errorList);
            }
        }
        return ResponseEntity.badRequest().body(createApiError(errorMap,request));
    }
}

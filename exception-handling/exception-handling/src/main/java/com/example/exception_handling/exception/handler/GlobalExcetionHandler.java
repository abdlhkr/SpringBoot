package com.example.exception_handling.exception.handler;


import com.example.exception_handling.exception.BaseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

@ControllerAdvice
// controller advice ın anlamı : // tüm controllerlar için geçerli olan exception handler sınıfıdır.
public class GlobalExcetionHandler {


//    @ExceptionHandler(value = {BaseException.class})
//    public ResponseEntity<String> handleBaseException(BaseException exception) {
//        return ResponseEntity.badRequest().body(exception.getMessage());
//    }
@ExceptionHandler(value = {BaseException.class})
public ResponseEntity<ApiError> handleBaseException(BaseException exception,WebRequest request) {
    return ResponseEntity.badRequest().body(createApiError(exception.getMessage(),request));
}

    private String getHostName() {
        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }

    public <T> ApiError<T> createApiError(T message,WebRequest request){
        ApiError<T> apiError = new ApiError<>();
        apiError.setStatus(HttpStatus.BAD_REQUEST.value());

        Exception<T> exception = new Exception<>();
        exception.setCreateTime(new Date());
        exception.setHostName(getHostName());
        exception.setPath(request.getDescription(false).substring(4));
        exception.setMessage(message);
        apiError.setException(exception);
        return apiError;
    }


}

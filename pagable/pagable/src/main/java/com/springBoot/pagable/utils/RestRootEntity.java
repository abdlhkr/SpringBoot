package com.springBoot.pagable.utils;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
@Data
public class RestRootEntity <T>{
    private Integer status;
    private T payload;
    private String errorMessage;

    public static <T> RestRootEntity<T> ok(T payload){
        RestRootEntity<T> rootEntity = new RestRootEntity<T>();
        rootEntity.setPayload(payload);
        rootEntity.setStatus(HttpStatus.OK.value());
        rootEntity.setErrorMessage(null);
        return rootEntity;
    }

    public static <T> RestRootEntity<T> error(String errorMessage){
        RestRootEntity<T> rootEntity = new RestRootEntity<T>();
        rootEntity.setErrorMessage(errorMessage);
        rootEntity.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        rootEntity.setPayload(null);
        return rootEntity;
    }
}

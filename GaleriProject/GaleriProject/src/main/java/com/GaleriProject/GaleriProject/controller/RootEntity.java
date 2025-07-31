package com.GaleriProject.GaleriProject.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.http.HttpStatus;

// bu sınıf cevap formatı aynı olsun diye kodladığımız sınıf
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RootEntity <T>{
    private int status;
    private T payload;
    private String errorMessage;

    public static <T> RootEntity<T> ok(T payload) {
        RootEntity<T> entity = new RootEntity<T>();
        entity.setStatus(HttpStatus.ACCEPTED.value());
        entity.setPayload(payload);
        entity.setErrorMessage(null);
        return entity;
    }

    public static <T> RootEntity<T> error(String errorMessage) {
        RootEntity<T> entity = new RootEntity<T>();
        entity.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        entity.setErrorMessage(errorMessage);
        entity.setPayload(null);
        return entity;
    }
}

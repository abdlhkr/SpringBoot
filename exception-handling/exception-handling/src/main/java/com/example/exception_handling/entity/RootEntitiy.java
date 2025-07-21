package com.example.exception_handling.entity;


import jdk.jfr.Name;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RootEntitiy <T>{
    private boolean success;
    private String errorMessage;
    private T data;

    public static <T> RootEntitiy<T> ok(T data) {
        RootEntitiy<T> rootEntitiy = new RootEntitiy<>();
        rootEntitiy.setSuccess(true);
        rootEntitiy.setData(data);
        rootEntitiy.setErrorMessage(null);
        return rootEntitiy;
    }

    public static <T> RootEntitiy<T> error(String errorMessage) {
        RootEntitiy<T> rootEntitiy = new RootEntitiy<>();
        rootEntitiy.setSuccess(false);
        rootEntitiy.setData(null);
        rootEntitiy.setErrorMessage(errorMessage);
        return rootEntitiy;
    }
}

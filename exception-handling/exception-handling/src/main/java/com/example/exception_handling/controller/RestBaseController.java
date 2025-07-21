package com.example.exception_handling.controller;


import com.example.exception_handling.entity.RootEntitiy;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class RestBaseController {

    public <T> RootEntitiy<T> ok(T data){
        return RootEntitiy.ok(data);
    }

    public <T> RootEntitiy<T> error(String message){
        return RootEntitiy.error(message);
    }
}

package com.GaleriProject.GaleriProject.controller.Imple;


import com.GaleriProject.GaleriProject.controller.RootEntity;

public class RestBaseController<T> {

    public RootEntity<T> ok(T payload){
        return RootEntity.ok(payload);
    }

    public RootEntity<T> error(String errorMessage){
        return RootEntity.error(errorMessage);
    }
}

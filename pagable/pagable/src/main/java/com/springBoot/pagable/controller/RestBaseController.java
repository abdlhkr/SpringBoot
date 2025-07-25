package com.springBoot.pagable.controller;

import com.springBoot.pagable.utils.PagerUtil;
import com.springBoot.pagable.utils.RestPageableEntity;
import com.springBoot.pagable.utils.RestPageableRequest;
import com.springBoot.pagable.utils.RestRootEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public class RestBaseController {



    public Pageable toPageable(RestPageableRequest request){
        return PagerUtil.toPageable(request);
    }

    public <T> RestPageableEntity<T> toPageableResponse(Page<?> page, List<T> content){
        return PagerUtil.toPageableResponse((Page<T>) page,content);
    }

    public <T>RestRootEntity<T> ok(T payload){
        return  RestRootEntity.ok(payload);
    }
    public <T>RestRootEntity<T> error(String message){
        return  RestRootEntity.error(message);
    }
}

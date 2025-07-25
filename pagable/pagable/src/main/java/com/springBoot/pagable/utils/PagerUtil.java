package com.springBoot.pagable.utils;

import com.springBoot.pagable.entity.Personel;
import lombok.experimental.UtilityClass;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@UtilityClass
public class PagerUtil {

    public boolean isNullOrEmpty(String text){
        return text == null || text.isEmpty();
    }

    public Pageable toPageable(RestPageableRequest request){
        RestPageableRequest readyRequest = new RestPageableRequest();
        readyRequest.setPageSize(request.getPageSize());
        readyRequest.setPageNumber(request.getPageNumber());
        if(!isNullOrEmpty(request.getColumnName())){
            Sort sort = request.isAscending() ?
                    Sort.by(Sort.Direction.ASC, request.getColumnName())
                    : Sort.by(Sort.Direction.DESC, request.getColumnName());
            return PageRequest.of(readyRequest.getPageNumber(), readyRequest.getPageSize(),sort);
        }
        return PageRequest.of(readyRequest.getPageNumber(), readyRequest.getPageSize());
    }

    public <T> RestPageableEntity<T>  toPageableResponse(Page<T> page, List<T> content){
        RestPageableEntity<T> restPageableEntity = new RestPageableEntity();
        restPageableEntity.setContent(content);
        restPageableEntity.setPageNumber(page.getNumber());
        restPageableEntity.setPageSize(page.getSize());
        restPageableEntity.setTotalElements(page.getTotalElements());
        return restPageableEntity;
    }
}

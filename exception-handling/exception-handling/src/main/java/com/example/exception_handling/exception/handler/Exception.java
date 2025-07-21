package com.example.exception_handling.exception.handler;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Exception<T> {

    private String hostName;
    private String path;
    private Date createTime;
    // private String message; yaparsan liste veya
    // map gibi bir hata sana sorun çıkarır
    // genel bi yapı kuruyoruz dikkat et
    private T message;
}

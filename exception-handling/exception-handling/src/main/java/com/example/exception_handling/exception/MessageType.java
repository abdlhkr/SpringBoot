package com.example.exception_handling.exception;


import lombok.Getter;

@Getter // değişmesini istemiyorum ondan data kullanmadım
public enum MessageType {


    NO_RECORD_EXIST("1001","Kayıt bulunamadı"),
    GENERAL_ERROR("9999","Genel hata oluştu");

    private String code;
    private String message;


     MessageType(String code, String message) {
        this.code = code;
        this.message = message;
    }
}

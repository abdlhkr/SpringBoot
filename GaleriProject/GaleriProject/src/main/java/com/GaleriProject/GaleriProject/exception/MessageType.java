package com.GaleriProject.GaleriProject.exception;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
public enum MessageType {
    NO_RECORD_EXIST("1004","Kayıt bulunamadı"),
    REFRESH_TOKEN_DOESNT_EXIST("1005","refresh token bulunamadı"),
    REFRESH_TOKEN_EXPIRED("1006","Refresh tokenin süresi dolmuş gg"),
    GENERAL_EXCEPTION("9999","genel bi hata oluştu"),
    JWT_TOKEN_EXPIRED("1907","token süresi doldu"),
    USER_NAME_NOT_FOUND("1111","kullanıcı adı kayıtlı değil"),
    ACCOUNT_NOT_FOUND("1112","bu id ye sahip account bulunamadı"),
    USER_NAME_OR_PASSWORD_INVALID("5656","kullanıcı adı veya şifre hatalı");

    private final String code;
    private final String message;
    MessageType(String code, String message) {
        this.code = code;
        this.message = message;
    }

}

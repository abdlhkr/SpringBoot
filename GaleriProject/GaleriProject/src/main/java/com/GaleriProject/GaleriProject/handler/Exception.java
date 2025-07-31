package com.GaleriProject.GaleriProject.handler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Exception <T>{
    private String hostName;
    private String path;
    private Date createDate;
    private T message;



}

package com.GaleriProject.GaleriProject.dto;


import com.GaleriProject.GaleriProject.enums.Role;
import lombok.Data;

@Data
public class DtoUser extends DtoBase {
    private String username;
    private String password;
}

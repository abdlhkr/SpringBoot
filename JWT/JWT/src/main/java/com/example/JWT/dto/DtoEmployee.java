package com.example.JWT.dto;


import com.example.JWT.entity.Department;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoEmployee {

    private String firstName;
    private String lastName;
    private DtoDepartment department;
}

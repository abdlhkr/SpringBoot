package com.example.exception_handling.dto;

import com.example.exception_handling.entity.Department;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class DtoEmployee {
    private String name;
    private DtoDepartment department;
}

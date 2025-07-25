package com.springBoot.pagable.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoPersonel {
    private String firstName;
    private String lastName;
    private DtoDepartment department;
}

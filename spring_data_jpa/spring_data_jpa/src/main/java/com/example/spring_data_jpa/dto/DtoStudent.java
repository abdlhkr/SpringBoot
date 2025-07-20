package com.example.spring_data_jpa.dto;


import com.example.spring_data_jpa.controller.DtoCourse;
import com.example.spring_data_jpa.entities.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoStudent {

    private String firstName;
    private String lastName;
    List<DtoCourse> courses;
}

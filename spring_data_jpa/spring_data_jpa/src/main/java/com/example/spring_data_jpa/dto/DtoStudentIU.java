package com.example.spring_data_jpa.dto;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoStudentIU {
    @NotEmpty(message = "First name cannot be empty")
    @Size(min = 2, max = 40, message = "First name must be between 2 and 40 characters")
    private String firstName;
    @NotEmpty(message = "Last name cannot be empty")
    private String lastName;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date dateOfBirth;
}

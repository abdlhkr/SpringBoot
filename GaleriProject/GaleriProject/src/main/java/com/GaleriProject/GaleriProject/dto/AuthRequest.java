package com.GaleriProject.GaleriProject.dto;


import com.GaleriProject.GaleriProject.enums.Role;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthRequest {
    @NotEmpty
    @Size(min = 2, max = 20)
    private String username;
    @Size(min = 6)
    private String password;
}

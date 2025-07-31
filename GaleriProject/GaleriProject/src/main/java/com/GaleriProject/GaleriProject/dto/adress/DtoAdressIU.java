package com.GaleriProject.GaleriProject.dto.adress;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoAdressIU {
    private String city;
    private String district;
    private String neighborhood;
    private String street;
}

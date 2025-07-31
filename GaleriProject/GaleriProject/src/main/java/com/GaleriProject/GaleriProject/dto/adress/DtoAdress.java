package com.GaleriProject.GaleriProject.dto.adress;

import com.GaleriProject.GaleriProject.dto.DtoBase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoAdress extends DtoBase{
    private String city;
    private String district;
    private String neighborhood;
    private String street;
}

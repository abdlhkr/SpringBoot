package com.GaleriProject.GaleriProject.dto.saled_car;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DtoSaledCarIU {
    private long galleristId;
    private long carId;
    private long customerId;
}

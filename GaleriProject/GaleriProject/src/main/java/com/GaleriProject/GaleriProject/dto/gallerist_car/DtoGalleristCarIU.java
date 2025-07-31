package com.GaleriProject.GaleriProject.dto.gallerist_car;

import com.GaleriProject.GaleriProject.model.Car;
import com.GaleriProject.GaleriProject.model.Gallerist;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoGalleristCarIU {
    private Long gallerist_id;
    private Long car_id;
}

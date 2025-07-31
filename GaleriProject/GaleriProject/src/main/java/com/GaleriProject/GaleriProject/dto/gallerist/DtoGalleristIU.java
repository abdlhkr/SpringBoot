package com.GaleriProject.GaleriProject.dto.gallerist;

import com.GaleriProject.GaleriProject.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoGalleristIU extends BaseEntity {
    private String firstName;
    private String lastName;
    private Long addressId;
}

package com.GaleriProject.GaleriProject.dto.gallerist;


import com.GaleriProject.GaleriProject.dto.adress.DtoAdress;
import com.GaleriProject.GaleriProject.model.Adress;
import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoGallerist {
    private String firstName;
    private String lastName;
    private DtoAdress adress;
}

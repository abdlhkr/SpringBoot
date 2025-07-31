package com.GaleriProject.GaleriProject.dto.customer;

import com.GaleriProject.GaleriProject.dto.account.DtoAccount;
import com.GaleriProject.GaleriProject.dto.adress.DtoAdress;
import com.GaleriProject.GaleriProject.model.Account;
import com.GaleriProject.GaleriProject.model.Adress;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoCustomerIU {
    private String firstName;
    private String lastName;
    private String tckn;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date birthOfDate;
    private List<Long> adressIdList ;
    private Long accountId;
}

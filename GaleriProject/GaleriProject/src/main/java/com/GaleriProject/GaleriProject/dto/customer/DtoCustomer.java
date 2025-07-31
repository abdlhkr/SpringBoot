package com.GaleriProject.GaleriProject.dto.customer;

import com.GaleriProject.GaleriProject.dto.DtoBase;
import com.GaleriProject.GaleriProject.dto.account.DtoAccount;
import com.GaleriProject.GaleriProject.dto.adress.DtoAdress;
import com.GaleriProject.GaleriProject.model.Account;
import com.GaleriProject.GaleriProject.model.Adress;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoCustomer extends DtoBase {
    private String firstName;
    private String lastName;
    private String tckn;
    private Date birthOfDate;
    private List<DtoAdress> adressList ;
    private DtoAccount account;
}

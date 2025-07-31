package com.GaleriProject.GaleriProject.dto.account;

import com.GaleriProject.GaleriProject.enums.CurrencyType;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoAccountIU {
    private String accountNo;
    private String iban;
    private BigDecimal amount;
    private CurrencyType currencyType;
}

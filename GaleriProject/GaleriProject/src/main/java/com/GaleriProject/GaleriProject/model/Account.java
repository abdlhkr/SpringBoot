package com.GaleriProject.GaleriProject.model;

import com.GaleriProject.GaleriProject.enums.CurrencyType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "account")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account extends BaseEntity{
    @Column(name = "account_no")
    private String accountNo;
    @Column(name = "iban")
    private String iban;
    @Column(name = "amount")
    private BigDecimal amount;
    // enumrated string te direk tl usd yazar
    // enumrated ordinal de is tl de 0 usd de 1 yazar
    @Column(name = "currency_type")
    @Enumerated(EnumType.STRING)
    private CurrencyType currencyType;

}

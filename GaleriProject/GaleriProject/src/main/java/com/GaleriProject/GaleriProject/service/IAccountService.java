package com.GaleriProject.GaleriProject.service;

import com.GaleriProject.GaleriProject.dto.account.DtoAccount;
import com.GaleriProject.GaleriProject.dto.account.DtoAccountIU;

public interface IAccountService {
    DtoAccount saveAccount(DtoAccountIU dtoAccountIU);
}

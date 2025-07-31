package com.GaleriProject.GaleriProject.controller;

import com.GaleriProject.GaleriProject.dto.account.DtoAccount;
import com.GaleriProject.GaleriProject.dto.account.DtoAccountIU;

public interface IAccauntController {
    public RootEntity<DtoAccount> saveAccount(DtoAccountIU dtoAccountIU);
}

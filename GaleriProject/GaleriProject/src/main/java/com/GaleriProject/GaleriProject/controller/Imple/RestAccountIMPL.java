package com.GaleriProject.GaleriProject.controller.Imple;

import com.GaleriProject.GaleriProject.controller.IAccauntController;
import com.GaleriProject.GaleriProject.controller.RootEntity;
import com.GaleriProject.GaleriProject.dto.account.DtoAccount;
import com.GaleriProject.GaleriProject.dto.account.DtoAccountIU;
import com.GaleriProject.GaleriProject.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.GaleriProject.GaleriProject.controller.RootEntity.ok;

@RestController
@RequestMapping("/api/account")
public class RestAccountIMPL implements IAccauntController {
    @Autowired
    private IAccountService accountService;

    @PostMapping
    @Override
    public RootEntity<DtoAccount> saveAccount(@RequestBody DtoAccountIU dtoAccountIU) {
        return ok(accountService.saveAccount(dtoAccountIU));
    }
}

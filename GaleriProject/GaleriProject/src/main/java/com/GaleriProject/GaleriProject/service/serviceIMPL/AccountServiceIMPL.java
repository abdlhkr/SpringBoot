package com.GaleriProject.GaleriProject.service.serviceIMPL;
import com.GaleriProject.GaleriProject.dto.account.DtoAccount;
import com.GaleriProject.GaleriProject.dto.account.DtoAccountIU;
import com.GaleriProject.GaleriProject.model.Account;
import com.GaleriProject.GaleriProject.repository.AccountRepository;
import com.GaleriProject.GaleriProject.service.IAccountService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;

@Service
public class AccountServiceIMPL implements IAccountService {

   @Autowired
   private AccountRepository accountRepository;

   private Account createAccount(DtoAccountIU dtoAccountIU){
       Account account = new Account();
       BeanUtils.copyProperties(dtoAccountIU, account);
       account.setCreateDate(new Date());
       return accountRepository.save(account);
   }

    @Override
    public DtoAccount saveAccount(DtoAccountIU dtoAccountIU) {
        Account dbAccount = new Account();
        dbAccount = createAccount(dtoAccountIU);
        DtoAccount dtoAccount = new DtoAccount();
        BeanUtils.copyProperties(dbAccount, dtoAccount);
        return dtoAccount;
    }

}

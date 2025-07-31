package com.GaleriProject.GaleriProject.service.serviceIMPL;
import com.GaleriProject.GaleriProject.dto.account.DtoAccount;
import com.GaleriProject.GaleriProject.dto.adress.DtoAdress;
import com.GaleriProject.GaleriProject.dto.customer.DtoCustomer;
import com.GaleriProject.GaleriProject.dto.customer.DtoCustomerIU;
import com.GaleriProject.GaleriProject.exception.BaseException;
import com.GaleriProject.GaleriProject.exception.ErrorMessage;
import com.GaleriProject.GaleriProject.exception.MessageType;
import com.GaleriProject.GaleriProject.model.Account;
import com.GaleriProject.GaleriProject.model.Adress;
import com.GaleriProject.GaleriProject.model.Customer;
import com.GaleriProject.GaleriProject.repository.AccountRepository;
import com.GaleriProject.GaleriProject.repository.AdressRepository;
import com.GaleriProject.GaleriProject.repository.CustomerRepository;
import com.GaleriProject.GaleriProject.service.ICustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    CustomerRepository  customerRepository;
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    AdressRepository adressRepository;

    public Customer makeCustomer(DtoCustomerIU dtoCustomerIU) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(dtoCustomerIU, customer);
        customer.setCreateDate(new Date());
        List<Adress> adressList = adressRepository.findByIdIn(dtoCustomerIU.getAdressIdList());
        customer.setAdressList(adressList);
        Account account = accountRepository.findById(dtoCustomerIU.getAccountId()).orElseThrow(
                () -> new BaseException(new ErrorMessage(MessageType.ACCOUNT_NOT_FOUND,"id : " +  dtoCustomerIU.getAccountId()))
        );
        customer.setAccount(account);
        return customer;
    }

    // model mapper la düzenlicem sonra
    @Override
    public DtoCustomer createCustomer(DtoCustomerIU dtoCustomerIU) {
        Customer customer = makeCustomer(dtoCustomerIU);
        customerRepository.save(customer);
        // şu an customer hazır bunu Dto customer yapıcaz
        DtoCustomer dtoCustomer = new DtoCustomer();
        BeanUtils.copyProperties(customer, dtoCustomer);
        List<DtoAdress> dtoAdressList = customer.getAdressList().stream().map(adress -> {
            DtoAdress dto = new DtoAdress();
            BeanUtils.copyProperties(adress, dto);
            return dto;
        }).collect(Collectors.toList());
        dtoCustomer.setAdressList(dtoAdressList);
        DtoAccount  dtoAccount = new DtoAccount();
        BeanUtils.copyProperties(customer.getAccount(), dtoAccount);
        dtoCustomer.setAccount(dtoAccount);
        return dtoCustomer;
    }
}

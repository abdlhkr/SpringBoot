package com.GaleriProject.GaleriProject.service.serviceIMPL;
import com.GaleriProject.GaleriProject.dto.account.DtoAccount;
import com.GaleriProject.GaleriProject.dto.adress.DtoAdress;
import com.GaleriProject.GaleriProject.dto.car.DtoCar;
import com.GaleriProject.GaleriProject.dto.currency.CurrencyRatesItems;
import com.GaleriProject.GaleriProject.dto.currency.CurrencyRatesResponse;
import com.GaleriProject.GaleriProject.dto.customer.DtoCustomer;
import com.GaleriProject.GaleriProject.dto.gallerist.DtoGallerist;
import com.GaleriProject.GaleriProject.dto.saled_car.DtoSaledCar;
import com.GaleriProject.GaleriProject.dto.saled_car.DtoSaledCarIU;
import com.GaleriProject.GaleriProject.enums.CarStatusType;
import com.GaleriProject.GaleriProject.enums.CurrencyType;
import com.GaleriProject.GaleriProject.exception.BaseException;
import com.GaleriProject.GaleriProject.exception.ErrorMessage;
import com.GaleriProject.GaleriProject.exception.MessageType;
import com.GaleriProject.GaleriProject.model.*;
import com.GaleriProject.GaleriProject.repository.*;
import com.GaleriProject.GaleriProject.service.ISaledCarService;
import com.GaleriProject.GaleriProject.utils.GetDateFromatted;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SaledCarServiceIMP implements ISaledCarService {
    private Customer generalCustomer;
    private Car generalCar;
    private Gallerist generalGallerist;

    @Autowired
    private SaledCarRepository saledCarRepository;
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private GalleristRepository galleristRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CurrencyRatesServiceImpl currencyRatesServiceImpl;
    @Autowired
    private GalleristCarRepository galleristCarRepository;



    private void arrangeObject(DtoSaledCarIU dtoSaledCarIU){
        generalGallerist = galleristRepository.findById(dtoSaledCarIU.getGalleristId()).orElseThrow(
                () -> new BaseException(new ErrorMessage(MessageType.GENERAL_EXCEPTION,"gallerist bulunamadı  id : "+dtoSaledCarIU.getGalleristId()))
        );
        generalCar = carRepository.findById(dtoSaledCarIU.getCarId()).orElseThrow(
                () -> new BaseException(new ErrorMessage(MessageType.GENERAL_EXCEPTION,"car bulumamadı id : "+dtoSaledCarIU.getCarId())));
        generalCustomer = customerRepository.findById(dtoSaledCarIU.getCustomerId()).orElseThrow(
                () -> new BaseException(new ErrorMessage(MessageType.GENERAL_EXCEPTION,"customer bulunamadı id : "+dtoSaledCarIU.getCustomerId()))
        );

    }

    public BigDecimal getExchangeRate(){
        String currentDate = GetDateFromatted.getCurrentDate(new Date());
        CurrencyRatesResponse response =  currencyRatesServiceImpl.getCurrencyRates(currentDate,currentDate);
        List<CurrencyRatesItems> items = response.getItems();
        BigDecimal rate = new BigDecimal(items.get(0).getUsd());
        return rate;
    }

    // satış dolar üzerinden olsun
    private BigDecimal arrangeCarPrice(){
        if(generalCar.getCurrency() != CurrencyType.TL){
            // tl harici dolar var sadece
            BigDecimal rate = getExchangeRate();
            BigDecimal price = generalCar.getPrice().divide(rate,5, RoundingMode.HALF_UP);
            return price;
        }
        // zaten dolarsa postala gitsin
        return generalCar.getPrice();
    }

    private BigDecimal arrangeCustomerBalance(){
        Account customerAccount = generalCustomer.getAccount();
        if(customerAccount.getCurrencyType() != CurrencyType.TL){
            BigDecimal rate = getExchangeRate();
            BigDecimal customerBalance = customerAccount.getAmount().divide(rate,5, RoundingMode.HALF_UP);
            return customerBalance;
        }else {
            return customerAccount.getAmount();
        }
    }

    private boolean canAfford(){
        BigDecimal carPrice = arrangeCarPrice();
        BigDecimal customerBalance = arrangeCustomerBalance();
        return carPrice.compareTo(customerBalance) <= 0;
    }

    public void receivePayment(){
        BigDecimal carPrice = arrangeCarPrice();
        BigDecimal customerBalance = arrangeCustomerBalance();
        generalCustomer.getAccount().setAmount(customerBalance.subtract(carPrice));
        customerRepository.save(generalCustomer);
    }

    @Override
    public DtoSaledCar saledCar(DtoSaledCarIU dtoSaledCarIU) {
        arrangeObject(dtoSaledCarIU);
        if(canAfford()){
            if(generalCar.getCarStatusType() != CarStatusType.SALABLE){
                throw new BaseException(new ErrorMessage(MessageType.GENERAL_EXCEPTION,"çalıcan mı şerefsiz"));
            }
            SaledCar saledCar = new SaledCar();
            saledCar.setGallerist(generalGallerist);
            saledCar.setCar(generalCar);
            saledCar.setCustomer(generalCustomer);
            SaledCar info = saledCarRepository.save(saledCar);
            //araba satıldı kullanıcıdan parayı düşmemiz lazım
            // beleşe mi gitsin araba ::))
            receivePayment();
            // araba durumunu satıldı yapmamız lazım
            generalCar.setCarStatusType(CarStatusType.SOLD);
            carRepository.save(generalCar);
            DtoSaledCar dtoSaledCar = new DtoSaledCar();
            // customer car gallerist var onları ayarlamam lazım tek tek
            DtoCar dtoCar = new DtoCar();
            BeanUtils.copyProperties(generalCar,dtoCar);
            DtoCustomer dtoCustomer = new DtoCustomer();
            BeanUtils.copyProperties(generalCustomer,dtoCustomer);
            List<DtoAdress> dtoAdressList = generalCustomer.getAdressList().stream().map(
                    adress -> {
                        DtoAdress  dtoAdress = new DtoAdress();
                        BeanUtils.copyProperties(adress,dtoAdress);
                        return dtoAdress;
                    }
            ).collect(Collectors.toList());
            dtoCustomer.setAdressList(dtoAdressList);
            DtoAccount dtoAccount = new DtoAccount();
            BeanUtils.copyProperties(generalCustomer.getAccount(),dtoAccount);
            dtoCustomer.setAccount(dtoAccount);
            dtoSaledCar.setCustomer(dtoCustomer);
            // araba satıldı galeri vermese olmaz gallerist cardan silicez
            GalleristCar galleristCar = galleristCarRepository.findByGalleristIdAndCarId(generalGallerist.getId(),generalCar.getId());
            galleristCarRepository.delete(galleristCar);
            DtoGallerist dtoGallerist = new DtoGallerist();
            BeanUtils.copyProperties(generalGallerist,dtoGallerist);
            dtoSaledCar.setGallerist(dtoGallerist);
            dtoSaledCar.setCreateDate(new Date());
            return  dtoSaledCar;
        }
        throw new BaseException(new ErrorMessage(MessageType.GENERAL_EXCEPTION,"fakir köpke"));
    }
}

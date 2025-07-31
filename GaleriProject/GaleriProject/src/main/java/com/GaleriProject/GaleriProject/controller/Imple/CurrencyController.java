package com.GaleriProject.GaleriProject.controller.Imple;

import com.GaleriProject.GaleriProject.controller.RootEntity;
import com.GaleriProject.GaleriProject.dto.currency.CurrencyRatesResponse;
import com.GaleriProject.GaleriProject.service.serviceIMPL.CurrencyRatesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.GaleriProject.GaleriProject.controller.RootEntity.ok;

@RestController
@RequestMapping("/api/usd")
public class CurrencyController {
    @Autowired
    CurrencyRatesServiceImpl currencyRatesService;


    @GetMapping
    RootEntity<CurrencyRatesResponse> getUSD(@RequestParam("startDate") String startDate,
                                             @RequestParam("endDate") String endDate) {
            return  ok(currencyRatesService.getCurrencyRates(startDate, endDate));
    }
}

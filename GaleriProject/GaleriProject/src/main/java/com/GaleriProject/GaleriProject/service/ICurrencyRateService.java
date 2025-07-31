package com.GaleriProject.GaleriProject.service;

import com.GaleriProject.GaleriProject.dto.currency.CurrencyRatesResponse;

public interface ICurrencyRateService {
    public CurrencyRatesResponse getCurrencyRates(String startDate, String endDat);
}

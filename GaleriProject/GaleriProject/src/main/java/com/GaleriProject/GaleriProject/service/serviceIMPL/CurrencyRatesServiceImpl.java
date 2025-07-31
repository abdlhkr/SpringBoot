package com.GaleriProject.GaleriProject.service.serviceIMPL;

import com.GaleriProject.GaleriProject.dto.currency.CurrencyRatesResponse;
import com.GaleriProject.GaleriProject.exception.BaseException;
import com.GaleriProject.GaleriProject.exception.ErrorMessage;
import com.GaleriProject.GaleriProject.exception.MessageType;
import com.GaleriProject.GaleriProject.service.ICurrencyRateService;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CurrencyRatesServiceImpl implements ICurrencyRateService {



    @Override
    public CurrencyRatesResponse getCurrencyRates(String startDate, String endDate) {
        // https://evds2.tcmb.gov.tr/service/evds/series=TP.DK.USD.A&startDate=30-07-2025
        // &endDate=30-07-2025&type=json&formulas=0&frequency=1
        String rootUrl = "https://evds2.tcmb.gov.tr/service/evds/";
        String series = "TP.DK.USD.A&";
        String type = "json";
        String endpoint = rootUrl+"series="+series+"&startDate="+startDate+"&endDate="+endDate+"&type="+type+"&formulas=0&frequency=1";

        HttpHeaders headers = new HttpHeaders();
        headers.set("key","OpPLAPT4bG");

        HttpEntity<?> entity = new HttpEntity<>(headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<CurrencyRatesResponse> response = restTemplate.exchange(endpoint, HttpMethod.GET, entity, new ParameterizedTypeReference<CurrencyRatesResponse>() {
        });
        if(!response.getStatusCode().is2xxSuccessful()){
            throw new BaseException(new ErrorMessage(MessageType.GENERAL_EXCEPTION,"oldu bişeyler"));
        }
        return response.getBody();
    }
}

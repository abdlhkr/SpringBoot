package com.GaleriProject.GaleriProject.dto.currency;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyRatesResponse {

    private int totalCount;
    private List<CurrencyRatesItems> items;
//    {
//        "totalCount": 1,
//            "items": [
//        {
//            "Tarih": "2025",
//                "TP_DK_USD_A": "37.77991549295774",
//                "UNIXTIME": {
//            "$numberLong": "1735678800"
//        }
//        }
//    ]
//    }
}

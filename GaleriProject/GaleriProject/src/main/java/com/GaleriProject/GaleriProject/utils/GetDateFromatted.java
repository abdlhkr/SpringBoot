package com.GaleriProject.GaleriProject.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GetDateFromatted {
    public static String getCurrentDate(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        return sdf.format(date);
    }
}

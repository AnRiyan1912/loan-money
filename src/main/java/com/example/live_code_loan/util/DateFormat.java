package com.example.live_code_loan.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class DateFormat {
    public static Date formatStringToDate(String stringDate) {
        Date date = null;
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
            date = format.parse(stringDate);


        } catch (ParseException e) {
            e.getMessage();
        }
        return date;
    }


}

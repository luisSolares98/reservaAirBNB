package com.nur.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class UtilTest {
    public static Date parseToDate(String fecha) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.parse(fecha);
    }
    public static List listVoid () {
        return Collections.emptyList();
    }
}

package com.pado2;

import com.sun.security.jgss.GSSUtil;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Ch10_Calender_date {
    public static void main(String[] args) {
        Calendar calendar = new GregorianCalendar();
        Calendar calendar1 = Calendar.getInstance();

        System.out.println(calendar);
        System.out.println(calendar1);
        System.out.println(calendar.get(Calendar.DATE));
        System.out.println(calendar.get(Calendar.MONTH));
        System.out.println(calendar.get(Calendar.SECOND));


        Date d = new Date();
        System.out.println(d);
        d.setTime(10);
        System.out.println(d);
    }
}

package com.linktic.settlement.util;

import java.util.Calendar;
import java.util.Date;

public class DateUtils {

    public static int calculateAge(Date birthDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(birthDate);
        Calendar calendarNow = Calendar.getInstance();
        calendarNow.setTime(new Date());

        int age = calendarNow.get(Calendar.YEAR) - calendar.get(Calendar.YEAR);
        if (calendar.get(Calendar.MONTH) > calendarNow.get(Calendar.MONTH) ||
                (calendar.get(Calendar.MONTH) == calendarNow.get(Calendar.MONTH) &&
                        calendar.get(Calendar.DAY_OF_MONTH) > calendarNow.get(Calendar.DAY_OF_MONTH))) {
            age--;
        }
        return age;
    }
}


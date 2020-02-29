package com.util;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by tianjian on 2020/2/29.
 */
public class CommonUtil {
    public static boolean isData(String str) {
        DateTimeFormatter ldt = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

        boolean dateFlag = true;
        try {
            LocalDate.parse(str, ldt);
        } catch (DateTimeParseException | NullPointerException e) {
            dateFlag = false;
        }

        return dateFlag;
    }

    public boolean HasDigit(String content) {
        boolean flag = false;
        Pattern p = Pattern.compile(".*\\d+.*");
        Matcher m = p.matcher(content);
        if (m.matches()) {
            flag = true;
        }
        return flag;
    }

    public static Date getCurrentTime(String timeStr) {
        DateTimeFormatter timeDtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.parse(timeStr, timeDtf);
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDateTime.atZone(zone).toInstant();
        Date date = Date.from(instant);
        return date;
    }
}

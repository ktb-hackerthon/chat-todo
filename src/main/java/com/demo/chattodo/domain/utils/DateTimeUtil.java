package com.demo.chattodo.domain.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class DateTimeUtil {

    public static LocalDateTime getStartLocalDateTime(LocalDate date, LocalTime time) {
        if (date == null) {
            return null;
        }

        return date.atTime(time != null ? time : LocalTime.MIN);
    }

    public static LocalDateTime getEndLocalDateTime(LocalDate date, LocalTime time) {
        if (date == null) {
            return null;
        }

        return date.atTime(time != null ? time : LocalTime.MAX).minusSeconds(1);
    }

}

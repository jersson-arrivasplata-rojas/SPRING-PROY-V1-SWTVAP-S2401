package com.jersson.arrivasplata.swtvap.api.setting.util;

import lombok.Builder;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Builder
public class Common {

    public LocalDate getCurrentDate() {
        ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("America/Lima"));
        LocalDate localDate = zonedDateTime.toLocalDate();
        return localDate;
    }
}

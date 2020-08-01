package br.com.juridico.util;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/**
 *
 * @author Carlos Eduardo Ambrosio
 */
public class DateUtil {

    public static Date getDate() {
        return Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

}
